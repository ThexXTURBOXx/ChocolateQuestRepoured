package com.teamcqr.chocolatequestrepoured.objects.entity.ai;

import java.util.Random;

import com.teamcqr.chocolatequestrepoured.objects.entity.bases.AbstractEntityCQR;

import net.minecraft.entity.ai.EntityAIBase;

public abstract class AbstractCQREntityAI extends EntityAIBase {

	protected final AbstractEntityCQR entity;
	protected final Random random = new Random();

	public AbstractCQREntityAI(AbstractEntityCQR entity) {
		this.entity = entity;
	}

}
