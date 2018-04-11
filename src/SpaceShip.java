/**
 * Created by Carlos Lemos on 04/05/2018.
 */
public interface SpaceShip {
    /* PART 1: The design (continue from Item class)

    2. Create a SpaceShip Interface that includes the definitions of these methods:
    launch: a method that returns either true or false indicating if the launch was successful
    or if the rocket has crashed.
    land: a method that also returns either true or false based on the success of the landing.
    canCarry: a method that takes an Item as an argument and returns true if the rocket can carry
    such item or false if it will exceed the weight limit.
    carry: a method that also takes an Item object and updates the current weight of the rocket.
    */

    boolean launch ();   // returns either true or false indicating if the launch was successful or if the rocket has crashed
    boolean land ();   // returns either true or false based on the success of the landing
    boolean canCarry (Item item);  // returns true if the rocket can carry such item or false if it will exceed the weight limit
    void carry (Item item);   // updates the current weight of the rocket

}
