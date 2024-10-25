
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.inetcore.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.inetcore.client.renderer.LaptopRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InetcoreModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(InetcoreModEntities.LAPTOP.get(), LaptopRenderer::new);
	}
}
