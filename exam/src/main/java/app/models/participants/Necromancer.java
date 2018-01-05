package app.models.participants;

import app.models.Config;

public class Necromancer extends AbstractHero {
    public Necromancer(String name) {
        super(name,Config.HERO_HEALTH_MULTIPLIER * Config.NECROMANCER_BASE_STRENGTH,
                Config.NECROMANCER_BASE_STRENGTH,
                Config.NECROMANCER_BASE_DEXTERITY,
                Config.NECROMANCER_BASE_INTELLIGENCE,
                Config.NECROMANCER_BASE_STRENGTH * 2 + Config.NECROMANCER_BASE_DEXTERITY);
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 2) + (this.getDexterity() * 2) + (this.getStrength() * 2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Name: %s | Class: Necromancer", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold",this.getStrength(),this.getDexterity(),
                        this.getIntelligence(),this.getGold()));

        return sb.toString();
    }
}
