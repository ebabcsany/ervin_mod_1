package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.fluid.JurkFluid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class FluidInit_ extends Fluids {

    public static FluidInit_ FLUIDS;

    //public static FluidAttributes FLUID_ATTRIBUTES = createVanillaFluidAttributes(null);

    public static final ResourceLocation JURK_STILL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_still");
    public static final ResourceLocation JURK_FLOWING = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_flow");
    public static final ResourceLocation JURK_OVERLAY = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_overlay");
    public static final FlowingFluid FLOWING_JURK = register("ervin_mod_1:fluids/flowing_jurk", new JurkFluid.Flowing());
    public static final FlowingFluid JURK = register("ervin_mod_1:fluids/jurk", new JurkFluid.Source());

    //public static final FlowingFluid MILK_FLUID = register("milk_fluid", new ForgeFlowingFluid.Source(MILK_PROPERTIES));

    //public static final FlowingFluid MILK_FLOWING = register("milk_flowing", new ForgeFlowingFluid.Flowing(MILK_PROPERTIES));

    //public static final Block MILK_BLOCK = register("milk", new FlowingFluidBlock(MILK_FLUID, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

    private static <T extends Fluid> T register(String key, T p_215710_1_) {
        return Registry.register(Registry.FLUID, key, p_215710_1_);
    }

    static {
        for(Fluid fluid : Registry.FLUID) {
            for(FluidState fluidstate : fluid.getStateContainer().getValidStates()) {
                Fluid.STATE_REGISTRY.add(fluidstate);
            }
        }

    }

    private final TextureAtlasSprite[] atlasSpritesJurk = new TextureAtlasSprite[2];
    private TextureAtlasSprite atlasSpriteJurkOverlay;

    protected void initAtlasSprites() {
        this.atlasSpritesJurk[0] = Minecraft.getInstance().getModelManager().getBlockModelShapes().getModel(Fluids.EMPTY.getFluid().getDefaultState().getBlockState()).getParticleTexture();
        this.atlasSpriteJurkOverlay = Ervin_mod_1.LOCATION_JURK_OVERLAY.getSprite();
        this.atlasSpritesJurk[1] = Ervin_mod_1.LOCATION_JURK_FLOW.getSprite();
    }
}
