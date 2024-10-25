
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.techdecor.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.techdecor.client.renderer.MonitorRenderer;
import net.fc.techdecor.client.renderer.LaptopRenderer;
import net.fc.techdecor.client.renderer.IPCRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TechdecorModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TechdecorModEntities.LAPTOP.get(), LaptopRenderer::new);
		event.registerEntityRenderer(TechdecorModEntities.IPC.get(), IPCRenderer::new);
		event.registerEntityRenderer(TechdecorModEntities.MONITOR.get(), MonitorRenderer::new);
	}
}
