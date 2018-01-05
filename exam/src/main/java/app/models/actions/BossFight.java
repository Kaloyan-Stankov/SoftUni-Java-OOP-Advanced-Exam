package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    @Override
    public String executeAction(List<Targetable> participants) {

        String error = "There should be at least 1 participant for boss fight!";
        String bossWinMsg = "Boss has slain them all!";
        String bossSlainMsg = "Boss has been slain";

        if (participants.size() < 2){
            return error;
        }

        StringBuilder sb = new StringBuilder();

        Targetable boss = participants.get(0);
        List<Targetable> participants1 = participants.stream().skip(1).collect(Collectors.toList());

        while (participants1.size() > 0){
            for (int i = 0; i < participants1.size(); i++) {
                Targetable currentAttacker = participants1.get(i);
                currentAttacker.attack(boss);
                if (!boss.isAlive()){
                    boss.giveReward(currentAttacker);
                    participants.forEach(p -> p.receiveReward(Config.BOSS_INDIVIDUAL_REWARD));
                    for (Targetable targetable : participants1) {
                        if (!targetable.equals(currentAttacker)){
                            targetable.levelUp();
                        }
                    }
                    sb.append(bossSlainMsg).append(System.lineSeparator());
                    participants1.stream().sorted(Comparator.comparing(Targetable::getName)).forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));


                    return sb.substring(0, sb.length() - 1);
                }
               boss.attack(currentAttacker);
                if (!currentAttacker.isAlive()){
                    participants1.remove(i--);
                }
            }
        }

        sb.append(bossWinMsg);
        return sb.toString();

    }
}
