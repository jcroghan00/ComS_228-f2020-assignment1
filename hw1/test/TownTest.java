package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hw1.Town;

class TownTest 
{
	@Test
	void testGetWidth()
	{
		Town town = new Town(1, 1);
		
		assertEquals(town.getWidth(), 1);
		
		town = new Town(5, 5);
		
		assertEquals(town.getWidth(), 5);
		
		town = new Town(4, 7);
		
		assertEquals(town.getWidth(), 7);
		
		town = new Town(9, 2);
		
		assertEquals(town.getWidth(), 2);
	}

	@Test
	void testGetLength() 
	{
		Town town = new Town(1, 1);
		
		assertEquals(town.getLength(), 1);
		
		town = new Town(5, 5);
		
		assertEquals(town.getLength(), 5);
		
		town = new Town(4, 7);
		
		assertEquals(town.getLength(), 4);
		
		town = new Town(9, 2);
		
		assertEquals(town.getLength(), 9);
	}

	@Test
	void testRandomInit() 
	{
		Town town = new Town(4, 4);
		Town town2 = new Town(4, 4);
		
		town.randomInit(10);
		town2.randomInit(10);
		
		assertEquals(town.toString(), town2.toString());
		
		town.randomInit(40);
		town2.randomInit(40);
		
		assertEquals(town.toString(), town2.toString());
		
		town.randomInit(20);
		town2.randomInit(10);
		
		assertNotEquals(town.toString(), town2.toString());
		
		town.randomInit(30);
		town2.randomInit(90);
		
		assertNotEquals(town.toString(), town2.toString());
	}

	@Test
	void testToString() throws IOException 
	{
		//Town town = new Town("ISP4x4.txt");
		
		//assertEquals(town.toString(), "O R O R \n" + "E E C O \n" + "E S O S \n" + "E O R R ");
	}
}
