package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.Town;
import hw1.TownCell;

class TownCellTest 
{
	@Test
	void testCensus()
	{
		Town town = new Town(4, 4);
		town.randomInit(20);
		int[] nCensus = new int[5];
		
		town.grid[0][0].census(nCensus);
	
		assertEquals(TownCell.nCensus[0], 0);
		assertEquals(TownCell.nCensus[1], 0);
		assertEquals(TownCell.nCensus[2], 2);
		assertEquals(TownCell.nCensus[3], 1);
		assertEquals(TownCell.nCensus[4], 0);
		
		town.grid[2][1].census(nCensus);
		
		assertEquals(TownCell.nCensus[0], 3);
		assertEquals(TownCell.nCensus[1], 0);
		assertEquals(TownCell.nCensus[2], 4);
		assertEquals(TownCell.nCensus[3], 1);
		assertEquals(TownCell.nCensus[4], 0);
		
		town.grid[1][3].census(nCensus);
		
		assertEquals(TownCell.nCensus[0], 1);
		assertEquals(TownCell.nCensus[1], 1);
		assertEquals(TownCell.nCensus[2], 0);
		assertEquals(TownCell.nCensus[3], 3);
		assertEquals(TownCell.nCensus[4], 0);
		
		town.grid[3][3].census(nCensus);
		
		assertEquals(TownCell.nCensus[0], 1);
		assertEquals(TownCell.nCensus[1], 1);
		assertEquals(TownCell.nCensus[2], 0);
		assertEquals(TownCell.nCensus[3], 1);
		assertEquals(TownCell.nCensus[4], 0);
	}
}
