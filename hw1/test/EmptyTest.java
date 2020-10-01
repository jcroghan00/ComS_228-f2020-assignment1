package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.Empty;
import hw1.State;
import hw1.Town;
import hw1.TownCell;

class EmptyTest 
{
	@Test
	void testWho()
	{
		Town town = new Town(4, 4);
		Empty empty = new Empty(town, 0, 0);
		
		assertEquals(State.EMPTY, empty.who());
	}

	@Test
	void testNext() 
	{
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		Empty empty = new Empty(town, 0, 0);
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
		
		TownCell.nCensus[1] = 1;
		
		TownCell emptyNext = empty.next(town2);
		
		assertEquals(State.RESELLER, emptyNext.who());
		
		TownCell.nCensus[0] = 4;
		TownCell.nCensus[1] = 6;
		TownCell.nCensus[2] = 2;
		TownCell.nCensus[3] = 17;
		TownCell.nCensus[4] = 90;
		
		emptyNext = empty.next(town2);
		
		assertEquals(State.CASUAL, emptyNext.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
	}
}
