/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 23/12/2013 3:26:00 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package Reika.RotaryCraft.ModInterface;

import java.util.ArrayList;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelDynamo2 extends RotaryModelBase
{
	//fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public ModelDynamo2()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 16, 10, 16);
		Shape1.setRotationPoint(-8F, 14F, -8F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 70, 0);
		Shape2.addBox(0F, 0F, 0F, 8, 6, 8);
		Shape2.setRotationPoint(-4F, 8F, -4F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		Shape1.render(f5);
		Shape2.render(f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
