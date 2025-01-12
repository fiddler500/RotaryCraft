/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RotaryCraft.Blocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.ASM.APIStripper.Strippable;
import Reika.DragonAPI.ASM.DependentMethodStripper.ModDependent;
import Reika.DragonAPI.Instantiable.Data.BlockKey;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.DragonAPI.ModInteract.LegacyWailaHelper;
import Reika.LegacyCraft.LegacyOptions;
import Reika.RotaryCraft.RotaryCraft;
import Reika.RotaryCraft.Auxiliary.ItemStacks;
import Reika.RotaryCraft.Base.BlockBasic;
import Reika.RotaryCraft.Registry.BlockRegistry;

@Strippable(value = {"mcp.mobius.waila.api.IWailaDataProvider"})
public final class BlockCanola extends BlockBasic implements IPlantable, IGrowable, IWailaDataProvider {

	private final Random rand = new Random();

	private static final HashSet<BlockKey> farmBlocks = new HashSet();

	public static final int GROWN = 9;

	public BlockCanola() {
		super(Material.plants);
		this.setHardness(0F);
		this.setResistance(0F);
		this.setLightLevel(0F);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
	}

	@Override
	protected boolean isAvailableInCreativeMode() {
		return false;
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return null;
	}

	@Override
	public final ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return ItemStacks.canolaSeeds;
	}

	@Override
	public boolean isFoliage(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(this.getDrops(metadata));
		return ret;
	}

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	{
		if (par2 < 0)
		{
			par2 = 9;
		}
		if (par2 > 2)
			par2 += 2;
		if (par2 > 11)
			par2 = 11;

		return 0;//this.blockIndexInTexture + par2;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random par5Random) {
		int l = world.getBlockLightValue(x, y, z);
		if (l < 6 && !world.canBlockSeeTheSky(x, y, z)) {
			this.die(world, x, y, z);
		}
		if (!world.getBlock(x, y-1, z).canSustainPlant(world, x, y-1, z, ForgeDirection.UP, this)) {
			this.die(world, x, y, z);
		}
		else if (l >= 9)  {
			int metadata = world.getBlockMetadata(x, y, z);
			if (metadata < GROWN && isFertileSoil(world, x, y-1, z)) {
				if (par5Random.nextInt(3) == 0) {
					metadata++;
					world.setBlockMetadataWithNotify(x, y, z, metadata, 3);
				}
			}
		}
	}

	public void die(World world, int x, int y, int z) {
		world.setBlockToAir(x, y, z);
		ReikaItemHelper.dropItem(world, x, y, z, ItemStacks.canolaSeeds);
	}

	public ItemStack getDrops(int metadata) {
		int ndrops = metadata == GROWN ? (1+rand.nextInt(2))*(2+rand.nextInt(8)+rand.nextInt(5)) : 1;
		ItemStack items = ReikaItemHelper.getSizedItemStack(ItemStacks.canolaSeeds, ndrops);
		return items;
	}
	/*
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer ep, int s, float f1, float f2, float f3) {
		ItemStack is = ep.getCurrentEquippedItem();
		if (!world.isRemote && ReikaItemHelper.matchStacks(is, ReikaItemHelper.bonemeal)) {
			if (world.getBlockMetadata(x, y, z) < GROWN) {
				int to = Math.min(GROWN, world.getBlockMetadata(x, y, z)+1+rand.nextInt(4));
				if (ModList.LEGACYCRAFT.isLoaded() && LegacyOptions.BONEMEAL.getState())
					to = GROWN;
				world.setBlockMetadataWithNotify(x, y, z, to, 3);
				for (int i = 0; i < 16; i++)
					world.spawnParticle("happyVillager", x+rand.nextDouble(), y+rand.nextDouble(), z+rand.nextDouble(), 0, 0, 0);
				if (!ep.capabilities.isCreativeMode)
					ep.getCurrentEquippedItem().stackSize--;
				return true;
			}
		}
		return false;
	}
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		this.testStable(world, x, y, z);
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block changedid) {
		this.testStable(world, x, y, z);
	}

	public void testStable(World world, int x, int y, int z) {
		Block idbelow = world.getBlock(x, y-1, z);
		if ((world.getBlockLightValue(x, y, z) < 9 && !world.canBlockSeeTheSky(x, y, z)) || !this.isValidFarmBlock(world, x, y, z, idbelow)) {
			this.die(world, x, y, z);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return AxisAlignedBB.getBoundingBox(x + minX, y + minY, z + minZ, x + maxX, meta/(float)GROWN, z + maxZ);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		float var6 = var5/(float)GROWN;
		if (var6 < 0.125F)
			var6 = 0.125F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, var6, 1.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return 6;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int damageDropped(int par1)
	{
		return 0;
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@Override
	public IIcon getIcon(int s, int meta) {
		return icons[meta][s];
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		if (RotaryCraft.instance.isLocked())
			return;
		for (int j = 0; j <= GROWN; j++) {
			for (int i = 0; i < 6; i++) {
				icons[j][i] = par1IconRegister.registerIcon("RotaryCraft:canola"+String.valueOf(j));
			}
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	/** What is this <u>for?</u> Nothing calls it... */
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return GROWN;
	}

	public static boolean isValidFarmBlock(World world, int x, int y, int z, Block id) {
		if (id == Blocks.farmland)
			return true;
		if (id == Blocks.air)
			return false;
		if (id == null)
			return false;
		return id.isFertile(world, x, y, z);
		//return farmBlocks.contains(id);
	}

	public static void addFarmBlock(Block b) {
		addFarmBlock(new BlockKey(b));
	}

	public static void addFarmBlock(Block b, int meta) {
		addFarmBlock(new BlockKey(b, meta));
	}

	private static void addFarmBlock(BlockKey bk) {
		farmBlocks.add(bk);
	}
	/*
	@Override
	public boolean isReadyToHarvest(World world, int x, int y, int z) {
		Block b = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		return b == this && meta == GROWN;
	}

	@Override
	public void setPostHarvest(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, 0, 3);
	}

	@Override
	public ArrayList<ItemStack> getHarvestProducts(World world, int x, int y, int z) {
		ArrayList<ItemStack> li = new ArrayList();
		li.add(this.getDrops(world.getBlockMetadata(x, y, z)));
		return li;
	}

	@Override
	public float getHarvestingSpeed() {
		return 2F;
	}*/

	@Override
	@ModDependent(ModList.WAILA)
	public ItemStack getWailaStack(IWailaDataAccessor acc, IWailaConfigHandler cfg) {
		return ItemStacks.canolaSeeds;
	}

	@Override
	@ModDependent(ModList.WAILA)
	public List<String> getWailaHead(ItemStack is, List<String> currenttip, IWailaDataAccessor acc, IWailaConfigHandler cfg) {
		currenttip.add(EnumChatFormatting.WHITE+"Canola Plant");
		return currenttip;
	}

	@Override
	@ModDependent(ModList.WAILA)
	public List<String> getWailaBody(ItemStack is, List<String> currenttip, IWailaDataAccessor acc, IWailaConfigHandler cfg) {
		if (LegacyWailaHelper.cacheAndReturn(acc))
			return currenttip;
		int meta = acc.getMetadata();
		currenttip.add(String.format("Growth Stage: %d%s", 100*meta/GROWN, "%"));
		return currenttip;
	}

	@Override
	@ModDependent(ModList.WAILA)
	public List<String> getWailaTail(ItemStack is, List<String> currenttip, IWailaDataAccessor acc, IWailaConfigHandler cfg) {
		String s1 = EnumChatFormatting.ITALIC.toString();
		String s2 = EnumChatFormatting.BLUE.toString();
		currenttip.add(s2+s1+"RotaryCraft");
		return currenttip;
	}

	@Override
	@ModDependent(ModList.WAILA)
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
		return tag;
	}

	public static boolean canGrowAt(World world, int x, int y, int z) {
		return world.getBlockLightValue(x, y, z) >= 9 && isSoil(world, x, y-1, z) && isFertileSoil(world, x, y-1, z);
	}

	private static boolean isSoil(World world, int x, int y, int z) {
		return world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, (BlockCanola)BlockRegistry.CANOLA.getBlockInstance());
	}

	private static boolean isFertileSoil(World world, int x, int y, int z) {
		return world.getBlock(x, y, z) == Blocks.farmland ? world.getBlockMetadata(x, y, z) > 0 : true;
	}

	@Override //Can apply
	public boolean func_149851_a(World world, int x, int y, int z, boolean client) {
		return world.getBlockMetadata(x, y, z) < GROWN;
	}

	@Override //shouldTryGrow
	public boolean func_149852_a(World world, Random rand, int x, int y, int z) {
		return true;
	}

	@Override //tryGrow
	public void func_149853_b(World world, Random rand, int x, int y, int z) {
		int to = Math.min(GROWN, world.getBlockMetadata(x, y, z)+1+rand.nextInt(4));
		if (ModList.LEGACYCRAFT.isLoaded() && LegacyOptions.BONEMEAL.getState())
			to = GROWN;
		world.setBlockMetadataWithNotify(x, y, z, to, 3);
		world.spawnParticle("happyVillager", x+rand.nextDouble(), y+rand.nextDouble(), z+rand.nextDouble(), 0, 0, 0);
	}
}
