package net.pm.railed.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.vehicle.ExperimentalMinecartController;
import net.minecraft.state.property.Property;
import net.pm.railed.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ExperimentalMinecartController.class)
public class ExperimentalMinecartControllerMixin {

    //God this looks horrid
    //i think it works though...
    //atleast there's that

    @WrapOperation(method = "decelerateFromPoweredRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    public boolean slowSelfPowered1(BlockState railState, Block block, Operation<Boolean> original) {
        return railState.isOf(block) || railState.isOf(Blocks.SELF_POWERED_RAIL);
    }

    @WrapOperation(method = "decelerateFromPoweredRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"))
    public Comparable slowSelfPowered2(BlockState railState, Property property, Operation<Comparable> original) {
        return (railState.isOf(net.minecraft.block.Blocks.POWERED_RAIL) && (Boolean)railState.get(property)) || (railState.isOf(Blocks.SELF_POWERED_RAIL) && !(Boolean)railState.get(property));
    }

    @WrapOperation(method = "accelerateFromPoweredRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    public boolean fastSelfPowered1(BlockState railState, Block block, Operation<Boolean> original) {
        return railState.isOf(block) || railState.isOf(Blocks.SELF_POWERED_RAIL);
    }

    @WrapOperation(method = "accelerateFromPoweredRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"))
    public Comparable fastSelfPowered2(BlockState railState, Property property, Operation<Comparable> original) {
        return (railState.isOf(net.minecraft.block.Blocks.POWERED_RAIL) && (Boolean)railState.get(property)) || (railState.isOf(Blocks.SELF_POWERED_RAIL) && !(Boolean)railState.get(property));
    }
}
