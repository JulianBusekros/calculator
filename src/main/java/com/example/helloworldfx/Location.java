package com.example.helloworldfx;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> locationExits;

    public Location(int locationID, String description, Map<String, Integer> locationExits) {
        this.locationID = locationID;
        this.description = description;

        if(locationExits != null){
            this.locationExits = new HashMap<>(locationExits);
        }else{
            this.locationExits = new HashMap<>();
        }
        this.locationExits.put("Q", 0);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getLocationExits() {
        return new HashMap<>(locationExits);
    }

}
