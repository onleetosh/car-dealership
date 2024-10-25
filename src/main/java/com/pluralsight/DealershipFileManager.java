/**
 * DealershipFileManager encapsulates the methods for reading the dealership file, parsing
 * the data, and creating a Dealership object full of vehicles from the file. It is also
 * responsible for saving a dealership and the vehicle back into the file in the same
 * pipe-delimited format
 */

package com.pluralsight;


public class DealershipFileManager {


    private static final String dataFileName = "inventory.csv";

    /**
     * This method loads and reads the inventory.csv file and uses the data in the file to create the Dealership object
     * and populates the inventory with a list of Vehicles
     */
    public Dealership getDealership() {

        return  null;

    }


    /**
     * This method overwrites the inventory.csv file with the current dealership information and inventory list
     * @param dealership
     */
    public void saveDealership(Dealership dealership) {

    }
}
