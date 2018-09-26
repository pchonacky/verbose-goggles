package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
	
	private int fuse;

	
public EntityGrenade(World world) {
	super(world);
	this.fuse = 20;
	this.noClip=true;

}
	
	
	public EntityGrenade(World world, EntityLivingBase player) {
		super(world, player);
		this.fuse = 20;
		this.noClip=true;
		double vFactor = 0.5D;
		Vec2f pitchYaw = player.getPitchYaw();
		double pitch = pitchYaw.y;
		double yaw = pitchYaw.x;

		double xVeloc = 0-(vFactor*(Math.sin(yaw)));
		double yVeloc = 0-(vFactor*(Math.sin(pitch)));
		double zVeloc = vFactor*(Math.cos(yaw));
		this.setVelocity(xVeloc, yVeloc, zVeloc);
		
//  Debugging code		
//		System.out.println("Pitch : "+pitch+"  Yaw : "+yaw);
//		System.out.println("Xfactor: " + Math.sin(yaw) );
//		System.out.println("x velocity = "+ xVeloc +
//				"	y velocity = "+yVeloc+
//				"	z velocity = "+zVeloc);
	}

	//not used
	public EntityGrenade(World worldIn, double posX,
			double posY, double posZ) {
		super(worldIn, posX, posY, posZ);
	}



	@Override
	public void onUpdate() {
		
		if (this.world.isRemote) {
			System.out.println("X : " + this.posX+"	"+"Y : " + this.posY+"	"+"Z : " + this.posZ);
		}
		//Decrement Fuse		
		this.fuse--;	
		//Blow up if fuse runs out
		if (this.fuse <= 0){
			for (int i = 0; i < 8; ++i) {		
				//EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters)
				this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
			if (!this.world.isRemote) {
				this.world.newExplosion(this, this.posX, this.posY, this.posZ, 1.5F, false, true);
				this.setDead();
			}
		}
		super.onUpdate();
	}

	//stop if grenade hits something	
	@Override
	protected void onImpact(RayTraceResult movObjPos) {
		if ((movObjPos.entityHit != null) && (!this.world.isRemote)) { 
			movObjPos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()),1);
			this.posX = movObjPos.entityHit.posX;
			this.posY = movObjPos.entityHit.posY+0.01F;
			this.posZ = movObjPos.entityHit.posZ;
			this.motionX=0F;
			this.motionY=0F;
			this.motionZ=0F;
			
		}
		else { //didn't hit an entity (hit a block)
		//Bounce Grenade
		//Which side was hit. : 
				if ( movObjPos.sideHit == EnumFacing.UP) { //top hit

		            this.motionX *= 0.699999988079071D;
		            this.motionZ *= 0.699999988079071D;
		            this.motionY *= -0.5D;
				}
				else { 
					if ( (movObjPos.sideHit == EnumFacing.EAST) || (movObjPos.sideHit == EnumFacing.WEST)) { // east/west hit
					this.motionZ = -(0.9 * this.motionZ);
					}
					else { 
						if ( (movObjPos.sideHit == EnumFacing.NORTH) || (movObjPos.sideHit == EnumFacing.SOUTH)) {// north/south hit
							this.motionX = -(0.9 * this.motionX);
						}
						else {
							if (movObjPos.sideHit == EnumFacing.DOWN) { //bottom hit
								this.motionY = -(0.9 * this.motionY);
							}
							else {
								return; /// none of the above
							}
						}
					}
				}

		
		}
	}
	
}
	
