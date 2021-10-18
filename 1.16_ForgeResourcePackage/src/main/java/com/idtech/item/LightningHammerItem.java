package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningHammerItem extends Item {

    private static Properties properties = new Item.Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new LightningHammerItem(properties).setRegistryName("lightninghammer");

    public LightningHammerItem(Properties properties) {
        super(properties);

    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //get the held item for return
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        //find the location at the cursor
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        //as long as the location exists
        if(location != null){

            //create an explosion
            Utils.createExplosion(worldIn, location, 0.5f);

            //strike lightning
            Utils.strikeLightning(worldIn, location);

            //return success
            return ActionResult.resultSuccess(itemstack);

        } else {

            //return a fail
            return ActionResult.resultFail(itemstack);
        }
    }
}