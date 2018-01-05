package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Boss extends BaseTargetable {


    public Boss(String name) {
        super(name,Config.BOSS_HEALTH, Config.BOSS_GOLD, Config.BOSS_DAMAGE);
    }


    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }


}
