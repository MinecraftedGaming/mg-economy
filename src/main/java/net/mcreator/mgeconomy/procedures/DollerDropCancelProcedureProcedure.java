package net.mcreator.mgeconomy.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.mgeconomy.init.MgEconomyModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DollerDropCancelProcedureProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.hasPermissions(4)) {
			if (entity instanceof Player) {
				if (itemstack.getItem() == MgEconomyModItems.DOLLER_ITEM.get()) {
					if (entity instanceof ServerPlayer _serverPlayer)
						event.setCanceled(true);
				} else if (itemstack.getItem() == MgEconomyModItems.FIVE_DOLLER_ITEM.get()) {
					if (entity instanceof ServerPlayer _serverPlayer)
						event.setCanceled(true);
				} else if (itemstack.getItem() == MgEconomyModItems.TEN_DOLLER_ITEM.get()) {
					if (entity instanceof ServerPlayer _serverPlayer)
						event.setCanceled(true);
				}
			}
		}
	}
}
