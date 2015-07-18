/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.AllowDespawn;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.ASM.DependentMethodStripper.ClassDependent;
import Reika.DragonAPI.ASM.DependentMethodStripper.ModDependent;
import Reika.DragonAPI.Instantiable.Event.BlockConsumedByFireEvent;
import Reika.DragonAPI.Instantiable.Event.EntityPushOutOfBlocksEvent;
import Reika.DragonAPI.Instantiable.Event.FurnaceUpdateEvent;
import Reika.DragonAPI.Instantiable.Event.PlayerPlaceBlockEvent;
import Reika.DragonAPI.Instantiable.Event.SlotEvent.RemoveFromSlotEvent;
import Reika.DragonAPI.Libraries.ReikaEntityHelper;
import Reika.DragonAPI.Libraries.ReikaInventoryHelper;
import Reika.DragonAPI.Libraries.Java.ReikaObfuscationHelper;
import Reika.DragonAPI.Libraries.Java.ReikaReflectionHelper;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.DragonAPI.Libraries.World.ReikaWorldHelper;
import Reika.DragonAPI.ModInteract.DeepInteract.FrameBlacklist.FrameUsageEvent;
import Reika.DragonAPI.ModInteract.ItemHandlers.TinkerToolHandler;
import Reika.RotaryCraft.API.Power.ShaftMachine;
import Reika.RotaryCraft.Auxiliary.GrinderDamage;
import Reika.RotaryCraft.Auxiliary.HarvesterDamage;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import Reika.RotaryCraft.Auxiliary.ReservoirComboRecipe;
import Reika.RotaryCraft.Base.TileEntity.TileEntityIOMachine;
import Reika.RotaryCraft.Items.Tools.Bedrock.ItemBedrockArmor;
import Reika.RotaryCraft.Items.Tools.Charged.ItemSpringBoots;
import Reika.RotaryCraft.Registry.BlockRegistry;
import Reika.RotaryCraft.Registry.ConfigRegistry;
import Reika.RotaryCraft.Registry.ItemRegistry;
import Reika.RotaryCraft.Registry.MachineRegistry;
import Reika.RotaryCraft.Registry.SoundRegistry;
import Reika.RotaryCraft.TileEntities.Auxiliary.TileEntityFurnaceHeater;
import Reika.RotaryCraft.TileEntities.Farming.TileEntitySpawnerController;
import Reika.RotaryCraft.TileEntities.Piping.TileEntityHose;
import WayofTime.alchemicalWizardry.api.event.TeleposeEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class RotaryEventManager {

	public static final RotaryEventManager instance = new RotaryEventManager();

	private RotaryEventManager() {

	}

	@SubscribeEvent
	public void cleanUpReservoirCrafting(PlayerEvent.ItemCraftedEvent evt) {
		if (ReikaItemHelper.matchStacks(evt.crafting, MachineRegistry.RESERVOIR.getCraftedProduct())) {
			if (evt.crafting.stackTagCompound != null && evt.crafting.stackTagCompound.getBoolean(ReservoirComboRecipe.NBT_TAG)) {
				if (!ReikaInventoryHelper.addToIInv(MachineRegistry.RESERVOIR.getCraftedProduct(), evt.player.inventory)) {
					ReikaItemHelper.dropItem(evt.player, MachineRegistry.RESERVOIR.getCraftedProduct());
				}
				evt.crafting.stackTagCompound.removeTag(ReservoirComboRecipe.NBT_TAG);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void preventControlledDespawns(LivingSpawnEvent.AllowDespawn evt) {
		if (TileEntitySpawnerController.isFlaggedNoDespawn(evt.entity))
			evt.setResult(Result.DENY);
	}

	@SubscribeEvent
	public void burnLubricantHose(BlockConsumedByFireEvent evt) {
		if (MachineRegistry.getMachine(evt.world, evt.x, evt.y, evt.z) == MachineRegistry.HOSE) {
			((TileEntityHose)evt.world.getTileEntity(evt.x, evt.y, evt.z)).burn();
		}
	}

	@SubscribeEvent
	public void noItemEntityPush(EntityPushOutOfBlocksEvent evt) {
		Entity e = evt.entity;
		if (e instanceof EntityItem) {
			int x = MathHelper.floor_double(e.posX);
			int y = MathHelper.floor_double(e.posY);
			int z = MathHelper.floor_double(e.posZ);
			MachineRegistry m = MachineRegistry.getMachine(e.worldObj, x, y, z);
			if (m == MachineRegistry.RESERVOIR) {
				evt.setCanceled(true);
			}
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void harvestSpawner(BlockEvent.BreakEvent evt) {
		if (evt.block == Blocks.mob_spawner && ItemRegistry.BEDPICK.matchItem(evt.getPlayer().getCurrentEquippedItem())) {
			evt.setExpToDrop(0);
		}
	}
	/*
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderItemInSlot(RenderItemInSlotEvent evt) {
		if (evt.getGuiClass() == GuiAutoCrafter.class) {
			if (evt.slotIndex < 18) {
				ItemStack is = evt.getItem();
				if (is != null) {
					ItemStack out = ItemCraftPattern.getRecipeOutput(is);
					ReikaGuiAPI.instance.drawItemStack(new RenderItem(), out, evt.slotX, evt.slotY);
				}
			}
		}
	}*/

	@SubscribeEvent
	public void onRemoveArmor(RemoveFromSlotEvent evt) {
		int id = evt.slotID;
		if (evt.slotID == 36) { //foot armor
			ItemStack is = evt.getItem();
			if (is != null && is.getItem() instanceof ItemSpringBoots) {
				evt.player.stepHeight = 0.5F;
			}
		}
	}

	@SubscribeEvent
	public void fallEvent(LivingFallEvent event)
	{
		EntityLivingBase e = event.entityLiving;
		ItemStack is = e.getEquipmentInSlot(1);

		if (is != null) {
			if (is.getItem() instanceof ItemSpringBoots) {
				if (is.getItem() == ItemRegistry.BEDJUMP.getItemInstance() || is.getItemDamage() > 0) {
					//ReikaJavaLibrary.pConsole(event.distance);
					event.distance *= 0.6F;
					//ReikaJavaLibrary.pConsole(event.distance);
					if (is.getItem() == ItemRegistry.BEDJUMP.getItemInstance())
						event.distance = Math.min(event.distance, 25);
				}
			}
		}
	}

	@SubscribeEvent
	public void enforceHarvesterLooting(LivingDropsEvent ev) {
		if (ev.source instanceof HarvesterDamage) {
			HarvesterDamage dmg = (HarvesterDamage)ev.source;
			int looting = dmg.getLootingLevel();
			EntityLivingBase e = ev.entityLiving;
			ArrayList<EntityItem> li = ev.drops;
			li.clear();
			e.captureDrops = true;
			try {
				ReikaObfuscationHelper.getMethod("dropFewItems").invoke(e, true, looting);
				ReikaObfuscationHelper.getMethod("dropEquipment").invoke(e, true, dmg.hasInfinity() ? 100 : looting*4);
				int rem = RotaryCraft.rand.nextInt(200) - looting*4;
				if (rem <= 5 || dmg.hasInfinity())
					ReikaObfuscationHelper.getMethod("dropRareDrop").invoke(e, 1);
			}
			catch (Exception ex) {
				RotaryCraft.logger.debug("Could not process harvester drops event!");
				if (RotaryCraft.logger.shouldDebug())
					ex.printStackTrace();
			}
			e.captureDrops = false;
		}
	}

	@SubscribeEvent
	public void meatGrinding(LivingDropsEvent ev) {
		if (ev.source instanceof GrinderDamage) {
			ItemStack food = ReikaEntityHelper.getFoodItem(ev.entityLiving);
			ev.drops.clear();
			if (food != null) {
				World world = ev.entityLiving.worldObj;
				Random rand = RotaryCraft.rand;
				int num = 4+rand.nextInt(4)+rand.nextInt(4)+rand.nextInt(4);
				ItemStack is = ReikaItemHelper.getSizedItemStack(food, num);
				ReikaItemHelper.dropItem(world, ev.entityLiving.posX, ev.entityLiving.posY, ev.entityLiving.posZ, is);
			}
			ev.setCanceled(true);
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void disallowDespawn(AllowDespawn ad) {
		EntityLivingBase e = ad.entityLiving;
		PotionEffect pe = e.getActivePotionEffect(RotaryCraft.freeze);
		if (pe == null)
			return;
		ad.setResult(Result.DENY);
	}
}
