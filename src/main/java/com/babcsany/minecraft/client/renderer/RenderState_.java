package com.babcsany.minecraft.client.renderer;

import net.minecraft.client.renderer.RenderState;

public class RenderState_ extends RenderState {
    public static final RenderState.TargetState targetState = RenderState.OUTLINE_TARGET;
    public static final RenderState.TargetState targetState1 = RenderState.MAIN_TARGET;
    public static final RenderState.TargetState targetState2 = RenderState.TRANSLUCENT_TARGET;
    public RenderState_(String nameIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, setupTaskIn, clearTaskIn);
    }
}
