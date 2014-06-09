/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 17/02/2013 1:31:47 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.RotaryCraft.Models.Animated;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;


public class ModelFlywheel extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2;
	LODModelPart Shape3;
	LODModelPart Shape4;
	LODModelPart Shape5;
	LODModelPart Shape6;
	LODModelPart Shape7;
	LODModelPart Shape8;
	LODModelPart Shape9;
	LODModelPart Shape10;
	LODModelPart Shape11;
	LODModelPart Shape13;
	LODModelPart Shape15;
	LODModelPart Shape16;
	LODModelPart Shape17;
	LODModelPart Shape18;
	LODModelPart Shape12;
	LODModelPart Shape14;
	LODModelPart Shape19;
	LODModelPart Shape20;
	LODModelPart Shape21;
	LODModelPart Shape22;
	LODModelPart Shape23;
	LODModelPart Shape24;
	LODModelPart Shape25;
	LODModelPart Shape26;
	LODModelPart Shape27;
	LODModelPart Shape28;
	LODModelPart Shape29;
	LODModelPart Shape30;
	LODModelPart Shape31;
	LODModelPart Shape32;
	LODModelPart Shape33;
	LODModelPart Shape34;
	LODModelPart Shape35;

	public ModelFlywheel()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new LODModelPart(this, 0, 22);
		Shape1.addBox(0F, 0F, 0F, 17, 2, 2);
		Shape1.setRotationPoint(-8.5F, 15F, -1F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new LODModelPart(this, 0, 22);
		Shape2.addBox(0F, 0F, 0F, 17, 2, 2);
		Shape2.setRotationPoint(-8.5F, 16F, -1.4F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0.7853982F, 0F, 0F);
		Shape3 = new LODModelPart(this, 0, 26);
		Shape3.addBox(0F, 0F, 0F, 1, 10, 10);
		Shape3.setRotationPoint(1F, 13.5F, -6.5F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0.3926991F, 0F, 0F);
		Shape4 = new LODModelPart(this, 0, 26);
		Shape4.addBox(0F, 0F, 0F, 1, 10, 10);
		Shape4.setRotationPoint(1F, 16F, -7F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0.7853982F, 0F, 0F);
		Shape5 = new LODModelPart(this, 0, 26);
		Shape5.addBox(0F, 0F, 0F, 1, 10, 10);
		Shape5.setRotationPoint(1F, 11F, -5F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new LODModelPart(this, 0, 26);
		Shape6.addBox(0F, 0F, 0F, 1, 10, 10);
		Shape6.setRotationPoint(1F, 9.5F, -2.8F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		this.setRotation(Shape6, -0.3926991F, 0F, 0F);
		Shape7 = new LODModelPart(this, 0, 46);
		Shape7.addBox(0F, 0F, 0F, 2, 3, 10);
		Shape7.setRotationPoint(-1F, 18F, -5F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		this.setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new LODModelPart(this, 98, 10);
		Shape8.addBox(0F, 0F, 0F, 1, 6, 2);
		Shape8.setRotationPoint(-2F, 13F, -5F);
		Shape8.setTextureSize(128, 128);
		Shape8.mirror = true;
		this.setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new LODModelPart(this, 0, 59);
		Shape9.addBox(0F, 0F, 0F, 1, 2, 10);
		Shape9.setRotationPoint(-2F, 19F, -5F);
		Shape9.setTextureSize(128, 128);
		Shape9.mirror = true;
		this.setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new LODModelPart(this, 54, 17);
		Shape10.addBox(0F, 0F, 0F, 2, 4, 3);
		Shape10.setRotationPoint(-1F, 14F, -5F);
		Shape10.setTextureSize(128, 128);
		Shape10.mirror = true;
		this.setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new LODModelPart(this, 0, 46);
		Shape11.addBox(0F, 0F, 0F, 2, 3, 10);
		Shape11.setRotationPoint(-1F, 11F, -5F);
		Shape11.setTextureSize(128, 128);
		Shape11.mirror = true;
		this.setRotation(Shape11, 0F, 0F, 0F);
		Shape13 = new LODModelPart(this, 54, 17);
		Shape13.addBox(0F, 0F, 0F, 2, 4, 3);
		Shape13.setRotationPoint(-1F, 14F, 2F);
		Shape13.setTextureSize(128, 128);
		Shape13.mirror = true;
		this.setRotation(Shape13, 0F, 0F, 0F);
		Shape15 = new LODModelPart(this, 0, 59);
		Shape15.addBox(0F, 0F, 0F, 1, 2, 10);
		Shape15.setRotationPoint(-2F, 11F, -5F);
		Shape15.setTextureSize(128, 128);
		Shape15.mirror = true;
		this.setRotation(Shape15, 0F, 0F, 0F);
		Shape16 = new LODModelPart(this, 114, 3);
		Shape16.addBox(0F, 0F, 0F, 1, 1, 2);
		Shape16.setRotationPoint(-3F, 11F, -4F);
		Shape16.setTextureSize(128, 128);
		Shape16.mirror = true;
		this.setRotation(Shape16, 0F, 0F, 0F);
		Shape17 = new LODModelPart(this, 98, 10);
		Shape17.addBox(0F, 0F, 0F, 1, 6, 2);
		Shape17.setRotationPoint(-2F, 13F, 3F);
		Shape17.setTextureSize(128, 128);
		Shape17.mirror = true;
		this.setRotation(Shape17, 0F, 0F, 0F);
		Shape18 = new LODModelPart(this, 104, 0);
		Shape18.addBox(0F, 0F, 0F, 4, 4, 1);
		Shape18.setRotationPoint(-3F, 14F, -6F);
		Shape18.setTextureSize(128, 128);
		Shape18.mirror = true;
		this.setRotation(Shape18, 0F, 0F, 0F);
		Shape12 = new LODModelPart(this, 98, 5);
		Shape12.addBox(0F, 0F, 0F, 4, 1, 4);
		Shape12.setRotationPoint(-3F, 21F, -2F);
		Shape12.setTextureSize(128, 128);
		Shape12.mirror = true;
		this.setRotation(Shape12, 0F, 0F, 0F);
		Shape14 = new LODModelPart(this, 114, 3);
		Shape14.addBox(0F, 0F, 0F, 1, 1, 2);
		Shape14.setRotationPoint(-3F, 20F, -4F);
		Shape14.setTextureSize(128, 128);
		Shape14.mirror = true;
		this.setRotation(Shape14, 0F, 0F, 0F);
		Shape19 = new LODModelPart(this, 98, 5);
		Shape19.addBox(0F, 0F, 0F, 4, 1, 4);
		Shape19.setRotationPoint(-3F, 10F, -2F);
		Shape19.setTextureSize(128, 128);
		Shape19.mirror = true;
		this.setRotation(Shape19, 0F, 0F, 0F);
		Shape20 = new LODModelPart(this, 114, 0);
		Shape20.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape20.setRotationPoint(-3F, 18F, -5F);
		Shape20.setTextureSize(128, 128);
		Shape20.mirror = true;
		this.setRotation(Shape20, 0F, 0F, 0F);
		Shape21 = new LODModelPart(this, 114, 3);
		Shape21.addBox(0F, 0F, 0F, 1, 1, 2);
		Shape21.setRotationPoint(-3F, 20F, 2F);
		Shape21.setTextureSize(128, 128);
		Shape21.mirror = true;
		this.setRotation(Shape21, 0F, 0F, 0F);
		Shape22 = new LODModelPart(this, 114, 3);
		Shape22.addBox(0F, 0F, 0F, 1, 1, 2);
		Shape22.setRotationPoint(-3F, 11F, 2F);
		Shape22.setTextureSize(128, 128);
		Shape22.mirror = true;
		this.setRotation(Shape22, 0F, 0F, 0F);
		Shape23 = new LODModelPart(this, 114, 0);
		Shape23.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape23.setRotationPoint(-3F, 12F, -5F);
		Shape23.setTextureSize(128, 128);
		Shape23.mirror = true;
		this.setRotation(Shape23, 0F, 0F, 0F);
		Shape24 = new LODModelPart(this, 104, 0);
		Shape24.addBox(0F, 0F, 0F, 4, 4, 1);
		Shape24.setRotationPoint(-3F, 14F, 5F);
		Shape24.setTextureSize(128, 128);
		Shape24.mirror = true;
		this.setRotation(Shape24, 0F, 0F, 0F);
		Shape25 = new LODModelPart(this, 114, 0);
		Shape25.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape25.setRotationPoint(-3F, 12F, 4F);
		Shape25.setTextureSize(128, 128);
		Shape25.mirror = true;
		this.setRotation(Shape25, 0F, 0F, 0F);
		Shape26 = new LODModelPart(this, 114, 0);
		Shape26.addBox(0F, 0F, 0F, 1, 2, 1);
		Shape26.setRotationPoint(-3F, 18F, 4F);
		Shape26.setTextureSize(128, 128);
		Shape26.mirror = true;
		this.setRotation(Shape26, 0F, 0F, 0F);
		Shape27 = new LODModelPart(this, 98, 0);
		Shape27.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape27.setRotationPoint(-1F, 17F, 1F);
		Shape27.setTextureSize(128, 128);
		Shape27.mirror = true;
		this.setRotation(Shape27, 0F, 0F, 0F);
		Shape28 = new LODModelPart(this, 98, 0);
		Shape28.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape28.setRotationPoint(-1F, 17F, -2F);
		Shape28.setTextureSize(128, 128);
		Shape28.mirror = true;
		this.setRotation(Shape28, 0F, 0F, 0F);
		Shape29 = new LODModelPart(this, 98, 0);
		Shape29.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape29.setRotationPoint(-1F, 14F, 1F);
		Shape29.setTextureSize(128, 128);
		Shape29.mirror = true;
		this.setRotation(Shape29, 0F, 0F, 0F);
		Shape30 = new LODModelPart(this, 98, 0);
		Shape30.addBox(0F, 0F, 0F, 2, 1, 1);
		Shape30.setRotationPoint(-1F, 14F, -2F);
		Shape30.setTextureSize(128, 128);
		Shape30.mirror = true;
		this.setRotation(Shape30, 0F, 0F, 0F);
		Shape31 = new LODModelPart(this, 0, 0);
		Shape31.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape31.setRotationPoint(-8F, 23F, -8F);
		Shape31.setTextureSize(128, 128);
		Shape31.mirror = true;
		this.setRotation(Shape31, 0F, 0F, 0F);
		Shape32 = new LODModelPart(this, 64, 0);
		Shape32.addBox(0F, 0F, 0F, 1, 12, 16);
		Shape32.setRotationPoint(-8F, 11F, -8F);
		Shape32.setTextureSize(128, 128);
		Shape32.mirror = true;
		this.setRotation(Shape32, 0F, 0F, 0F);
		Shape33 = new LODModelPart(this, 64, 0);
		Shape33.addBox(0F, 0F, 0F, 1, 12, 16);
		Shape33.setRotationPoint(7F, 11F, -8F);
		Shape33.setTextureSize(128, 128);
		Shape33.mirror = true;
		this.setRotation(Shape33, 0F, 0F, 0F);
		Shape34 = new LODModelPart(this, 0, 17);
		Shape34.addBox(0F, 0F, 0F, 14, 4, 1);
		Shape34.setRotationPoint(-7F, 19F, 7F);
		Shape34.setTextureSize(128, 128);
		Shape34.mirror = true;
		this.setRotation(Shape34, 0F, 0F, 0F);
		Shape35 = new LODModelPart(this, 0, 17);
		Shape35.addBox(0F, 0F, 0F, 14, 4, 1);
		Shape35.setRotationPoint(-7F, 19F, -8F);
		Shape35.setTextureSize(128, 128);
		Shape35.mirror = true;
		this.setRotation(Shape35, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		boolean failed = (Boolean)li.get(0);
		GL11.glTranslated(0, 1, 0);
		GL11.glRotatef(phi, 1, 0, 0);
		GL11.glTranslated(0, -1, 0);
		Shape1.render(te, f5);
		Shape2.render(te, f5);
		if (!failed) {
			Shape3.render(te, f5);
			Shape4.render(te, f5);
			Shape5.render(te, f5);
			Shape6.render(te, f5);
			Shape7.render(te, f5);
			Shape8.render(te, f5);
			Shape9.render(te, f5);
			Shape10.render(te, f5);
			Shape11.render(te, f5);
			Shape13.render(te, f5);
			Shape15.render(te, f5);
			Shape16.render(te, f5);
			Shape17.render(te, f5);
			Shape18.render(te, f5);
			Shape12.render(te, f5);
			Shape14.render(te, f5);
			Shape19.render(te, f5);
			Shape20.render(te, f5);
			Shape21.render(te, f5);
			Shape22.render(te, f5);
			Shape23.render(te, f5);
			Shape24.render(te, f5);
			Shape25.render(te, f5);
			Shape26.render(te, f5);
			Shape27.render(te, f5);
			Shape28.render(te, f5);
			Shape29.render(te, f5);
			Shape30.render(te, f5);
		}
		GL11.glTranslated(0, 1, 0);
		GL11.glRotatef(-phi, 1, 0, 0);
		GL11.glTranslated(0, -1, 0);
		Shape31.render(te, f5);
		Shape32.render(te, f5);
		Shape33.render(te, f5);
		Shape34.render(te, f5);
		Shape35.render(te, f5);
	}

}
