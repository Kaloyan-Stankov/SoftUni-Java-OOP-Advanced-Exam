package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class OneVsOneTest {

    private Warrior targetable1;
    private Warrior targetable2;
    private Action action;
    private List<Targetable> participants;
    private static final double DELTA = 1e-15;

    @Before
    public void before(){
        action = new OneVsOne();
        this.participants = new ArrayList<>();

        this.targetable1 = Mockito.mock(Warrior.class);
        this.targetable2 = Mockito.mock(Warrior.class);

        Mockito.when(targetable1.getDamage()).thenReturn(9.0);
        Mockito.when(targetable2.getDamage()).thenReturn(399.0);
        Mockito.when(targetable1.getName()).thenReturn("Warr");
        Mockito.when(targetable2.getName()).thenReturn("Wizz");
        Mockito.when(targetable1.getHealth()).thenReturn(400.0);
        Mockito.when(targetable2.getHealth()).thenReturn(9.5);

        participants.add(targetable1);
        participants.add(targetable2);
    }

    @Test
    public void oneVsOneRunningLoserDying(){
        action.executeAction(participants);

        Assert.assertTrue(!targetable2.isAlive());
    }

    @Test
    public void resultIsCorrect(){
       String result = action.executeAction(participants);

        Assert.assertEquals("Wizz is victorious!",result.split(System.lineSeparator())[0]);
}

    @Test
    public void winnerLevelsUpCorrectly(){
        double startigStr = targetable1.getStrength();
        action.executeAction(participants);

        Assert.assertEquals(startigStr , targetable1.getStrength(),DELTA);
    }

    @Test
    public void lessThan2Participants(){
        String result = action.executeAction(new ArrayList<>());

        Assert.assertEquals("There should be exactly 2 participants for OneVsOne!",result);
    }
}
