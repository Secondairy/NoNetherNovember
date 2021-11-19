package me.secondairy.nonethernovember.mixin;

import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndGatewayBlockEntity.class)
public class EndGatewayBlockEntityMixin {

    private static final BlockPos spawnPos = new BlockPos(100, 49, 0);

    @Inject(at = @At("HEAD"), method = "tryTeleportingEntity")
    public void tryTeleportingEntity(Entity entity, CallbackInfo ci) {
        if (entity.getEntityWorld().getRegistryKey() == World.OVERWORLD) {
            entity.changeDimension(entity.getServer().getWorld(World.END));
            entity.refreshPositionAndAngles(spawnPos, 0, 0);
        }
    }
}
