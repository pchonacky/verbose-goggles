package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMyFireball extends EntityLargeFireball {

	public EntityMyFireball(World p_i1767_1_) {
		super(p_i1767_1_);
		// TODO Auto-generated constructor stub
	}

	public EntityMyFireball(World thisWorld, EntityLivingBase throwingEntity,
			double accX, double accZ, double accY) {
		super(thisWorld, throwingEntity, accX, accZ, accY);
		float f = 0.2F;
		this.motionX=0.0F;
		this.motionY=0.0F;
		this.motionZ=0.0F;
//		this.posY = throwingEntity.getEyeHeight();
		this.posY = this.posY +0.5F;
        this.accelerationX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.accelerationZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.accelerationY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		// TODO Auto-generated constructor stub
	}

	public EntityMyFireball(World p_i1768_1_, double p_i1768_2_, double p_i1768_4_,
			double p_i1768_6_, double p_i1768_8_, double p_i1768_10_,
			double p_i1768_12_) {
		super(p_i1768_1_, p_i1768_2_, p_i1768_4_, p_i1768_6_, p_i1768_8_,
				p_i1768_10_, p_i1768_12_);
		// TODO Auto-generated constructor stub
	}

}
