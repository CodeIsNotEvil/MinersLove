package com.codeisnotevil.minerslove.objects.items;

import com.codeisnotevil.minerslove.MinersLoveItemGroup;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(MinersLoveItemGroup.instance));
    }

    public ItemBase(Properties properties) {
        super(properties.group(MinersLoveItemGroup.instance));
    }
}
