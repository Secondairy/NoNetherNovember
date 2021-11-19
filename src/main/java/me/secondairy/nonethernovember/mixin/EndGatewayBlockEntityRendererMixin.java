package me.secondairy.nonethernovember.mixin;

import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.EndGatewayBlockEntityRenderer;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndGatewayBlockEntityRenderer.class)
public class EndGatewayBlockEntityRendererMixin extends EndPortalBlockEntityRenderer<EndGatewayBlockEntity>  {
    private static final Identifier BEAM_TEXTURE = new Identifier("textures/entity/end_gateway_beam.png");

    public EndGatewayBlockEntityRendererMixin(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    public void render(EndGatewayBlockEntity endGatewayBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        if (endGatewayBlockEntity.getWorld().getRegistryKey() == World.OVERWORLD) {
            super.render(endGatewayBlockEntity, f, matrixStack, vertexConsumerProvider, i, j);
            ci.cancel();
        }
    }
}
