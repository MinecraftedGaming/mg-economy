package net.mcreator.mgeconomy.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	static {

		SPEC = BUILDER.build();
	}

}
