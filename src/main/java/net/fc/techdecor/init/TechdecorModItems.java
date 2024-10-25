
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.techdecor.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.item.Item;

import net.fc.techdecor.item.PhoneItem;
import net.fc.techdecor.item.PhabletItem;
import net.fc.techdecor.TechdecorMod;

public class TechdecorModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TechdecorMod.MODID);
	public static final DeferredItem<Item> PHONE = REGISTRY.register("phone", PhoneItem::new);
	public static final DeferredItem<Item> LAPTOP_SPAWN_EGG = REGISTRY.register("laptop_spawn_egg", () -> new DeferredSpawnEggItem(TechdecorModEntities.LAPTOP, -10066330, -16711885, new Item.Properties()));
	public static final DeferredItem<Item> PHABLET = REGISTRY.register("phablet", PhabletItem::new);
	public static final DeferredItem<Item> IPC_SPAWN_EGG = REGISTRY.register("ipc_spawn_egg", () -> new DeferredSpawnEggItem(TechdecorModEntities.IPC, -6710887, -6684775, new Item.Properties()));
	public static final DeferredItem<Item> MONITOR_SPAWN_EGG = REGISTRY.register("monitor_spawn_egg", () -> new DeferredSpawnEggItem(TechdecorModEntities.MONITOR, -16764109, -13369498, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
