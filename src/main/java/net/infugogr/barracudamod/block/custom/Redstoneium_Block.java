package net.infugogr.barracudamod.block.custom;

import net.infugogr.barracudamod.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;


public class Redstoneium_Block extends Block {

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            if (world.isThundering() && world.isRaining()) {
                if (random.nextInt(4)==0) {
                    Entity entity = ModEntities.MOD_LIGHTNING.create(world);
                    entity.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
                    world.spawnEntity(entity);
                }
            }
        }
        super.randomTick(state, world, pos, random);
    }

    public Redstoneium_Block(Settings settings) {
        super(settings);
    }


}

