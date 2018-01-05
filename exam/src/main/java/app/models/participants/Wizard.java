package app.models.participants;

import app.models.Config;

public class Wizard extends AbstractHero {


    public Wizard(String name) {
        super(name,Config.HERO_HEALTH_MULTIPLIER * Config.WIZARD_BASE_STRENGTH,
                Config.WIZARD_BASE_STRENGTH,
                Config.WIZARD_BASE_DEXTERITY,
                Config.WIZARD_BASE_INTELLIGENCE,
                Config.WIZARD_BASE_STRENGTH * 2 + Config.WIZARD_BASE_DEXTERITY);
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Name: %s | Class: Wizard", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold",this.getStrength(),this.getDexterity(),
                        this.getIntelligence(),this.getGold()));

        return sb.toString();
    }
}
