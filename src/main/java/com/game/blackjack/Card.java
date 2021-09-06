package com.game.blackjack;

import com.game.core.stdlib.Draw;

/******************************************************************************
 *  Compilation:  javac Card.java
 *  Execution:    java -classpath .:cards.jar Card
 *  Dependencies: Draw.java
 *
 *  Implement a playing card in a standard 52 card deck.

 *  Assumes cards.jar is in the current directory and contains
 *  images of the cards named: 2c.gif, 2d, 2h, 2s, ..., as.gif.
 *
 ******************************************************************************/

public class Card {
    private int suit;
    private int rank;
    private String front;
    private String back;
    private boolean isConcealed;

    // create a new card based on integer 0 = 2C, 1 = 3C, ..., 51 = AS
    Card(int card, String front, String back) {
        this.rank   = card % 13;
        this.suit   = card / 13;
        this.front  = front;
        this.back   = back;
        isConcealed = false;
    }

    public boolean isAce() { return rank == 12; }

    // 1 for ace, 10 for jqk, actual rank for other cards
    public int rank()  {
        if (rank == 12) return  1;
        if (rank >=  8) return 10;
        return rank + 2;
    }

    public void draw(Draw d, double x, double y)  {
        if (isConcealed) d.picture(x, y, back);
        else             d.picture(x, y, front);
    }


    public void conceal() { isConcealed = true;  }
    public void reveal()  { isConcealed = false; }

    // represent cards like "2H", "9C", "JS", "AD"
    public String toString() {
        String ranks = "23456789TJQKA";
        String suits = "CDHS";
        return ranks.charAt(rank) + "" + suits.charAt(suit);
    }


}

