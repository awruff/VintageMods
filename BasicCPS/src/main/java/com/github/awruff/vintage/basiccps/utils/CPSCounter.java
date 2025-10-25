package com.github.awruff.vintage.basiccps.utils;

import net.fabricmc.loader.api.FabricLoader;

import java.util.ArrayList;
import java.util.List;

public class CPSCounter {
    private static final List<Long> leftClicks = new ArrayList<>();
    private static final List<Long> rightClicks = new ArrayList<>();

    private static final long CLICK_WINDOW_MS = 1000;

    public static void leftClick() {
        leftClicks.add(System.currentTimeMillis());
    }

    public static void rightClick() {
        rightClicks.add(System.currentTimeMillis());
    }

    public static void tick() {
        long now = System.currentTimeMillis();
        leftClicks.removeIf(clickTime -> now - clickTime > CLICK_WINDOW_MS);
        rightClicks.removeIf(clickTime -> now - clickTime > CLICK_WINDOW_MS);
    }


    public static String getText() {
        int leftSize = leftClicks.size();
        int rightSize = rightClicks.size();

        int value = Math.max(leftSize, rightSize);
        String label = rightSize > leftSize ? "rcps" : "cps";

        return value + " " + label;
    }

    public static int getOffset() {
        final int DEFAULT_OFFSET = 3;
        final int COMPATIBLITY_OFFSET = 13;

        return FabricLoader.getInstance().isModLoaded("basicfps") ? COMPATIBLITY_OFFSET : DEFAULT_OFFSET;
    }
}
