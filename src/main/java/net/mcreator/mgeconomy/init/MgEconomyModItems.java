
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mgeconomy.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.mgeconomy.item.TenDollerItemItem;
import net.mcreator.mgeconomy.item.FiveDollerItemItem;
import net.mcreator.mgeconomy.item.DollerItemItem;
import net.mcreator.mgeconomy.MgEconomyMod;

public class MgEconomyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MgEconomyMod.MODID);
	public static final RegistryObject<Item> DOLLER_ITEM = REGISTRY.register("doller_item", () -> new DollerItemItem());
	public static final RegistryObject<Item> FIVE_DOLLER_ITEM = REGISTRY.register("five_doller_item", () -> new FiveDollerItemItem());
	public static final RegistryObject<Item> TEN_DOLLER_ITEM = REGISTRY.register("ten_doller_item", () -> new TenDollerItemItem());
	// Start of user code block custom items
	// End of user code block custom items
}
