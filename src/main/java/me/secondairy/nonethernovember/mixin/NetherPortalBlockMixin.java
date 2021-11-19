package me.secondairy.nonethernovember.mixin;

import me.secondairy.nonethernovember.nonethernovember;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NetherPortalBlock.AreaHelper.class)
public class NetherPortalBlockMixin {
    @Shadow
    private WorldAccess world;
    @Shadow
    private Direction.Axis axis;
    @Shadow
    private Direction negativeDir;
    @Shadow
    private Direction positiveDir;
    @Shadow
    private int foundPortalBlocks;

    @Shadow
    private BlockPos lowerCorner;
    @Shadow
    private int height;
    @Shadow
    private int width;

    @Inject(at = @At("HEAD"), method = "createPortal", cancellable = true)
    private void createPortal(CallbackInfo ci) {
        for (int i = 0; i < this.width; ++i) {
            BlockPos blockPos = this.lowerCorner.offset(this.negativeDir, i);
            for (int j = 0; j < this.height; ++j) {
                this.world.setBlockState(blockPos.up(j), (BlockState) Blocks.END_GATEWAY.getDefaultState(), 18);
            }
        }
        ci.cancel();
    }
}
