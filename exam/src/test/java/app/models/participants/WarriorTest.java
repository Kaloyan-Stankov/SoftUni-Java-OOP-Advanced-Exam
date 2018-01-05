package app.models.participants;

import app.contracts.Targetable;

import app.models.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;


public class WarriorTest {

    private Targetable targetable1;
    private Targetable targetable2;
    private Warrior testTarget;
    private static final double DELTA = 1e-15;
    private static final double GOLD = 120;

    @Before
    public void before() {

        this.targetable1 = Mockito.mock(Warrior.class);
        this.targetable2 = Mockito.mock(Targetable.class);

        Mockito.when(targetable1.getDamage()).thenReturn(9.0);
        Mockito.when(targetable2.getDamage()).thenReturn(51.0);

        testTarget = new Warrior();

    }

    @Test
    public void takingDamageCorrectly(){
       testTarget.takeDamage(targetable1.getDamage());

        Assert.assertEquals(41.0,testTarget.getHealth(),DELTA);
    }

    @Test
    public void isAliveCorrectly(){

        Assert.assertEquals(true,testTarget.isAlive());

        testTarget.takeDamage(targetable2.getDamage());

        Assert.assertEquals(false,testTarget.isAlive());
    }

    @Test
    public void levelUpCorrectly(){
        testTarget.levelUp();

        Assert.assertEquals(Config.WARRIOR_BASE_STRENGTH * 2 ,testTarget.getStrength());
    }


    @Test
    public void recieveRewardCorrectly(){
        testTarget.receiveReward(GOLD);
        double goldExpected = 0;

        Class warriorClass = testTarget.getClass();
        try {
            Field field = warriorClass.getDeclaredField("gold");
            field.setAccessible(true);
            goldExpected = (Double) field.get(this.testTarget);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        Assert.assertEquals(Config.HERO_START_GOLD + 120.0,goldExpected,DELTA);
    }

}
