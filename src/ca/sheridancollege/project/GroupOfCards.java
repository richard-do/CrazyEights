package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Class: GroupOfCards
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 *
 * GroupOfCards is designed to represent both the player's hand
 * alongside the game's deck in which players will draw from.
 * It'll also represent the face-up pile in which cards will be
 * played.
 *
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */

public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    
    // default constructor
    public GroupOfCards()
    {
        setCards(new ArrayList<>());
    }
    
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> getCards()
    {
        return cards;
    }
    
    // returns number of cards in this group
    public int size(){
        return getCards().size();
    }
    
    // for shuffling the deck of cards
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    
    // add card to arraylist cards
    public void addCard(Card card){
        cards.add(card);
    }
    
    // adds pile to deck and suffle
    public void addPile(GroupOfCards pile){
        getCards().addAll(pile.getCards());
    }
}//end class
