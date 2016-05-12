import characters.Dude;
import characters.Fighter;
import characters.Rogue;
import characters.Wizard;

import java.util.Scanner;

/**
 * Created by HansDaniel on 12.05.2016.
 */
public class Duel {

    public static void main(String[] args) {
        Dude character1, character2;
        System.out.println("Valige esimene tegelane, Fighter, Wizard või Rogue. Mängust väljumiseks sisesta EXIT");
        character1 = createCharacter();
        System.out.println("Valige teine tegelane, Fighter, Wizard või Rogue. Mängust väljumiseks sisesta EXIT");
        character2 = createCharacter();
        while(character1.isAlive() && character2.isAlive()) {
            System.out.println("Esimese duellandi käik: ");
            character1.takeTurn(character2);
            if(!character1.isAlive() || !character2.isAlive()){
                break;
            }
            System.out.println("Teise duellandi käik: ");
            character2.takeTurn(character1);
            System.out.println("Esimesel on alles " + character1.getHealth() + " elu ja " + character1.getActionPoints() + " punkti energiat.");
            System.out.println("Teisel on alles " + character2.getHealth() + " elu ja " + character2.getActionPoints() + " punkti energiat.");
            System.out.println();
        }

        if(character1.isAlive()){
            System.out.println("Esimene duellant võitis!");
        } else{
            System.out.println("Teine duellant võitis!");
        }

    }




    static Dude createCharacter() {
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {
            case "Fighter":
                return new Fighter();
            case "Wizard":
                return new Wizard();
            case "Rogue":
                return new Rogue();
            case "EXIT":
                System.exit(1);
            default:
                System.out.println("Proovige uuesti...");
                return createCharacter();
        }
    }

}
