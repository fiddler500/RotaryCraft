/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.Auxiliary.RecipeManagers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.Instantiable.Data.Maps.ItemHashMap;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.DragonAPI.ModInteract.ItemHandlers.RedstoneArsenalHandler;
import Reika.RotaryCraft.RotaryCraft;
import Reika.RotaryCraft.API.RecipeInterface;
import Reika.RotaryCraft.API.RecipeInterface.PulseFurnaceManager;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import Reika.RotaryCraft.Registry.BlockRegistry;
import Reika.RotaryCraft.Registry.ItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesPulseFurnace extends RecipeHandler implements PulseFurnaceManager {

	private static final RecipesPulseFurnace PulseFurnaceBase = new RecipesPulseFurnace();

	private ItemHashMap<ItemStack> recipes = new ItemHashMap().setOneWay();

	private ItemHashMap<ItemStack> customRecipes = new ItemHashMap();

	public static final RecipesPulseFurnace getRecipes()
	{
		return PulseFurnaceBase;
	}

	private RecipesPulseFurnace()
	{
		RecipeInterface.pulsefurn = this;

		this.addSmelting(Blocks.obsidian, BlockRegistry.BLASTGLASS.getCraftedProduct(1), RecipeLevel.CORE);
		this.addSmelting(Items.iron_ingot, ItemStacks.steelingot, RecipeLevel.CORE);

		this.addRecycling();

		this.addSmelting(ItemStacks.redgolddust, ItemStacks.redgoldingot, RecipeLevel.CORE);

		//addSmelting(RotaryCraft.shaftcraft, 10, new ItemStack(Items.iron_ingot, 1, 0));	//scrap
		//addSmelting(RotaryCraft.shaftcraft, 9, new ItemStack(RotaryCraft.shaftcraft, 1, 1));	//Iron scrap
		this.addSmelting(Blocks.detector_rail, new ItemStack(Items.iron_ingot, 1, 0), RecipeLevel.PERIPHERAL);	//1 ingot per block of rail
		this.addSmelting(Blocks.golden_rail, new ItemStack(Items.gold_ingot, 1, 0), RecipeLevel.PERIPHERAL);
	}

	private void addRecycling() {
		this.addSmelting(Items.chainmail_helmet, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.chainmail_boots, new ItemStack(Items.iron_ingot, 2, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.chainmail_leggings, new ItemStack(Items.iron_ingot, 4, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.chainmail_chestplate, new ItemStack(Items.iron_ingot, 5, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.iron_helmet, new ItemStack(Items.iron_ingot, 5, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_chestplate, new ItemStack(Items.iron_ingot, 8, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_leggings, new ItemStack(Items.iron_ingot, 7, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_boots, new ItemStack(Items.iron_ingot, 4, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.iron_hoe, new ItemStack(Items.iron_ingot, 2, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_shovel, new ItemStack(Items.iron_ingot, 1, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_axe, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_pickaxe, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_sword, new ItemStack(Items.iron_ingot, 2, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.golden_helmet, new ItemStack(Items.gold_ingot, 5, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_chestplate, new ItemStack(Items.gold_ingot, 8, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_leggings, new ItemStack(Items.gold_ingot, 7, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_boots, new ItemStack(Items.gold_ingot, 4, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.golden_axe, new ItemStack(Items.gold_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_sword, new ItemStack(Items.gold_ingot, 2, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_shovel, new ItemStack(Items.gold_ingot, 1, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_pickaxe, new ItemStack(Items.gold_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_hoe, new ItemStack(Items.gold_ingot, 2, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.diamond_helmet, new ItemStack(Items.diamond, 5, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_chestplate, new ItemStack(Items.diamond, 8, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_leggings, new ItemStack(Items.diamond, 7, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_boots, new ItemStack(Items.diamond, 4, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.diamond_axe, new ItemStack(Items.diamond, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_sword, new ItemStack(Items.diamond, 2, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_shovel, new ItemStack(Items.diamond, 1, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_pickaxe, new ItemStack(Items.diamond, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_hoe, new ItemStack(Items.diamond, 2, 0), RecipeLevel.PROTECTED);

		this.addSmelting(Items.iron_horse_armor, new ItemStack(Items.iron_ingot, 7), RecipeLevel.PROTECTED);
		this.addSmelting(Items.diamond_horse_armor, new ItemStack(Items.diamond, 7), RecipeLevel.PROTECTED);
		this.addSmelting(Items.golden_horse_armor, new ItemStack(Items.gold_ingot, 7), RecipeLevel.PROTECTED);

		this.addSmelting(Items.flint_and_steel, new ItemStack(Items.iron_ingot, 1, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.bucket, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.water_bucket, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.lava_bucket, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.milk_bucket, new ItemStack(Items.iron_ingot, 3, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.minecart, new ItemStack(Items.iron_ingot, 5, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.iron_door, new ItemStack(Items.iron_ingot, 6, 0), RecipeLevel.PROTECTED);
		this.addSmelting(Items.cauldron, new ItemStack(Items.iron_ingot, 7, 0), RecipeLevel.PROTECTED);

		this.addSmelting(ItemRegistry.STEELHELMET.getItemInstance(), this.getSizedSteel(5), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELBOOTS.getItemInstance(), this.getSizedSteel(4), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELCHEST.getItemInstance(), this.getSizedSteel(8), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELLEGS.getItemInstance(), this.getSizedSteel(7), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELAXE.getItemInstance(), this.getSizedSteel(3), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELPICK.getItemInstance(), this.getSizedSteel(3), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELSHOVEL.getItemInstance(), this.getSizedSteel(1), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELHOE.getItemInstance(), this.getSizedSteel(2), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELSHEARS.getItemInstance(), this.getSizedSteel(2), RecipeLevel.PROTECTED);
		this.addSmelting(ItemRegistry.STEELSICKLE.getItemInstance(), this.getSizedSteel(3), RecipeLevel.PROTECTED);
	}

	private ItemStack getSizedSteel(int size) {
		return ReikaItemHelper.getSizedItemStack(ItemStacks.steelingot, size);
	}

	public void addAPISmelting(ItemStack in, ItemStack itemstack) {
		this.addSmelting(in, itemstack, RecipeLevel.API);
	}

	public void addSmelting(ItemStack in, ItemStack itemstack) {
		this.addSmelting(in, itemstack, RecipeLevel.CORE);
	}

	private void addSmelting(ItemStack in, ItemStack itemstack, RecipeLevel rl) {
		recipes.put(in, itemstack);
	}

	private void addSmelting(Block b, ItemStack itemstack, RecipeLevel rl) {
		this.addSmelting(new ItemStack(b, 1, OreDictionary.WILDCARD_VALUE), itemstack, rl);
	}

	private void addSmelting(Item i, ItemStack itemstack, RecipeLevel rl) {
		this.addSmelting(new ItemStack(i, 1, OreDictionary.WILDCARD_VALUE), itemstack, rl);
	}

	public void addCustomRecipe(ItemStack in, ItemStack output) {
		customRecipes.put(in, output);
	}

	public void removeCustomRecipe(ItemStack in) {
		customRecipes.remove(in);
	}

	public ItemStack getSmeltingResult(ItemStack item) {
		if (item == null)
			return null;
		ItemStack ret = recipes.get(item);
		if (ret == null)
			ret = customRecipes.get(item);
		return ret != null ? ret.copy() : null;
	}

	public List<ItemStack> getSources(ItemStack result) {
		List<ItemStack> li = new ArrayList();
		for (ItemStack in : recipes.keySet()) {
			ItemStack out = this.getSmeltingResult(in);
			if (ReikaItemHelper.matchStacks(result, out))
				li.add(in.copy());
		}
		for (ItemStack in : customRecipes.keySet()) {
			ItemStack out = this.getSmeltingResult(in);
			if (ReikaItemHelper.matchStacks(result, out))
				li.add(in.copy());
		}
		return li;
	}

	public boolean isProduct(ItemStack result) {
		return ReikaItemHelper.collectionContainsItemStack(recipes.values(), result) || ReikaItemHelper.collectionContainsItemStack(customRecipes.values(), result);
	}

	public boolean isSmeltable(ItemStack ingredient) {
		return this.getSmeltingResult(ingredient) != null;
	}

	public Collection<ItemStack> getAllSmeltables() {
		Collection<ItemStack> li = new ArrayList(recipes.keySet());
		li.addAll(customRecipes.keySet());
		return li;
	}

	@Override
	public void addPostLoadRecipes() {
		if (ModList.THERMALFOUNDATION.isLoaded()) {
			ItemStack enderdust = GameRegistry.findItemStack(ModList.THERMALFOUNDATION.modLabel, "dustEnderium", 1);
			ItemStack enderingot = GameRegistry.findItemStack(ModList.THERMALFOUNDATION.modLabel, "ingotEnderium", 1);
			if (enderdust == null || enderingot == null)
				RotaryCraft.logger.logError("No item found for TE3 enderium crafting!");
			else
				this.addSmelting(enderdust, enderingot, RecipeLevel.MODINTERACT);
		}

		if (ModList.ARSENAL.isLoaded()) {
			ItemStack fluxdust = RedstoneArsenalHandler.getInstance().getFluxDust();
			ItemStack fluxingot = RedstoneArsenalHandler.getInstance().getFluxIngot();
			if (fluxdust == null || fluxingot == null)
				RotaryCraft.logger.logError("No item found for Redstone Arsenal fluxed ingot crafting!");
			else
				this.addSmelting(fluxdust, fluxingot, RecipeLevel.MODINTERACT);
		}
	}
}
