package net.infugogr.barracudamod.block.custom;

import net.infugogr.barracudamod.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;


public class Charged_Redstoneium_Block extends Block {

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            if ((long) world.random.nextInt(200) <= world.getTime() % 200L) {
                ParticleUtil.spawnParticle(world, pos, ParticleTypes.ELECTRIC_SPARK, UniformIntProvider.create(1, 2));
            }
        }
    }

    public Charged_Redstoneium_Block(Settings settings) {
        super(settings);
    }


}

