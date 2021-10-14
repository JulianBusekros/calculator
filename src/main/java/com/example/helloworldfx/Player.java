package com.example.helloworldfx;

public class Player {

    private int health;
    private final String name;

    public Player(String name) {
        this.health = 200;
        this.name = name;
    }
    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
    public void adjustHealth(int damageOrHealing){

        this.health += damageOrHealing;

        if (this.health <= 0){
            System.out.println("You died");
        }
    }

}
