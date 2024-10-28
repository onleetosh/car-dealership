/**
 * DealershipFileManager encapsulates the methods for reading the dealership file, parsing
 * the data, and creating a Dealership object full of vehicles from the file. It is also
 * responsible for saving a dealership and the vehicle back into the file in the same
 * pipe-delimited format
 */

package com.pluralsight;


import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DealershipFileManager {

    private static final String dataFileName = "inventory.csv";

    private static ArrayList<Dealership> dealerships = getDealership();

    /**
     * This method loads and reads the inventory.csv file and uses the data in the file to create the Dealership object
     * and populates the inventory with a list of Vehicles
     */
    public static ArrayList<Dealership> getDealership() {

        ArrayList<Dealership> dealerships = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dataFileName))) {
            String inputFile;

            // Read the first line containing dealership info
            inputFile = br.readLine();

            if (inputFile != null) {
                String[] dsTokens = inputFile.split(Pattern.quote("|"));
                if (dsTokens.length == 3) {
                    try {
                        String name = dsTokens[0];
                        String address = dsTokens[1];
                        String contact = dsTokens[2];


                        System.out.printf("%33s | %22s | %20s \n", name, address, contact);
                        // System.out.println("Dealership Name - " + name + ", Address - " + address + ", Contact- " + contact);
                        System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s | %20s | %10s \n",
                                "Vin", "Year", "Make", "Model", "Vehicle Type", "Color", "Odometer", "Price");

                        // Loop through the rest of the file to read vehicles
                        while ((inputFile = br.readLine()) != null) {
                            String[] vTokens = inputFile.split(Pattern.quote("|"));
                            if (vTokens.length == 8) {
                                int vin = Integer.parseInt(vTokens[0]);
                                int year = Integer.parseInt(vTokens[1]);
                                String make = vTokens[2];
                                String model = vTokens[3];
                                String vehicleType = vTokens[4];
                                String color = vTokens[5];
                                int odometer = Integer.parseInt(vTokens[6]);
                                double price = Double.parseDouble(vTokens[7]);

                                System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s | %20s | %10s \n",
                                        vin, year,make, model, vehicleType, color, odometer, price );

                                vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                            }
                        }
                        // Add dealership with vehicles
                        dealerships.add(new Dealership(name, address, contact, new ArrayList<>(vehicles)));
                    } catch (Exception e) {
                        System.out.println("Error processing dealership or vehicles");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        return dealerships;
    }

    /**
     * This method overwrites the inventory.csv file with the current dealership information and inventory list
     * @param dealership
     */
    public static void saveDealership(Dealership dealership) {
        try {
            //create a FileWriter to append data to file
            FileWriter fw = new FileWriter(dataFileName, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Get the most recent dealership in the file
            Dealership newDealership = dealerships.get(dealerships.size() - 1);

            //format data as a string
            String data = newDealership.getName() + "|" +
                    newDealership.getAddress() + "|" +
                    newDealership.getContact() + "\n";

            fw.write(data); // Write the dealership data to the file.
            bw.close(); //close and release the date
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
        }
    }
}
