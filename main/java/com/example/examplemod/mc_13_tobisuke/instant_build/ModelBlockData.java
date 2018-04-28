package com.example.examplemod.mc_13_tobisuke.instant_build;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class ModelBlockData {

    private int x;
    private int y;
    private int z;
    private IBlockState block;


    ModelBlockData(){}

    ModelBlockData(int x, int y, int z, IBlockState block){
        this.x = x;
        this.y = y;
        this.z = z;
        this.block = block;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
    public IBlockState getBlock(){
        return block;
    }

}
