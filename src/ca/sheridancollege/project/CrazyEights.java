package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Class: CrazyEights
 * Course: SYST17796 Fundamentals of Software Design and Development
 * Instructor: Ali Hassan
 * Group: 13
 * 
 * The model of the game.  It will handle all operations related
 * to communications in the game, and generating the base deck
 * required for play.
 *
 * 
 * @Author Richard Do, Brandon Stegmaier, Matthew Grinton
 */

public class CrazyEights
{
    private String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    private GroupOfCards deck; // deck players draw from
    private GroupOfCards pile; // the pile cards are played in
    private Suit suit; // represents the suit that must be adhered to
    private int turn; // represents the current player's turn
    
    private int numPlayers;
    Scanner input = new Scanner(System.in);

    public CrazyEights(){
        
    }
    
    // constructor
    public CrazyEights(String givenName)
    {
        gameName = givenName;
        players = new ArrayList<>();
        
        getNumPlayers();
        generateDeck();
        getDeck().shuffle();
        
        setPlayers();
        setTurn(0);
        setPile(new GroupOfCards());
        
        // remove top card of deck to set as top card of pile
        Card topCard = getDeck().getCards().remove(0);
        getPile().addCard(topCard);
        // set suit according to this card
        setSuit(topCard.getSuit());
    }

    // constructor for manual testing purposes
    public CrazyEights(ArrayList<Player> players){
        setPlayers(players);
        generateDeck();
        setTurn(0);
        setPile(new GroupOfCards());
    }
    
    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
    public void setGameName(String gameName){
        this.gameName = gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    // generates the players for the game
    public void setPlayers() 
    {
        int cardsInHand = (numPlayers == 2) ? 7 : 5; 
        System.out.println("We will now be getting the IDs for each player.");
        for (int i = 0; i < numPlayers; i++){
            System.out.println("What will player" + (i+1) + "'s ID be?");
            String playerID = input.nextLine();
            getPlayers().add(new Player(playerID, this, cardsInHand));
        }
    }
    
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

     /**
     * @return the deck's suit
     */
    public Suit getSuit() {
        return this.suit;
    }

    // set the suit that must be adhered to
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }
    
        /**
     * @return the deck
     */
    public GroupOfCards getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }

    /**
     * @return the pile
     */
    public GroupOfCards getPile() {
        return pile;
    }

    /**
     * @param pile the pile to set
     */
    public void setPile(GroupOfCards pile) {
        this.pile = pile;
    }
    
    // shuffles the two decks together
    public void shufflePileIntoDeck(){
        // take the top card
        Card tempHolder = getPile().getCards().remove(0);
        // adds the remainder of the pile to the deck
        getDeck().addPile(getPile());
        // shuffle the deck
        getDeck().shuffle();
        // clear the pile
        getPile().getCards().clear();
        // add top card back into the pile
        getPile().addCard(tempHolder);
    }
    
    // main game loop
    public void play(){
        Player currentPlayer;
        String choice;
        Card generatedCard;
        
        while (true){
            currentPlayer = players.get(turn);
            
            // force the user into a loop until a valid play is made
            while (true){
                System.out.println("~~It is currently " +
                        currentPlayer + "'s turn.~~");
                playCard(currentPlayer); // generates the instructions
                choice = input.nextLine();
                
                // checks to make sure user isn't drawing
                // prior to prompting for invalid play
                if (choice.toLowerCase().matches("draw"))
                    currentPlayer.drawCard();
                
                // if user makes a valid card choice
                else if (PlayValidator.validateCard(choice)){
                    // doing quick check if value is 10
                    String rank = (choice.substring(0,2).equals("10")) ?
                            "10" : choice.substring(0,1);
                    
                    // generate card with given parameters
                    generatedCard = new Card(rank,
                                     choice.substring(choice.length()-1,
                                             choice.length()));
                    
                    // check if its in their hand
                    if (PlayValidator.inHand(
                            currentPlayer.getHand(),
                            generatedCard)
                            // and is a valid play
                        && PlayValidator.validatePlay(
                                getTopCardPile().getRank(),
                                getSuit(),
                                generatedCard))
                    {    
                        // if so, remove it from their hand
                        // and add it to the pile
                        currentPlayer.getHand().getCards()
                                .remove(generatedCard);
                        getPile().addCard(generatedCard);
                        if (generatedCard.getRank() == Rank.EIGHT){
                            while (true){
                                System.out.println("You've played an eight! "
                                        + "What suit would you like the pile"
                                        + " to be?"
                                        + "\nH = \u2661, S = \u2660,"
                                        + "D = \u2662, C = \u2663");
                                        choice = input.nextLine();
                                
                                // tell user they've made an invalid choice
                                // and prompt again, otherwise break loop
                                if (!PlayValidator.validateSuit(choice)){
                                    System.out.println("You've entered"
                                            + " an invalid suit.  Try again,");
                                } else {
                                    setSuit(Suit.getSuitFromLetter(choice));
                                    break;
                                }
                            } // suit prompt loop (played 8)
                        } else {
                            setSuit(generatedCard.getSuit());
                        }
                        break;
                    }
                } else {         
                    // if it reaches here, the user has an invalid input or play
                    System.out.println("\n\nOops! The card you mentioned"
                            + " isn't in your hand or a valid play."
                            + "\nThe rank or suit must match the pile,"
                            + " or must be an eight.");
                }
                
                // special case where one player decides
                // to draw out the entire deck, force turn to incremenet
                if (getDeck().size() == 0 && getPile().size() == 1) break;
            } // card input loop
            
            // ends the game when winner is found
            if (declareWinner(players.get(turn))) break;
            
            // go to the next player
            turn++;
            if (turn == players.size()) turn = 0;
        }
    }
    
    public boolean declareWinner(Player player){
        if (player.getHand().size() == 0){
            System.out.println("Congratulations, " + player.getPlayerID() 
            + " has won the game!");
            return true;
        }
        return false;
    }
   
    // setup to get the players and their IDs
    private void getNumPlayers(){
        System.out.println("How many players are in this game?\n"
                + "Enter a number between 2 and 7.");
        String n = input.nextLine();
        while (!n.trim().matches("[2-7]")){
            System.out.println("Invalid input! Try again.\n"
                    + "How many players are in this game?\n"
                    + "Choose a number between 2 and 7.");
            n = input.nextLine();
        }
        
        numPlayers = Integer.parseInt(n);
    }
    
    // generate 52 card deck for 2-4 players
    // generate 104 card deck for 5-7 players
    public void generateDeck(){
        int numOfDecks = (numPlayers < 5) ? 1 : 2;
        setDeck(new GroupOfCards());
        
        // generates cards to add in deck
        for (Rank r : Rank.values()){
            for (Suit s : Suit.values()){
                // will add in duplicates of the card if necessary
                for (int i = 0; i < numOfDecks; i++)
                    getDeck().getCards().add(new Card(r, s));
            }
        }
    }
    
    // Generates the instructions prior to grabbing the player's input
    public void playCard(Player currentPlayer){
        System.out.println(
                    "\nPlay a card using the rank followed by the suit "
                    + "(eg 2H for 2\u2661)."
                    + "\nIf you cannot make a valid play or wish to draw a card"
                    + ", type draw."
                    + "\nH = \u2661, S = \u2660, D = \u2662, C = \u2663"
                    + "\n" + getRankSuitOfPile()
                    + "\nYour hand is:\n"
                    + currentPlayer.getHand().getCards()
                    + "\nWhat card would you like to play?");
    }
    
    // gives back the string regarding the suit and rank
    // relative to the current state of the game
    public String getRankSuitOfPile(){
        return  "The current suit of the pile is: "
                    + getSuit().getName() + " - " + getSuit().getSymbol()
                +  "\nThe current rank of the pile is: " +
                                getTopCardPile().getRank().getName()
                + " - " + getTopCardPile().getRank().getShortName();
    }
    
    public Card getTopCardPile(){
        return getPile().getCards().get(getPile().getCards().size()-1);
    }
}//end class
