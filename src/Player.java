/*
 * Player.java
 * Author: Cynthia He, Laurenz Holcik, Evan Howell
 * Submission Date: November 08, 2018
 *
 * Purpose: This program implements the Player class which includes instance variables and
 * methods related to the player object.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.
 */

public class Player {

    // instance variables
    private int xCoor;
    private int yCoor;
    private Lamp theLamp;
    private Key theKey;

    // constructor to default values
    public Player() {
        xCoor = 0;
        yCoor = 0;
        theLamp = null;
        theKey = null;
    }

    public void setLamp(Lamp theLamp) { // set lamp

        this.theLamp = theLamp;
    }

    public void setKey(Key theKey) { // set key

        this.theKey = theKey;
    }

    public void setX(int x) { // set x coordinate

        xCoor = x;
    }

    public void setY(int y) { // set y coordinate

        yCoor = y;
    }

    public Lamp getLamp() { // get lamp

        return theLamp;
    }

    public Key getKey() { // get key

        return theKey;
    }

    public int getX() { // get x coordinate

        return xCoor;
    }

    public int getY() { // get y coordinate

        return yCoor;
    }



}