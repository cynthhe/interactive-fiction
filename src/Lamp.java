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
