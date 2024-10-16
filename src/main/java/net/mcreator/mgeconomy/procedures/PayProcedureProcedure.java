package net.mcreator.mgeconomy.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.mgeconomy.network.MgEconomyModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PayProcedureProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (Math.round(DoubleArgumentType.getDouble(arguments, "Amount")) >= 1) {
			if (Math.round(DoubleArgumentType.getDouble(arguments, "Amount")) <= (entity.getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MgEconomyModVariables.PlayerVariables())).PlayerBalance) {
				{
					double _setval = Math.round(DoubleArgumentType.getDouble(arguments, "Amount"));
					(new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "Player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity()).getCapability(MgEconomyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerBalance = _setval;
						capability.syncPlayerVariables((new Object() {
							public Entity getEntity() {
								try {
									return EntityArgument.getEntity(arguments, "Player");
								} catch (CommandSyntaxException e) {
									e.printStackTrace();
									return null;
								}
							}
						}.getEntity()));
					});
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Sent $" + Math.round(DoubleArgumentType.getDouble(arguments, "Amount")) + " to " + new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "Player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity())), true);
				if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "Player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Received $" + Math.round(DoubleArgumentType.getDouble(arguments, "Amount")) + " from " + entity)), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You do not have enough money"), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("(always rounds to nearest doller)"), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Amount must be $1 or higher"), false);
		}
	}
}
