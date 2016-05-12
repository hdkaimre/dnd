package characters;

import effect.Effect;
import wizardEffects.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Wizard extends Dude {

    public Wizard() {
        this.accuracy = 70;
        this.armor = 15;
        this.health = 60;
        this.actionPoints = 50;
        this.underInfluence = new ArrayList<Effect>();
        this.skillSet = new HashMap<String,Effect>();
        skillSet.put("Inferno", new Inferno(this));
        skillSet.put("SlowSpell", new SlowSpell(this));
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
