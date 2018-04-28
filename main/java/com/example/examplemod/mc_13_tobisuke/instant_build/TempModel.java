package com.example.examplemod.mc_13_tobisuke.instant_build;

import net.minecraft.block.state.IBlockState;

public class TempModel {

    private int x;
    private int y;
    private int z;
    private int state;


    TempModel(){}

    TempModel(int x, int y, int z, int state){
        this.x = x;
        this.y = y;
        this.z = z;
        this.state = state;
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
    public int getState() {
        return state;
    }

}
