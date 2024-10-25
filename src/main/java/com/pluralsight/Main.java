package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {

    private static final String dataFileName = "inventory.csv";
    private static ArrayList<Vehicle> inventory = getInventory();

    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        displayVehicles(inventory);

    }


  //  private  static ArrayList
    //method designed to read the file and stores transactions in array list
    private static ArrayList<Vehicle> getInventory() {
        //declare an empty array list
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(dataFileName));
            String inputFile = br.readLine();
            while (inputFile  != null) {
                //split tokens
                String[] tokens = inputFile.split(Pattern.quote("|"));

                // Check if the tokens array has the 5 elements
                if (tokens.length == 8) {
                    try {
                        int vin = Integer.parseInt(tokens[0]);
                        int year = Integer.parseInt(tokens[1]);
                        String make = tokens[2];
                        String model = tokens[3];
                        String vehicleType = tokens[4];
                        String color = tokens[5];
                        int odometer = Integer.parseInt(tokens[6]);
                        double price = Double.parseDouble(tokens[7]);

                        vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                    } catch (Exception e) {
                        // System.out.println("Error");
                        e.printStackTrace();
                    }
                }
            }
            br.close(); //close and release transactions
        } catch (Exception e) {
            System.out.println("ERROR!!");
            e.printStackTrace();
        }
        return vehicles; //add transactions to list
    }
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


}