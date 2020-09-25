package ca.sheridancollege.project;

/**
 * Class: Card
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 * 
 * Represents the standard card from a 52 card deck
 * or alternatively known as a French card.
 * 
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */
public class Card {

    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit){
        setRank(rank);
        setSuit(suit);
    }
    
    public Card (String rank, String suit){
        setRank(Rank.getRankFromLetter(rank));
        setSuit(Suit.getSuitFromLetter(suit));
    }

    /**
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    @Override
    // returns short form of each card
    public String toString(){
        return this.getRank().getShortName()+this.getSuit().getSymbol();
    }
    
    // check if cards are equal by checking if they
    // have the same rank and suit
    @Override
    public boolean equals(Object o){
        if (o instanceof Card)
            return (((Card)o).getRank() == this.getRank()
                    && ((Card)o).getSuit() == this.getSuit());
        return false;
    }
    
    @Override
    public int hashCode(){
        int result = 53;
        result = 53 * result + getRank().hashCode();
        result = 53 * result + getSuit().hashCode();
        return result;
    }
}
