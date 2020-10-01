package hw1;

/**
 *  @author Jack Croghan
 *  
 *  Casual customer: checks their email 13 times a day
 */
public class Casual extends TownCell
{
	/**
	 * Creates a new casual object that is represented by a 'C' in the town grid
	 * 
	 * @param p
	 * 	the town that this cell is being applied to
	 * @param r
	 * 	the row of the cell
	 * @param c
	 * 	the column of the cell
	 */
	public Casual(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who() 
	{
		return State.CASUAL;
	}

	@Override
	public TownCell next(Town tNew)
	{
		
		if(nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
			return new Reseller(tNew, row, col);
		}
		else if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		}
		else if (nCensus[STREAMER] > 0) {
			return new Streamer(tNew, row, col);
		}
		else if (nCensus[CASUAL] >=5) {
			return new Streamer(tNew, row, col);
		}
		else {
			return new Casual(tNew,row,col);
		}
	}
}
