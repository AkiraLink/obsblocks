package com.akiralink.obsblocks;

import net.minecraft.util.math.Direction;

public class GeneralUtils {

    class GeneratorMath{

        float a;
        int shift;
        float max;
        GeneratorMath(float a, int shift, float max){
            this.a = a;
            this.shift = shift;
            this.max = max;
        }
        int quadFunctionCalc(int input){
            int result = Math.round(a* (input-shift)*(input-shift) + max);
            return result;
        }
    }

    public static class Randomizer {
        public int generateWithStep(int first, int last, int step) {
            int nsteps = (last+1-first) / step;
            return first + step*(int)(nsteps*Math.random());
        }
        public int generate(int min, int max) {
            return min + (int) (Math.random() * ((max - min) + 1));
        }
    }
    public static Direction rotate(Direction offset)
    {
        if (offset == Direction.NORTH){
            Direction result = Direction.EAST;
            return result;
        }
        if (offset == Direction.EAST){
            Direction result = Direction.SOUTH;
            return result;
        }
        if (offset == Direction.SOUTH){
            Direction result = Direction.WEST;
            return result;
        }
        if (offset == Direction.WEST){
            Direction result = Direction.NORTH;
            return result;
        }
        else{
            return offset;
        }
    }

}

