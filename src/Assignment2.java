import java.util.ArrayList;

public class Assignment2
{
	// these can't be final, because main would not be able to set them if they were
	static int		N_GAMES;
	static int		N_HANDS;
	static int		CARDS_PER_HAND;
	static int		CARDS_PER_LINE;
    static boolean	SHUFFLE;
    
	public static ArrayList<Hand> setHands(ArrayList<Hand> HandList, final int N_HANDS)
	{
		if(!HandList.isEmpty())
		{
			HandList.removeAll(HandList);
		}
		for(int i=0; i< N_HANDS; i++ )
		{
			Hand myHand = new Hand();
			HandList.add(myHand);
		}
		return HandList;
	}
    public static void main(String args[])
    {
    	// remember to have this print your own name instead of I. Forgot
        System.out.printf("CS261 - Assignment 2 - Alseny Diallo %n%n");
        
        // get command line arguments
        if (args.length != 5) {
        	System.out.println("requires 5 arguments: nGames, nHands, cardsPerHand, cardsPerLine, shuffle");
        	return;
        	}
        try {
        	N_GAMES = Integer.parseInt(args[0]);
        	N_HANDS = Integer.parseInt(args[1]);
		    CARDS_PER_HAND = Integer.parseInt(args[2]);
		    CARDS_PER_LINE = Integer.parseInt(args[3]);
        	}
        catch (NumberFormatException e) {
        	System.out.printf("bad numeric argument %s%n", e.getMessage());
        	return;
        	}
        SHUFFLE = new Boolean(args[4]);

        System.out.printf("games: %d, hands: %d, cards per hand: %d,%ncards per line: %d, shuffle: %b%n%n",
        				  N_GAMES, N_HANDS, CARDS_PER_HAND, CARDS_PER_LINE, SHUFFLE);
        
        // add your code here
        ArrayList<Hand> HandList = new ArrayList<Hand>(N_HANDS);
    	Deck deck = new Deck();
    	Dealer dealer = new Dealer(deck.getDeck(), CARDS_PER_HAND, SHUFFLE);
    	dealer.displayDelearDeck(CARDS_PER_LINE);
    	
        // play games
        for(int i=1; i<= N_GAMES; i++)
        {
        	System.out.println("\n\n=== Game " +i+ " ==="); 
        	
        	int remainingCard = dealer.getDealerCardList().size() / N_HANDS;
        	if( remainingCard < CARDS_PER_HAND)
        	{
            	deck = new Deck();
            	dealer = new Dealer(deck.getDeck(), CARDS_PER_HAND, SHUFFLE);
            	HandList = setHands(HandList, N_HANDS);
        	}
            HandList = setHands(HandList, N_HANDS);
        	HandList = (dealer.dealCard(HandList, N_HANDS));
        	
            for(int j=0; j<N_HANDS; j++)
            {
            	System.out.println("\n--- Hand " +(j+1)+ " ---\n");
            	HandList.get(j).displayHandCard(CARDS_PER_LINE);
            	System.out.println("\nscore = " + HandList.get(j).getHandScore());
            }      	
        }
        System.out.println("\n=== Games complete ===");
        
    }
}
