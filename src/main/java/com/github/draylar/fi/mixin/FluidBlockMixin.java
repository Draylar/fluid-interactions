package com.github.draylar.fi.mixin;

import com.github.draylar.fi.FluidInteractionMaps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin
{
	@Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z"), method = "receiveNeighborFluids")
	private void injectObsidian(World world_1, BlockPos blockPos_1, BlockState blockState_1, CallbackInfoReturnable<Boolean> cir) {
		// water falls on lava source -- normally lava
		world_1.setBlockState(blockPos_1, FluidInteractionMaps.getRandomObsidian());
	}

	@Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Z", ordinal = 1), method = "receiveNeighborFluids")
	private void injectCobblestone(World world_1, BlockPos blockPos_1, BlockState blockState_1, CallbackInfoReturnable<Boolean> cir) {
		// water falls on running lava -- normally cobble
		world_1.setBlockState(blockPos_1, FluidInteractionMaps.getRandomCobblestone());
	}
}
