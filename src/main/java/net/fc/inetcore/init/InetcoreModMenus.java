
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.inetcore.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.fc.inetcore.world.inventory.WarpsMenu;
import net.fc.inetcore.world.inventory.LockMenu;
import net.fc.inetcore.world.inventory.HomeScreenMenu;
import net.fc.inetcore.InetcoreMod;

public class InetcoreModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, InetcoreMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<LockMenu>> LOCK = REGISTRY.register("lock", () -> IMenuTypeExtension.create(LockMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HomeScreenMenu>> HOME_SCREEN = REGISTRY.register("home_screen", () -> IMenuTypeExtension.create(HomeScreenMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WarpsMenu>> WARPS = REGISTRY.register("warps", () -> IMenuTypeExtension.create(WarpsMenu::new));
}
