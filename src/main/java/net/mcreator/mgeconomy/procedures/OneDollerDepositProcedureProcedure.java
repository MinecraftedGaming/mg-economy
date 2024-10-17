package net.mcreator.mgeconomy.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.mcreator.mgeconomy.network.MgEconomyModVariables;
import net.mcreator.mgeconomy.init.MgEconomyModItems;
import net.mcreator.mgeconomy.configuration.ClientConfigConfiguration;

public class OneDollerDepositProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = itemstack;
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
		}
		if (MgEconomyModItems.DOLLER_ITEM.get() == itemstack.getItem()) {
			{
				double _setval = (entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MgEconomyModVariables.PlayerVariables())).PlayerBalance + itemstack.getCount() * 1;
				entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerBalance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (MgEconomyModItems.FIVE_DOLLER_ITEM.get() == itemstack.getItem()) {
			{
				double _setval = (entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MgEconomyModVariables.PlayerVariables())).PlayerBalance + itemstack.getCount() * 5;
				entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerBalance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (MgEconomyModItems.TEN_DOLLER_ITEM.get() == itemstack.getItem()) {
			{
				double _setval = (entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MgEconomyModVariables.PlayerVariables())).PlayerBalance + itemstack.getCount() * 10;
				entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerBalance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (ClientConfigConfiguration.SHOWMONEYANIMATION.get()) {
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
		}
	}
}
