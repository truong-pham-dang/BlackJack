package com.game.blackjack;

import com.game.core.stdlib.Draw;

/******************************************************************************
 *  Compilation:  javac Player.java
 *  Execution:    java -classpath .:cards.jar Player
 *  Dependencies: Card.java Draw.java
 *
 *  Implement a player that holds a pile of cards.
 *
 ******************************************************************************/

public class Player {
    final static int MAX_CARDS = 52;                    // max number of cards in a hand

    private Card[] cards = new Card[MAX_CARDS];         // the cards
    private int N = 0;                                  // number of cards
    private String name;                                // player's name
    private int x, y;                                   // location to draw

    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Card peak()         { return cards[0];   }    // return first card
    public void dealTo(Card c) { cards[N++] = c;    }    // insert card
    public void reset()        { N = 0;             }    // discard all cards

    // compute value of blackjack hand
    public int value() {
        int val = 0;
        boolean hasAce = false;
        for (int i = 0; i < N; i++) {
            val = val + cards[i].rank();
            if (cards[i].isAce()) hasAce = true;
        }
        if (hasAce && (val <= 11)) val = val + 10;          // handle ace = 1 or 11
        return val;
    }

    // draw the pile of cards, with the first one centered at (x, y)
    public void draw(Draw d) {
        for (int i = 0; i < N; i++)
            cards[i].draw(d, x + i*25, y);
    }

    // print out cards in player's hand (for debugging)
    public String toString() {
        String s = name + "  (" + value() + ")  ";
        for (int i = 0; i < N; i++)
            s += cards[i] + " ";
        return s;
    }

}
