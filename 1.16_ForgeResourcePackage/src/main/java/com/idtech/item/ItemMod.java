package com.idtech.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", ItemGroup.MISC);


    //FOODS
    public static Food yummyFood = (new Food.Builder()).hunger(5).saturation(1.4f).effect(new EffectInstance(Effects.SPEED, 400, 1), 1.0F)
            .effect(new EffectInstance(Effects.STRENGTH, 400, 1), 1.0F).setAlwaysEdible().build();
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood);

    public static Food chickenNugget = (new Food.Builder()).hunger(2).saturation(0.2f)
            .effect(new EffectInstance(Effects.JUMP_BOOST, 1600, 4), 1.0F)
            .effect(new EffectInstance(Effects.STRENGTH, 800, 2), .5f)
            .effect(new EffectInstance(Effects.RESISTANCE, 80, 2), .5f)
            .setAlwaysEdible().build();
    public static Item chickenNuggetItem = ItemUtils.buildFoodItem("chickennugget", chickenNugget);

    //ORES
    public static Item RUBY_ITEM = ItemUtils.buildBasicItem("rubyitem", ItemGroup.MISC);




    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);

        //ORES
        event.getRegistry().register(RUBY_ITEM);

        // ITEMS


        // TOOLS
        event.getRegistry().register(RubyPickaxeItem.INSTANCE);
        event.getRegistry().register(RubyEnhancedSword.INSTANCE);
        event.getRegistry().register(FireWand.INSTANCE);



        // FOOD
        event.getRegistry().register(yummyFoodItem);
        event.getRegistry().register(chickenNuggetItem);


        // ARMOR
        event.getRegistry().register(DragonScaleArmorItem.HELM);
        event.getRegistry().register(DragonScaleArmorItem.CHEST);
        event.getRegistry().register(DragonScaleArmorItem.LEGS);
        event.getRegistry().register(DragonScaleArmorItem.BOOTS);

        //ARROWS
        event.getRegistry().register(LightningArrowItem.INSTANCE);
        event.getRegistry().register(BombArrowItem.INSTANCE);

        event.getRegistry().register(AppleBombItem.INSTANCE);





    }
}
