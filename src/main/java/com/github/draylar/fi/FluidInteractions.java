package com.github.draylar.fi;

import com.github.draylar.fi.config.FIConfig;
import me.sargunvohra.mcmods.autoconfig1.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidInteractions implements ModInitializer
{
	private static FIConfig config;

	@Override
	public void onInitialize()
	{
		config = AutoConfig.register(FIConfig.class, GsonConfigSerializer::new).getConfig();
		loadConfig();
	}

	private static void loadConfig()
	{
		config.cobblestone.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if(state.getBlock() != Blocks.AIR)
			{
				FluidInteractionMaps.addRandomCobblestone(state, weight);
			}
		});

		config.stone.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if(state.getBlock() != Blocks.AIR)
			{
				FluidInteractionMaps.addRandomStone(state, weight);
			}
		});

		config.obsidian.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if(state.getBlock() != Blocks.AIR)
			{
				FluidInteractionMaps.addRandomObsidian(state, weight);
			}
		});
	}
}
