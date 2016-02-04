import java.util.ArrayList;
import java.util.Collections;

public class Dealer 
{
	private int n_cardPerHand;
	private Boolean shuffle = false; // default setting
	final private ArrayList<Card> dealerCardList;
	int topOfList=0;
	
 	Dealer(ArrayList<Card> cardList, int nCrdHand, Boolean shuffle)
	{
		n_cardPerHand = nCrdHand;
		this.shuffle = new Boolean(shuffle);
		dealerCardList = new ArrayList<Card>(cardList);
	}
 	
 	public final ArrayList<Card> getDealerCardList()
 	{
 		return this.dealerCardList;
 	}
 	
	public final ArrayList<Hand> dealCard(final ArrayList<Hand> handList, final int nbrHand)
	{		
		if(this.shuffle)
		{
			Collections.shuffle(this.dealerCardList);
		}
		
		for(int i=0; i < this.n_cardPerHand; i++)
		{
			for(int j=0; j < nbrHand; j++)
			{	
				handList.get(j).getHandCardList().add(this.dealerCardList.remove(topOfList));
			}
		}
		return handList;
	}
	
    public void displayDelearDeck(int nbrCardPerLine)
    {
    	final ArrayList<Card> tempCardList = new ArrayList<Card>(this.getDealerCardList());
    	final int size = tempCardList.size();
    	
    	for(int i=0, cardCount=0; i<size; i++, ++cardCount)
    	{
    		if(cardCount == nbrCardPerLine){ System.out.println(); cardCount=0;}
    		tempCardList.get(i).displayCard();
    		if(i < size-1){ System.out.print(", ");}

    	}
    }
	
}
