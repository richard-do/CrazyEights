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
public class PlayValidatorTest {
    
    public PlayValidatorTest() {
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
    public void testValidateSuitLowercase() {
        System.out.println("validateSuitLowercase");
        String suit = "d";
        boolean expResult = true;
        boolean result = PlayValidator.validateSuit(suit);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateSuitUppercase() {
        System.out.println("validateSuitUppercase");
        String suit = "C";
        boolean expResult = true;
        boolean result = PlayValidator.validateSuit(suit);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBadValidateSuit() {
        System.out.println("validateBadSuit");
        String suit = "x";
        boolean expResult = false;
        boolean result = PlayValidator.validateSuit(suit);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateCardLowercase() {
        System.out.println("validateCardLowercase");
        String card = "10c";
        boolean expResult = true;
        boolean result = PlayValidator.validateCard(card);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidateCardUppercase() {
        System.out.println("validateCardUppercase");
        String card = "AH";
        boolean expResult = true;
        boolean result = PlayValidator.validateCard(card);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidate10Card(){
        System.out.println("validate10Card");
        String card = "10H";
        boolean expResult = true;
        boolean result = PlayValidator.validateCard(card);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInHand() {
        System.out.println("inHand");
        GroupOfCards hand = new GroupOfCards();
        hand.addCard(new Card("a", "c"));
        hand.addCard(new Card(Rank.EIGHT, Suit.HEARTS));
        Card card = new Card("8", "h");
        boolean expResult = true;
        boolean result = PlayValidator.inHand(hand, card);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotInHand() {
        System.out.println("notInHand");
        GroupOfCards hand = new GroupOfCards();
        hand.addCard(new Card("a", "c"));
        hand.addCard(new Card(Rank.EIGHT, Suit.HEARTS));
        Card card = new Card("7", "h");
        boolean expResult = false;
        boolean result = PlayValidator.inHand(hand, card);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidatePlaySameCard() {
        System.out.println("validatePlaySameCard");
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card playCard = new Card(Rank.ACE, Suit.DIAMONDS);
        boolean expResult = true;
        boolean result = PlayValidator.validatePlay(rank, suit, playCard);
    }
    
    @Test
    public void testValidatePlaySameSuit() {
        System.out.println("validatePlaySameSuit");
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card playCard = new Card(Rank.JACK, Suit.DIAMONDS);
        boolean expResult = true;
        boolean result = PlayValidator.validatePlay(rank, suit, playCard);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidatePlaySameRank() {
        System.out.println("validatePlaySameRank");
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card playCard = new Card(Rank.ACE, Suit.CLUBS);
        boolean expResult = true;
        boolean result = PlayValidator.validatePlay(rank, suit, playCard);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidatePlay8Card() {
        System.out.println("validatePlay8Card");
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card playCard = new Card(Rank.EIGHT, Suit.CLUBS);
        boolean expResult = true;
        boolean result = PlayValidator.validatePlay(rank, suit, playCard);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidateBadPlay() {
        System.out.println("validateBadPlay");
        Rank rank = Rank.ACE;
        Suit suit = Suit.DIAMONDS;
        Card playCard = new Card(Rank.JACK, Suit.CLUBS);
        boolean expResult = false;
        boolean result = PlayValidator.validatePlay(rank, suit, playCard);
    }
}
