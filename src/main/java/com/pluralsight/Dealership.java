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
    private String phone;

    static ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static void addVehicle() {

    }

    public static void getAllVehicles(){

    }



}
