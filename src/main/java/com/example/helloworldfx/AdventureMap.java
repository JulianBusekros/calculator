package com.example.helloworldfx;

import java.util.HashMap;
import java.util.Map;

public class AdventureMap {

    private static final Map<Integer, Location> locations = new HashMap<>();

    public void createMap(Map<Integer, Location> locations){

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are leaving the region.", tempExit));

        tempExit.put("W", 2);
        tempExit.put("E", 7);
        tempExit.put("S", 4);
        tempExit.put("N", 10);
        locations.put(1, new Location(1, "You are standing on a hill which is surrounded by grassland.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("E", 1);
        tempExit.put("S", 3);
        locations.put(2, new Location(2, "You are in the forest.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 2);
        locations.put(3, new Location(3, "You stand in front of the ocean.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("E", 5);
        locations.put(4, new Location(4, "You stand in front of an abandoned temple.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 4);
        locations.put(5, new Location(5, "You stand on the west side of the river.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 8);
        locations.put(6, new Location(6, "You stand on the east side of the river.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        tempExit.put("N", 9);
        tempExit.put("E", 8);
        locations.put(7, new Location(7, "You are in a small village.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 6);
        tempExit.put("W", 7);
        locations.put(8, new Location(8, "You are on a tiny farm.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 7);
        locations.put(9, new Location(9, "You crossed a bridge and are now on an island.", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        locations.put(10, new Location(10, "You are in the mountain area.", tempExit));

    }
    public Map<Integer, Location> getLocations(){
        createMap(locations);
        return locations;
    }



}
