package hw1;

/**
 *  @author Jack Croghan
 *
 *  Empty grid cell
 */
public class Empty extends TownCell
{
	/**
	 * Creates a new empty object that is represented by a 'E' in the town grid
	 * 
	 * @param p
	 * 	the town that this cell is being applied to
	 * @param r
	 * 	the row of the cell
	 * @param c
	 * 	the column of the cell
	 */
	public Empty(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who() 
	{
		return State.EMPTY;
	}

	@Override
	public TownCell next(Town tNew)
	{
		if(nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
			return new Reseller(tNew, row, col);
		}
		else {
			return new Casual(tNew, row, col);
		}
	}
}
