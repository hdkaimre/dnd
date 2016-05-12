package characters;

import effect.Effect;
import fighterEffects.Fist;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HansDaniel on 7.03.2016.
 */
public class Fighter extends Dude {
    @Override
    public String toString() {
        return "Fighter";
    }

    public Fighter() {
        this.accuracy = 30;
        this.armor = 40;
        this.health = 60;
        this.actionPoints = 50;
        this.underInfluence = new ArrayList<Effect>();
        this.skillSet = new HashMap<String,Effect>();
        skillSet.put("Fist", new Fist(this));
    }
}
