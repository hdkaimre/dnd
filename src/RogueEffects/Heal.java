package RogueEffects;

import characters.Dude;
import characters.Rogue;
import effect.Effect;

/**
 * Created by HansDaniel on 12.05.2016.
 * Turns 3 action points to health points.

 */
public class Heal implements Effect {
    Rogue rogue;

    public Heal(Rogue rogue) {
        this.rogue = rogue;
    }

    @Override
    public void onHit(Dude target) {
        rogue.increaseHealthPoints(3);
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
        return "Heal";
    }
}
