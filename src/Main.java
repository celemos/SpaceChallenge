import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.NoSuchMethodException;

/*
 * Created by Carlos Lemos on 04/05/2018.
 */
public class Main {

    /* PART 3: Running the Simulation
    Create a Main class with the main method and start running the simulation:
    - Create a Simulation object
    - Load Items for Phase-1 and Phase-2
    - Load a fleet of U1 rockets for Phase-1 and then for Phase-2
    - Run the simulation using the fleet of U1 rockets and display the total budget required.
    - Repeat the same for U2 rockets and display the total budget for that.

    UNSOLVED ISSUE/BUG 1:
    The main method must be placed inside the Simulation class (otherwise, it does not run at all).
    If I try to place it inside the Main class, I get the error:

    Exception in thread “main” java.lang.NoSuchMethodException: Simulation.main([Ljava.lang.String;)
    at java.lang.Class.getMethod(Class.java:1786)
    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:125)

    That's the reason why the following main method is commented out.
    A copy of it is placed in the Simulation class where it runs smoothly without problems.
    Please, refer to the main method in the Simulation class.

    UNSOLVED ISSUE/BUG 2    :
    I also did not get running the carry and canCarry methods in the Rocket class.
    To get them running, they must be implemented in the U1 and U2 classes (otherwise, they do not run correctly).
    I thought the solution for the second issue was related with the correct use of “static” keyword.
    But, after some trials with “static”, the issue continues to force me to place the carry and canCarry methods
    in the U1 and U2 classes to get them running.

    Suggestions are welcome! (I thing they will help all of us who are interested to learn a bit more).
    COMMENTED OUT CODE FOLLOWS:

    public static void main(String [] args) throws FileNotFoundException {

        // NOTE: RUN THIS METHOD 5 OR 6 TIMES IN A ROW IN ORDER TO SEE THE EFFECT OF LAUNCH EXPLOSIONS AND LAND CRASHES

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
}
