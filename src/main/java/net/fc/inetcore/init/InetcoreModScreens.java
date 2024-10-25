
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.inetcore.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.fc.inetcore.client.gui.WarpsScreen;
import net.fc.inetcore.client.gui.LockScreen;
import net.fc.inetcore.client.gui.HomeScreenScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InetcoreModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(InetcoreModMenus.LOCK.get(), LockScreen::new);
		event.register(InetcoreModMenus.HOME_SCREEN.get(), HomeScreenScreen::new);
		event.register(InetcoreModMenus.WARPS.get(), WarpsScreen::new);
	}
}
