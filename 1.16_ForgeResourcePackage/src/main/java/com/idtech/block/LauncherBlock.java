package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LauncherBlock extends Block {

    private static Properties properties = Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 0.9f).harvestTool(ToolType.PICKAXE);

    public static Block INSTANCE = new LauncherBlock(properties).setRegistryName(BaseMod.MODID,"launcher_block");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    public LauncherBlock(Properties properties){
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos posIn, Entity entityIn) {
        super.onEntityWalk(worldIn, posIn, entityIn);

        entityIn.addVelocity(0,5,0);



    }



}
