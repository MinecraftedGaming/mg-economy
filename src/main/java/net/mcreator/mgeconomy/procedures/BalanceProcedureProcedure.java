package net.mcreator.mgeconomy.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.mgeconomy.network.MgEconomyModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class BalanceProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("$" + ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "Player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MgEconomyModVariables.PlayerVariables())).PlayerBalance)), true);
	}
}
