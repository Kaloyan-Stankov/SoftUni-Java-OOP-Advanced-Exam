package app.models.participants;

import app.contracts.Targetable;

public abstract class BaseTargetable implements Targetable {
    private double health;
    private String name;
    private boolean isAlive;
    private double gold;
    private double damage;

    BaseTargetable(String name, double health, double gold, double damage) {
        this.name = name;
        this.setHealth(health);
        this.isAlive = true;
        this.gold = gold;
        this.damage = damage;
    }

    BaseTargetable(double health, double gold, double damage) {
        this.setHealth(health);
        this.isAlive = true;
        this.gold = gold;
        this.damage = damage;
    }
    public BaseTargetable() {
    }

    @Override
    public String attack(Targetable target) {
        target.takeDamage(this.damage);

        return String.format("%s attacked!",target.getName());
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health <= 0) this.isAlive = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable){
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public abstract void levelUp();

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
}
