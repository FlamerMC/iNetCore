
package net.fc.techdecor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.fc.techdecor.entity.MonitorEntity;
import net.fc.techdecor.client.model.Modelimini;

public class MonitorRenderer extends MobRenderer<MonitorEntity, Modelimini<MonitorEntity>> {
	public MonitorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelimini(context.bakeLayer(Modelimini.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MonitorEntity entity) {
		return ResourceLocation.parse("techdecor:textures/entities/texture1.png");
	}
}
