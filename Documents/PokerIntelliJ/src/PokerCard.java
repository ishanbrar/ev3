import java.util.*;
import java.util.Arrays;
import java.util.List;

class PokerCard
{
    private int number;
    private String suit;

    public static void main(String args[])
    {


    }
    public PokerCard(int num, String type)
    {
        number = num;
        suit = type;

    }


    public void createCard()
    {


    }

    public String getSuit()
    {
        return suit;
    }
    public int getNumber()
    {
        if(number == 1)
        {
            return 14;
        }
        return number;
    }

    public String getValue()
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
        return key + number;
    }
    @Override
    public String toString()
    {
        return getValue() +" of " + getSuit();
    }
}