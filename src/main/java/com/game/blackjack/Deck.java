package com.game.blackjack;

import com.game.core.stdlib.StdOut;

/******************************************************************************
 *  Compilation:  javac Deck.java Card.java
 *  Execution:    java -classpath .:cards.jar Player
 *
 *  Implement a deck of cards.
 *
 ******************************************************************************/

public class Deck {
    final static int DECK_SIZE = 52;

    private Card[] cards;         // the cards  - cards[0] is bottom of deck
    private int N;                // number of cards

    public Deck()  {
        N = DECK_SIZE;
        cards = new Card[N];
        for (int i = 0; i < N; i++)
            cards[N - i - 1] = new Card(i, i + ".gif", "back.gif");
    }

    public Card dealFrom()   { return cards[--N]; }
    public boolean isEmpty() { return (N == 0);   }
    public int size()        { return N;          }


    // shuffles cards
    public void shuffle() {
        for (int i = 0; i < N; i++) {
            int r = (int) (Math.random() * i);
            Card swap = cards[i];
            cards[i]  = cards[r];
            cards[r]  = swap;
        }
    }



    public String toString() {
        String s = "Deck  ";
        for (int i = N - 1; i >= 0; i--)
            s += cards[i] + " ";
        return s;
    }


    // test client
    public static void main(String[] args) {
        Deck deck = new Deck();
        StdOut.println(deck);
        deck.shuffle();
        StdOut.println(deck);
    }

}

