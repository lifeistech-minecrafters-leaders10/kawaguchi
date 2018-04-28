package com.example.examplemod;

import com.example.examplemod.mc_13_tobisuke.instant_build.HouseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static Block houseBlock = new HouseBlock();

//    public static SoundEvent soundEvent1 = new SoundEvent(new ResourceLocation(MODID,"sound1"));

    public static SoundEvent[] soundEvents = {
            new SoundEvent(new ResourceLocation(MODID,"sound1")),
            new SoundEvent(new ResourceLocation(MODID,"sound2")),
            new SoundEvent(new ResourceLocation(MODID,"sound3"))
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        boolean isClient = event.getSide().isClient();
        registerBlock(houseBlock,isClient);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    private void registerRecipe(){

        GameRegistry.addRecipe(new ItemStack(Blocks.DIAMOND_BLOCK),
                  "AAA",
                "AAA",
                "AAA",'A',new ItemStack(Blocks.DIRT)
        );

        NBTTagCompound creeperId = new NBTTagCompound();
        creeperId.setString("id", "Creeper");
        ItemStack creeperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
        creeperSpawnEgg.setTagInfo("EntityTag", creeperId);
        GameRegistry.addRecipe(creeperSpawnEgg,
                " A ",
                "CBC",
                "CBC",
                'A', new ItemStack(Items.SKULL, 1, 4),
                'B', new ItemStack(Blocks.TNT),
                'C', new ItemStack(Items.GUNPOWDER));
    }



    // ======================================================================================================
    // ここから下はいじらないよ！

    private void registerBlock(Block block, boolean isClient) {
        ItemBlock itemBlockInput = new ItemBlock(block);

        GameRegistry.register(block);
        GameRegistry.register(itemBlockInput, block.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }
    }

    private void registerItem(Item item, boolean isClient) {
        GameRegistry.register(item);
        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelName);
        }
    }
}
