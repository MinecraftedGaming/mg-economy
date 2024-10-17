package net.mcreator.mgeconomy.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SHOWMONEYANIMATION;
	static {
		BUILDER.push("Animations");
		SHOWMONEYANIMATION = BUILDER.comment("Show an animation when depisiting money").define("Show Money Animation", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
