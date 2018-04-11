import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NoSuchMethodException;

/**
 * Created by Carlos Lemos on 04/05/2018.
 */
public class Simulation {

    /* PART 2: The simulation
    Create a Simulation class that is responsible for reading item data and filling up the rockets.
    The Simulation class should include these methods:

    loadItems: this method loads all items from a text file and returns an ArrayList of Items:
    Each line in the text file consists of the item name followed by = then its weight in kg.
    For example:
        habitat=100000
        colony=50000
        food=50000
    loadItems should read the text file line by line and create an Item object for each
    and then add it to an ArrayList of Items. The method should then return that ArrayList.

    loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
    and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets
    that are fully loaded.

    loadU2: this method also takes the ArrayList of Items and starts creating U2 rockets
    and filling them with those items the same way as with U1 until all items are loaded.
    The method then returns the ArrayList of those U2 rockets that are fully loaded.

    runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods
    for each of the rockets in the ArrayList.
    Every time a rocket explodes or crashes (i.e if launch or land return false)
    it will have to send that rocket again. All while keeping track of the total budget
    required to send each rocket safely to Mars. runSimulation then returns the total budget required
    to send all rockets (including the crashed ones).

    public static void main(String [] args) throws FileNotFoundException {

        // create a simulation object
        Simulation simulation = new Simulation();

        // create a million format converted to string
        DecimalFormat formatter = new DecimalFormat("#,###");
        //DecimalFormat formatter = new DecimalFormat("#,###.00");

        // create counters
        int i;
        int j;

        // load all the items of the phase 1
        File phase1 = new File("phase-1.txt");
        ArrayList<Item> itemListP1;
        itemListP1 = simulation.loadItems(phase1);

        // print out all the items of the phase 1
        i = 1;
        System.out.println( "Let's show all the items of phase 1: " );
        for ( Item item : itemListP1 ) {
            System.out.println(  "Item " + i + ": " + item.name + ", " + String.valueOf(item.weight) + " kg" );
            i++;
        }

        // load all the items of the phase 2
        File phase2 = new File("phase-2.txt");
        ArrayList<Item> itemListP2;
        itemListP2 = simulation.loadItems(phase2);

        // print out all the items of the phase 2
        i = 1;
        System.out.println( "Let's show all the items of phase 2: " );
        for ( Item item : itemListP2 ) {
            System.out.println(  "Item " + i + ": " + item.name + ", " + String.valueOf(item.weight) + " kg" );
            i++;
        }
        // ===========================

        //create fleet of U1 rockets that carries all the items of phase 1;
        ArrayList<Rocket> rocketListU1P1 = new ArrayList();
        rocketListU1P1 = simulation.loadU1 (itemListP1);
        ArrayList<Item> cargoListU1P1 = new ArrayList();

        //create fleet of U1 rockets that carries all the items of phase 2;
        ArrayList<Rocket> rocketListU1P2 = new ArrayList();
        rocketListU1P2 = simulation.loadU1 (itemListP2);
        ArrayList<Item> cargoListU1P2 = new ArrayList();

        // print out items list of U1 rockets fleet
        System.out.println( "=======================================" );
        System.out.println( "Let's show the U1 rocket's cargo list: " );

        ArrayList<Item> cargoList = new ArrayList();
        i=1;
        j=1;
        for ( Rocket rocket : rocketListU1P1 ) {
            System.out.println( "Rocket " + j + ": " + rocket);
            cargoList = rocket.getCargoList();
            for ( Item item : cargoList ){
                System.out.println(
                        "Item " + i + ": " + item.name + ", weight: " + String.valueOf(item.weight) + " kg"
                        //+ ", current weight = " + String.valueOf(rocket.currentWeight)
                        //+ ", max weight = " + String.valueOf(rocket.maxWeight)
                );
                i++;
            }
            j++;
        }

        //create fleet of U2 rockets that carry all the items of phase 1;
        ArrayList<Rocket> rocketListU2P1 = new ArrayList<>();
        rocketListU2P1 = simulation.loadU2 (itemListP1);
        ArrayList<Item> cargoListU2P1 = new ArrayList();

        //create fleet of U2 rockets that carry all the items of phase 2;
        ArrayList<Rocket> rocketListU2P2 = new ArrayList<>();
        rocketListU2P2 = simulation.loadU2 (itemListP2);
        ArrayList<Item> cargoListU2P2 = new ArrayList();

        // print out items list of U2 rockets fleet
        System.out.println( "=======================================" );
        System.out.println( "Let's show the U2 rocket's cargo list: " );

        i=1;
        j=1;
        for ( Rocket rocket : rocketListU2P1 ) {
            System.out.println( "Rocket " + j + ": " + rocket);
            cargoList = rocket.getCargoList();
            for ( Item item : cargoList ){
                System.out.println(
                        "Item " + i + ": " + item.name + ", weight: " + String.valueOf(item.weight) + " kg"
                        //+ ", current weight = " + String.valueOf(rocket.currentWeight)
                        //+ ", max weight = " + String.valueOf(rocket.maxWeight)
                );
                i++;
            }
            j++;
        }


        System.out.println( "========= U1 ROCKETS - PHASE 1 =========" );
        double totalCostU1P1 = simulation.runSimulation(rocketListU1P1);

        System.out.println( "========= U2 ROCKETS - PHASE 1 =========" );
        double totalCostU2P1 = simulation.runSimulation(rocketListU2P1);

        System.out.println( "========= U1 ROCKETS - PHASE 2 =========" );
        double totalCostU1P2 = simulation.runSimulation(rocketListU1P2);

        System.out.println( "========= U2 ROCKETS - PHASE 2 =========" );
        double totalCostU2P2 = simulation.runSimulation(rocketListU2P2);

        String totalU1 = formatter.format(totalCostU1P1 + totalCostU1P2);
        System.out.println( "Total budget using the U1 rocket's fleet: US$ " + totalU1 + " million");

        String totalU2 = formatter.format(totalCostU2P1 + totalCostU2P2);
        System.out.println( "Total budget using the U2 rocket's fleet: US$ " + totalU2 + " million");

    }
    */

    public static double runSimulation(ArrayList<Rocket> rocketList) {
        /*
        runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods
        for each of the rockets in the ArrayList.
        Every time a rocket explodes or crashes (i.e if launch or land return false)
        it will have to send that rocket again. All while keeping track of the total budget
        required to send each rocket safely to Mars. runSimulation then returns the total budget required
        to send all rockets (including the crashed ones).
        */

        System.out.println( "=========== Begin Simulation ===========" );
        //DecimalFormat formatter = new DecimalFormat("#,###.00");
        DecimalFormat formatter = new DecimalFormat("#,###");
        double totalBudget = 0;
        boolean rocketLaunchOk;
        boolean rocketLandOk;
        int x=1;
        int y=0;
        int z=0;
        for (Rocket rocket : rocketList) {
            double rocketCost = rocket.getRocketCost();
            System.out.println("Rocket "+ x +" is being sent: each attempt costs US$ "+ formatter.format(rocketCost) +" million");

            rocketLaunchOk = rocket.launch();
            rocketLandOk = rocket.land();
            while (!rocketLaunchOk || !rocketLandOk) {
                totalBudget = totalBudget + rocketCost;
                if(!(rocketLaunchOk)) y++;
                if(!(rocketLandOk)) z++;
                rocketLaunchOk = rocket.launch();
                rocketLandOk = rocket.land();
            }

            //while (!rocket.launch() || !rocket.land()) totalBudget = totalBudget + rocketCost;
            totalBudget = totalBudget + rocket.getRocketCost();
            System.out.println("Rocket launch and landing were both successful");
            x++;
        }
        System.out.println( "============== STATISTICS ==============" );
        System.out.println("Accumulated budget of all rockets: US$ " + formatter.format(totalBudget) +" million");
        System.out.println("Accumulated number of successful rockets: " + String.valueOf(x-1));
        System.out.println("Accumulated number of launch explosions: " + String.valueOf(y));
        System.out.println("Accumulated number of landing crashes: " + String.valueOf(z));
        System.out.println( "============ End Simulation ============" );
        return totalBudget;
    }

    public static ArrayList loadU1(ArrayList<Item> itemList) {

        /* It creates U1 rockets. It first tries to fill up 1 rocket with as many items as possible
        before creating a new rocket object and filling that one until all items are loaded.
        The method then returns the ArrayList of those U1 rockets that are fully loaded.
        */
        int i; // number of items
        int j; // number of rockets
        //int currentWeight;
        //int cargoCarried = 0; // initialize cargoCarried in kg
        ArrayList<U1> rocketListU1 = new ArrayList<U1>();
        ArrayList<Item> cargoList = new ArrayList<Item>();
        U1 rocket;
        int currentWeight = 0;

        System.out.println( "============ begin loadU1 ==========" );
        i = 1;
        j = 1;
        rocket = new U1(j, cargoList, currentWeight);
        rocket.initializeRocket(j);
        System.out.println( "Loading the U1 rocket " + j + ": " + rocket);

        for (Item item : itemList) {
            // loading an U1 rocket with items
            if (rocket.canCarry(item)) {
                rocket.carry(item);
                System.out.println( "U1 Rocket " + j + ": loading item " + i + ": " + item.name +
                        ", " + String.valueOf(item.weight) + " kg" );
                i++;
            }
            else {
                // as no more space for the last item, add the rocket to the rocket list
                rocketListU1.add(rocket);
                currentWeight = rocket.getCurrentWeight();
                System.out.println( "U1 Rocket " + j + " added to the U1 rocket list: " + currentWeight + " kg" );
                // create a new rocket
                j++;
                rocket = new U1(j, cargoList, currentWeight);
                rocket.initializeRocket(j);
                System.out.println( "Loading the U1 rocket " + j + ": " + rocket);
                // load the new rocket with the last item that was left behind
                rocket.carry(item);
                System.out.println( "U1 Rocket " + j + ": loading item " + i + ": " + item.name +
                        ", " + String.valueOf(item.weight) + " kg" );
                i++;
            }
        }
        // add the last rocket to the rocket list (as the last add method was not performed)
        rocketListU1.add(rocket);
        currentWeight = rocket.getCurrentWeight();
        System.out.println( "U1 Rocket " + j + " added to the U1 rocket list: " + currentWeight + " kg" );

        // if no more items to carry, return with the list of rockets
        System.out.println( "============ end of loadU1 ============" );
        return rocketListU1;
    }

    public static ArrayList loadU2(ArrayList<Item> itemList) {

        /* It creates U2 rockets. It first tries to fill up 1 rocket with as many items as possible
        before creating a new rocket object and filling that one until all items are loaded.
        The method then returns the ArrayList of those U2 rockets that are fully loaded.
        */
        int i; // number of items
        int j; // number of rockets
        //int cargoCarried = 0; // initialize cargoCarried in kg
        ArrayList<U2> rocketListU2 = new ArrayList<U2>();
        ArrayList<Item> cargoList = new ArrayList<Item>();
        U2 rocket;
        //int currentWeight = 0;

        System.out.println( "============ begin loadU2 ==========" );
        i = 1;
        j = 1;
        rocket = new U2(j, cargoList);
        rocket.initializeRocket(j);
        System.out.println( "Loading the U2 rocket " + j + ": " + rocket);

        for (Item item : itemList) {
            // loading an U2 rocket with items
            if (rocket.canCarry(item)) {
                rocket.carry(item);
                System.out.println( "U2 Rocket " + j + ": loading item " + i + ": " + item.name +
                        ", " + String.valueOf(item.weight) + " kg" );
                i++;
            }
            else {
                // as no more space for the last item, add the rocket to the rocket list
                rocketListU2.add(rocket);
                System.out.println( "U2 Rocket " + j + " added to the U2 rocket list: " + rocket );
                // create a new rocket
                j++;
                rocket = new U2(j, cargoList);
                rocket.initializeRocket(j);
                System.out.println( "Loading the U2 rocket " + j + ": " + rocket);
                // load the new rocket with the last item that was left behind
                rocket.carry(item);
                System.out.println( "U2 Rocket " + j + ": loading item " + i + ": " + item.name +
                        ", " + String.valueOf(item.weight) + " kg" );
                i++;
            }
        }
        // add the last rocket to the rocket list (as the last add method was not performed)
        rocketListU2.add(rocket);
        System.out.println( "U2 Rocket " + j + " added to the U2 rocket list: " + rocket );

        // if no more items to carry, return with the list of rockets
        System.out.println( "============ end of loadU2 ============" );
        return rocketListU2;
    }

    public static ArrayList loadItems(File file) throws FileNotFoundException {

        ArrayList<Item> itemsList = new ArrayList<Item>();
        int i = 1;
        Scanner s = new Scanner(file);
        System.out.println( "=========== begin loadItems ========" );
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] items = line.split("=");

            //String[] item = line.split("=");
            Item item = new Item();
            item.name = items[0];
            item.weight = Integer.valueOf(items[1]);
            itemsList.add(item);
            //System.out.println("The item " + i + " is '" + items[0] + "' with a weight of " + items[1] + " kg");
            i++;
        }
        System.out.println( "========== end of loadItems ========" );
        return itemsList;
    }
    //*/
        //ArrayList<U1> rocketListU1;
        /*
        i = 1;
        j = 1;
        //ArrayList<Item> itemsList = new ArrayList();
        //Rocket rocketU1[] = new Rocket[5];
        //double rocketCost;
        //int rocketWeight;
        //int maxWeight;
        //int cargoLimit;
        //double chanceOfLaunchExplosion;
        //double chanceOfLandingCrash;

        ///*
        //U1 rocket = new U1();
        //rocketListU1.add(rocket);
        //rocketListU1.add(new U1());
        //rocketListU1.add(rocket);
        //System.out.println( "U1 Rocket added: " + rocket );
        //rocket.cargoCarried = 0;
        //ArrayList<Item> cargoList = new ArrayList<Item>();

        //U1 rocket = new U1();
        //rocketListU1.add(rocket);
        //rocketListU1.add(new U1());
        //System.out.println( "U1 Rocket added: " + rocket" );
        for (U1 rock : rocketListU1) {
            System.out.println( "U1 Rocket added: " + rock );
            //rock.cargoCarried = 0;

            for (Item item : itemList) {

                // fill up the rocket with items
                if (rock.canCarry(item)) {
                    rock.carry(item);
                    //rock.cargoList.add(item);
                    System.out.println("U1 Rocket " + j + ", Item " + i + ": " + item.name +
                            " with " + String.valueOf(item.weight) + " kg");
                    i++;
                }
                else {
                    // if no more space, use a new rocket
                    //return rocket.cargoList;
                    //rocketListU1.add(rock);
                    //rocketListU1.add(new U1());
                    //rocketListU1.add(rocket);
                    j++;
                    rock.newU1(j);
                    System.out.println( "U1 Rocket added: " + rock );
                    //rock.cargoList = new ArrayList<Item>();
                    //rock.cargoCarried = 0;
                //U1 rocket = new U1();
                //rocketListU1.add(rocket);
                //rocket.newU1(j);
                //rocket.cargoCarried = 0;
                //cargoList = new ArrayList<Item>();
                //ArrayList<Item> rocket.cargolist = new ArrayList<Item>();
                }

            }
            //return rocketListU1;
            break;
        }
        */
        //if( size(rocketListU1) <  )
        //return rocketListU1;

}


