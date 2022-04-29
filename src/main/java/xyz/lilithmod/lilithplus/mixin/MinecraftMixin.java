package xyz.lilithmod.lilithplus.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.Minecraft.class)
public class MinecraftMixin {
    private void sayHello(CallbackInfo ci) {
        System.out.println("Hello, world!");
    }
}
