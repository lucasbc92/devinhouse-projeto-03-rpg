package v2.entities;

import java.util.Random;

public class Dice {
    private Random random;
    private int maxValue;

    public Dice(int maxValue){
        this.random = new Random();
        this.maxValue = maxValue;
    }

    public int getMaxValue(){
        return this.maxValue;
    }

    public int roll(){
        return random.nextInt(this.getMaxValue()) + 1;
    }
}
