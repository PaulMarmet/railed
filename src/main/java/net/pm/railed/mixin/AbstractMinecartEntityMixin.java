package net.pm.railed.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.math.BlockPos;
import net.pm.railed.block.Blocks;
import net.pm.railed.block.SelfPoweredRailBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecartEntity.class)
public class AbstractMinecartEntityMixin {
    @Inject(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z", shift = At.Shift.AFTER))
    private void speedUpCondition(BlockPos pos, BlockState state, CallbackInfo ci, @Local(ordinal = 0) LocalBooleanRef local, @Local(ordinal = 1) LocalBooleanRef local2) {
        if (state.isOf(Blocks.SELF_POWERED_RAIL)) {
            local.set(!state.get(SelfPoweredRailBlock.POWERED));
            local2.set(!local.get());
        }
    }
}
