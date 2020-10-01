package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.Casual;
import hw1.State;
import hw1.Town;
import hw1.TownCell;

class CasualTest 
{
	@Test
	void testWho()
	{
		Town town = new Town(4, 4);
		Casual casual = new Casual(town, 0, 0);
		
		assertEquals(State.CASUAL, casual.who());
	}

	@Test
	void testNext() 
	{		
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		Casual casual = new Casual(town, 0, 0);
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
		
		TownCell.nCensus[1] = 1;
		
		TownCell casualNext = casual.next(town2);
		
		assertEquals(State.RESELLER, casualNext.who());
		
		TownCell.nCensus[1] = 2;
		
		TownCell.nCensus[0] = 1;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.OUTAGE, casualNext.who());
		
		TownCell.nCensus[0] = 0;
		
		TownCell.nCensus[4] = 1;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.STREAMER, casualNext.who());
		
		TownCell.nCensus[4] = 0;
		
		TownCell.nCensus[2] = 5;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.STREAMER, casualNext.who());
		
		TownCell.nCensus[2] = 0;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.CASUAL, casualNext.who());

		TownCell.nCensus[0] = 1;
		TownCell.nCensus[1] = 1;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 3;
		TownCell.nCensus[4] = 2;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.OUTAGE, casualNext.who());

		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 4;
		TownCell.nCensus[3] = 1;
		TownCell.nCensus[4] = 8;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.RESELLER, casualNext.who());

		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 1;
		TownCell.nCensus[2] = 3;
		TownCell.nCensus[3] = 1;
		TownCell.nCensus[4] = 2;
		
		casualNext = casual.next(town2);
		
		assertEquals(State.STREAMER, casualNext.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
	}
}
