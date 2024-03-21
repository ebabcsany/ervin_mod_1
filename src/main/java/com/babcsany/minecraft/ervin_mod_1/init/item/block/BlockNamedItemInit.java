package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockNamedItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FI_RT_PLOCK = BLOCK_ITEMS.register("fi_rt_plock", () -> new BlockItem(H_u_fBlockInit.H_U_F_UUUUUUUU.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.ERVIN_MOD_1_SEARCH)));


}
