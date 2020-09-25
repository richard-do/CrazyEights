/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class CrazyEightsTest {
    
    public CrazyEightsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // special case where it cant be tested apart without breaking
    @Test
    public void testGetAndSetGameName() {
        System.out.println("getAndSetGameName");
        String gameName = "setGameName";
        CrazyEights instance = new CrazyEights();
        instance.setGameName(gameName);
        assertEquals(gameName, instance.getGameName());
    }

    // special cases that will
    // be incorrect if set separately
    @Test
    public void testGetAndSetPlayers() {
        System.out.println("getAndSetPlayers");
        CrazyEights instance = new CrazyEights();
        ArrayList<Player> playerList = new ArrayList<>();
        instance.setPlayers(playerList);
        assertEquals(playerList, instance.getPlayers());
    }

    // special case that can't be done separately
    @Test
    public void testGetAndSetSuit() {
        System.out.println("getAndSetSuit");
        CrazyEights instance = new CrazyEights();
        Suit expResult = Suit.CLUBS;
        instance.setSuit(expResult);
        Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    // special case that can't be done separately
    @Test
    public void testGetAndSetTurn() {
        System.out.println("getAndSetTurn");
        CrazyEights instance = new CrazyEights();
        int expResult = 1;
        instance.setTurn(1);
        int result = instance.getTurn();
        assertEquals(expResult, result);
    }

    // special case that can't be done separately
    @Test
    public void testGetAndSetDeck() {
        System.out.println("getAndSetDeck");
        CrazyEights instance = new CrazyEights();
        GroupOfCards expResult = new GroupOfCards();
        expResult.addCard(new Card("A", "C"));
        instance.setDeck(expResult);
        assertEquals(expResult, instance.getDeck());
    }

    // special case that can't be done separately
    @Test
    public void testGetAndSetPile() {
        System.out.println("getAndSetPile");
        CrazyEights instance = new CrazyEights();
        GroupOfCards expResult = new GroupOfCards();
        expResult.addCard(new Card("A", "C"));
        instance.setPile(expResult);
        assertEquals(expResult, instance.getPile());
    }

    @Test
    public void testShufflePileIntoDeck() {
        System.out.println("shufflePileIntoDeck");
        CrazyEights instance = new CrazyEights();
        GroupOfCards deck = new GroupOfCards();
        GroupOfCards pile = new GroupOfCards();
        deck.addCard(new Card("A", "C"));
        pile.addCard(new Card("A", "S"));
        pile.addCard(new Card("J", "H"));
        instance.setDeck(deck);
        instance.setPile(pile);
        instance.shufflePileIntoDeck();
        assertEquals(instance.getDeck().size(), 2);
    }

    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        Player player = new Player("Joe");
        CrazyEights instance = new CrazyEights();
        boolean expResult = true;
        boolean result = instance.declareWinner(player);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBadDeclareWinner() {
        System.out.println("declareBadWinner");
        Player player = new Player("Joe");
        player.getHand().addCard(new Card("A", "H"));
        CrazyEights instance = new CrazyEights();
        boolean expResult = false;
        boolean result = instance.declareWinner(player);
        assertEquals(expResult, result);
    }
}
