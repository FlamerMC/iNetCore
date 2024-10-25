
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.techdecor.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.techdecor.client.model.Modellaptop;
import net.fc.techdecor.client.model.Modelimini;
import net.fc.techdecor.client.model.Modeldesktop;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TechdecorModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modellaptop.LAYER_LOCATION, Modellaptop::createBodyLayer);
		event.registerLayerDefinition(Modelimini.LAYER_LOCATION, Modelimini::createBodyLayer);
		event.registerLayerDefinition(Modeldesktop.LAYER_LOCATION, Modeldesktop::createBodyLayer);
	}
}
