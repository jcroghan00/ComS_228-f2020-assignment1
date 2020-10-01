package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hw1.State;
import hw1.Streamer;
import hw1.Town;
import hw1.TownCell;

class StreamerTest 
{
	@Test
	void testWho()
	{
		Town town = new Town(4, 4);
		Streamer streamer = new Streamer(town, 0, 0);
		
		assertEquals(State.STREAMER, streamer.who());
	}

	@Test
	void testNext() 
	{
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		Streamer streamer = new Streamer(town, 0, 0);
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
		
		TownCell streamerNext = streamer.next(town2);
		
		assertEquals(State.RESELLER, streamerNext.who());
		
		TownCell.nCensus[0] = 1;
		TownCell.nCensus[1] = 4;
		
		streamerNext = streamer.next(town2);
		
		assertEquals(State.OUTAGE, streamerNext.who());
		
		TownCell.nCensus[0] = 0;
		
		TownCell.nCensus[3] = 1;
		
		streamerNext = streamer.next(town2);
		
		assertEquals(State.EMPTY, streamerNext.who());
		
		TownCell.nCensus[0] = 1;
		TownCell.nCensus[1] = 1;
		TownCell.nCensus[2] = 2;
		TownCell.nCensus[3] = 1;
		TownCell.nCensus[4] = 0;
		
		streamerNext = streamer.next(town2);
		
		assertEquals(State.OUTAGE, streamerNext.who());
		
		TownCell.nCensus[0] = 1;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 1;
		TownCell.nCensus[3] = 1;
		TownCell.nCensus[4] = 3;
		
		streamerNext = streamer.next(town2);
		
		assertEquals(State.STREAMER, streamer.who());
		
		TownCell.nCensus[0] = 0;
		TownCell.nCensus[1] = 0;
		TownCell.nCensus[2] = 0;
		TownCell.nCensus[3] = 0;
		TownCell.nCensus[4] = 0;
	}
}