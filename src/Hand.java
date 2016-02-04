import java.util.ArrayList;

public class Hand
{

	 private ArrayList<Card> MyCardList;
	
	Hand()
	{
		MyCardList = new ArrayList<Card>();
	}
	
	public final ArrayList<Card> getHandCardList()
	{
		return this.MyCardList;
	}
	
	private int computeHandScore()
	{
		int score=0;
		final ArrayList<Card> tempCardList= new ArrayList<Card>(this.getHandCardList());
		final int size = tempCardList.size();
		
		for(int i=0; i < size; i++)
		{
			score += tempCardList.get(i).computeCardScore();
		}
		return score;
	}

	public final int getHandScore()
	{
		return this.computeHandScore();
	}
	
	public void displayHandCard(int nbrCardPerLine)
	{
		final ArrayList<Card> tempCardList = new ArrayList<Card>(this.getHandCardList());
		final int size = tempCardList.size();
		
		for(int i=0, cardCount=0; i<size; i++, ++cardCount)
		{
			if(cardCount == nbrCardPerLine){ System.out.println(); cardCount=0;}
			tempCardList.get(i).displayCard();
			if(i < size-1){ System.out.print(", ");}

		}
	}
}
