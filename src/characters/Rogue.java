package characters;

import RogueEffects.*;
import effect.Effect;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HansDaniel on 7.03.2016.
 */
public class Rogue extends Dude{

    @Override
    public String toString() {
        return "Rogue";
    }

    public Rogue() {
        this.accuracy = 80;
        this.armor = 20;
        this.health = 50;
        this.actionPoints = 50;
        this.underInfluence = new ArrayList<Effect>();
        this.skillSet = new HashMap<String,Effect>();
        skillSet.put("PoisonStab", new PoisonStab(this));
        skillSet.put("Heal",new Heal(this));
        skillSet.put("Stab", new Stab(this));
    }

}
