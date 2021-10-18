package com.idtech.block;

import com.idtech.item.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.EnderChestBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.EnderCrystalRenderer;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.item.EnderCrystalItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockMod {

    //Basic Block

    public static final Block CASTLE_WALL = BlockUtils.createBasicBlock("castlewall", Material.ROCK, 0.5f, 0.9f, ToolType.PICKAXE);
    public static final Item CASTLE_WALL_ITEM = BlockUtils.createBlockItem(CASTLE_WALL, ItemGroup.BUILDING_BLOCKS);

    public static final Block RUBY_ORE_BLOCK = BlockUtils.createBasicBlock("rubyoreblock", Material.ROCK, 0.5f, 0.6f, ToolType.PICKAXE);
    public static final Item RUBY_ORE_BLOCK_ITEM = BlockUtils.createBlockItem(RUBY_ORE_BLOCK, ItemGroup.BUILDING_BLOCKS);

    public static final Block NUGGET_BLOCK = BlockUtils.createBasicBlock("nuggetblock", Material.SAND, 1f, 1f, ToolType.HOE);
    public static final Item NUGGET_BLOCK_ITEM = BlockUtils.createBlockItem(NUGGET_BLOCK, ItemGroup.MATERIALS);

    public static final Block BLUE_PINK_STONE = BlockUtils.createBasicBlock("bluepinkstone", Material.ROCK, 3f, 0.6f, ToolType.PICKAXE);
    public static final Item BLUE_PINK_STONE_ITEM = BlockUtils.createBlockItem(BLUE_PINK_STONE, ItemGroup.BUILDING_BLOCKS);

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(CASTLE_WALL_ITEM);
        event.getRegistry().register(RubberBlock.ITEM);
        event.getRegistry().register(LauncherBlock.ITEM);
        event.getRegistry().register(CreepingMoldBlock.ITEM);
        event.getRegistry().register(RUBY_ORE_BLOCK_ITEM);
        event.getRegistry().register(NUGGET_BLOCK_ITEM);
        event.getRegistry().register(WalkNTalk.ITEM);
        event.getRegistry().register(BLUE_PINK_STONE_ITEM);



    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(CASTLE_WALL);
        event.getRegistry().register(RubberBlock.INSTANCE);
        event.getRegistry().register(LauncherBlock.INSTANCE);
        event.getRegistry().register(RUBY_ORE_BLOCK);
        event.getRegistry().register(NUGGET_BLOCK);
        event.getRegistry().register(WalkNTalk.INSTANCE);
        event.getRegistry().register(BLUE_PINK_STONE);
        event.getRegistry().register(CreepingMoldBlock.INSTANCE);

    }
}























