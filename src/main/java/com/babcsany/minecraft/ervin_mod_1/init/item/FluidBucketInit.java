package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.item.bucket.ModBucketItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//import static com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.JURK_FLUID;
import static net.minecraft.item.Items.BUCKET;

public class FluidBucketInit {

    public static final DeferredRegister<Item> FLUID_BUCKETS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Item> JURK_BUCKET = FLUID_BUCKETS.register("jurk_bucket_", () -> new BucketItem(JURK_FLUID, (new Item.Properties()).containerItem(BUCKET).maxStackSize(1).group(net.minecraft.item.ItemGroup.MISC)));

}
