package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class RubyEnhancedSword extends SwordItem {

    private static Properties properties = new Item.Properties().group(ItemGroup.TOOLS);

    public static IItemTier tier = ItemUtils.buildItemTier(4, 1561, 12.0F, 3.0F, 10, "examplemod:rubyenhancedsword");

    public static Item INSTANCE = new RubyEnhancedSword(tier, 50, 100,  properties).setRegistryName(BaseMod.MODID, "rubyenhancedsword");

    public RubyEnhancedSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder){
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

}
