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
public class GroupOfCardsTest {
    
    public GroupOfCardsTest() {
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
    public void testSetNoCards() {
        System.out.println("setNoCards");
        GroupOfCards instance = new GroupOfCards();
        assertEquals(instance.size(), 0);
    }

    @Test
    public void testSetManyCards() {
        System.out.println("setManyCards");
        ArrayList<Card> cards = new ArrayList<>();
        GroupOfCards instance = new GroupOfCards();
        cards.add(new Card("a", "c"));
        cards.add(new Card("j", "c"));
        cards.add(new Card("5", "d"));
        instance.setCards(cards);
        assertEquals(instance.size(), 3);
    }
    
    @Test
    public void testSetOneCards() {
        System.out.println("setOneCard");
        ArrayList<Card> cards = new ArrayList<>();
        GroupOfCards instance = new GroupOfCards();
        cards.add(new Card("a", "c"));
        instance.setCards(cards);
        assertEquals(instance.size(), 1);
    }   
    
    @Test
    public void testAddCardEmptyList(){
        System.out.println("addCardEmptyList");
        GroupOfCards instance = new GroupOfCards();
        Card card = new Card("a", "c");
        instance.addCard(card);
        assertEquals(instance.getCards().get(0), card);
    }
    
    @Test
    public void testAddCardPopulatedList(){
        System.out.println("addCardPopulatedList");
        GroupOfCards instance = new GroupOfCards();
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new Card(Rank.EIGHT, Suit.CLUBS));
        cardList.add(new Card("7", "H"));
        Card card = new Card("a", "c");
        instance.setCards(cardList);
        instance.addCard(card);
        assertEquals(instance.getCards().get(2), card);
    }
    
    @Test
    public void testAddPileBothEmptyList(){
        System.out.println("addPileBothEmptyList");
        GroupOfCards instance = new GroupOfCards();
        GroupOfCards instance2 = new GroupOfCards();
        instance.addPile(instance2);
        assertEquals(instance.size(), 0);
    }
    
    @Test
    public void testAddPileToEmptyList(){
        System.out.println("addPileToEmptyList");
        GroupOfCards instance = new GroupOfCards();
        GroupOfCards instance2 = new GroupOfCards();
        instance2.addCard(new Card("A", "C"));
        instance2.addCard(new Card("J", "H"));
        instance.addPile(instance2);
        assertEquals(instance.size(), 2);
    }
    
    @Test
    public void testAddPileToList(){
        System.out.println("addPileToList");
        GroupOfCards instance = new GroupOfCards();
        GroupOfCards instance2 = new GroupOfCards();
        instance.addCard(new Card("7", "D"));
        instance.addCard(new Card("K", "S"));
        instance2.addCard(new Card("A", "C"));
        instance2.addCard(new Card("J", "H"));
        instance.addPile(instance2);
        assertEquals(instance.size(), 4);
    }
}
