package com.github.awruff.vintage.potionstatus.utils;

import net.minecraft.client.Minecraft;

import java.awt.*;

public class EffectDisplay {
    public final String name;
    public final String duration;
    public final int color;

    private static final int DEFAULT_DURATION_COLOR = Color.WHITE.getRGB();

    public EffectDisplay(String name, String duration, int color) {
        this.name = name;
        this.duration = duration;
        this.color = color;
    }

    public void draw(Minecraft minecraft, int x, int y) {
        draw(minecraft, x, y, DEFAULT_DURATION_COLOR);
    }

    public void draw(Minecraft minecraft, int x, int y, int durationColor) {
        minecraft.textRenderer.draw(name, x, y, this.color, true);
        x += minecraft.textRenderer.getWidth(name);
        minecraft.textRenderer.draw(" " + duration, x, y, durationColor, true);
    }

    public int getWidth(Minecraft minecraft) {
        if (minecraft == null || minecraft.textRenderer == null) return 0;
        return minecraft.textRenderer.getWidth(name + " " + duration);
    }
}
