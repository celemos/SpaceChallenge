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

    ArrayList<Item> cargoList = new ArrayList<Item>();
    int rocketId;
    int currentWeight;
    double rocketCost; // million
    int rocketWeight; // kg
    int maxWeight; // kg
    double chanceOfLaunchExplosion; // * this.cargoCarried / this.cargoLimit;
    double chanceOfLandingCrash; // * this.cargoCarried / this.cargoLimit;
    //where:
    //int cargoCarried = this.currentWeight - this.rocketWeight;
    //int cargoLimit = this.maxWeight - this.rocketWeight;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return (currentWeight + item.weight <= maxWeight);
        //return (this.cargoCarried + item.weight <= this.cargoLimit);
    }

    public void carry(Item item) {
        cargoList.add(item);
        this.currentWeight = this.currentWeight + item.weight;
        //this.cargoCarried = cargoCarried + item.weight;
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
        this.currentWeight = rocketWeight;
        //this.cargoCarried = 0;
    }

}
