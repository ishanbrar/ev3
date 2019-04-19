import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class PokerDealer
{
    ArrayList<PokerCard> deck = new ArrayList<PokerCard>();
    ArrayList<PokerPlayer> gamblers = new ArrayList<PokerPlayer>();
    private PokerCard card1;
    private PokerCard card2;
    private PokerCard card3;
    private PokerCard card4;
    private PokerCard card5;
    public ArrayList<PokerCard> comCards;

    public static void main(String args[])
    {
        PokerDealer deal = new PokerDealer();
        //deal.printAllCards();
        deal.createDeck();
        deal.addPlayers();
        deal.dealCards();
        deal.whoHasWhat();
        deal.dealCommunityCards();
        deal.getCommunityCards();
        deal.whoWon();
        deal.takeTheMoney();


    }
    public PokerDealer()
    {
    }
    public PokerDealer(int numPlayers)
    {

    }
    public void addPlayers()
    {
        PokerPlayer ishan = new PokerPlayer("Ishan", 10);
        PokerPlayer anish = new PokerPlayer("Anish", 10);
        PokerPlayer nick = new PokerPlayer("Nick", 10);
        PokerPlayer ronald = new PokerPlayer("Ronald", 10);
        PokerPlayer paritosh = new PokerPlayer("Paritosh", 10);
        PokerPlayer sanjeet = new PokerPlayer("Sanjeet", 10);
        gamblers.add(ishan);
        gamblers.add(anish);
        gamblers.add(nick);
        gamblers.add(ronald);
        gamblers.add(paritosh);
        gamblers.add(sanjeet);

    }
    public void dealCards()
    {
        for(int index = 0; index < gamblers.size(); index ++)
        {
            gamblers.get(index).first(drawCard());
            gamblers.get(index).second(drawCard());

        }


    }

    public void createDeck()
    {
        for(int index = 0; index < 13; index++)
        {
            deck.add(new PokerCard((index + 1), "Spades"));
        }
        for(int index = 13; index < 26; index++)
        {
            deck.add(new PokerCard((index - 12), "Clubs"));
        }
        for(int index = 26; index < 39; index++)
        {
            deck.add(new PokerCard((index -25), "Hearts"));
        }
        for(int index = 39; index < 52; index++)
        {
            deck.add(new PokerCard((index -38), "Diamonds"));
        }
    }
    public PokerCard drawCard()
    {
        int size = deck.size();
        int random = ThreadLocalRandom.current().nextInt(0, size);
        PokerCard answer = deck.get(random);
        deck.remove(random);
        return answer;

    }
    public void dealCommunityCards()
    {
        drawCard();
        //for(int index = 1; index < 4; index++)
        //{
        card1 = drawCard();
        System.out.println(card1.toString());
        card2 = drawCard();
        System.out.println(card2.toString());
        card3 = drawCard();
        System.out.println(card3.toString());
        //}
        drawCard();
        card4 = drawCard();
        System.out.println(card4.toString());
        drawCard();
        card5 = drawCard();
        System.out.println(card5.toString());
        System.out.println();


    }
    public void whoWon()
    {
        for(int index = 0; index < gamblers.size(); index ++)
        {
            PokerPlayer x = gamblers.get(index);
            System.out.println(x.getName() + " has a " + x.bestHandSecond(comCards));


        }


    }
    public void takeTheMoney()
    {
        boolean loneWinner = true;
        String winnerName = "";
        double winnerRank = 0;
        String winnerName2 = "";
        double winnerRank2 = 0;
        for(int index = 0; index < gamblers.size(); index ++)
        {
            if(gamblers.get(index).getRank() > winnerRank)
            {
                winnerRank = gamblers.get(index).getRank();
                winnerName = gamblers.get(index).getName();
            }
        }
        for(int index = 0; index < gamblers.size(); index ++)
        {
            if(gamblers.get(index).getRank() == winnerRank)
            {
                loneWinner = false;
                winnerRank2 = gamblers.get(index).getRank();
                winnerName2 = gamblers.get(index).getName();
                System.out.println( winnerName + " splits with " + winnerName2);
            }
        }
        if(loneWinner == true)
        {
            System.out.println(winnerName + " is the winner!");

        }
    }
    public ArrayList<PokerCard> getCommunityCards()
    {
        ArrayList<PokerCard> communityCards = new ArrayList<PokerCard>();
        communityCards.add(card1);
        communityCards.add(card2);
        communityCards.add(card3);
        communityCards.add(card4);
        communityCards.add(card5);
        comCards = communityCards;
        return comCards;


    }

    public int randomNum()
    {
        int size = deck.size();
        int random = ThreadLocalRandom.current().nextInt(0, size);
        return random;
    }
    public void printAllCards()
    {

        createDeck();
        int max = deck.size();
        System.out.println(max);
        while(deck.size() > 0)
        {
            PokerCard test = drawCard();
            System.out.println(test.getValue() + " of " + test.getSuit());
        }
    }
    public void whoHasWhat()
    {
        for(int index = 0; index < gamblers.size(); index ++)
        {
            PokerPlayer x = gamblers.get(index);
            System.out.println(x.getName() + " has a " + x.showFirst() + " and a " + x.showSecond());
            System.out.println();


        }
    }
}