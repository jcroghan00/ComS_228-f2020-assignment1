package hw1;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Jack Croghan
 *
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 */
public class ISPBusiness 
{
	public static int[] nCensus = new int[5];
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld)
	{
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		
		for (int i = 0; i < tOld.getLength(); ++i) {
			for (int j = 0; j < tOld.getWidth(); ++j) {
				tOld.grid[i][j].census(nCensus);
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}	
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return
	 */
	public static int getProfit(Town town) 
	{
		int profit = 0;
		
		for (int i = 0; i < town.getLength(); ++i) {
			for (int j = 0; j < town.getWidth(); ++j) {
				if (town.grid[i][j].who() == State.CASUAL) {
					profit += 1;
				}
			}
		}
		
		return profit;
	}
	

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should only print the integer part (Just print the 
	 *  integer value. Example if profit is 35.56%, your output should be just: 35).
	 *  
	 * Note that this method does not throws any exception, thus you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) 
	{
		Scanner scnr = new Scanner(System.in);
		Town[] town = new Town[12];
		Boolean loop = true;
		
		while (loop) {
			System.out.print("How to populate grid (type 1 or 2): ");
			int answer = scnr.nextInt();
			scnr.nextLine();
			
			if (answer == 1) {
				System.out.print("Please enter file path: ");
				String fileName = scnr.next();
				try {
					town[0] = new Town(fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				loop = false;
			}
			else if (answer == 2) {
				System.out.print("Provide rows, cols, and seed integer separated by spaces: ");
				String intString = scnr.nextLine();
				
				String[] strNumbers = intString.split(" ");
				int[] intNumbers = new int[strNumbers.length];
				
				for (int i = 0; i < 3; ++i) {
					intNumbers[i] = Integer.parseInt(strNumbers[i]);
				}
				
				town[0] = new Town(intNumbers[0], intNumbers[1]);
				town[0].randomInit(intNumbers[2]);
				
				loop = false;
			}
			else {
				System.out.println("");
				System.out.println("Your input was not one of the two options. Please try again.");
				System.out.println("");
			}
		}
		
		
		String townString = town[0].toString();
		System.out.println(townString);
		
		System.out.println("");
		
		double maxProfit = town[0].getLength() * town[0].getWidth() * 12;
		double totalProfit = getProfit(town[0]);
		
		for (int i = 1; i < 12; ++i) {
			town[i] = new Town(town[i - 1].getLength(), town[i - 1].getWidth());
			town[i] = updatePlain(town[i - 1]);

			totalProfit = totalProfit + getProfit(town[i]);
			
			townString = town[i].toString();
			System.out.println(townString);
		}
		
		double percentProfit = (totalProfit / maxProfit) * 100.00;
		
		System.out.print("Profit Utilization: " + percentProfit);
		
		scnr.close();
	}
}
