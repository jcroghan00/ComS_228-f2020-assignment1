package hw1;

/**
 *  @author Jack Croghan
 *
 *  Outage grid cell
 */
public class Outage extends TownCell
{
	/**
	 * Creates a new outage object that is represented by a 'O' in the town grid
	 * 
	 * @param p
	 * 	the town that this cell is being applied to
	 * @param r
	 * 	the row of the cell
	 * @param c
	 * 	the column of the cell
	 */
	public Outage(Town p, int r, int c) 
	{
		super(p, r, c);
	}

	@Override
	public State who() 
	{
		return State.OUTAGE;
	}

	@Override
	public TownCell next(Town tNew) 
	{
		return new Empty(tNew, row, col);
	}
}
