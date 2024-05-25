package com.babcsany.minecraft.ervin_mod_1.tags;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public final class ModItemTags {
    public static final ITag.INamedTag<Item> COALS = ItemTags.createOptional(new ResourceLocation("coals"));
    public static final ITag.INamedTag<Item> ZUR_LOVED = createTag("zur_loved");

    public static ITag.INamedTag<Item> createTag(String id) {
        return ItemTags.createOptional(Ervin_mod_1.getKey(id));
    }
}
