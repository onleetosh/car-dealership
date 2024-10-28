/**
 * Dealership encapsulates and hold information about the dealership (name, address and phone number)
 * and maintains a list of vehicles; methods that search the list for matching vehicles; as well as
 * add or remove vehicles.
 */

package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String contact;

    private List<Vehicle> inventory;

    public  Dealership(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.inventory = new ArrayList<>();

    }

    public Dealership(String name, String address, String contact, ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.inventory = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContact() { return contact; }


    public void getVehicleByPrice(double min, double max) {


    }

    public void getVehiclesByMakeModel(String make, String model) {


    }
    public List<Vehicle> getVehiclesByYear(){
        ArrayList<Vehicle> found = new ArrayList<>();
        int input = Console.PromptForInt("Enter year to search");

        for(Vehicle vehicle: inventory){
            if(vehicle.getYear() == input) {
                System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
                found.add(vehicle);
            }
        }
        if (found.isEmpty()) {
            System.out.printf("No match for " + input);
        }
        return found;
    }

    public List<Vehicle> getVehiclesByColor(){
        ArrayList<Vehicle> found = new ArrayList<>();
        String input = Console.PromptForString("Enter color to search");

        for(Vehicle vehicle: inventory){
            if(vehicle.getColor().equalsIgnoreCase(input)) {
                System.out.printf("%10s | %20s | %10s |%10s | %20s | %10s| %20s | %10s \n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
                found.add(vehicle);
            }
        }
        if (found.isEmpty()) {
            System.out.printf("No match for " + input);
        }
        return found;
    }
    public void getVehiclesByMileage(){

    }
    public void getVehiclesByType(){

    }
    public List<Vehicle> getAllVehicles(){
       return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);

    }

    @Override
    public String toString() {
        return name + " | " + address + " | " + contact;
    }



}
