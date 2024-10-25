
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.inetcore.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.fc.inetcore.item.PhoneItem;
import net.fc.inetcore.item.PhabletItem;
import net.fc.inetcore.InetcoreMod;

public class InetcoreModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(InetcoreMod.MODID);
	public static final DeferredItem<Item> PHONE = REGISTRY.register("phone", PhoneItem::new);
	public static final DeferredItem<Item> LAPTOP_SPAWN_EGG = REGISTRY.register("laptop_spawn_egg", () -> new DeferredSpawnEggItem(InetcoreModEntities.LAPTOP, -1, -1, new Item.Properties()));
	public static final DeferredItem<Item> PHABLET = REGISTRY.register("phablet", PhabletItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
