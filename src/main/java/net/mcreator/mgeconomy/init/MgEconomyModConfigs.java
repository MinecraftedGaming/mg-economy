package net.mcreator.mgeconomy.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.mgeconomy.configuration.ServerConfigConfiguration;
import net.mcreator.mgeconomy.configuration.ClientConfigConfiguration;
import net.mcreator.mgeconomy.MgEconomyMod;

@Mod.EventBusSubscriber(modid = MgEconomyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MgEconomyModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ServerConfigConfiguration.SPEC, "MGEServerConfig.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigConfiguration.SPEC, "MGEClientConfig.toml");
		});
	}
}
