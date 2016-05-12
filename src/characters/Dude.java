package characters;

import effect.Effect;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HansDaniel on 7.03.2016.
 */
public abstract class Dude{
    int accuracy;
    int armor;
    int health;
    int actionPoints;
    HashMap<String, Effect> skillSet;
    List<Effect> underInfluence;

    public void takeTurn(Dude target) {
        System.out.println("Käigu algus...");
        for (Effect effect : underInfluence) {
            effect.beforeTurn(this);
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("Energiat on alles " + this.actionPoints + " ja vastasel on " + target.health + " elu!");
        System.out.println("Vali rünnak, mida vastase peal kasutada: ");
        for (Effect effect : skillSet.values()) {
            System.out.println(effect.toString());
        }
        String input = sc.nextLine();
        if (skillSet.containsKey(input)) {
            Effect effect = skillSet.get(input);
            effect.onHit(target);
        } else if (!input.equals("STOP")) {
            System.out.println("Valitud rünnakut ei eksisteeri.");
        }

        for (Effect effect : underInfluence) {
            effect.afterTurn(this);
        }
        System.out.println("Käigu lõpp.");
    }

    public boolean isAlive() {
        if (this.health < 0) {
            return false;
        } else {
            return true;
        }
    }

    public void reduceActionPoints(int i){
        this.actionPoints-=i;
    }

    public void reduceHealthPoints(int i){
        this.health -= i;
    }

    public void increaseHealthPoints(int i){
        this.reduceActionPoints(i);
        System.out.println(this.toString()+" kaotas "+i+" action pointi, sai juurde "+i+" health pointi.");
        this.health += i;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void addEffect(Effect effect){
        underInfluence.add(effect);
    }
}
