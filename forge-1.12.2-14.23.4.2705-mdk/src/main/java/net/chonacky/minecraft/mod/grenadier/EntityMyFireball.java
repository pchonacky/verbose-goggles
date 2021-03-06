package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMyFireball extends EntityLargeFireball {

	public EntityMyFireball(World inWorld) {
		super(inWorld);
	}
	
	public EntityMyFireball(World inWorld, double posX, double posY,
			double posZ, double accelX, double accelY,	double accelZ) {
		super(inWorld, posX, posY, posZ, accelX, accelY, accelZ);

	}

	public EntityMyFireball(World thisWorld, EntityLivingBase throwingEntity,
			double accX, double accZ, double accY) {
		super(thisWorld, throwingEntity, accX, accZ, accY);
		float f = 0.2F;
		this.motionX=0.1F;
		this.motionY=0.1F;
		this.motionZ=0.1F;
//		this.posY = throwingEntity.getEyeHeight();
		this.posY = this.posY +0.5F;
        this.accelerationX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.accelerationZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
        this.accelerationY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI) * f);
	}

//	@Override
//	protected void onImpact(RayTraceResult result) {
//		// TODO Auto-generated method stub
//		
//	}


}
