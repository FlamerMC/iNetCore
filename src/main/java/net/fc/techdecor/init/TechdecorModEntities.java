
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.fc.techdecor.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.fc.techdecor.entity.MonitorEntity;
import net.fc.techdecor.entity.LaptopEntity;
import net.fc.techdecor.entity.IPCEntity;
import net.fc.techdecor.TechdecorMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TechdecorModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, TechdecorMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<LaptopEntity>> LAPTOP = register("laptop",
			EntityType.Builder.<LaptopEntity>of(LaptopEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<IPCEntity>> IPC = register("ipc", EntityType.Builder.<IPCEntity>of(IPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<MonitorEntity>> MONITOR = register("monitor",
			EntityType.Builder.<MonitorEntity>of(MonitorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		LaptopEntity.init(event);
		IPCEntity.init(event);
		MonitorEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(LAPTOP.get(), LaptopEntity.createAttributes().build());
		event.put(IPC.get(), IPCEntity.createAttributes().build());
		event.put(MONITOR.get(), MonitorEntity.createAttributes().build());
	}
}
