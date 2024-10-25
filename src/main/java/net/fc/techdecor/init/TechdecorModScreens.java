
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.techdecor.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.techdecor.client.gui.WarpsScreen;
import net.fc.techdecor.client.gui.LockScreen;
import net.fc.techdecor.client.gui.HomeScreenScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TechdecorModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TechdecorModMenus.LOCK.get(), LockScreen::new);
		event.register(TechdecorModMenus.HOME_SCREEN.get(), HomeScreenScreen::new);
		event.register(TechdecorModMenus.WARPS.get(), WarpsScreen::new);
	}
}
