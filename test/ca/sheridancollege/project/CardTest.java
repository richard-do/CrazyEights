/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

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
public class CardTest {
    
    public CardTest() {
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
    public void testSetRankString() {
        System.out.println("testSetRankString");
        Card instance = new Card("A", "C");
        Rank expResult = Rank.ACE;
        Rank result = instance.getRank();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSetSuitString() {
        System.out.println("testSetSuitString");
        Card instance = new Card("a", "D");
        Suit expResult = Suit.DIAMONDS;
        Suit result = instance.getSuit();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSetRank() {
        System.out.println("setRank");
        Rank rank = Rank.SIX;
        Card instance = new Card(Rank.SEVEN, Suit.DIAMONDS);
        instance.setRank(rank);
        assertEquals(rank, instance.getRank());
    }
    
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = new Card(Rank.EIGHT, Suit.CLUBS);
        Rank expResult = Rank.EIGHT;
        Rank result = instance.getRank();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetSuit() {
        System.out.println("setSuit");
        Suit suit = Suit.CLUBS;
        Card instance = new Card(Rank.SEVEN, Suit.DIAMONDS);
        instance.setSuit(suit);
        assertEquals(suit, instance.getSuit());
    }
    
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new Card(Rank.EIGHT, Suit.CLUBS);
        Suit expResult = Suit.CLUBS;
        Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringCardRankSuitInputs() {
        System.out.println("testToStringCardRankSuitInputs");
        Card instance = new Card(Rank.FOUR, Suit.HEARTS);
        String expResult = "4\u2661";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringCardStringInputs() {
        System.out.println("testToStringCardStringInputs");
        Card instance = new Card(Rank.ACE, Suit.CLUBS);
        String expResult = "A\u2663";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Card("A", "C");
        Card instance = new Card(Rank.ACE, Suit.CLUBS);
        boolean expResult = true;
        boolean result = instance.equals(o);
    }
    
    @Test
    public void testNotEqualsRank(){
        System.out.println("notEqualsRank");
        Object o = new Card("A", "C");
        Card instance = new Card(Rank.SEVEN, Suit.CLUBS);
        boolean expResult = false;
        boolean result = instance.equals(o);
    }
    
    @Test
    public void testNotEqualsSuit(){
        System.out.println("notEqualsSuit");
        Object o = new Card("A", "D");
        Card instance = new Card(Rank.ACE, Suit.CLUBS);
        boolean expResult = false;
        boolean result = instance.equals(o);
    }
}
