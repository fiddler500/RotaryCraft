/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 30/05/2013 7:20:24 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.RotaryCraft.Models;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelLandmine extends RotaryModelBase
{
	//fields
	LODModelPart Shape2;
	LODModelPart Shape2a;
	LODModelPart Shape2b;
	LODModelPart Shape2c;
	LODModelPart Shape2d;
	LODModelPart Shape2e;
	LODModelPart Shape2f;
	LODModelPart Shape2g;
	LODModelPart Shape2i;
	LODModelPart Shape21;
	LODModelPart Shape22;
	LODModelPart Shape23;

	public ModelLandmine()
	{
		textureWidth = 64;
		textureHeight = 64;

		Shape2 = new LODModelPart(this, 0, 0);
		Shape2.addBox(-5F, 0F, -5F, 10, 4, 10);
		Shape2.setRotationPoint(0F, 20F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 1.178097F, 0F);
		Shape2a = new LODModelPart(this, 0, 0);
		Shape2a.addBox(-5F, 0F, -5F, 10, 4, 10);
		Shape2a.setRotationPoint(0F, 20F, 0F);
		Shape2a.setTextureSize(64, 64);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0.3926991F, 0F);
		Shape2b = new LODModelPart(this, 0, 31);
		Shape2b.addBox(-2F, 0F, -2F, 4, 1, 4);
		Shape2b.setRotationPoint(0F, 17F, 0F);
		Shape2b.setTextureSize(64, 64);
		Shape2b.mirror = true;
		this.setRotation(Shape2b, 0F, 0F, 0F);
		Shape2c = new LODModelPart(this, 0, 0);
		Shape2c.addBox(-5F, 0F, -5F, 10, 4, 10);
		Shape2c.setRotationPoint(0F, 20F, 0F);
		Shape2c.setTextureSize(64, 64);
		Shape2c.mirror = true;
		this.setRotation(Shape2c, 0F, 0.7853982F, 0F);
		Shape2d = new LODModelPart(this, 0, 0);
		Shape2d.addBox(-5F, 0F, -5F, 10, 4, 10);
		Shape2d.setRotationPoint(0F, 20F, 0F);
		Shape2d.setTextureSize(64, 64);
		Shape2d.mirror = true;
		this.setRotation(Shape2d, 0F, 0F, 0F);
		Shape2e = new LODModelPart(this, 0, 15);
		Shape2e.addBox(-4F, 0F, -4F, 8, 2, 8);
		Shape2e.setRotationPoint(0F, 18F, 0F);
		Shape2e.setTextureSize(64, 64);
		Shape2e.mirror = true;
		this.setRotation(Shape2e, 0F, 0F, 0F);
		Shape2f = new LODModelPart(this, 0, 15);
		Shape2f.addBox(-4F, 0F, -4F, 8, 2, 8);
		Shape2f.setRotationPoint(0F, 18F, 0F);
		Shape2f.setTextureSize(64, 64);
		Shape2f.mirror = true;
		this.setRotation(Shape2f, 0F, 0.3926991F, 0F);
		Shape2g = new LODModelPart(this, 0, 15);
		Shape2g.addBox(-4F, 0F, -4F, 8, 2, 8);
		Shape2g.setRotationPoint(0F, 18F, 0F);
		Shape2g.setTextureSize(64, 64);
		Shape2g.mirror = true;
		this.setRotation(Shape2g, 0F, 0.7853982F, 0F);
		Shape2i = new LODModelPart(this, 0, 15);
		Shape2i.addBox(-4F, 0F, -4F, 8, 2, 8);
		Shape2i.setRotationPoint(0F, 18F, 0F);
		Shape2i.setTextureSize(64, 64);
		Shape2i.mirror = true;
		this.setRotation(Shape2i, 0F, 1.178097F, 0F);
		Shape21 = new LODModelPart(this, 0, 31);
		Shape21.addBox(-2F, 0F, -2F, 4, 1, 4);
		Shape21.setRotationPoint(0F, 17F, 0F);
		Shape21.setTextureSize(64, 64);
		Shape21.mirror = true;
		this.setRotation(Shape21, 0F, 1.178097F, 0F);
		Shape22 = new LODModelPart(this, 0, 31);
		Shape22.addBox(-2F, 0F, -2F, 4, 1, 4);
		Shape22.setRotationPoint(0F, 17F, 0F);
		Shape22.setTextureSize(64, 64);
		Shape22.mirror = true;
		this.setRotation(Shape22, 0F, 0.7853982F, 0F);
		Shape23 = new LODModelPart(this, 0, 31);
		Shape23.addBox(-2F, 0F, -2F, 4, 1, 4);
		Shape23.setRotationPoint(0F, 17F, 0F);
		Shape23.setTextureSize(64, 64);
		Shape23.mirror = true;
		this.setRotation(Shape23, 0F, 0.3926991F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		Shape2.render(te, f5);
		Shape2a.render(te, f5);
		Shape2b.render(te, f5);
		Shape2c.render(te, f5);
		Shape2d.render(te, f5);
		Shape2e.render(te, f5);
		Shape2f.render(te, f5);
		Shape2g.render(te, f5);
		Shape2i.render(te, f5);
		Shape21.render(te, f5);
		Shape22.render(te, f5);
		Shape23.render(te, f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f6)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
