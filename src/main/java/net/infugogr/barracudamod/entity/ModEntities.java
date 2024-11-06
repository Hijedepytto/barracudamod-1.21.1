package net.infugogr.barracudamod.entity;

import net.infugogr.barracudamod.BarracudaMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ModLightning> MOD_LIGHTNING = register(
            EntityType.Builder.create(ModLightning::new, SpawnGroup.MISC)
                    .disableSaving()
                    .dimensions(0.0F, 0.0F)
                    .maxTrackingRange(16)
                    .trackingTickInterval(Integer.MAX_VALUE)
    );

    private static <T extends Entity> EntityType<T> register(EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(BarracudaMod.MOD_ID, "lightning_bolt"), type.build("lightning_bolt"));
    }

    public static void registerModEntities() {
        BarracudaMod.LOGGER.info("Registering Mod Entities for " + BarracudaMod.MOD_ID);
    }
}



