package hw1;

/**
 *  @author Jack Croghan
 *
 *  Streamer customer: an aspiring e-celebrity with an appetite for bandwidth
 */
public class Streamer extends TownCell
{
	/**
	 * Creates a new streamer object that is represented by a 'S' in the town grid
	 * 
	 * @param p
	 * 	the town that this cell is being applied to
	 * @param r
	 * 	the row of the cell
	 * @param c
	 * 	the column of the cell
	 */
	public Streamer(Town p, int r, int c)
	{
		super(p, r, c);
	}

	@Override
	public State who() 
	{
		return State.STREAMER;
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
		else if (nCensus[OUTAGE] > 0) {
			return new Empty(tNew, row, col);
		}
		else {
			return new Streamer(tNew, row, col);
		}
	}
}
