package com.example.helloworldfx;

import java.util.Random;

public class CreateRandomEvent {

    private final Random r = new Random();

    public String getRandomEvent(){

        return switch (getRandomNumber()) {
            case 1 -> "A bandit is trying to attack you. Solve this task to defend yourself: ";
            case 2 -> "A friendly pilgrim is offering you a healing potion. Solve this task to gain 20 health: ";
            case 3 -> "You stumble over a rock. Solve this task to damp the fall: ";
            case 4 -> "A hostile wolf is trying to bite you. Solve this task to defend yourself: ";
            case 5 -> "You find a medical plant. Solve this task to eat it: ";
            case 6 -> "A stranger with a sword is appearing. Solve this task to run away: ";
            case 7 -> "A wizard appears. He wants you to solve this task to see if he can trust you: ";
            case 8 -> "A soldier appears. Solve this task to show that you are friendly.";
            case 9 -> "Nothing to see here.";
            default -> "Error";
        };
    }

    private int getRandomNumber(){
        int x = 1;
        int y = 10;

        return r.nextInt(y-x) + x;
    }
}
