
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.inetcore.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.inetcore.client.model.Modellaptop;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InetcoreModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modellaptop.LAYER_LOCATION, Modellaptop::createBodyLayer);
	}
}
