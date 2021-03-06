package com.teamcqr.chocolatequestrepoured.objects.entity.ai;

import com.teamcqr.chocolatequestrepoured.objects.entity.bases.AbstractEntityCQR;

import net.minecraft.util.math.BlockPos;

public class EntityAIMoveToHome extends AbstractCQREntityAI {

	public EntityAIMoveToHome(AbstractEntityCQR entity) {
		super(entity);
	}

	@Override
	public boolean shouldExecute() {
		if (!this.entity.hasLeader()) {
			BlockPos pos = this.entity.getHomePosition();
			if (pos != null) {
				double x = pos.getX() - this.entity.posX;
				double y = pos.getY() - this.entity.posY;
				double z = pos.getZ() - this.entity.posZ;
				double distance = Math.sqrt(x * x + y * y + z * z);

				return distance > 8.0D;
			}
		}
		return false;
	}

	@Override
	public boolean shouldContinueExecuting() {
		return !this.entity.getNavigator().noPath();
	}

	@Override
	public void startExecuting() {
		BlockPos pos = this.entity.getHomePosition();
		this.entity.getNavigator().tryMoveToXYZ(pos.getX(), pos.getY(), pos.getZ(), 1.0D);
	}

}
