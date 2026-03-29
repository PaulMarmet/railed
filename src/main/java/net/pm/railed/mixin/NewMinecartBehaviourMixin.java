package net.pm.railed.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.vehicle.minecart.NewMinecartBehavior;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.pm.railed.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(NewMinecartBehavior.class)
public class NewMinecartBehaviourMixin {

    //God this looks horrid
    //i think it works though...
    //atleast there's that

    @WrapOperation(method = "calculateHaltTrackSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z"))
    public boolean railed$slowSelfPowered1(BlockState railState, Object block, Operation<Boolean> original) {
        return railState.is((Block)block) || railState.is(Blocks.SELF_POWERED_RAIL);
    }

    @WrapOperation(method = "calculateHaltTrackSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getValue(Lnet/minecraft/world/level/block/state/properties/Property;)Ljava/lang/Comparable;"))
    public Comparable railed$slowSelfPowered2(BlockState railState, Property property, Operation<Comparable> original) {
        return (railState.is(net.minecraft.world.level.block.Blocks.POWERED_RAIL) && (Boolean)railState.getValue(property)) || (railState.is(Blocks.SELF_POWERED_RAIL) && !(Boolean)railState.getValue(property));
    }

    @WrapOperation(method = "calculateBoostTrackSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Ljava/lang/Object;)Z"))
    public boolean railed$fastSelfPowered1(BlockState railState, Object block, Operation<Boolean> original) {
        return railState.is((Block)block) || railState.is(Blocks.SELF_POWERED_RAIL);
    }

    @WrapOperation(method = "calculateBoostTrackSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getValue(Lnet/minecraft/world/level/block/state/properties/Property;)Ljava/lang/Comparable;"))
    public Comparable railed$fastSelfPowered2(BlockState railState, Property property, Operation<Comparable> original) {
        return (railState.is(net.minecraft.world.level.block.Blocks.POWERED_RAIL) && (Boolean)railState.getValue(property)) || (railState.is(Blocks.SELF_POWERED_RAIL) && !(Boolean)railState.getValue(property));
    }
}
