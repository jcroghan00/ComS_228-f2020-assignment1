package hw1.test;

import hw1.Outage;
import hw1.State;
import hw1.Town;
import hw1.TownCell;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutageTest 
{
	@Test
	void testWho()
	{
		Town town = new Town(4, 4);
		Outage outage = new Outage(town, 0, 0);
		
		assertEquals(State.OUTAGE, outage.who());
	}

	@Test
	void testNext() 
	{
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		Outage outage = new Outage(town, 0, 0);
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
		
		TownCell outageNext = outage.next(town2);
		
		assertEquals(State.EMPTY, outageNext.who());
		
		TownCell.nCensus[0] = 20;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 274;
		TownCell.nCensus[3] = 46;
		TownCell.nCensus[4] = 90;
		
		outageNext = outage.next(town2);
		
		assertEquals(State.EMPTY, outageNext.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
	}
}
