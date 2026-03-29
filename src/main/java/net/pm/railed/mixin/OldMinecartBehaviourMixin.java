package net.pm.railed.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.vehicle.minecart.OldMinecartBehavior;
import net.minecraft.world.level.block.state.BlockState;
import net.pm.railed.block.Blocks;
import net.pm.railed.block.SelfPoweredRailBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OldMinecartBehavior.class)
public class OldMinecartBehaviourMixin {
    @Inject(method = "moveAlongTrack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z", shift = At.Shift.AFTER))
    private void railed$speedUpCondition(ServerLevel level, CallbackInfo ci, @Local(name = "state") BlockState state, @Local(name = "powerTrack") LocalBooleanRef local, @Local(name = "haltTrack") LocalBooleanRef local2) {
        if (state.is(Blocks.SELF_POWERED_RAIL)) {
            local.set(!state.getValue(SelfPoweredRailBlock.POWERED));
            local2.set(!local.get());
        }
    }
}
