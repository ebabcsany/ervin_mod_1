package com.babcsany.minecraft.ervin_mod_1.loot;

import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.entity.Entity;
import net.minecraft.util.JSONUtils;

import javax.annotation.Nullable;

public class HuihkingPredicate {
    public static final HuihkingPredicate PREDICATE = new HuihkingPredicate(false);
    private boolean field_234636_b_;

    private HuihkingPredicate(boolean p_i231586_1_) {
        this.field_234636_b_ = p_i231586_1_;
    }

    public static HuihkingPredicate func_234640_a_(boolean p_234640_0_) {
        return new HuihkingPredicate(p_234640_0_);
    }

    public static HuihkingPredicate func_234639_a_(@Nullable JsonElement p_234639_0_) {
        if (p_234639_0_ != null && !p_234639_0_.isJsonNull()) {
            JsonObject jsonobject = JSONUtils.getJsonObject(p_234639_0_, "huihk_hook");
            JsonElement jsonelement = jsonobject.get("in_open_lava");
            return jsonelement != null ? new HuihkingPredicate(JSONUtils.getBoolean(jsonelement, "in_open_lava")) : PREDICATE;
        } else {
            return PREDICATE;
        }
    }

    public JsonElement func_234637_a_() {
        if (this == PREDICATE) {
            return JsonNull.INSTANCE;
        } else {
            JsonObject jsonobject = new JsonObject();
            jsonobject.add("in_open_lava", new JsonPrimitive(this.field_234636_b_));
            return jsonobject;
        }
    }

    public boolean func_234638_a_(Entity entity) {
        if (this == PREDICATE) {
            return true;
        } else if (!(entity instanceof Huihk)) {
            return false;
        } else {
//            Huihk huihk = (Huihk)entity;
            return false;//this.field_234636_b_ == huihk.isCanCatched();
        }
    }
}
