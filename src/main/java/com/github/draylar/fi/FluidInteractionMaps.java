package com.github.draylar.fi;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FluidInteractionMaps
{
    private static final HashMap<BlockState, Integer> STONE_REPLACEMENT = new HashMap<>();
    private static final HashMap<BlockState, Integer> COBBLESTONE_REPLACEMENT = new HashMap<>();
    private static final HashMap<BlockState, Integer> OBSIDIAN_REPLACEMENT = new HashMap<>();
    private static final Random rand = new Random();

    public static BlockState getRandomStone()
    {
        if(STONE_REPLACEMENT.isEmpty()) STONE_REPLACEMENT.put(Blocks.STONE.getDefaultState(), 1);

        ArrayList<BlockState> states = new ArrayList<>();

        for (BlockState blockState : STONE_REPLACEMENT.keySet())
        {
            for (int i = 0; i < STONE_REPLACEMENT.get(blockState); i++)
            {
                states.add(blockState);
            }
        }

        return states.get(rand.nextInt(states.size()));
    }

    public static void addRandomStone(BlockState state, int weight)
    {
        STONE_REPLACEMENT.put(state, weight);
    }

    public static BlockState getRandomCobblestone()
    {
        if(COBBLESTONE_REPLACEMENT.isEmpty()) COBBLESTONE_REPLACEMENT.put(Blocks.COBBLESTONE.getDefaultState(), 1);

        ArrayList<BlockState> states = new ArrayList<>();

        for (BlockState blockState : COBBLESTONE_REPLACEMENT.keySet())
        {
            for (int i = 0; i < COBBLESTONE_REPLACEMENT.get(blockState); i++)
            {
                states.add(blockState);
            }
        }

        return states.get(rand.nextInt(states.size()));
    }

    public static void addRandomCobblestone(BlockState state, int weight)
    {
        COBBLESTONE_REPLACEMENT.put(state, weight);
    }

    public static BlockState getRandomObsidian()
    {
        if(OBSIDIAN_REPLACEMENT.isEmpty()) OBSIDIAN_REPLACEMENT.put(Blocks.OBSIDIAN.getDefaultState(), 1);

        ArrayList<BlockState> states = new ArrayList<>();

        for (BlockState blockState : OBSIDIAN_REPLACEMENT.keySet())
        {
            for (int i = 0; i < OBSIDIAN_REPLACEMENT.get(blockState); i++)
            {
                states.add(blockState);
            }
        }

        return states.get(rand.nextInt(states.size()));
    }

    public static void addRandomObsidian(BlockState state, int weight)
    {
        OBSIDIAN_REPLACEMENT.put(state, weight);
    }
}
