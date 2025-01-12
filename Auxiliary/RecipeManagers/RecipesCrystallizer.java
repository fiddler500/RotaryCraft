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

import java.util.Collection;
import java.util.Collections;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import Reika.DragonAPI.Instantiable.Data.Collections.OneWayCollections.OneWayMap;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.RotaryCraft.API.RecipeInterface;
import Reika.RotaryCraft.API.RecipeInterface.CrystallizerManager;
import Reika.RotaryCraft.Registry.ItemRegistry;

public class RecipesCrystallizer extends RecipeHandler implements CrystallizerManager {

	private static final RecipesCrystallizer CrystallizerBase = new RecipesCrystallizer();

	private final OneWayMap<Fluid, ItemStack> recipeList = new OneWayMap();
	private final OneWayMap<Fluid, Integer> amounts = new OneWayMap();

	public static final RecipesCrystallizer getRecipes()
	{
		return CrystallizerBase;
	}

	private RecipesCrystallizer() {
		RecipeInterface.crystallizer = this;

		this.addRecipe(FluidRegistry.WATER, 1000, new ItemStack(Blocks.ice), RecipeLevel.CORE);
		this.addRecipe(FluidRegistry.LAVA, 1000, new ItemStack(Blocks.stone), RecipeLevel.PERIPHERAL);

		this.addRecipe("rc ethanol", 1000, ItemRegistry.ETHANOL.getStackOf(), RecipeLevel.PROTECTED);
	}

	public void addAPIRecipe(Fluid f, int amount, ItemStack out) {
		this.addRecipe(f, amount, out, RecipeLevel.API);
	}

	private void addRecipe(Fluid f, int amount, ItemStack out, RecipeLevel rl) {
		recipeList.put(f, out);
		amounts.put(f, amount);
	}

	private void addRecipe(String s, int amount, ItemStack out, RecipeLevel rl) {
		Fluid f = FluidRegistry.getFluid(s);
		if (f != null)
			this.addRecipe(f, amount, out, rl);
	}

	public ItemStack getFreezingResult(FluidStack liquid)
	{
		Fluid f = liquid.getFluid();
		if (amounts.containsKey(f)) {
			int req = amounts.get(f);
			if (req > liquid.amount)
				return null;
			return recipeList.get(f).copy();
		}
		else
			return null;
	}

	public Fluid getRecipe(ItemStack result) {
		for (Fluid f : recipeList.keySet()) {
			ItemStack is = recipeList.get(f);
			if (ReikaItemHelper.matchStacks(result, is))
				return f;
		}
		return null;
	}

	public int getRecipeConsumption(ItemStack result) {
		for (Fluid f : recipeList.keySet()) {
			ItemStack is = recipeList.get(f);
			if (ReikaItemHelper.matchStacks(result, is))
				return amounts.get(f);
		}
		return 0;
	}

	public boolean isValidFluid(Fluid f) {
		return recipeList.containsKey(f);
	}

	public Collection<Fluid> getAllRecipes() {
		return Collections.unmodifiableCollection(recipeList.keySet());
	}

	@Override
	public void addPostLoadRecipes() {
		this.addRecipe("ender", 250, new ItemStack(Items.ender_pearl), RecipeLevel.MODINTERACT);
		this.addRecipe("redstone", 100, new ItemStack(Items.redstone), RecipeLevel.MODINTERACT);
		this.addRecipe("glowstone", 250, new ItemStack(Items.glowstone_dust), RecipeLevel.MODINTERACT);
		this.addRecipe("coal", 100, new ItemStack(Items.coal), RecipeLevel.MODINTERACT);
	}
}
