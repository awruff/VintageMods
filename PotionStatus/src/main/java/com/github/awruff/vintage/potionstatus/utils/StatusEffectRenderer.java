package com.github.awruff.vintage.potionstatus.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.TextRenderer;
import net.minecraft.client.render.Window;
import net.minecraft.entity.living.effect.StatusEffect;
import net.minecraft.entity.living.effect.StatusEffectInstance;
import net.minecraft.entity.living.player.PlayerEntity;
import net.minecraft.locale.I18n;
import net.minecraft.text.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class StatusEffectRenderer {
    private static final int MARGIN = 3;
    private static final int LINE_SPACING = 2;

    public static void draw(Minecraft minecraft, Window window, TextRenderer textRenderer) {
        PlayerEntity player = minecraft.player;

        List<EffectDisplay> effectDisplays = getEffectDisplays(player.getStatusEffects());
        effectDisplays.sort(Comparator.comparingInt((EffectDisplay e) -> e.getWidth(minecraft)).reversed());

        int y = (int) (window.getScaledHeight() - textRenderer.fontHeight - MARGIN);

        for (EffectDisplay display : effectDisplays) {
            display.draw(minecraft, MARGIN, y);
            y -= textRenderer.fontHeight + LINE_SPACING;
        }
    }

    private static List<EffectDisplay> getEffectDisplays(Collection<StatusEffectInstance> effects) {
        List<EffectDisplay> effectDisplays = new ArrayList<>();

        for (StatusEffectInstance effect : effects) {
            StatusEffect type = StatusEffect.BY_ID[effect.getId()];

            String name = I18n.translate(type.getTranslationKey());
            String title = name + " " + getAmplifier(effect);
            String duration = StringUtils.getDurationString(effect.getDuration());

            effectDisplays.add(new EffectDisplay(title, duration, type.getPotionColor()));
        }

        return effectDisplays;
    }

    private static String getAmplifier(StatusEffectInstance effect) {
        return (effect.getAmplifier() + 1) + "";
    }
}
