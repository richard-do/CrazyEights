package ca.sheridancollege.project;

/*
 *
 * Class: Player
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 *
 * Represents the Player in the crazy eight game.
 *
 * Handles operations related to the player and
 * how they interact with the board.  In this case, they
 * will be able draw and play cards.
 *
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */

public class Player 
{
    private String playerID; //the unique ID for this player
    private GroupOfCards hand; // represents the player's hand
    private CrazyEights game; // represents the game the players are in

    // default constructor
    public Player(String name, CrazyEights game, int startingHand)
    {
        setPlayerID(name);
        setGame(game);
        hand = new GroupOfCards();
        
        for (int i = 0; i < startingHand; i++){
            this.drawCard();
        }
    }
    
    // constructor for testing purposes
    public Player(String name){
        setPlayerID(name);
        hand = new GroupOfCards();
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }

    /**
     * @return the hand
     */
    public GroupOfCards getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }
    
        /**
     * @return the game
     */
    public CrazyEights getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(CrazyEights game) {
        this.game = game;
    }
    
    // Draws a card.
    // Will shuffle pile into deck if empty.
    public void drawCard(){
    // remove and returns top card from deck
        if (getGame().getDeck().size() == 0) getGame().shufflePileIntoDeck();
        if (getGame().getDeck().size() > 0)
            hand.addCard(getGame().getDeck().getCards().remove(0));
        else if (getGame().getDeck().size()
                == 0 && getGame().getPile().size() == 1)
            System.out.println("Can't draw any more cards!");
    }
    
    // returns their ID for toString
    @Override
    public String toString(){
        return this.getPlayerID();
    }
}