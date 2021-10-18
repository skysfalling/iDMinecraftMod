package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.AbstractFireballEntity;

public class FireWand extends Item {

    public int fireballStrength = 9;    //default fireball is strength 1
    private static Properties properties = new Item.Properties().group(ItemGroup.COMBAT);
    public static Item INSTANCE = new FireWand(properties).setRegistryName("firewand");
    public FireWand(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {

        Vector3d looking = player.getLookVec();
        FireballEntity fireballentity = new FireballEntity(world, player, looking.x * 1.2, looking.y, looking.z * 1.2);
        //creates a fireball entity in the direction of the player's looking vector
        fireballentity.explosionPower = fireballStrength;
        world.addEntity(fireballentity);
        return super.onItemRightClick(world, player, handIn);//returns the default onItemRightClick value
    }

    }
