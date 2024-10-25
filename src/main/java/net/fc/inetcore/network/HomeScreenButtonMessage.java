
package net.fc.inetcore.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.fc.inetcore.world.inventory.HomeScreenMenu;
import net.fc.inetcore.procedures.OpenwarpsProcedure;
import net.fc.inetcore.procedures.HomeButtonProcedure;
import net.fc.inetcore.InetcoreMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record HomeScreenButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<HomeScreenButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(InetcoreMod.MODID, "home_screen_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, HomeScreenButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, HomeScreenButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new HomeScreenButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<HomeScreenButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final HomeScreenButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = HomeScreenMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			HomeButtonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenwarpsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenwarpsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		InetcoreMod.addNetworkMessage(HomeScreenButtonMessage.TYPE, HomeScreenButtonMessage.STREAM_CODEC, HomeScreenButtonMessage::handleData);
	}
}
