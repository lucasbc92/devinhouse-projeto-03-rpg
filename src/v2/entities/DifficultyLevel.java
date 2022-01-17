package v2.entities;

public enum DifficultyLevel {
    EASY(0.8), //80% damage from enemies;
    NORMAL(1), //no modifier;
    HARD(0.9); //90% damage to enemies;

    private double damageModifier;

    private DifficultyLevel(double damageModifier){
        this.damageModifier = damageModifier;
    }

    public double getDamageModifier(){
        return this.damageModifier;
    }
}
