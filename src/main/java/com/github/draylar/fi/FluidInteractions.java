package com.github.draylar.fi;

import com.github.draylar.fi.config.FIConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidInteractions implements ModInitializer {

	public static final String MODID = "fluid-interactions";
	private static final FIConfig CONFIG = AutoConfig.register(FIConfig.class, GsonConfigSerializer::new).getConfig();

	@Override
	public void onInitialize() {
		loadConfig();
	}

	private static void loadConfig() {
		CONFIG.cobblestone.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if (state.getBlock() != Blocks.AIR) {
				InteractionPools.addRandomCobblestone(state, weight);
			}
		});

		CONFIG.stone.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if (state.getBlock() != Blocks.AIR) {
				InteractionPools.addRandomStone(state, weight);
			}
		});

		CONFIG.obsidian.forEach((block, weight) ->
		{
			BlockState state = Registry.BLOCK.get(new Identifier(block)).getDefaultState();
			if (state.getBlock() != Blocks.AIR) {
				InteractionPools.addRandomObsidian(state, weight);
			}
		});
	}
}
