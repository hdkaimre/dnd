package wizardEffects;

import characters.Dude;
import characters.Wizard;

/**
 * Created by HansDaniel on 11.05.2016.
 * Reduces target's health points for three turns.
 */
public class SlowSpell implements effect.Effect{
    int duration;
    Wizard wizard;

    public SlowSpell(Wizard wizard) {
        this.duration = 0;
        this.wizard = wizard;
    }

    @Override
    public void onHit(Dude target) {
        double randomArmor = Math.random()*100;
        double randomAccuracy = Math.random()*100;
        if (randomArmor>target.getArmor()&&randomAccuracy<wizard.getAccuracy()) {
            this.duration = 3;
            System.out.println("Slow spell hakkab töötama! Wizard kaotas 3 action pointi." );
            wizard.reduceActionPoints(3);
            target.addEffect(this);
        }
        else{
            System.out.println("Slow spell ei õnnestunud! Wizard kaotas 1 action pointi.");
            wizard.reduceActionPoints(1);
        }
    }

    @Override
    public void beforeTurn(Dude target) {
        if(!isExpired()){
            target.reduceHealthPoints(3);
            System.out.println("Slow spell eemaldas duellandilt "+target.toString()+" "+4+" elu!");
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
        return "SlowSpell";
    }
}
