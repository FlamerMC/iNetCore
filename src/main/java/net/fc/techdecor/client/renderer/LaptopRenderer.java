
package net.fc.techdecor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.fc.techdecor.entity.LaptopEntity;
import net.fc.techdecor.client.model.Modellaptop;

public class LaptopRenderer extends MobRenderer<LaptopEntity, Modellaptop<LaptopEntity>> {
	public LaptopRenderer(EntityRendererProvider.Context context) {
		super(context, new Modellaptop(context.bakeLayer(Modellaptop.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LaptopEntity entity) {
		return ResourceLocation.parse("techdecor:textures/entities/texture.png");
	}
}
