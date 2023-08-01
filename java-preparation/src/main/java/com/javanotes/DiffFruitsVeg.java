/*  Write a java program to segregate vegetables and fruits from a basket and tag prices as per current market value.

    Basket = {"FRT", "Apple"},{"VG", "Onion"},{"VG", "Potato"},{"VG", "Chillies"},{"FRT", "Mango"},{"FRT", "Banana"}

        Price/kg = {"200", "Apple"},
        {"20", "Onion"},
        {"20", "Potato"},
        {"80", "Chillies"},
        {"450", "Mango"},
        {"50", "Banana"}
        {"30", "Watermellon"},
        {"50", "Grapes"}

        Output <To be printed in below format> :
        Available Fruits with price value :
        1. Apple 200/kg
        2. Mango 450/kg
        3. Banana 50/kg

        Avaliable Vegetables with price value :
        1. Onion 20/kg
        2. Potato 20/kg
        3. Chillies 80/kg        */

package com.javanotes;

import java.util.HashMap;
import java.util.Map;

public class DiffFruitsVeg {

    public static void main() {

        Map<String, String> basketMap = new HashMap<>();
        basketMap.put("FRT", "Apple");

    }
}
