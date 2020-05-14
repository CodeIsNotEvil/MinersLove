package com.codeisnotevil.minerslove.objects.items;

import com.codeisnotevil.minerslove.MinersLoveItemGroup;
import net.minecraft.item.Item;

public class MinersBackpack extends Item {

    public MinersBackpack() {
        super(new Properties().group(MinersLoveItemGroup.instance));
    }

    public MinersBackpack(Properties properties) {
        super(properties.group(MinersLoveItemGroup.instance));
    }
}
