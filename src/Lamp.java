/*
 * Lamp.java
 * Author: Cynthia He, Laurenz Holcik, Evan Howell
 * Submission Date: November 08, 2018
 *
 * Purpose: This program stores information on whether the lamp is lit or not.
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

public class Lamp {

    // instance variables
    private boolean lit;

    public Lamp() {
        lit = false;
    }

    public void on() { // set lamp status -- true

        lit = true;
    }

    public void off() { // set lamp status -- false

        lit = false;
    }

    public boolean isLit() { // return lamp status

        return lit;
    }


}