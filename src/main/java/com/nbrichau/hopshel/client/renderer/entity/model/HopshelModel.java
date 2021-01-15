package com.nbrichau.hopshel.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.nbrichau.hopshel.entity.HopshelEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class HopshelModel extends EntityModel<HopshelEntity> {

	private final ModelRenderer body;
	private final ModelRenderer shell_head;
	private final ModelRenderer shell_left;
	private final ModelRenderer shell_right;
	private final ModelRenderer legs;

	public HopshelModel() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 21.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 5.0F, 8.0F, 0.0F, false);

		shell_head = new ModelRenderer(this);
		shell_head.setRotationPoint(0.0F, -2.0F, -1.0F);
		body.addChild(shell_head);
		setRotationAngle(shell_head, -1.0472F, 0.0F, 0.0F);
		shell_head.setTextureOffset(0, 15).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 5.0F, 2.0F, 0.0F, false);

		shell_left = new ModelRenderer(this);
		shell_left.setRotationPoint(3.5F, -3.5F, 3.5F);
		body.addChild(shell_left);
		setRotationAngle(shell_left, 0.0F, -0.2618F, -0.7854F);
		shell_left.setTextureOffset(30, 1).addBox(-0.5F, -2.5F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);

		shell_right = new ModelRenderer(this);
		shell_right.setRotationPoint(-3.5F, -3.5F, 3.5F);
		body.addChild(shell_right);
		setRotationAngle(shell_right, 0.0F, 0.2618F, 0.7854F);
		shell_right.setTextureOffset(30, 1).addBox(-0.5F, -2.5F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(legs);
		legs.setTextureOffset(0, 0).addBox(2.0F, 1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		legs.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, -3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		legs.setTextureOffset(0, 0).addBox(-3.0F, 1.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		legs.setTextureOffset(0, 0).addBox(2.0F, 1.0F, 1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(HopshelEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entityIn.isShielding()) {
			shell_head.rotateAngleX = 0F;
		} else {
			shell_head.rotateAngleX = -60F * ((float) Math.PI / 180F);
		}
	}

	private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
