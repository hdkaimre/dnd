package wizardEffects;

import characters.Dude;
import characters.Wizard;
import effect.Effect;

/**
 * Created by HansDaniel on 12.05.2016.
 */
public class Inferno implements Effect {
    Wizard wizard;

    public Inferno(Wizard wizard) {
        this.wizard = wizard;
    }

    @Override
    public void onHit(Dude target) {
        double randomArmor = Math.random()*100;
        double randomAccuracy = Math.random()*100;
        if (randomArmor>target.getArmor()&&randomAccuracy<wizard.getAccuracy()) {
            System.out.println("Inferno! "+target.toString()+" kaotas 5 elu! Wizard kaotas 3 action pointi.");
            wizard.reduceActionPoints(3);
            target.reduceHealthPoints(5);
        }
        else{
            System.out.println("Inferno ei õnnestunud! Wizard kaotas 1 action pointi.");
            wizard.reduceActionPoints(1);
        }
    }

    @Override
    public void beforeTurn(Dude target) {

    }

    @Override
    public void afterTurn(Dude target) {
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public String toString() {
        return "Inferno";
    }
}
