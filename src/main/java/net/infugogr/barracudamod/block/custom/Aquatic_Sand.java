package net.infugogr.barracudamod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.FallingBlock;

public class Aquatic_Sand extends FallingBlock {
    public Aquatic_Sand(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }
}
