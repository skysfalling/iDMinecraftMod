package com.idtech.entity;

import com.idtech.entity.FrostZombie.FrostZombieEntity;
import com.idtech.entity.FrostZombie.FrostZombieRenderFactory;
import com.idtech.entity.projectile.AppleBombEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){

        event.getRegistry().register(AppleBombEntity.TYPE);
        RenderingRegistry.registerEntityRenderingHandler(AppleBombEntity.TYPE, m -> new SpriteRenderer<>(m, Minecraft.getInstance().getItemRenderer()));

        event.getRegistry().register(FrostZombieEntity.TYPE);
        GlobalEntityTypeAttributes.put(FrostZombieEntity.TYPE, FrostZombieEntity.setupAttributes().func_233813_a_());

        EntityUtils.spawnMobsIn(EntityType.MOOSHROOM, EntityClassification.CREATURE, 100, 4, 10, Biomes.PLAINS);

        System.out.println("Entities Registered");

    }

    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event){
        event.getRegistry().register(FrostZombieEntity.EGG);

    }

    public static void entityRenderers(){

        RenderingRegistry.registerEntityRenderingHandler(FrostZombieEntity.TYPE, FrostZombieRenderFactory.INSTANCE);

    }

}
