package hw1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Jack Croghan
 *  
 *  A town consisting of grids of multiple types
 */
public class Town 
{
	private int length, width;  //Row and col (first and second indices)	
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width)
	{
		this.length = length;
		this.width = width;
		
		grid = new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws IOException 
	 */
	public Town(String inputFileName) throws IOException 
	{
		FileInputStream inStream = new FileInputStream(inputFileName);
		Scanner scnr = new Scanner(inStream);
		
		length = Integer.parseInt(scnr.next());
		width = Integer.parseInt(scnr.next());
		
		grid = new TownCell[length][width];
		
		int i;
		int j;
		
		String c;
		
		for (i = 0; i < length; ++i) {
			for (j = 0; j < width; ++j) {
				c = scnr.next();
				if (c.equals("C")) {
					grid[i][j] = new Casual(this, i, j);
				}
				else if (c.equals("O")) {
					grid[i][j] = new Outage(this, i, j);
				}
				else if (c.equals("E")) {
					grid[i][j] = new Empty(this, i, j);
				}
				else if (c.equals("R")) {
					grid[i][j] = new Reseller(this, i, j);
				}
				else if (c.equals("S")) {
					grid[i][j] = new Streamer(this, i, j);
				}
			}
		}
		scnr.close();
		inStream.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() 
	{
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() 
	{
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) 
	{
		Random rand = new Random(seed);
		
		int i;
		int j;
		
		for(i = 0; i < length; ++i) {
			for (j = 0; j < width; ++j) {
				int random = rand.nextInt(5);
				
				if (random == 0) {
					grid[i][j] = new Casual(this, i, j);
				}
				else if (random == 1) {
					grid[i][j] = new Outage(this, i, j);
				}
				else if (random == 2) {
					grid[i][j] = new Empty(this, i, j);
				}
				else if (random == 3) {
					grid[i][j] = new Reseller(this, i, j);
				}
				else if (random == 4) {
					grid[i][j] = new Streamer(this, i, j);
					
				}
			}
		}	
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() 
	{
		String s = "";
		
		int i;
		int j;
		
		for (i = 0; i < length; ++i) {
			for ( j = 0; j < width; ++j) {
				if (this.grid[i][j].who() == State.CASUAL) {
					s = s + "C";
				}
				else if (this.grid[i][j].who() == State.EMPTY) {
					s = s + "E";
				}
				else if (this.grid[i][j].who() == State.RESELLER) {
					s = s + "R";
				}
				else if (this.grid[i][j].who() == State.STREAMER) {
					s = s + "S";
				}
				else if (this.grid[i][j].who() == State.OUTAGE) {
					s = s + "O";
				}
				s = s + " ";
			}
			s = s + "\n";
		}
		return s;
	}
}
