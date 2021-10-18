package com.idtech.block;

import com.idtech.BaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.NoteBlockInstrument;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class WalkNTalk extends Block {

    public static final IntegerProperty NOTE = BlockStateProperties.NOTE_0_24;
    public static final EnumProperty<NoteBlockInstrument> INSTRUMENT = BlockStateProperties.NOTE_BLOCK_INSTRUMENT;


    private static Properties properties = Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 0.9f).harvestTool(ToolType.PICKAXE);

    public static Block INSTANCE = new WalkNTalk(properties).setRegistryName(BaseMod.MODID,"walk_n_talk");
    public static Item ITEM = BlockUtils.createBlockItem(INSTANCE, ItemGroup.MISC);

    public WalkNTalk(Properties properties){
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos posIn, Entity entityIn) {
        super.onEntityWalk(worldIn, posIn, entityIn);

        BlockState state = this.getDefaultState();

        if (worldIn.isRemote){ //Sounds should only play on the server's version of the world
            entityIn.playSound(state.get(INSTRUMENT).getSound(), 10f, 1f);
        }

        entityIn.addVelocity(0,0.75,0);


    }

}
