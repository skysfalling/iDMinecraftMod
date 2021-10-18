package com.idtech.entity.FrostZombie;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;

public class FrostZombieRenderer extends ZombieRenderer {

    public FrostZombieRenderer(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getEntityTexture(ZombieEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/frozen_zombie.png");
    }
}
