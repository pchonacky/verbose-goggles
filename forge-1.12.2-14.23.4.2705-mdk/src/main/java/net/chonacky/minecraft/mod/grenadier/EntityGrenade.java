package net.chonacky.minecraft.mod.grenadier;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
	
	private int fuse;

	public EntityGrenade(World worldIn) {
		super(worldIn);
		this.fuse = 20;
		this.noClip=true;
	}

	public EntityGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		this.fuse = 20;
		this.noClip=true;
	}

	public EntityGrenade(World worldIn, double posX,
			double posY, double posZ) {
		super(worldIn, posX, posY, posZ);
		this.fuse = 20;
		this.noClip=true;
	}

	@Override
	protected void onImpact(MovingObjectPosition movObjPos) {
		if ((movObjPos.entityHit != null) && (!this.worldObj.isRemote)) { 
//			movObjPos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 3F);
			movObjPos.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()),1);
			this.posX = movObjPos.entityHit.posX;
			this.posY = movObjPos.entityHit.posY+0.01F;
			this.posZ = movObjPos.entityHit.posZ;
			this.motionX=0F;
			this.motionY=0F;
			this.motionZ=0F;
			
		}
		else { //didn't hit an entity (hit a block)
	
	//Which side was hit. If its -1 then it went the full length of the ray trace. Bottom = 0, Top = 1,  
	//			East = 2, West = 3, North = 4, South = 5.
				if ( movObjPos.sideHit == 1) { //top hit

		            this.motionX *= 0.699999988079071D;
		            this.motionZ *= 0.699999988079071D;
		            this.motionY *= -0.5D;
				}
				else { 
					if ( (movObjPos.sideHit == 2) || (movObjPos.sideHit == 3)) { // east/west hit
					this.motionZ = -(0.9 * this.motionZ);
					}
					else { 
						if ( (movObjPos.sideHit == 4) || (movObjPos.sideHit == 5)) {// north/south hit
							this.motionX = -(0.9 * this.motionX);
						}
						else {
							if (movObjPos.sideHit == 0) { //bottom hit
								this.motionY = -(0.9 * this.motionY);
							}
							else {
								return; /// none of the above
							}
						}
					}
				}
				
		}
		
		
		
		
///////////////////////////////////////////////
//		for (int i = 0; i < 8; ++i) {
//			this.worldObj.spawnParticle("cloud", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
//		}
//		if (!this.worldObj.isRemote) {
//			this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 2, false, true);
//			this.setDead();
//		}
		
		
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		
//		System.out.println(">>>>NOCLIP = " + noClip);
//		if (!this.worldObj.isRemote) {System.out.println(">>>> Position: " + this.posX + " , " + this.posY + " , " + this.posZ);}
		this.fuse--;
		if (this.fuse <= 0){
			for (int i = 0; i < 8; ++i) {
				this.worldObj.spawnParticle("cloud", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
			if (!this.worldObj.isRemote) {
				this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.5F, false, true);
				this.setDead();
			}
		}
	}

	
	
}
