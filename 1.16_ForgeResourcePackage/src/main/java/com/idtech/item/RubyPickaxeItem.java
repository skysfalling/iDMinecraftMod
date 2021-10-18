package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RubyPickaxeItem extends PickaxeItem {

    private static Properties properties = new Item.Properties().group(ItemGroup.TOOLS);

    public static IItemTier tier = ItemUtils.buildItemTier(4, 1561, 12.0F, 3.0F, 10, "examplemod:rubypickaxe");

    public static Item INSTANCE = new RubyPickaxeItem(tier, 50, 100,  properties).setRegistryName(BaseMod.MODID, "rubypickaxe");

    public RubyPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder){
        super(tier, attackDamageIn, attackSpeedIn, builder);

    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
