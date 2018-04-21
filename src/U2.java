import java.util.ArrayList;

/**
 * Created by Carlos Lemos on 04/05/2018.
 */
public class U2 extends Rocket{
    /*
    Class that extend the Rocket class and override the land and launch methods
    to calculate the corresponding chance of exploding and return
    either true or false based on a random number using the probability equation for each.

    Notes:
    - launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket
    class they will override these methods to return true or false based on the actual probability of each type.

    - carry and canCarry should be implemented in Rocket class and will not need to be overridden in the U1 and U2
    classes (???)

    boolean launch (); // returns either true or false indicating if the launch was successful or if the rocket has crashed
    boolean land ();   // returns either true or false based on the success of the landing

    Specs:
    Rocket cost = $120 Million
    Rocket weight = 18 Tonnes
    Max weight (with cargo) = 29 Tonnes
    Chance of launch explosion = 4% * (cargo carried / cargo limit)
    Chance of landing crash = 8% * (cargo carried / cargo limit)
    */

    // Constructors
    public U2(int rocketId, ArrayList<Item> cargoList, int currentWeight){
        this.rocketId = rocketId;
        this.cargoList = cargoList;
        this.currentWeight = currentWeight;

        rocketCost = 120; // million
        rocketWeight = 18000; // kg
        maxWeight = 29000; // kg
        chanceOfLaunchExplosion  = 0.04; // * this.cargoCarried / this.cargoLimit;
        chanceOfLandingCrash = 0.08; // * this.cargoCarried / this.cargoLimit;
        //where:
        //int cargoCarried = this.currentWeight - this.rocketWeight;
        //int cargoLimit = this.maxWeight - this.rocketWeight;
    }

    @Override
    public boolean launch() {
        int cargoCarried = currentWeight - rocketWeight;
        int cargoLimit = maxWeight - rocketWeight;
        double probabilityTrue = this.chanceOfLaunchExplosion * cargoCarried / cargoLimit;
        //boolean success = Math.random() >= 1.0 - probabilityTrue;
        boolean success = Math.random() >= probabilityTrue;
        if (!success) System.out.println("U2 Rocket exploded at launch: send it again");
        return success;
    }

    @Override
    public boolean land() {
        int cargoCarried = currentWeight - rocketWeight;
        int cargoLimit = maxWeight - rocketWeight;
        double probabilityTrue = this.chanceOfLandingCrash * cargoCarried / cargoLimit;
        //boolean success = Math.random() >= 1.0 - probabilityTrue;
        boolean success = Math.random() >= probabilityTrue;
        if (!success) System.out.println("U2 Rocket crashed at landing: send it again");
        return success;
    }

}
