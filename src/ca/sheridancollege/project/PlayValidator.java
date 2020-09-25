package ca.sheridancollege.project;

/**
 * 
 * Class: PlayValidator
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 * 
 * Checks for valid inputs and plays according
 * to the game state and the current player's hand.
 * 
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */

public class PlayValidator {
    
    // check if user input a valid suit
    public static boolean validateSuit(String suit){
        return suit.matches("[schdSCHD]");
    }
    
    // checks to see if the user input a valid card
    public static boolean validateCard(String card){
        return card.matches("([ajqkAJQK]|[2-9]|10)[schdSCHD]");
    }
    
    // checks to see if user hand contains the card
    // that they specified
    public static boolean inHand(GroupOfCards hand, Card card){
        return hand.getCards().contains(card);
    }
    
    // A valid play is one where either the played card matches
    // the top card of the pile's rank, the current
    // suit of the pile or is an eight.
    public static boolean validatePlay(Rank rank, Suit suit, Card playCard){
        return (suit == playCard.getSuit() ||
                rank == playCard.getRank() ||
                playCard.getRank() == Rank.EIGHT);
    }
}
