package net.infugogr.barracudamod.entity;

import net.infugogr.barracudamod.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.*;
import net.minecraft.world.World;


public class ModLightning extends LightningEntity {
	public int ambientTick;
	public long seed;
	private int remainingActions;

	public ModLightning(EntityType<? extends ModLightning> entityType, World world) {
		super(entityType, world);
		this.ignoreCameraFrustum = true;
		this.ambientTick = 2;
		this.seed = this.random.nextLong();
		this.remainingActions = this.random.nextInt(3) + 1;
	}

	private void Charge_Redstoneium_block() {
		BlockPos blockPos = this.getAffectedBlockPos();
		BlockState blockState = this.getWorld().getBlockState(blockPos);
		if (blockState.isOf(ModBlocks.REDSTONEIUM_BLOCK)) {
			World world =getWorld();
			BlockPos pos = getBlockPos();
			world.setBlockState(pos.add(0,-1,0), (ModBlocks.CHARGED_REDSTONEIUM_BLOCK).getDefaultState());
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.ambientTick == 2) {
			if (this.getWorld().isClient()) {
				this.getWorld()
					.playSound(
						this.getX(),
						this.getY(),
						this.getZ(),
						SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER,
						SoundCategory.WEATHER,
						10000.0F,
						0.8F + this.random.nextFloat() * 0.2F,
						false
					);
				this.getWorld()
					.playSound(
						this.getX(),
						this.getY(),
						this.getZ(),
						SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT,
						SoundCategory.WEATHER,
						2.0F,
						0.5F + this.random.nextFloat() * 0.2F,
						false
					);
			} else {
				this.Charge_Redstoneium_block();
			}
		}
		this.ambientTick--;
		if (this.ambientTick < 0) {
			if (this.remainingActions == 0) {
				this.discard();
			} else if (this.ambientTick < -this.random.nextInt(2)) {
				this.remainingActions--;
				this.ambientTick = 1;
				this.seed = this.random.nextLong();
			}
		}

		if (this.ambientTick >= 0) {
			if (!(this.getWorld() instanceof ServerWorld)) {
				this.getWorld().setLightningTicksLeft(2);
			}
		}
	}

	private BlockPos getAffectedBlockPos() {
		Vec3d vec3d = this.getPos();
		return BlockPos.ofFloored(vec3d.x, vec3d.y - 1.0E-6, vec3d.z);
	}
}
