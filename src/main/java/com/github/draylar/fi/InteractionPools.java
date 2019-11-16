package com.github.draylar.fi;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InteractionPools {

    private static final HashMap<BlockState, Integer> STONE = new HashMap<>();
    private static final HashMap<BlockState, Integer> COBBLESTONE = new HashMap<>();
    private static final HashMap<BlockState, Integer> OBSIDIAN = new HashMap<>();
    private static final Random RANDOM = new Random();

    public static BlockState getRandomStone() {
        if (STONE.isEmpty()) {
            STONE.put(Blocks.STONE.getDefaultState(), 1);
        }

        ArrayList<BlockState> statePool = new ArrayList<>();

        for (BlockState blockState : STONE.keySet()) {
            for (int i = 0; i < STONE.get(blockState); i++) {
                statePool.add(blockState);
            }
        }

        return statePool.get(RANDOM.nextInt(statePool.size()));
    }

    public static BlockState getRandomCobblestone() {
        if (COBBLESTONE.isEmpty()) {
            COBBLESTONE.put(Blocks.COBBLESTONE.getDefaultState(), 1);
        }

        ArrayList<BlockState> statePool = new ArrayList<>();

        for (BlockState blockState : COBBLESTONE.keySet()) {
            for (int i = 0; i < COBBLESTONE.get(blockState); i++) {
                statePool.add(blockState);
            }
        }

        return statePool.get(RANDOM.nextInt(statePool.size()));
    }

    public static BlockState getRandomObsidian() {
        if (OBSIDIAN.isEmpty()) {
            OBSIDIAN.put(Blocks.OBSIDIAN.getDefaultState(), 1);
        }

        ArrayList<BlockState> statePool = new ArrayList<>();

        for (BlockState blockState : OBSIDIAN.keySet()) {
            for (int i = 0; i < OBSIDIAN.get(blockState); i++) {
                statePool.add(blockState);
            }
        }

        return statePool.get(RANDOM.nextInt(statePool.size()));
    }

    public static void addRandomStone(BlockState state, int weight) {
        STONE.put(state, weight);
    }

    public static void addRandomCobblestone(BlockState state, int weight) {
        COBBLESTONE.put(state, weight);
    }

    public static void addRandomObsidian(BlockState state, int weight) {
        OBSIDIAN.put(state, weight);
    }
}
