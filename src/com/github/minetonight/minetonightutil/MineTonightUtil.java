package com.github.minetonight.minetonightutil;

import org.bukkit.plugin.java.JavaPlugin;

public class MineTonightUtil extends JavaPlugin {
	
	
	public static int[][][] rotateMatrixClockwise(int[][][] matrix) {
		checkChunkSectionMatrix(matrix);
		
		int[][][] newMatrix = new int[matrix.length][16][16];
		
		for (int y = 0; y < matrix.length; y++) {
			for (int z = 0; z < matrix[y].length; z++) {
				for (int x = 0; x < matrix[y][z].length; x++) {
					newMatrix[y][x][z] = matrix[y][z][15-x]; // that is clock wise
				}//for x
			}//for z
		}//for y
		
		return newMatrix;
	}//eof rotateMatrixClockwise

	
	public static int[][][] rotateMatrixCounterClockwise(int[][][] matrix) {
		checkChunkSectionMatrix(matrix);
		
		int[][][] newMatrix = new int[matrix.length][16][16];
		
		for (int y = 0; y < matrix.length; y++) {
			for (int z = 0; z < matrix[y].length; z++) {
				for (int x = 0; x < matrix[y][z].length; x++) {
					newMatrix[y][15-x][z] = matrix[y][z][x]; // that is counter clockwise
				}//for x
			}//for z
		}//for y
		
		return newMatrix;
	}//eof rotateMatrixClockwise

	/**
	 * Check second and third dimensions to be of lenght 16 
	 */
	public static void checkChunkSectionMatrix(int[][][] matrix) {
		if ( ! (matrix.length > 0)) throw new IllegalArgumentException("Define some matrix, at least");
		for (int i = 0; i < matrix.length; i++) {
			if ( ! (matrix[i].length == 16)) throw new IllegalArgumentException("You need 16 rows!");
			
			for (int j = 0; j < matrix[i].length; j++) {
				if ( ! (matrix[i][j].length == 16)) throw new IllegalArgumentException("You need 16 columns!");
			}//for j
		}//for i
	}//eof checkChunkSectionMatrix
}
