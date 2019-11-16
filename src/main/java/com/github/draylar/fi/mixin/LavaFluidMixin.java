package com.github.draylar.fi.mixin;

import com.github.draylar.fi.InteractionPools;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LavaFluid.class)
public class LavaFluidMixin {

    @Inject(at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/IWorld;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"), method = "flow")
    private void injectStone(IWorld world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState, CallbackInfo ci) {
        // lava falls on water -- normally stone
        world.setBlockState(pos, InteractionPools.getRandomStone(), 3);
    }
}
