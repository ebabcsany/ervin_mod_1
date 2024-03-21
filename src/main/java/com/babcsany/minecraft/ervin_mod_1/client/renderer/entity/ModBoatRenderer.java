package com.babcsany.minecraft.ervin_mod_1.client.renderer.entity;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.ModBoatEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ModBoatRenderer extends EntityRenderer<ModBoatEntity> {
    private static final ArrayList<ResourceLocation> BOAT_TEXTURES = getBoatTextures("firg", "frim");

    private static ArrayList<ResourceLocation> getBoatTextures(String... strings) {
        ArrayList<ResourceLocation> locations = new ArrayList<>(Collections.emptyList());
        Arrays.stream(strings).filter(string -> !string.isEmpty()).map(string -> new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/boat/" + string)).forEachOrdered(locations::add);
        return locations;
    }

    public ModBoatRenderer(EntityRendererManager p_i46190_1_) {
        super(p_i46190_1_);
    }

    @Override
    public ResourceLocation getEntityTexture(ModBoatEntity modBoatEntity) {
        return BOAT_TEXTURES.get(modBoatEntity.getModBoatType().ordinal());
    }
}
