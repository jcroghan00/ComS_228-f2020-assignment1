package hw1;

/**
 * 
 * @author Jack Croghan
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c)
	{
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Censuses all cell types in the 3 X 3 neighborhood
	 * Use who() method to get who is present in the area
	 *  
	 * @param nCensus of all customers
	 */
	public void census(int nCensus[]) 
	{
		// zero the counts of all customers
		TownCell.nCensus[RESELLER] = 0; 
		TownCell.nCensus[EMPTY] = 0; 
		TownCell.nCensus[CASUAL] = 0; 
		TownCell.nCensus[OUTAGE] = 0; 
		TownCell.nCensus[STREAMER] = 0; 

		int i;
		int j;
		
		for (i = -1; i <= 1; ++i) {
			for (j = -1; j <= 1; ++ j) {
				if ((row + i >= 0 && col + j >= 0) && (row + i < plain.getLength() && col + j < plain.getWidth())) {
					if (i != 0 || j != 0) {
						TownCell.nCensus[determineMatch(plain.grid[row + i][col + j].who())] += 1;
					}
				}
			}
		}
	}
	
	/**
	 * This helper method will run a series of if-then statements to test what the initial state 
	 * of the town cell is.
 	 * 
 	 * @param initialState
 	 * 	the state that is searching for a match
 	 * @return
 	 * 	the integer of the match
 	 */
	private int determineMatch(State initialState) 
	{
		if (initialState == State.CASUAL) {
			return CASUAL;
		}
		else if (initialState == State.RESELLER) {
			return RESELLER;
		}
		else if (initialState == State.EMPTY) {
			return EMPTY;
		}
		else if (initialState == State.STREAMER) {
			return STREAMER;
		}
		else if (initialState == State.OUTAGE) {
			return OUTAGE;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
