package com.babcsany.minecraft.ervin_mod_1.tags;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public final class ModItemTags {
    public static final ITag.INamedTag<Item> ZUR_LOVED = makeWrapperTag("zur_loved");

    public static ITag.INamedTag<Item> makeWrapperTag(String id) {
        return ItemTags.makeWrapperTag(Ervin_mod_1.MOD_ID + id);
    }
}
