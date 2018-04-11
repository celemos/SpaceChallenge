import java.util.ArrayList;

/**
 * Created by Carlos Lemos on 04/05/2018.
 */
public class Rocket implements SpaceShip {


    /* PART 1: The design (continue from SpaceShip interface)
    3. Create a class Rocket that implements the SpaceShip Interface and hence implements all the methods above.

    - launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket
    class they will override these methods to return true or false based on the actual probability of each type.

    - carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes

    Notes:
    boolean launch ();   // returns either true or false indicating if the launch was successful or if the rocket has crashed
    boolean land ();   // returns either true or false based on the success of the landing
    boolean canCarry (Item item);  // returns true if the rocket can carry such item or false if it will exceed the weight limit
    void carry (Item item);   // updates the current weight of the rocket
    */

    private ArrayList<Item> cargoList = new ArrayList<Item>();

    private static int currentWeight;

    private int maxWeight;
    private double rocketCost;
    private int rocketId;
    private int rocketWeight;
    //private int cargoCarried;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    /*
    @Override
    public boolean canCarry(Item item) {
        return (currentWeight + item.weight <= maxWeight);
        //return (this.cargoCarried + item.weight <= this.cargoLimit);
    }

    @Override
    public void carry(Item item) {
        cargoList.add(item);
        currentWeight = currentWeight + item.weight;
        //this.cargoCarried = cargoCarried + item.weight;
    }
    */

    /*UNSOLVED ISSUE/BUG 2:
    I also did not get running the carry and canCarry methods in the Rocket class.
    To get them running, they must be implemented in the U1 and U2 classes (otherwise, they do not run correctly).
    I thought the solution for the second issue was related with the correct use of “static” keyword.
    But, after some trials with “static”, the issue continues to force me to place the carry and canCarry methods
    in the U1 and U2 classes to get them running.
    */

    @Override
    public boolean canCarry(Item item) {
        return true;
    }

    @Override
    public void carry(Item item) {
    }

    public ArrayList<Item> getCargoList() {
        return this.cargoList;
    }

    public int getCurrentWeight() {
        return this.currentWeight;
    }

    public double getRocketCost() {
        return this.rocketCost;
    }

    public void initializeRocket(int rocketId) {
        this.rocketId = rocketId;
        this.cargoList = new ArrayList<Item>();
        currentWeight = rocketWeight;
        //this.cargoCarried = 0;
    }


}
