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
public class PlayerTest {
    
    public PlayerTest() {
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

    @Test
    public void testGetEmptyPlayerID() {
        System.out.println("getEmptyPlayerID");
        Player instance = new Player("");
        String expResult = "";
        String result = instance.getPlayerID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValidPlayerID() {
        System.out.println("getValidPlayerID");
        Player instance = new Player("Jacob Bob");
        String expResult = "Jacob Bob";
        String result = instance.getPlayerID();
        assertEquals(expResult, result);
    }    
    
    @Test
    public void testSetEmptyPlayerID() {
        System.out.println("setEmptyPlayerID");
        String givenID = "";
        Player instance = new Player("");
        instance.setPlayerID(givenID);
        assertEquals(instance.getPlayerID(), "");
    }

    @Test
    public void testSetValidPlayerID() {
        System.out.println("setEmptyPlayerID");
        String givenID = "Bob";
        Player instance = new Player("BobJoeSchmroe");
        instance.setPlayerID(givenID);
        assertEquals(instance.getPlayerID(), "Bob");
    }
    
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Player instance = new Player("Joe");
        GroupOfCards expResult = new GroupOfCards();
        expResult.addCard(new Card("a", "c"));
        instance.setHand(expResult);
        assertEquals(expResult, instance.getHand());
    }
    
    @Test
    public void testSetHand() {
        System.out.println("setHand");
        GroupOfCards hand = new GroupOfCards();
        Player instance = new Player("Joe");
        hand.addCard(new Card("a", "c"));
        instance.setHand(hand);
        assertEquals(instance.getHand().getCards().get(0), new Card("a", "c"));
    }

    @Test
    public void testSetAndGetGame() {
        System.out.println("getAndSetGame");
        CrazyEights ce = new CrazyEights(new ArrayList<Player>());
        Player p = new Player("something");
        p.setGame(ce);
        assertEquals(ce, p.getGame());
    }

    @Test
    public void testDrawCard() {
        System.out.println("drawCard");
        Player instance = new Player("Something");
        CrazyEights ce = new CrazyEights();
        ce.generateDeck();
        instance.setGame(ce);
        instance.drawCard();
        instance.drawCard();
        instance.drawCard();
        assertEquals(instance.getHand().size(), 3);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player("Joe");
        String expResult = "Joe";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
