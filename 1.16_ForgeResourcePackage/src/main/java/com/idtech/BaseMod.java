package com.idtech;

import com.google.common.collect.Lists;
import com.idtech.block.*;
import com.idtech.entity.EntityMod;
import com.idtech.entity.FrostZombie.FrostZombieEntity;
import com.idtech.item.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Stream;

/**
 * The BaseMod class holds any static variables your mod needs and runs all registry events. You'll add registry lines
 * in this file for all of your block, item, entities, etc. that you add to Minecraft
 */
@Mod(BaseMod.MODID)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BaseMod {

    // Change your modid here. Whenever modid is needed, use BaseMod.MODID
    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger(BaseMod.MODID);

    /**
     * Registers block during mod setup
     * @param event RegistryEvent to access the block registry
     */
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event){
        LOGGER.info("Registering Blocks");
        // Add block registry calls here.
        // event.getRegistry().register(<block variable>)

        BlockMod.registerBlocks(event);

    }

    /**
     * Registers item during mod setup
     * @param event RegistryEvent to access the item registry
     */
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){
        LOGGER.info("Registering Items");
        // Add item registry calls here.
        // event.getRegistry.register(<item variable>)

        ItemMod.registerItems(event);
        BlockMod.registerBlockItems(event);
        EntityMod.registerEntityEggs(event);

        //EGGS

    }

    /**
     * Registers entities during mod setup
     * @param event RegistryEvent to access the entity registry
     */
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        BaseMod.LOGGER.info("Registering Entities");
        // Add item registry calls here.
        // event.getRegistry.register(<entity type>)
        // also register the entity attributes with:
        // GlobalEntityTypeAttributes.put(<entity type>, <entity attribute method>.func_233813_a_());
        EntityMod.registerEntities(event);
    }

    @SubscribeEvent
    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
        BaseMod.LOGGER.info("Registering Biomes");
        // Add biome registry calls here
        // event.getRegistry.register(<biome variable>)

    }

    /**
     * Client-side setup - register renderers here.
     * @param event event variable with client setup info
     */
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        BaseMod.LOGGER.info("Client Setup Step");
        // Add rendering registry entries here.
        // RenderingRegistry.registerEntityRenderingHandler(<entity type>, <render factory>);
        EntityMod.entityRenderers();
    }


    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     * @param event event info
     */
    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent event){
        // Do any mod setup steps here. Occurs after all registry events.
        // Put biome manager registry stuff here.
        BaseMod.LOGGER.info("Mod Setup Step");
        BaseMod.LOGGER.info("Adding Spawns");
        spawnMobsIn(FrostZombieEntity.TYPE,EntityClassification.MONSTER, 50, 1, 10, Biomes.SAVANNA);

    }

    /**
     * Setup step after all other registry events - if you need to do anything after everything else has loaded, put it here.
     * @param type entity type
     * @param weight likelihood it will spawn
     * @param min min number of entities in a group
     * @param max max number of entities in a group
     */
    public static void addSpawn(EntityType type, int weight, int min, int max){

        //for each biome in the biomes registry
        for (Biome b : ForgeRegistries.BIOMES) {
            BaseMod.LOGGER.info("Add Spawn to biome "+ b);
            //if the biome is NOT the ocean or the end or the nether,
            if(b.getCategory() != Biome.Category.OCEAN && b.getCategory() != Biome.Category.THEEND && b.getCategory() != Biome.Category.NETHER) {
                //add the entity to the spawn list for the biome
                b.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(type, weight, min, max));
            }
        }
    }

    /**
     * Spawns Mobs/Creatures into all biomes
     * @param entityType Entity
     * @param classification Entity type (Creature/Monster/etc)
     * @param weight The randomness weight
     * @param min minimum entity count per group
     * @param max maximum entity count per group
     */
    protected static void spawnMobs(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max) {
        ForgeRegistries.BIOMES.getValues().stream().forEach(biome -> {
            biome.getSpawns(classification).add(new Biome.SpawnListEntry(entityType, weight, min, max));
        });
    }

    /**
     * Spawns Mobs/Creatures into specific biomes
     * @param entityType Entity
     * @param classification Entity type (Creature/Monster/etc)
     * @param weight The randomness weight
     * @param min minimum entity count per group
     * @param max maximum entity count per group
     * @param biomesIn List of biomes
     */
    protected static void spawnMobsIn(EntityType<?> entityType, EntityClassification classification, int weight, int min, int max, Biome... biomesIn) {
        List<Biome> list = Lists.newArrayList(biomesIn);
        ForgeRegistries.BIOMES.getValues().stream().filter(biome -> list.contains(biome)).forEach(biome -> {
            biome.getSpawns(classification).add(new Biome.SpawnListEntry(entityType, weight, min, max));
        });
    }

    public class OreGeneration {

        private Stream<Biome> biomes;

        public void applyBiomeFeatures() {
            biomes = getDifferentBiomes();


            // only in certain biomes
            // generateFeatures(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlockMod.GEL_ORE_BLOCK.getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)), Biomes.BADLANDS);

            // in all biomes
            generateFeaturesInAllBiomes(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), BlockMod.NUGGET_BLOCK.getDefaultState())).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }

        protected void generateFeatures(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
            for(Biome biome : biomesIn) biome.addFeature(stageIn, featureIn);
        }

        protected void generateFeaturesExcept(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn, Biome... biomesIn) {
            List<Biome> list = Lists.newArrayList(biomesIn);
            biomes.filter(biome -> !list.contains(biome)).forEach(biome -> biome.addFeature(stageIn, featureIn));
        }

        protected void generateFeaturesInAllBiomes(GenerationStage.Decoration stageIn, ConfiguredFeature<?, ?> featureIn) {
            biomes.forEach(biome -> biome.addFeature(stageIn, featureIn));
        }

        private Stream<Biome> getDifferentBiomes() {
            return ForgeRegistries.BIOMES.getValues().stream().filter(biome -> !biome.getRegistryName().getNamespace().equals(BaseMod.MODID));
        }
    }

}
