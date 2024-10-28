/**
 * UI encapsulates methods for all output to the screen, reading user input, and
 * dispatching of the commands to the Dealership as need ( ex: when the user selects
 * "List all vehicles", the UI calls the method and display vehicles
 */
package com.pluralsight;

import java.util.ArrayList;

public class UI {

    private Dealership dealership;

    /**
     * Constructor
     */
    public UI(Dealership dealership) {
        this.dealership = dealership;
    }

    /**
     * Method designed to initialize and load a dealership
     */
    private Dealership init(){
        DealershipFileManager.getDealership();
        return this.dealership;
    }

    public void Display(){
        init();
        while(true){
            System.out.println("Welcome to the Dealership. \n Choose the following options \n");

            int request = Console.PromptForInt();

            switch (request) {
                case 1: Display();
                break;
                case 2 :
            }
        }

    }

    /**
     * Method designed to display a list and can be called from all of the get-vehicles type methods,
     * with a parameter that is passed in containing the vehicles to list.
     * @param vehicles
     */
    private static void displayVehicles(ArrayList<Vehicle> vehicles){

        //print array list
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

    /***
     * Method desiged to list all
     */

    public void ProcessGetAllVehiclesRequest(){

    }
     public void ProcessGetByPriceRequest(){


     }

     public void ProcessGetByMakeModelRequest(){

     }
    public void ProcessGetByYearRequest(){

    }

    public void ProcessGetByMileageRequest(){

    }
    public void ProcessGetByVehicleTypeRequest(){

    }

    public void AddVehicleRequest(){

    }

    public void RemoveVehicleRequest(){

    }
}
