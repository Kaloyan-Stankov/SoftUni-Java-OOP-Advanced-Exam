package app.models.participants;

import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.Config;

public class Warrior extends AbstractHero {


    public Warrior(String name) {
        super(name,Config.HERO_HEALTH_MULTIPLIER*Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_DEXTERITY,
                Config.WARRIOR_BASE_INTELLIGENCE,
                Config.WARRIOR_BASE_STRENGTH * 2 + Config.WARRIOR_BASE_DEXTERITY);
    }
    public Warrior() {
        super(Config.HERO_HEALTH_MULTIPLIER*Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_STRENGTH,
                Config.WARRIOR_BASE_DEXTERITY,
                Config.WARRIOR_BASE_INTELLIGENCE,
                Config.WARRIOR_BASE_STRENGTH * 2 + Config.WARRIOR_BASE_DEXTERITY);
    }


    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Name: %s | Class: Warrior", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold",this.getStrength(),this.getDexterity(),
                        this.getIntelligence(),this.getGold()));

        return sb.toString();
    }

    //    public String attack(Targetable target) {
//        if (!this.isAlive()) {
//            return this.getName() + " is dead! Cannot attack.";
//        }
//
//        if (!target.isAlive()){
//            return target.getName() + " is dead! Cannot be attacked.";
//        }
//
//        target.takeDamage(this.getDamage());
//
//        String result = this.getName() + " attacked!";
//        if (!target.isAlive()) {
//            this.levelUp();
//            target.giveReward(this);
//            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
//        }
//
//        return result;
//    }
//
//    public double getReward(){
//        this.gold = 0;
//        return this.gold;
//    }
//
//    public void receiveReward(double reward){
//        this.gold = reward;
//    }
//
//    public void takeDamage(double damage) {
//        this.setHealth(this.getHealth() - damage);
//    }
//
//    public int getStrength() {
//        return strength;
//    }
//
//    public void setStrength(int strength) {
//        this.strength = strength;
//        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
//    }
//
//    public int getDexterity() {
//        return this.dexterity;
//    }
//
//    public void setDexterity(int dexterity) {
//        this.dexterity = dexterity;
//    }
//
//    public int getIntelligence() {
//        return this.intelligence;
//    }
//
//    public void setIntelligence(int intelligence) {
//        this.intelligence = intelligence;
//    }
//
//    public double getHealth() {
//        return this.health;
//    }
//
//    public void setHealth(double health) {
//        this.health = health;
//    }
//
//    @Override
//    public void giveReward(Targetable targetable) {
//        targetable.receiveReward(this.gold);
//        this.gold = 0;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//

//
//    public double getGold() {
//        return this.gold;
//    }
//
//    public boolean isAlive() {
//        return this.isAlive;
//    }
//
//    public void levelUp() {
//        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
//        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
//        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
//        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
//        this.level += 1;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
//                .append(System.lineSeparator())
//                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
//                .append(System.lineSeparator())
//                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));
//
//        return sb.toString();
//    }
}
