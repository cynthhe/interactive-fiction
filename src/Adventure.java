/*
 * Adventure.java
 * Author: Cynthia He, Laurenz Holcik, Evan Howell
 * Submission Date: November 08, 2018
 *
 * Purpose: This is the main method of the program. Player and map objects are created, and
 * user command methods are located in this file.
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

import java.util.*;

public class Adventure {

    public static void main(String[] args) {

        // create player and map objects
        Player user = new Player();
        Map theMap = new Map();

        // game startup
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to UGA Adventures: Episode I\n"
                + "The adventure of the Cave of Redundancy Adventure\n"
                + "By: Cynthia He, Evan Howell, and Laurenz Holcik");
        Room theRoom = theMap.getRoom(user.getX(), user.getY()); // get user's map location
        System.out.println(theRoom.getDescription()); // print room description

        // game loop
        while(true) {

            String input = keyboard.nextLine();

            // takes player commands
            if(input.equalsIgnoreCase("get lamp")) { // get lamp command
                // if lamp is present
                if(theRoom.getLamp() != null) {
                    user.setLamp(theRoom.getLamp());
                    theRoom.clearLamp();
                    System.out.println("OK");
                }
                // if lamp is not present
                else {
                    System.out.println("No lamp present");
                }
            }

            else if(input.equalsIgnoreCase("light lamp")) { // light lamp command
                // if player has a lamp to light
                if(user.getLamp() != null) {
                    user.getLamp().on();
                    System.out.println("OK");
                }
                // if player doesn't have a lamp to light
                else {
                    System.out.println("You don't have the lamp to light");
                }
            }
            // direction commands
            else if(input.equalsIgnoreCase("north") ||
                    input.equalsIgnoreCase("south")||
                    input.equalsIgnoreCase("east") ||
                    input.equalsIgnoreCase("west")) {

                if(theRoom.isDark() && user.getLamp() == null) {
                    System.out.println("You have stumbled into a passing grue, and have been eaten");
                    System.exit(0);
                }
                else if(theRoom.isDark() && !user.getLamp().isLit()) {
                    System.out.println("You have stumbled into a passing grue, and have been eaten");
                    System.exit(0);
                }
                else {
                    if(input.equalsIgnoreCase("north")) { // player inputs north
                        if(theRoom.canGoNorth()) {
                            user.setX(user.getX()-1);
                            theRoom = theMap.getRoom(user.getX(), user.getY());
                            System.out.println(theRoom.getDescription());
                        }
                        else System.out.println("Can't go that way"); // north not available
                    }
                    else if(input.equalsIgnoreCase("south")) { // player inputs south
                        if(theRoom.canGoSouth()) {
                            user.setX(user.getX()+1);
                            theRoom = theMap.getRoom(user.getX(), user.getY());
                            System.out.println(theRoom.getDescription());
                        }
                        else System.out.println("Can't go that way"); // south not available
                    }
                    else if(input.equalsIgnoreCase("east")) { // player inputs east
                        if(theRoom.canGoEast()) {
                            user.setY(user.getY()+1);
                            theRoom = theMap.getRoom(user.getX(), user.getY());
                            System.out.println(theRoom.getDescription());
                        }
                        else System.out.println("Can't go that way"); // east not available
                    }
                    else if(input.equalsIgnoreCase("west")) { // player inputs west
                        if(theRoom.canGoWest()) {
                            user.setY(user.getY()-1);
                            theRoom = theMap.getRoom(user.getX(), user.getY());
                            System.out.println(theRoom.getDescription());
                        }
                        else System.out.println("Can't go that way"); // west not available
                    }
                }
            }

            else if(input.equalsIgnoreCase("look")) { // look command

                if(theRoom.isDark() && user.getLamp() == null) {
                    System.out.println("It's pitch black, you can't see anything. You may be eaten by a grue!");
                }
                else if (theRoom.isDark() && !user.getLamp().isLit()) {
                    System.out.println("It's pitch black, you can't see anything. You may be eaten by a grue!");
                }
                else {
                    System.out.println(theRoom.getDescription());
                    if(theRoom.getLamp() != null) {
                        System.out.println("There is an old oil lamp here that was made long ago");
                    }
                    if(theRoom.getKey() != null) {
                        System.out.println("You see the outline of a key on a dusty shelf that's covered in dust");
                    }
                    if(theRoom.getChest() != null) {
                        System.out.println("There is an old wooden, massive, oaken chest here with the word \"CHEST\" carved into it");
                    }
                    System.out.print("Exits are: ");
                    if(theRoom.canGoEast()) System.out.println("east");
                    if(theRoom.canGoWest()) System.out.println("west");
                    if(theRoom.canGoSouth()) System.out.println("south");
                    if(theRoom.canGoNorth()) System.out.println("north");
                }
            }

            else if(input.equalsIgnoreCase("get key")) { // get key command
                // if there's a key present
                if(theRoom.getKey() != null) {
                    user.setKey(theRoom.getKey());
                    theRoom.clearKey();
                    System.out.println("OK");
                }
                // if there's no key present
                else {
                    System.out.println("No key present");
                }
            }

            else if(input.equalsIgnoreCase("open chest")) { // open chest command
                // if no chest is present
                if(theRoom.getChest() == null) {

                    System.out.println("No chest present");
                }
                // if chest is locked
                else if(theRoom.getChest().isLocked()) {
                    System.out.println("The chest is locked");
                }
                // if there's a chest -- get contents in chest
                else {
                    System.out.print(theRoom.getChest().getContents());
                    System.exit(0);
                }
            }

            else if(input.equalsIgnoreCase("unlock chest")) { // unlock chest command
                // able to unlock chest with key
                if(user.getKey() != null && theRoom.getChest() != null) {
                    user.getKey().use(theRoom.getChest());
                    System.out.println("OK");
                }
                // no key but have a chest
                else if(theRoom.getChest() != null && user.getKey() == null) {
                    System.out.println("Need a key to do any unlocking!");
                }
                // no chest present
                else if(theRoom.getChest() == null) {

                    System.out.println("No chest to unlock");
                }
            }
            // invalid input
            else {
                System.out.println("I'm sorry I don't know how to do that.");
            }
        }
    }

}