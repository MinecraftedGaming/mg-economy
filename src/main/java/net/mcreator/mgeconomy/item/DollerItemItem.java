
package net.mcreator.mgeconomy.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DollerItemItem extends Item {
	public DollerItemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
