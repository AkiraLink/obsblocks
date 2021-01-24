package com.akiralink.obsblocks.features;

import com.akiralink.obsblocks.GeneralUtils;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.nio.file.DirectoryStream;
import java.util.Random;

class GeneratorMath{

    float a;
    float shift;
    float max;
    GeneratorMath(float a, float shift, float max){
        this.a = a;
        this.shift = shift;
        this.max = max;
    }
    float quadFunctionCalc(float input){
        float result = a* (input-shift)*(input-shift) + max;
        return result;
    }
}

public class AncientEnergyOutbreak extends Feature<DefaultFeatureConfig> {
    public AncientEnergyOutbreak(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos,
                            DefaultFeatureConfig config) {
        BlockPos topPos = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos);
        Vec3i position = new Vec3i(topPos.getX(), topPos.getY(), topPos.getZ());
        Vec3i building_position = new Vec3i(topPos.getX(), topPos.getY(), topPos.getZ());
        Direction offset = Direction.NORTH;
        BlockPos start_position = new BlockPos(position);
        topPos = topPos.north();
        BlockPos rowPos = new BlockPos(position);
        start_position.north();
        GeneralUtils.Randomizer Randomizer = new GeneralUtils.Randomizer();
        ///////System.out.println("Starting New Generation!");
        //int loopCount = Randomizer.generateWithStep(1,10,2 );
        int loopCount = 10;
        int column = 0;
        int row = 0;
        int column_height;
        int row_height;

        // Math
        float columnCenter = Math.round(loopCount/2);
        float rowCenter = Math.round(loopCount/2);

        //function
        float stretch_factor_column = 1/((columnCenter)*(columnCenter-(columnCenter*2)));
        float stretch_factor_row = 1/((rowCenter)*(rowCenter-(rowCenter*2)));
        // Creating Column Function
        GeneratorMath columnFunction = new GeneratorMath(stretch_factor_column,columnCenter,1f);
        GeneratorMath rowFunction = new GeneratorMath(stretch_factor_row,rowCenter,1f);

        float height_og = Randomizer.generate(5, 50);
        float height_modified;
        float height_modified_row;

        // for Column (x)
        for (float b = 1; b <= loopCount; b++){

            //System.out.println("LoopCount:" + c);
            ///////System.out.println("OriginalHeight:" + height_og);
            //
            height_modified= height_og * columnFunction.quadFunctionCalc(b);
            ///////System.out.println("Hight Modified Column" + height_og * columnFunction.quadFunctionCalc(b));
            topPos = topPos.add(1,0,0);
            //position = new Vec3i(topPos.getX(), topPos.getY(), topPos.getZ());
            rowPos = topPos.add(0,0,-1);

            //for Rows (z)
            for (float d = 1; d <= loopCount; d++) {
                rowPos = rowPos.add(0,0,1);
                ///////System.out.println("Row Modifier:" + height_modified*rowFunction.quadFunctionCalc(d));
                height_modified_row = height_modified*rowFunction.quadFunctionCalc(d);
                building_position = rowPos;



                /// Building
                for (int y = 1; y <= Math.round(height_modified_row); y++) {

                    // building to Bedrock
                    for (int f = (building_position.getY()+5); f >2; f--){
                        world.setBlockState(rowPos.up(5).down(f), Blocks.CRYING_OBSIDIAN.getDefaultState(), 3);
                    }
                    // Debug
                    /*
                    System.out.println("Setting Block" + y);
                    System.out.println("TopPos:" + topPos);
                    System.out.println("HeightRow Modified:"+ height_modified_row);
                    System.out.println("Strech Factor:"+ stretch_factor_column);
                    System.out.println("FUNCTION TEST"+ columnFunction.quadFunctionCalc(2));

                     */

                    building_position = new Vec3i(building_position.getX(), building_position.getY() + 1, building_position.getZ());
                    start_position = new BlockPos(building_position);
                    ///////System.out.println("StartPosition:" + start_position);

                    // Build Command
                    world.setBlockState(start_position, Blocks.CRYING_OBSIDIAN.getDefaultState(), 3);
                }
            }

        }

        ///////System.out.println("Done generating AncientEnergyOutbreak!");
        return true;
    }
}

