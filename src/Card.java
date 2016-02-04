public class Card
{

	public enum Rank
	{
		
		ACE(11), KING(10), QUEEN(10), JACK(10), TEN(10), NINE(9), EIGHT(8),
		SEVEN(7), SIX(6), FIVE(5), FOUR(4), THREE(3), DEUCE(2);
		
		private int rankValue;
		private Rank(int value)
		{
			rankValue = value;
		}
		public int getRankValue()
		{
			return this.rankValue;
		}
	}
	
	public enum Suit
	{
		 HEARTS(4), DIAMONDS(3), CLUBS(2), SPADES(1);
		 
		 private int suitValue;
		 private Suit(int value)
		 {
			 suitValue = value;
		 }
		 public int getSuitValue()
		 {
			 return this.suitValue;
		 }
	}
	
	private final Rank	rank;
	private final Suit	suit;
	
	Card(Rank rank, Suit suit)
	{
	    this.rank = rank;
	    this.suit = suit;
	}
	
	public final int computeCardScore()
	{
		return this.rank().getRankValue() * this.suit().getSuitValue();
	}
	
	public void displayCard()
	{
		final int score = this.computeCardScore();
		System.out.print(this.toString()+ '(' +score+ ')');
	}
	
	
	public Rank rank()          { return this.rank; }
	public Suit suit()          { return this.suit; }
	public String toString()    { return rank + " of " + suit; }
}
