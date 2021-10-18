package com.idtech.entity.FrostZombie;

import com.idtech.BaseMod;
import com.idtech.entity.EntityUtils;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class FrostZombieEntity extends ZombieEntity {

    public static EntityType<FrostZombieEntity> TYPE = (EntityType<FrostZombieEntity>) EntityType.Builder.create(FrostZombieEntity::new, EntityClassification.MONSTER).build("frost_zombie").setRegistryName(BaseMod.MODID, "frost_zombie");

    public FrostZombieEntity(World worldIn){ super(TYPE, worldIn); }
    public FrostZombieEntity(EntityType type, World worldIn) { super(type, worldIn); }

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0x7ab6ff, 0x99f5ff);

    public static AttributeModifierMap.MutableAttribute setupAttributes() {
        return EntityUtils.addAttributes(true);
    }

}
