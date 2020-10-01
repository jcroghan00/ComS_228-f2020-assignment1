package hw1;

/**
 *  @author Jack Croghan
 *
 *  Reseller customer: provides lower-cost, lower-bandwidth internet to users off the grid
 */
public class Reseller extends TownCell
{
	/**
	 * Creates a new reseller object that is represented by a 'R' in the town grid
	 * 
	 * @param p
	 * 	the town that this cell is being applied to
	 * @param r
	 * 	the row of the cell
	 * @param c
	 * 	the column of the cell
	 */
	public Reseller(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who() 
	{
		return State.RESELLER;
	}

	@Override
	public TownCell next(Town tNew)
	{
		if (nCensus[CASUAL] <= 3) {
			return new Empty(tNew, row, col);
		}
		else if (nCensus[EMPTY] >= 3) {
			return new Empty(tNew, row, col);
		}
		else if (nCensus[CASUAL] >= 5) {
			return new Streamer(tNew, row, col);
		}
		else {
			return new Reseller(tNew, row, col);
		}
	}
}
