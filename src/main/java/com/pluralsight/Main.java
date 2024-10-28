package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    private static final String dataFileName = "inventory.csv";
   //private static ArrayList<Dealership> dealership = getDealership();

    //private static ArrayList<Vehicle> inventory = getInventory();

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        getDealership();
    }


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
                        System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
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

                                System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
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
}






    //  private  static ArrayList
    //method designed to read the file and stores transactions in array list




/*

    private static void displayVehicles(ArrayList<Vehicle> vehicles){

        //print array list
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }

    }

    private static void displayDealership(Dealership d){
        System.out.printf("%10s | %20s | %10s \n", d.getName(), d.getAddress(), d.getContact());
    }

 */


