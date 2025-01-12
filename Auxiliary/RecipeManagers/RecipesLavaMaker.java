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
import java.util.Collections;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.Instantiable.Data.Maps.ItemHashMap;
import Reika.DragonAPI.Libraries.MathSci.ReikaThermoHelper;
import Reika.DragonAPI.ModInteract.ItemHandlers.MagicCropHandler;
import Reika.RotaryCraft.RotaryCraft;
import Reika.RotaryCraft.API.RecipeInterface;
import Reika.RotaryCraft.API.RecipeInterface.RockMelterManager;
import Reika.RotaryCraft.Registry.ItemRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesLavaMaker extends RecipeHandler implements RockMelterManager {

	private static final RecipesLavaMaker recipes = new RecipesLavaMaker();

	public static final RecipesLavaMaker getRecipes() {
		return recipes;
	}

	private final ItemHashMap<MeltingRecipe> recipeList = new ItemHashMap().setOneWay();

	private RecipesLavaMaker() {
		RecipeInterface.rockmelt = this;

		this.addRecipe(Blocks.stone, FluidRegistry.LAVA, 1000, 1000, ReikaThermoHelper.ROCK_MELT_ENERGY, RecipeLevel.PROTECTED);
		this.addRecipe(Blocks.cobblestone, FluidRegistry.LAVA, 500, 1000, 3120000, RecipeLevel.PROTECTED);
		this.addRecipe(Blocks.netherrack, FluidRegistry.LAVA, 2000, 600, 480000, RecipeLevel.PROTECTED);
		this.addRecipe(Blocks.stonebrick, FluidRegistry.LAVA, 1000, 1200, 4160000, RecipeLevel.PROTECTED);

		this.addRecipe("stone", FluidRegistry.LAVA, 1000, 1000, 5200000, RecipeLevel.PROTECTED);
		this.addRecipe("cobblestone", FluidRegistry.LAVA, 500, 1000, 2820000, RecipeLevel.PROTECTED);

		this.addRecipe(ItemRegistry.ETHANOL.getStackOf(), "rc ethanol", 1000, 180, 6000, RecipeLevel.PERIPHERAL);
	}

	private static class MeltingRecipe {

		private final ItemStack input;
		private final FluidStack output;
		private final int temperature;
		private final long requiredEnergy;

		private MeltingRecipe(ItemStack is, FluidStack fs, int t, long e) {
			input = is;
			output = fs;
			temperature = t;
			requiredEnergy = e;
		}
	}

	private void addRecipe(String in, String out, int amt, int temperature, long energy, RecipeLevel rl) {
		if (this.validateFluid(out)) {
			ArrayList<ItemStack> li = OreDictionary.getOres(in);
			for (int i = 0; i < li.size(); i++)
				this.addRecipe(li.get(i), new FluidStack(FluidRegistry.getFluid(out), amt), temperature, energy, rl);
		}
	}

	private void addRecipe(String in, Fluid out, int amt, int temperature, long energy, RecipeLevel rl) {
		ArrayList<ItemStack> li = OreDictionary.getOres(in);
		for (ItemStack sin : li) {
			if (!recipeList.containsKey(sin))
				this.addRecipe(sin, new FluidStack(out, amt), temperature, energy, rl);
		}
	}

	private void addRecipe(ItemStack in, String out, int amt, int temperature, long energy, RecipeLevel rl) {
		if (this.validateFluid(out))
			this.addRecipe(in, new FluidStack(FluidRegistry.getFluid(out), amt), temperature, energy, rl);
	}

	private void addRecipe(Item in, String out, int amt, int temperature, long energy, RecipeLevel rl) {
		if (this.validateFluid(out))
			this.addRecipe(new ItemStack(in), new FluidStack(FluidRegistry.getFluid(out), amt), temperature, energy, rl);
	}

	private void addRecipe(Block in, String out, int amt, int temperature, long energy, RecipeLevel rl) {
		if (this.validateFluid(out))
			this.addRecipe(new ItemStack(in), new FluidStack(FluidRegistry.getFluid(out), amt), temperature, energy, rl);
	}

	private void addRecipe(Block in, Fluid out, int amt, int temperature, long energy, RecipeLevel rl) {
		this.addRecipe(new ItemStack(in), new FluidStack(out, amt), temperature, energy, rl);
	}

	private void addRecipe(Item in, Fluid out, int amt, int temperature, long energy, RecipeLevel rl) {
		this.addRecipe(new ItemStack(in), new FluidStack(out, amt), temperature, energy, rl);
	}

	public void addAPIRecipe(ItemStack in, FluidStack out, int temperature, long energy) {
		this.addRecipe(in, out, temperature, energy, RecipeLevel.API);
	}

	private void addRecipe(Block in, FluidStack out, int temperature, long energy, RecipeLevel rl) {
		this.addRecipe(new ItemStack(in), out, temperature, energy, rl);
	}

	private void addRecipe(Item in, FluidStack out, int temperature, long energy, RecipeLevel rl) {
		this.addRecipe(new ItemStack(in), out, temperature, energy, rl);
	}

	private void addRecipe(ItemStack in, FluidStack out, int temperature, long energy, RecipeLevel rl) {
		if (in != null) {
			recipeList.put(in, new MeltingRecipe(in, out, temperature, energy));
		}
		else {
			RotaryCraft.logger.logError("Null itemstack for recipe for "+out+"!");
		}
	}

	private boolean validateFluid(String s) {
		return FluidRegistry.getFluid(s) != null;
	}

	public FluidStack getMelting(ItemStack is) {
		MeltingRecipe r = recipeList.get(is);
		return r != null ? r.output.copy() : null;
	}

	public int getMeltTemperature(ItemStack is) {
		MeltingRecipe r = recipeList.get(is);
		return r != null ? r.temperature : Integer.MIN_VALUE;
	}

	public long getMeltingEnergy(ItemStack is) {
		MeltingRecipe r = recipeList.get(is);
		return r != null ? r.requiredEnergy : Integer.MIN_VALUE;
	}

	public boolean isValidFuel(ItemStack is) {
		return recipeList.containsKey(is);
	}

	public ArrayList<ItemStack> getSourceItems(Fluid f) {
		ArrayList<ItemStack> li = new ArrayList();
		for (ItemStack key : recipeList.keySet()) {
			MeltingRecipe r = recipeList.get(key);
			if (r.output.getFluid().equals(f))
				li.add(key.copy());
		}
		return li;
	}

	public Collection<ItemStack> getAllRecipes() {
		return Collections.unmodifiableCollection(recipeList.keySet());
	}

	@Override
	public void addPostLoadRecipes() {
		this.addRecipe("dustGlowstone", "glowstone", 250, 400, 80000, RecipeLevel.MODINTERACT);
		this.addRecipe(Blocks.glowstone, "glowstone", 1000, 500, 320000, RecipeLevel.MODINTERACT);
		this.addRecipe("dustRedstone", "redstone", 100, 600, 120000, RecipeLevel.MODINTERACT);
		this.addRecipe(Blocks.redstone_block, "redstone", 900, 750, 1080000, RecipeLevel.MODINTERACT);
		this.addRecipe(Items.ender_pearl, "ender", 250, 400, 240000, RecipeLevel.MODINTERACT);
		this.addRecipe("dustCoal", "coal", 100, 300, 60000, RecipeLevel.MODINTERACT);

		if (ModList.THERMALFOUNDATION.isLoaded()) {
			ItemStack pyro = GameRegistry.findItemStack(ModList.THERMALFOUNDATION.modLabel, "dustPyrotheum", 1);
			this.addRecipe(pyro, "pyrotheum", 250, 1800, 9000000, RecipeLevel.MODINTERACT);

			ItemStack cryo = GameRegistry.findItemStack(ModList.THERMALFOUNDATION.modLabel, "dustCryotheum", 1);
			this.addRecipe(cryo, "cryotheum", 250, -200, 2000, RecipeLevel.MODINTERACT);
		}

		this.addRecipe("shardCrystal", "potion crystal", 8000, 500, 80000, RecipeLevel.MODINTERACT);

		if (ModList.MAGICCROPS.isLoaded() && MagicCropHandler.EssenceType.XP.getEssence() != null)
			this.addRecipe(MagicCropHandler.EssenceType.XP.getEssence(), "mobessence", 200, 600, 360000, RecipeLevel.MODINTERACT);
	}

}
