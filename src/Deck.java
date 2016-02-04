import java.util.List;
import java.util.ArrayList;

public class Deck
{
	
    private static final List<Card> protoDeck = new ArrayList<Card>();
    // initialize prototype deck
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
    }
    
    private ArrayList<Card> MyDeck;
    
    Deck()
    {
    	MyDeck = new ArrayList<Card>(protoDeck);
    }
    
    public final ArrayList<Card> getDeck()
    {
    	return this.MyDeck;
    }
    
    public void displayDeck(int nbrCardPerLine)
    {
    	final ArrayList<Card> tempCardList = new ArrayList<Card>(this.getDeck());
    	final int size = tempCardList.size();
    	
    	for(int i=0, cardCount=0; i<size; i++, ++cardCount)
    	{
    		if(cardCount == nbrCardPerLine){ System.out.println(); cardCount=0;}
    		tempCardList.get(i).displayCard();
    		if(i < size-1){ System.out.print(", ");}

    	}
    }

}
