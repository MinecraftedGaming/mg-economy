
package net.mcreator.mgeconomy.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TenDollerItemItem extends Item {
	public TenDollerItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
