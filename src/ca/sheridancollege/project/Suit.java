package ca.sheridancollege.project;

/**
 * Class: Suit
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 * 
 * Represents the Suits for the Card class.
 * 
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */
public enum Suit {
    CLUBS(1, "C", "Clubs" ,'\u2663'),
    DIAMONDS(2, "D", "Diamonds", '\u2662'),
    HEARTS(3, "H", "Hearts", '\u2661'),
    SPADES(4, "S", "Spades", '\u2660');
    
    private int value;
    private String shortName;
    private String name;
    private char symbol;
    
    private Suit(int value, String shortName, String name, char symbol){
        this.value = value;
        this.shortName = shortName;
        this.name = name;
        this.symbol = symbol;
    }
    
    // get suit based on string
    public static Suit getSuitFromLetter(String letter){
        for (Suit s : values()){
            if (s.shortName.equals(letter.toUpperCase())) return s;
        }
        return null;
    }

    // gets the value of each suit
    public int getValue() {
        return value;
    }
    
    public String getShortName(){
        return shortName;
    }

    // returns the name of each suit
    public String getName() {
        return name;
    }
    
    // returns the symbol associated with the suit
    public char getSymbol(){
        return symbol;
    }
}
