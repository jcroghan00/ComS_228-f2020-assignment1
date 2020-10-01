package hw1.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hw1.ISPBusiness;
import hw1.Town;

class ISPBusinessTest 
{
	@Test
	void testUpdatePlain() throws IOException
	{
		Town town = new Town("ISP4x4.txt");
		
		Town town2 = ISPBusiness.updatePlain(town);
		
		String testString = "E E E E \n" + "C C O E \n" + "C O E O \n" + "C E E E \n";
		
		assertEquals(testString, town2.toString());
	}

	@Test
	void testGetProfit() throws IOException 
	{
		Town town = new Town("ISP4x4.txt");
		
		assertEquals(ISPBusiness.getProfit(town), 1);
		
		town = new Town(4, 4);
		town.randomInit(10);
		
		assertEquals(ISPBusiness.getProfit(town), 4);
		
		town = new Town(6, 6);
		town.randomInit(60);
		
		assertEquals(ISPBusiness.getProfit(town), 10);
		
		town = new Town(5, 5);
		town.randomInit(40);
		
		assertEquals(ISPBusiness.getProfit(town), 2);
	}
}
