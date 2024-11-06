package net.infugogr.barracudamod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.infugogr.barracudamod.entity.client.ModLightningRenderer;
import net.infugogr.barracudamod.entity.ModEntities;

public class BarracudaModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.MOD_LIGHTNING, ModLightningRenderer::new);
    }
}
