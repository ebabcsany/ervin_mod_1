package com.babcsany.minecraft.ervin_mod_1.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper 
{
	private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();
	
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingShift() 
	{
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
	}

	public static boolean isHoldingB()
	{
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_B) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_B);
	}
	
	@OnlyIn(Dist.CLIENT)
	public static boolean isHoldingCtrl() 
	{
		return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL) || InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_RIGHT_CONTROL);
	}
}	