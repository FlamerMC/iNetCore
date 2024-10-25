
package net.fc.techdecor.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.fc.techdecor.entity.IPCEntity;
import net.fc.techdecor.client.model.Modeldesktop;

public class IPCRenderer extends MobRenderer<IPCEntity, Modeldesktop<IPCEntity>> {
	public IPCRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldesktop(context.bakeLayer(Modeldesktop.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IPCEntity entity) {
		return ResourceLocation.parse("techdecor:textures/entities/pc.png");
	}
}
