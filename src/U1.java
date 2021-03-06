import java.util.ArrayList;

/**
 * Created by Carlos Lemos on 04/05/2018.
 */
public class U1 extends Rocket{
    /*
    Class that extends the Rocket class and override the land and launch methods
    to calculate the corresponding chance of exploding and return either true or false
    based on a random number using the probability equation for each.

    Notes:
    - launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket
    class they will override these methods to return true or false based on the actual probability of each type.

    - carry and canCarry should be implemented in Rocket class and will not need to be overridden in the U1 and U2
    classes (DOES NOT WORK... WHY???)

    boolean launch (); // returns either true or false indicating if the launch was successful or if the rocket has crashed
    boolean land ();   // returns either true or false based on the success of the landing

    Specs:
    Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
    */

    // Constructors
    public U1(int rocketId, ArrayList<Item> cargoList, int currentWeight){
        this.rocketId = rocketId;
        this.cargoList = cargoList;
        this.currentWeight = currentWeight;

        rocketCost = 100; // million
        rocketWeight = 10000; // kg
        maxWeight = 18000; // kg
        chanceOfLaunchExplosion  = 0.05; // * this.cargoCarried / this.cargoLimit;
        chanceOfLandingCrash = 0.01; // * this.cargoCarried / this.cargoLimit;
        //where:
        //int cargoCarried = this.currentWeight - this.rocketWeight;
        //int cargoLimit = this.maxWeight - this.rocketWeight;
    }

    @Override
    public boolean launch() {
        int cargoCarried = currentWeight - this.rocketWeight;
        int cargoLimit = this.maxWeight - this.rocketWeight;
        double probabilityTrue = this.chanceOfLaunchExplosion * cargoCarried / cargoLimit;
        //boolean success = Math.random() >= 1.0 - probabilityTrue;
        boolean success = Math.random() >= probabilityTrue;
        if (!success) System.out.println("U1 Rocket exploded at launch: send it again");
        return success;
    }

    @Override
    public boolean land() {
        int cargoCarried = currentWeight - this.rocketWeight;
        int cargoLimit = this.maxWeight - this.rocketWeight;
        double probabilityTrue = this.chanceOfLandingCrash * cargoCarried / cargoLimit;
        //boolean success = Math.random() >= 1.0 - probabilityTrue;
        boolean success = Math.random() >= probabilityTrue;
        if (!success) System.out.println("U1 Rocket crashed at landing: send it again");
        return success;
    }

}
