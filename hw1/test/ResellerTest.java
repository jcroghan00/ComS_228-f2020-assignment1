package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.Reseller;
import hw1.State;
import hw1.Town;
import hw1.TownCell;

class ResellerTest 
{
	@Test
	void testWho()
	{
		Town town = new Town(4, 4);
		Reseller reseller = new Reseller(town, 0, 0);
		
		assertEquals(State.RESELLER, reseller.who());
	}

	@Test
	void testNext() 
	{
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		Reseller reseller = new Reseller(town, 0, 0);
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
		
		TownCell.nCensus[2] = 2;
		
		TownCell resellerNext = reseller.next(town2);
		
		assertEquals(State.EMPTY, resellerNext.who());
		
		TownCell.nCensus[2] = 0;
		
		TownCell.nCensus[1] = 4;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.EMPTY, resellerNext.who());
		
		TownCell.nCensus[1] = 0;
		
		TownCell.nCensus[2] = 5;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.STREAMER, resellerNext.who());

		TownCell.nCensus[2] = 4;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.RESELLER, resellerNext.who());

		TownCell.nCensus[0] = 3;
		TownCell.nCensus[1] = 2;
		TownCell.nCensus[2] = 4;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 1;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.RESELLER, resellerNext.who());

		TownCell.nCensus[0] = 3;
		TownCell.nCensus[1] = 1;
		TownCell.nCensus[2] = 1;
		TownCell.nCensus[3] = 2;
		TownCell.nCensus[4] = 2;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.EMPTY, resellerNext.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 4;
		TownCell.nCensus[2] = 1;
		TownCell.nCensus[3] = 2;
		TownCell.nCensus[4] = 0;
		
		resellerNext = reseller.next(town2);
		
		assertEquals(State.EMPTY, resellerNext.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
	}
}
