/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 30/11/2013 3:25:03 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.RotaryCraft.Models;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelBigFurnace extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2;
	LODModelPart Shape2a;
	LODModelPart Shape3;
	LODModelPart Shape3a;
	LODModelPart Shape4;
	LODModelPart Shape4a;
	LODModelPart Shape5;
	LODModelPart Shape5a;
	LODModelPart Shape6;
	LODModelPart Shape6a;
	LODModelPart Shape6b;
	LODModelPart Shape6c;
	LODModelPart Shape6d;
	LODModelPart Shape6e;
	LODModelPart Shape6f;
	LODModelPart Shape6g;
	LODModelPart Shape6h;
	LODModelPart Shape6i;
	LODModelPart Shape6j;
	LODModelPart Shape6k;
	LODModelPart Shape6l;
	LODModelPart Shape6m;
	LODModelPart Shape6n;
	LODModelPart Shape6o;
	LODModelPart Shape6p;
	LODModelPart Shape6q;
	LODModelPart Shape6r;
	LODModelPart Shape6s;
	LODModelPart Shape6t;
	LODModelPart Shape7;

	public ModelBigFurnace()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new LODModelPart(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 16, 1, 16);
		Shape1.setRotationPoint(-8F, 23F, -8F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new LODModelPart(this, 65, 0);
		Shape2.addBox(0F, 0F, 0F, 16, 15, 1);
		Shape2.setRotationPoint(-8F, 8F, 7F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape2a = new LODModelPart(this, 65, 0);
		Shape2a.addBox(0F, 0F, 0F, 16, 15, 1);
		Shape2a.setRotationPoint(-8F, 8F, -8F);
		Shape2a.setTextureSize(128, 128);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, 0F);
		Shape3 = new LODModelPart(this, 0, 18);
		Shape3.addBox(0F, 0F, 0F, 1, 15, 14);
		Shape3.setRotationPoint(7F, 8F, -7F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape3a = new LODModelPart(this, 0, 18);
		Shape3a.addBox(0F, 0F, 0F, 1, 15, 14);
		Shape3a.setRotationPoint(-8F, 8F, -7F);
		Shape3a.setTextureSize(128, 128);
		Shape3a.mirror = true;
		this.setRotation(Shape3a, 0F, 0F, 0F);
		Shape4 = new LODModelPart(this, 0, 48);
		Shape4.addBox(0F, 0F, 0F, 12, 15, 1);
		Shape4.setRotationPoint(-6F, 8F, 5F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		this.setRotation(Shape4, 0F, 0F, 0F);
		Shape4a = new LODModelPart(this, 0, 48);
		Shape4a.addBox(0F, 0F, 0F, 12, 15, 1);
		Shape4a.setRotationPoint(-6F, 8F, -6F);
		Shape4a.setTextureSize(128, 128);
		Shape4a.mirror = true;
		this.setRotation(Shape4a, 0F, 0F, 0F);
		Shape5 = new LODModelPart(this, 31, 18);
		Shape5.addBox(0F, 0F, 0F, 1, 15, 10);
		Shape5.setRotationPoint(5F, 8F, -5F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		this.setRotation(Shape5, 0F, 0F, 0F);
		Shape5a = new LODModelPart(this, 31, 18);
		Shape5a.addBox(0F, 0F, 0F, 1, 15, 10);
		Shape5a.setRotationPoint(-6F, 8F, -5F);
		Shape5a.setTextureSize(128, 128);
		Shape5a.mirror = true;
		this.setRotation(Shape5a, 0F, 0F, 0F);
		Shape6 = new LODModelPart(this, 0, 65);
		Shape6.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6.setRotationPoint(-6.5F, 8.5F, 4F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		this.setRotation(Shape6, 0F, 0F, 0F);
		Shape6a = new LODModelPart(this, 0, 65);
		Shape6a.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6a.setRotationPoint(-6.5F, 8.5F, -5F);
		Shape6a.setTextureSize(128, 128);
		Shape6a.mirror = true;
		this.setRotation(Shape6a, 0F, 0F, 0F);
		Shape6b = new LODModelPart(this, 0, 65);
		Shape6b.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6b.setRotationPoint(-6.5F, 8.5F, -2.75F);
		Shape6b.setTextureSize(128, 128);
		Shape6b.mirror = true;
		this.setRotation(Shape6b, 0F, 0F, 0F);
		Shape6c = new LODModelPart(this, 0, 65);
		Shape6c.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6c.setRotationPoint(-6.5F, 8.5F, -0.5F);
		Shape6c.setTextureSize(128, 128);
		Shape6c.mirror = true;
		this.setRotation(Shape6c, 0F, 0F, 0F);
		Shape6d = new LODModelPart(this, 0, 65);
		Shape6d.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6d.setRotationPoint(-6.5F, 8.5F, 1.75F);
		Shape6d.setTextureSize(128, 128);
		Shape6d.mirror = true;
		this.setRotation(Shape6d, 0F, 0F, 0F);
		Shape6e = new LODModelPart(this, 0, 65);
		Shape6e.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6e.setRotationPoint(1.75F, 8.5F, -6.5F);
		Shape6e.setTextureSize(128, 128);
		Shape6e.mirror = true;
		this.setRotation(Shape6e, 0F, 0F, 0F);
		Shape6f = new LODModelPart(this, 0, 65);
		Shape6f.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6f.setRotationPoint(5.5F, 8.5F, -2.75F);
		Shape6f.setTextureSize(128, 128);
		Shape6f.mirror = true;
		this.setRotation(Shape6f, 0F, 0F, 0F);
		Shape6g = new LODModelPart(this, 0, 65);
		Shape6g.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6g.setRotationPoint(5.5F, 8.5F, -0.5F);
		Shape6g.setTextureSize(128, 128);
		Shape6g.mirror = true;
		this.setRotation(Shape6g, 0F, 0F, 0F);
		Shape6h = new LODModelPart(this, 0, 65);
		Shape6h.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6h.setRotationPoint(5.5F, 8.5F, 1.75F);
		Shape6h.setTextureSize(128, 128);
		Shape6h.mirror = true;
		this.setRotation(Shape6h, 0F, 0F, 0F);
		Shape6i = new LODModelPart(this, 0, 65);
		Shape6i.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6i.setRotationPoint(5.5F, 8.5F, 4F);
		Shape6i.setTextureSize(128, 128);
		Shape6i.mirror = true;
		this.setRotation(Shape6i, 0F, 0F, 0F);
		Shape6j = new LODModelPart(this, 0, 65);
		Shape6j.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6j.setRotationPoint(5.5F, 8.5F, -5F);
		Shape6j.setTextureSize(128, 128);
		Shape6j.mirror = true;
		this.setRotation(Shape6j, 0F, 0F, 0F);
		Shape6k = new LODModelPart(this, 0, 65);
		Shape6k.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6k.setRotationPoint(4F, 8.5F, 5.5F);
		Shape6k.setTextureSize(128, 128);
		Shape6k.mirror = true;
		this.setRotation(Shape6k, 0F, 0F, 0F);
		Shape6l = new LODModelPart(this, 0, 65);
		Shape6l.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6l.setRotationPoint(-5F, 8.5F, 5.5F);
		Shape6l.setTextureSize(128, 128);
		Shape6l.mirror = true;
		this.setRotation(Shape6l, 0F, 0F, 0F);
		Shape6m = new LODModelPart(this, 0, 65);
		Shape6m.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6m.setRotationPoint(-2.75F, 8.5F, 5.5F);
		Shape6m.setTextureSize(128, 128);
		Shape6m.mirror = true;
		this.setRotation(Shape6m, 0F, 0F, 0F);
		Shape6n = new LODModelPart(this, 0, 65);
		Shape6n.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6n.setRotationPoint(-0.5F, 8.5F, 5.5F);
		Shape6n.setTextureSize(128, 128);
		Shape6n.mirror = true;
		this.setRotation(Shape6n, 0F, 0F, 0F);
		Shape6o = new LODModelPart(this, 0, 65);
		Shape6o.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6o.setRotationPoint(4F, 8.5F, -6.5F);
		Shape6o.setTextureSize(128, 128);
		Shape6o.mirror = true;
		this.setRotation(Shape6o, 0F, 0F, 0F);
		Shape6p = new LODModelPart(this, 0, 65);
		Shape6p.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6p.setRotationPoint(1.75F, 8.5F, 5.5F);
		Shape6p.setTextureSize(128, 128);
		Shape6p.mirror = true;
		this.setRotation(Shape6p, 0F, 0F, 0F);
		Shape6q = new LODModelPart(this, 0, 65);
		Shape6q.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6q.setRotationPoint(1.75F, 8.5F, -6.5F);
		Shape6q.setTextureSize(128, 128);
		Shape6q.mirror = true;
		this.setRotation(Shape6q, 0F, 0F, 0F);
		Shape6r = new LODModelPart(this, 0, 65);
		Shape6r.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6r.setRotationPoint(-0.5F, 8.5F, -6.5F);
		Shape6r.setTextureSize(128, 128);
		Shape6r.mirror = true;
		this.setRotation(Shape6r, 0F, 0F, 0F);
		Shape6s = new LODModelPart(this, 0, 65);
		Shape6s.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6s.setRotationPoint(-2.75F, 8.5F, -6.5F);
		Shape6s.setTextureSize(128, 128);
		Shape6s.mirror = true;
		this.setRotation(Shape6s, 0F, 0F, 0F);
		Shape6t = new LODModelPart(this, 0, 65);
		Shape6t.addBox(0F, 0F, 0F, 1, 15, 1);
		Shape6t.setRotationPoint(-5F, 8.5F, -6.5F);
		Shape6t.setTextureSize(128, 128);
		Shape6t.mirror = true;
		this.setRotation(Shape6t, 0F, 0F, 0F);
		Shape7 = new LODModelPart(this, 5, 65);
		Shape7.addBox(0F, 0F, 0F, 10, 1, 10);
		Shape7.setRotationPoint(-5F, 8F, -5F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		this.setRotation(Shape7, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		Shape1.render(te, f5);
		Shape2.render(te, f5);
		Shape2a.render(te, f5);
		Shape3.render(te, f5);
		Shape3a.render(te, f5);
		Shape4.render(te, f5);
		Shape4a.render(te, f5);
		Shape5.render(te, f5);
		Shape5a.render(te, f5);
		Shape6.render(te, f5);
		Shape6a.render(te, f5);
		Shape6b.render(te, f5);
		Shape6c.render(te, f5);
		Shape6d.render(te, f5);
		Shape6e.render(te, f5);
		Shape6f.render(te, f5);
		Shape6g.render(te, f5);
		Shape6h.render(te, f5);
		Shape6i.render(te, f5);
		Shape6j.render(te, f5);
		Shape6k.render(te, f5);
		Shape6l.render(te, f5);
		Shape6m.render(te, f5);
		Shape6n.render(te, f5);
		Shape6o.render(te, f5);
		Shape6p.render(te, f5);
		Shape6q.render(te, f5);
		Shape6r.render(te, f5);
		Shape6s.render(te, f5);
		Shape6t.render(te, f5);
		Shape7.render(te, f5);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
