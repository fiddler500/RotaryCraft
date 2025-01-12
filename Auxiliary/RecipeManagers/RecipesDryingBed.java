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

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import Reika.DragonAPI.Instantiable.Data.Collections.OneWayCollections.OneWayMap;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
import Reika.RotaryCraft.API.RecipeInterface;
import Reika.RotaryCraft.API.RecipeInterface.DryingBedManager;
import Reika.RotaryCraft.Auxiliary.ItemStacks;

public class RecipesDryingBed extends RecipeHandler implements DryingBedManager {

	private static final RecipesDryingBed DryingBase = new RecipesDryingBed();

	private OneWayMap<Fluid, ItemStack> recipeList = new OneWayMap();
	private OneWayMap<Fluid, Integer> amounts = new OneWayMap();

	public static final RecipesDryingBed getRecipes()
	{
		return DryingBase;
	}

	private RecipesDryingBed()
	{
		RecipeInterface.dryingbed = this;

		this.addRecipe(FluidRegistry.WATER, 250, ItemStacks.salt, RecipeLevel.CORE);
		this.addRecipe(FluidRegistry.LAVA, 1000, new ItemStack(Items.gold_nugget), RecipeLevel.PERIPHERAL);
		this.addRecipe("oil", 200, ItemStacks.tar, RecipeLevel.PERIPHERAL);
		this.addRecipe("for.honey", 400, new ItemStack(Items.slime_ball), RecipeLevel.PERIPHERAL);
		this.addRecipe("honey", 400, new ItemStack(Items.slime_ball), RecipeLevel.PERIPHERAL);

		this.addRecipe("chroma", 2000, new ItemStack(Items.emerald), RecipeLevel.MODINTERACT);
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

	public ItemStack getDryingResult(FluidStack liquid)
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

	public boolean isRecipeFluid(Fluid f) {
		return recipeList.containsKey(f);
	}

	public Collection<Fluid> getAllRecipes() {
		return Collections.unmodifiableCollection(recipeList.keySet());
	}

	@Override
	public void addPostLoadRecipes() {
		ArrayList<ItemStack> li = OreDictionary.getOres("rubber");
		if (li == null || li.isEmpty()) {
			li = OreDictionary.getOres("itemRubber");
		}
		if (li != null && !li.isEmpty())
			this.addRecipe("lubricant", 100, li.get(0), RecipeLevel.MODINTERACT);
	}
}
