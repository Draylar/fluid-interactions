package com.github.draylar.fi.mixin;

import com.github.draylar.fi.InteractionPools;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {

	@Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z"), method = "receiveNeighborFluids")
	private void injectObsidian(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
		// water falls on lava source -- normally obsidian
		world.setBlockState(pos, InteractionPools.getRandomObsidian());
	}

	@Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z", ordinal = 1), method = "receiveNeighborFluids")
	private void injectCobblestone(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
		// water falls on running lava -- normally cobble
		world.setBlockState(pos, InteractionPools.getRandomCobblestone());
	}
}
