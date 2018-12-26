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
