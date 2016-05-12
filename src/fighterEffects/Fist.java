package fighterEffects;

import characters.Dude;
import characters.Fighter;
import effect.Effect;

/**
 * Created by HansDaniel on 12.05.2016.
 */
public class Fist implements Effect {
    Fighter fighter;

    public Fist(Fighter fighter) {
        this.fighter = fighter;
    }

    @Override
    public void onHit(Dude target) {
        double randomArmor = Math.random()*100;
        double randomAccuracy = Math.random()*100;
        if (randomArmor>target.getArmor()&&randomAccuracy<fighter.getAccuracy()) {
            System.out.println("Fist! "+target.toString()+" kaotas 5 elu! Fighter kaotas 3 action pointi.");
            fighter.reduceActionPoints(1);
            target.reduceHealthPoints(5);
        }
        else{
            System.out.println("Fist ei õnnestunud! Fighter kaotas 1 action pointi.");
            fighter.reduceActionPoints(1);
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
        return "Fist";
    }
}
