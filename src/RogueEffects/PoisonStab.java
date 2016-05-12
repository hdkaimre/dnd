package RogueEffects;

import characters.Dude;
import characters.Rogue;
import characters.Wizard;
import effect.Effect;

/**
 * Created by HansDaniel on 12.05.2016.
 * removes 1 action point from target for 3 turns
 */
public class PoisonStab implements Effect {
    int duration;
    Rogue rogue;

    public PoisonStab(Rogue rogue) {
        this.duration = 0;
        this.rogue = rogue;
    }

    @Override
    public void onHit(Dude target) {
        double randomArmor = Math.random()*100;
        double randomAccuracy = Math.random()*100;
        if (randomArmor>target.getArmor()&&randomAccuracy<rogue.getAccuracy()) {
            this.duration = 3;
            System.out.println("Poison stab hakkab töötama! Rogue kaotas 4 action pointi." );
            rogue.reduceActionPoints(1);
            target.addEffect(this);
        }
        else{
            System.out.println("Poison stab ei õnnestunud! Rogue kaotas 1 action pointi.");
            rogue.reduceActionPoints(1);
        }
    }

    @Override
    public void beforeTurn(Dude target) {
        if(!isExpired()){
            target.reduceActionPoints(2);
            System.out.println("Slow spell eemaldas duellandilt "+target.toString()+4+" elu!");
        }

    }

    @Override
    public void afterTurn(Dude target) {
        if(!isExpired()){
            duration -=1;
        }

    }

    @Override
    public boolean isExpired() {
        if(duration>0){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PoisonStab";
    }
}
