import java.util.*;
public class PokerPlayer
{
    private PokerCard firstCard;
    private PokerCard secondCard;
    private String id;
    private int money;
    private double rank = 0;


    public static void main(String args[])
    {


    }
    public PokerPlayer(String name, int buyIn)
    {
        id = name;
        money = buyIn;
    }
    public String bestHandSecond(ArrayList<PokerCard> comCards)
    {
        PokerCard p1 = getFirst();
        PokerCard p2 = getSecond();
        int[] cardsx = new int[15];
        PokerCard[] cardst = new PokerCard[7];
        for(int index = 0; index < 5; index ++)
        {
            cardsx[comCards.get(index).getNumber()] = comCards.get(index).getNumber();

        }
        cardsx[p1.getNumber()] = p1.getNumber();
        cardsx[p2.getNumber()] = p2.getNumber();
        int[] cards = new int[15];
        for(int index = 0; index < 5; index++)
        {
            PokerCard card = comCards.get(index);
            cardst[index] = card;
        }
        cardst[5] = p1;
        cardst[6] = p2;
        for(int index = 0; index < 5; index++)
        {
            PokerCard card = comCards.get(index);
            cards[card.getNumber()]++;
        }
        cards[p1.getNumber()]++;
        cards[p2.getNumber()]++;
        boolean p1pair = false;
        boolean p2pair = false;
        boolean twoPair = false;
        boolean p1threeOfAKind = false;
        boolean p2threeOfAKind = false;
        boolean straight = false;
        boolean flush = false;
        boolean fullHouse = false;
        int straightHigh = 0;
        int pairs = 0;
        int threes = 0;
        int fours = 0;
        int spades = 0;
        int hearts = 0;
        int clubs = 0;
        int diamonds = 0;
        int highCard = p1.getNumber();

        if(p2.getNumber() > highCard)
        {
            highCard = p2.getNumber();
        }
        for(int index = 0; index < 7; index ++)
        {
            if(cardst[index].getSuit().equals("Spades"))
            {
                spades++;
            }
            if(cardst[index].getSuit().equals("Clubs"))
            {
                clubs++;
            }
            if(cardst[index].getSuit().equals("Diamonds"))
            {
                diamonds++;
            }
            if(cardst[index].getSuit().equals("Hearts"))
            {
                hearts++;
            }
        }

        for(int index = 0; index < 15; index++)
        {
            if(cards[index] == 2)
            {
                pairs++;
            }
            if(cards[index] == 3)
            {
                threes++;
            }
            if(cards[index] == 4)
            {
                fours++;
            }
        }
        for(int index = 1; index < 10; index ++)
        {
            if(cardsx[index+4] - cardsx[index+3] == 1 && cardsx[index+3] - cardsx[index+2] == 1 && cardsx[index+2] - cardsx[index+1] == 1 && cardsx[index+1] - cardsx[index] == 1)
            {
                straight = true;
                if(straight == true)
                {
                    straightHigh =cardsx[index+4];
                }
            }
        }
        if(cardsx[14] - cardsx[13] ==1 && cardsx[13] - cardsx[12] ==1 && cardsx[12] - cardsx[11] ==1 && cardsx[11] - cardsx[10] ==1 && cardsx[1] == 1)
        {
            straight = true;
            if(straight == true)
            {
                straightHigh =14;
            }
        }
        if(fours > 0)
        {
            int index = 14;
            int foursHigh =0;
            while(cards[index] != 4)
            {
                index--;
            }
            foursHigh = index;
            rank = 8 + (foursHigh/10);

            return "Four of a Kind " + cards[index];
        }
        if(threes > 0 && pairs > 0)
        {
            int number = 14;
            for(int index = 14; index >0; index--)
            {
                if(cards[index] == 3)
                {
                    number = index;
                }
            }
            rank = 7 + number;
            return  getValue(number) + " High Full House";

        }
        if(hearts > 4)
        {
            int flushHigh = 0;
            String high = "";
            for(int index = 0; index < 7; index ++)
            {
                PokerCard card = cardst[index];
                if(card.getSuit().equals("Hearts"))
                {
                    high = card.getValue();
                    if(card.getNumber() > flushHigh)
                    {
                        flushHigh = card.getNumber();
                    }
                }
            }
            rank = 6 + (flushHigh/10);

            return high +" High Flush";

        }
        if(spades > 4)
        {
            int flushHigh = 0;
            String high = "";
            for(int index = 0; index < 7; index ++)
            {
                PokerCard card = cardst[index];
                if(card.getSuit().equals("Spades"))
                {
                    high = card.getValue();
                    if(card.getNumber() > flushHigh)
                    {
                        flushHigh = card.getNumber();
                    }
                }
            }
            rank = 6 + (flushHigh/10);

            return high +" High Flush";

        }
        if(clubs > 4)
        {
            int flushHigh = 0;
            String high = "";
            for(int index = 0; index < 7; index ++)
            {
                PokerCard card = cardst[index];
                if(card.getSuit().equals("Clubs"))
                {
                    high = card.getValue();
                    if(card.getNumber() > flushHigh)
                    {
                        flushHigh = card.getNumber();
                    }
                }
            }
            rank = 6 + (flushHigh/10);

            return high +" High Flush";

        }
        if(diamonds > 4)
        {
            String high = "";
            int flushHigh = 0;
            for(int index = 0; index < 7; index ++)
            {
                PokerCard card = cardst[index];
                if(card.getSuit().equals("Diamonds"))
                {
                    high = card.getValue();
                    if(card.getNumber() > flushHigh)
                    {
                        flushHigh = card.getNumber();
                    }
                }
            }
            rank = 6 + (flushHigh/10);

            return high +" High Flush";

        }
        if(straight == true)
        {
            rank = 5 + (straightHigh/10);

            return " Straight";
        }
        if(threes > 0)
        {
            int number = 14;
            int threesHigh = 0;
            for(int index = 14; index >0; index--)
            {
                if(cards[index] == 3)
                {
                    number = index;
                    threesHigh = cards[index];
                }
            }
            rank = 4 + (threesHigh/10);

            return "Three of a Kind  " + getValue(number) + "s with " + getValue(highCard) + " kicker";
        }
        if(pairs == 2)
        {
            int highNumber = 14;
            int lowNumber = 1;
            boolean found = false;
            int index = 14;
            while(found == false)
            {
                if(cards[index] == 2)
                {
                    found = true;
                    highNumber = index;
                    found = true;

                }
                index--;
            }
            for(int indexx = highNumber ; indexx >0; indexx--)
            {
                if(cards[indexx] == 2)
                {
                    lowNumber = indexx;

                }
            }
            rank = 3 + (highNumber/10);

            return "Two Pair with " + getValue(highNumber) + " High and " + getValue(lowNumber) + " low";
        }
        if(pairs ==1)
        {
            int number = 14;
            for(int index = 14; index >0; index--)
            {
                if(cards[index] == 2)
                {
                    number = index;
                }
            }
            rank = 2 + (highCard/10);
            return "Pair of " + getValue(number) + "s with " + getValue(highCard) + " kicker";
        }
        if(p2.getNumber() > highCard)
        {
            highCard = p2.getNumber();
        }
        if(p1.getNumber()==1 || p2.getNumber() == 1 )

        {
            rank = 1 + (highCard/10);
            return "High Card of Ace";
        }
        rank = 1 + (highCard/10);

        return "High Card of " + getValue(highCard);
    }











    public String bestHand(ArrayList<PokerCard> comCards)
    {
        //ArrayList<PokerCard> comCards = communityCards;
		    /*PokerCard card1 = comCards.get(0);
			PokerCard card2= comCards.get(1);
			PokerCard card3= comCards.get(2);
			PokerCard card4= comCards.get(3);
			PokerCard card5= comCards.get(4);*/
        int[] cards = new int[14];
        boolean p1pair = false;
        boolean p2pair = false;
        boolean twoPair = false;
        boolean p1threeOfAKind = false;
        boolean p2threeOfAKind = false;
        boolean straight = false;
        //boolean straight = false;
        //boolean flush = false;
        boolean fullHouse = false;
        PokerCard p1 = getFirst();
        PokerCard p2 = getSecond();
        boolean pocketPair = false;
        boolean fourOfAKind = false;
        int p1matches = 0;
        int p2matches = 0;
        //int matches = 0;
        PokerCard highCard = p1;
        for(int index = 0; index < 5; index ++)
        {
            cards[comCards.get(index).getNumber()] = comCards.get(index).getNumber();

        }
        cards[p1.getNumber()] = p1.getNumber();
        cards[p2.getNumber()] = p2.getNumber();
        if(p1.getNumber() >= p2.getNumber())
        {
            highCard = p1;
        }

        if(p2.getNumber() > p1.getNumber())
        {
            highCard = p2;
        }
        if(p1.getNumber() == 1)
        {
            highCard = p1;
        }
        if (p2.getNumber() == 1)
        {
            highCard = p2;
        }
        for(int index = 0; index < 5; index ++)
        {
            if(p1.getNumber() == comCards.get(index).getNumber())
            {
                p1matches++;
            }
        }
        if(p1.getNumber() == p2.getNumber())
        {
            p1matches++;
        }
        for(int index = 0; index < 5; index ++)
        {
            if(p2.getNumber() == comCards.get(index).getNumber())
            {
                p2matches++;
            }
        }

        if(p1.getNumber() == p2.getNumber())
        {
            pocketPair = true;
        }
        if(p2matches > p1matches)
        {
            //matches = p2matches;
        }
        if(p1matches == 1 && pocketPair == false)
        {
            p1pair = true;
        }
        if(p1matches == 2)
        {
            p1threeOfAKind = true;
        }
        if(p2matches == 1)
        {
            p2pair = true;
        }
        if(p2matches == 2)
        {
            p2threeOfAKind = true;
        }
        if(p1matches == 1 && p2matches == 1)
        {
            twoPair = true;
        }

        for(int index = 1; index < 9; index ++)
        {
            if(cards[index+4] - cards[index+3] == 1 && cards[index+3] - cards[index+2] == 1 &&cards[index+2] - cards[index+1] == 1 && cards[index+1] - cards[index] == 1)
            {
                straight = true;
            }
        }
        if(cards[13] - cards[12] ==1 && cards[12] - cards[11] ==1 && cards[11] - cards[10] ==1 && cards[10] - cards[9] ==1 && cards[1] == 1)
        {
            straight = true;
        }
        if(p1pair == true && p2threeOfAKind == true)
        {
            fullHouse = true;
            p1pair = false;
            twoPair = false;
        }
        if(p2pair == true && p1threeOfAKind == true)
        {
            fullHouse = true;
            p2pair = false;
            twoPair = false;
        }
        if(pocketPair == true && p2matches == 1)
        {
            p2matches--;
            fullHouse = false;
            p1threeOfAKind = true;
        }
        if(p1threeOfAKind == true || p2threeOfAKind == true && pocketPair == true)
        {
            for(int index = 0; index < 5; index++)
            {
                int matches = 0;
                PokerCard card = comCards.get(index);
                {
                    for(int indexx = 0; indexx < 5; indexx++)
                    {
                        if(comCards.get(indexx).getNumber() == card.getNumber())
                        {
                            matches++;
                        }
                    }
                }
                matches--;
                if(matches > 0)
                {
                    fullHouse = true;
                }
            }
        }
        if(p1matches > 2 || p2matches > 2 )
        {
            fourOfAKind = true;
        }
        if(fourOfAKind == true)
        {
            return "Four of a Kind ";
        }
        if(fullHouse == true)
        {
            return "Full House";
        }
        if(straight == true)
        {
            return "Straight";

        }
        if(p1threeOfAKind == true && p2threeOfAKind == true)
        {
            return "Three of a Kind " + highCard.getValue() + "s" ;
        }
        if(p1threeOfAKind == true)
        {
            return "Three of a Kind " + p1.getValue() + "s" ;
        }
        if(p2threeOfAKind == true)
        {
            return "Three of a Kind " + p2.getValue() + "s" ;
        }
        if(twoPair == true)
        {
            return "Two Pair of " + p1.getValue() + "s and " + p2.getValue() + "s";
        }
        if(p1pair == true)
        {
            return "Pair of " + p1.getValue() + "s";
        }
        if(p2pair == true)
        {
            return "Pair of " + p2.getValue() + "s";
        }






        return "High Card of " + highCard.getValue() + " of " + highCard.getSuit();
    }
    public PokerCard getFirst()
    {
        return firstCard;
    }
    public PokerCard getSecond()
    {
        return secondCard;
    }
    public String getValue(int number)
    {
        String key = "";
        if(number == 1)
        {
            return "Ace";
        }
        if(number == 11)
        {
            return "Jack";
        }
        if( number == 12)
        {
            return "Queen";
        }
        if( number == 13)
        {
            return "King";
        }
        if(number == 14)
        {
            return "Ace";
        }
        return key + number;
    }
    public String getName()
    {
        return id;
    }
    public int getMoney()
    {
        return money;
    }
    public void first(PokerCard one)
    {
        firstCard = one;
    }
    public void second(PokerCard two)
    {
        secondCard = two;
    }
    public String showFirst()
    {
        return firstCard.toString();
    }
    public String showSecond()
    {
        return secondCard.toString();
    }
    public double getRank()
    {
        return rank;
    }


}