package RogueEffects;

import characters.Dude;
import characters.Rogue;
import effect.Effect;

/**
 * Created by HansDaniel on 12.05.2016.
 * If succesful, removes 5 hp from target.
 */
public class Stab implements Effect {
    public Stab(Rogue rogue) {
        this.rogue = rogue;
    }

    Rogue rogue;

    @Override
    public void onHit(Dude target) {
        double randomArmor = Math.random()*100;
        double randomAccuracy = Math.random()*100;
        if (randomArmor>target.getArmor()&&randomAccuracy<rogue.getAccuracy()) {
            System.out.println("Stab! "+target.toString()+" kaotas 5 elu! Rogue kaotas 3 action pointi.");
            rogue.reduceActionPoints(1);
            target.reduceHealthPoints(5);
        }
        else{
            System.out.println("Stab ei õnnestunud! Rogue kaotas 1 action pointi.");
            rogue.reduceActionPoints(1);
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
        return "Stab";
    }
}
