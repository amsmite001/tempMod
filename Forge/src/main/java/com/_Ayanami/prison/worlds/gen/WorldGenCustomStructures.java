package com._Ayanami.prison.worlds.gen;

import java.util.ArrayList;
import java.util.Random;

import com._Ayanami.prison.worlds.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;

public class WorldGenCustomStructures implements IWorldGenerator {
	public static final WorldGenStructure PRISON = new WorldGenStructure("prison");
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 2:
			break;
		case 1:
			break;
		case 0:
		//	generateStructure(PRISON, world, random,chunkX,chunkZ,5,Block.PLANKS,classes);
			break;
		case -1:
			break;
		}
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + random.nextInt(15);
		int z = (chunkZ * 16) + random.nextInt(15);
		int y = calculateY(world,x,z,topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		if(classesList.contains(world.provider.getBiomeForCoords(pos).getClass())) {
			if(random.nextInt(chance)==0) {
				generator.generate(world, random, pos);
			}
		}
	}
	
	private static int calculateY(World world, int x, int z, Block topBlock) {
		int y = world.getHeight();
		boolean foundGround = false;
		while(!foundGround && y>=0) {
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			if(block == topBlock)
					foundGround = true;
			y--;
		}
		return y;
	}
}
