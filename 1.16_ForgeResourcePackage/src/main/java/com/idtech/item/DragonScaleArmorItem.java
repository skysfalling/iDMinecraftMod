package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.client.event.sound.SoundEvent;

import javax.annotation.Nullable;

public class DragonScaleArmorItem extends ArmorItem
{
    private static Properties properties = new Properties().group(ItemGroup.COMBAT);

    public static IArmorMaterial dragonScale = ItemUtils.buildArmorMaterial("DRAGONSCALE", 40, new int[]{5,8,6,4}, 15, null, 2, 0.2f, "examplemod:dragonscale");

    public static Item HELM = new DragonScaleArmorItem(ArmorMaterial.NETHERITE, EquipmentSlotType.HEAD, properties).setRegistryName(BaseMod.MODID,"dragonscalehelm");
    public static Item CHEST = new DragonScaleArmorItem(ArmorMaterial.NETHERITE, EquipmentSlotType.CHEST, properties).setRegistryName(BaseMod.MODID,"dragonscalechest");
    public static Item LEGS = new DragonScaleArmorItem(ArmorMaterial.NETHERITE, EquipmentSlotType.LEGS, properties).setRegistryName(BaseMod.MODID,"dragonscalelegs");
    public static Item BOOTS = new DragonScaleArmorItem(ArmorMaterial.NETHERITE, EquipmentSlotType.FEET, properties).setRegistryName(BaseMod.MODID,"dragonscaleboots");


    public DragonScaleArmorItem(IArmorMaterial material, EquipmentSlotType type, Properties properties) {
        super(material, type, properties);

    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if(slot == EquipmentSlotType.LEGS){
            return "examplemod:textures/models/armor/dragonscalearmor_2.png";
        }else{
            return "examplemod:textures/models/armor/dragonscalearmor_1.png";
        }
    }
}


