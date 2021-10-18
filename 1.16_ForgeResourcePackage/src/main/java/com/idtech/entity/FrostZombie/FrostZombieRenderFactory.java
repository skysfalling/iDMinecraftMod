package com.idtech.entity.FrostZombie;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class FrostZombieRenderFactory implements IRenderFactory<ZombieEntity> {

    public static FrostZombieRenderFactory INSTANCE = new FrostZombieRenderFactory();

    @Override
    public EntityRenderer<? super ZombieEntity> createRenderFor(EntityRendererManager manager) {
        return new FrostZombieRenderer(manager);
    }
}
