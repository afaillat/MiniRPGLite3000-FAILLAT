package com.isep.rpg;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean gameOver = false;
    int round = 1;
    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_RED = "\u001b[31m";
    Combatant[] list_goodOne;
    Combatant[] list_badOne;
    Combatant[] list_boss = new Combatant[1];

    public Game() {
        this.chooseNbHeros();
        this.createAllHeroes();
        this.createEnnemies();

        for(; !this.gameOver; ++this.round) {
            this.displayStatus();
            Combatant[] list_combatants = new Combatant[this.list_goodOne.length + this.list_badOne.length];
            System.arraycopy(this.list_goodOne, 0, list_combatants, 0, this.list_goodOne.length);
            System.arraycopy(this.list_badOne, 0, list_combatants, this.list_goodOne.length, this.list_badOne.length);
            List<Combatant> list = Arrays.asList(list_combatants);
            Collections.shuffle(list);
            list.toArray(list_combatants);
            Random r = new Random();
            Scanner scanner = new Scanner(System.in);
            Combatant[] var5 = list_combatants;
            int var6 = list_combatants.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Combatant goodOne = var5[var7];
                List<Combatant> liste = Arrays.asList(this.list_badOne);
                int types_action;
                PrintStream var10000;
                String var10001;
                if (liste.contains(goodOne)) {
                    types_action = r.nextInt(this.list_goodOne.length);
                    Combatant badOne = this.list_goodOne[types_action];
                    goodOne.fight(badOne);
                    var10000 = System.out;
                    var10001 = goodOne.getName();
                    var10000.println(var10001 + " attaque " + badOne.getName() + ", il perd " + goodOne.getDamagePoints() + " points de vie");
                    if (badOne.getHealthPoints() <= 0) {
                        this.list_goodOne = this.removeElement(this.list_goodOne, types_action);
                        System.out.println(badOne.getName() + " est mort !");
                    }
                } else {
                    System.out.println("Choisissez le type d'action pour votre héros : [1]: Attaquer, [2]: Défendre, [3]: Utiliser un consommable");
                    types_action = scanner.nextInt();
                    int randomNumber = r.nextInt(this.list_badOne.length);
                    Combatant ennemi = this.list_badOne[randomNumber];
                    if (types_action == 1) {
                        var10000 = System.out;
                        var10001 = goodOne.getName();
                        var10000.println("Le combattant " + var10001 + " attaque l'ennemi " + ennemi.getName() + "!");
                        goodOne.fight(ennemi);
                    } else if (types_action == 2) {
                        System.out.println("Je me défend de " + ennemi.getName() + " et je perds seulement 3 points de vie.");
                        goodOne.def(goodOne.getHealthPoints());
                    } else if (types_action == 3) {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Choisissez le type de consommable : [1]: Manger du lembas, [2]: Autre nourriture, [3] : Boire une potion pour restaurer le mana ");
                        int conso = scanner1.nextInt();
                        if (conso == 1) {
                            goodOne.win(goodOne.getHealthPoints());
                            System.out.print("Grâce aux lembas, je gagne des points de vie !");
                        } else if (conso == 2) {
                            goodOne.consu(goodOne.getHealthPoints());
                            System.out.print("Grace à la nourriture,je gagne des points de vie ! ");
                        } else if (conso == 3) {
                            goodOne.consu(goodOne.getHealthPoints());
                            var10000 = System.out;
                            var10001 = goodOne.getName();
                            var10000.print("Grâce à la potion,le mana du spellcaster est restauré : " + var10001 + " (" + goodOne.getHealthPoints() + " ) ");
                        } else {
                            System.out.println("Saisissez un autre numéro. ");
                        }

                        goodOne.fight(goodOne);
                        var10000 = System.out;
                        var10001 = goodOne.getName();
                        var10000.println(var10001 + " attaque " + ennemi.getName() + " est fait " + goodOne.getDamagePoints() + " dégats !");
                        this.list_badOne = this.removeElement(this.list_badOne, randomNumber);
                        var10000 = System.out;
                        var10001 = getClassName(ennemi.getClass());
                        var10000.println(var10001 + " " + ennemi.getName() + " est mort !");
                    }
                }

                if (this.list_badOne.length == 0) {
                    this.gameOver = true;
                    System.out.println("Vous avez tué tous les dragons, vous avez gagné la partie. Bravo!");
                    break;
                }

                if (this.list_badOne.length == 0) {
                    this.gameOver = true;
                    System.out.println("Tous vos héros sont morts. Dommage,vous avez perdu.");
                    break;
                }
            }

            if (this.round == 5) {
                this.list_boss[0] = new Boss("Boss!", 100);
                System.out.println("\nLes survivants vont maintenant combattre le boss.");
            }
        }

        ++this.round;
    }

    public Combatant[] removeElement(Combatant[] arr, int index) {
        Combatant[] arrDestination = new Combatant[arr.length - 1];
        int remainingElements = arr.length - (index + 1);
        System.arraycopy(arr, 0, arrDestination, 0, index);
        System.arraycopy(arr, index + 1, arrDestination, index, remainingElements);
        return arrDestination;
    }

    public void testHeroes() {
        this.list_goodOne = new Combatant[4];
        this.list_badOne = new Combatant[4];
        this.list_goodOne[0] = new Hunter("Hunter", 50);
        this.list_goodOne[1] = new Warrior("Warrior", 50);
        this.list_goodOne[2] = new Healer("Healer", 50, 10);
        this.list_goodOne[3] = new Mage("Mage", 50, 10);
    }

    public void chooseNbHeros() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bienvenue dans Mini RPG Lite 3000 ! Quel est votre prénom ?\n");
        String nom = scanner.nextLine();
        System.out.println("Etes vous prêts à commencer l'aventure, " + nom + " ?");
        int nbCombatant = this.Rules1("Veuillez indiquer le nombre de héros souhaité, choisissez entre 1 et 5 héros :");
        if (nbCombatant > 5) {
            System.out.println("Respectez les règles, choisissez un nombre entre 1 et 5 !");
            this.chooseNbHeros();
        }

        this.list_goodOne = new Combatant[nbCombatant];
        this.list_badOne = new Combatant[nbCombatant];
    }

    public void createAllHeroes() {
        for(int i = 0; i < this.list_goodOne.length; ++i) {
            String name = this.Rules("Quel nom souhaitez vous donner à votre héro numéro " + (i + 1) + " ?");
            boolean confirm = false;

            while(!confirm) {
                int firstHeroNumber = this.Rules1("Choisissez la classe de votre héros : \n [1] Hunter (40 pv) \n [2] Warrior (50 pv)\n [3] Mage (30 pv) \n [4] Healer (35 pv)");
                switch (firstHeroNumber) {
                    case 1:
                        this.list_goodOne[i] = new Hunter(name, 40);
                        confirm = true;
                    case 2:
                        this.list_goodOne[i] = new Warrior(name, 50);
                        confirm = true;
                    case 3:
                        this.list_goodOne[i] = new Mage(name, 30, 10);
                        confirm = true;
                    case 4:
                        this.list_goodOne[i] = new Healer(name, 35, 12);
                        confirm = true;
                }
            }
        }

    }

    public void createEnnemies() {
        for(int k = 0; k < this.list_badOne.length; ++k) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Ennemi " + (k + 1) + " : Veuillez saisir le nom de l'ennemi: ");
            String ennemy = scanner2.next();
            this.list_badOne[k] = new Dragon(ennemy, 50);
        }

    }

    public static String getClassName(Class c) {
        String className = c.getName();
        int firstChar = className.lastIndexOf(46) + 1;
        if (firstChar > 0) {
            className = className.substring(firstChar);
        }

        return className;
    }

    public void displayStatus() {
        System.out.println("\u001b[31m\n#################################Combat " + this.round + "#######################################\u001b[0m");
        Combatant[] var1 = this.list_goodOne;
        int var2 = var1.length;

        PrintStream var10000;
        String var10001;
        int var3;
        Combatant c;
        for(var3 = 0; var3 < var2; ++var3) {
            c = var1[var3];
            var10000 = System.out;
            var10001 = getClassName(c.getClass());
            var10000.println(var10001 + " " + c.getName() + " possède " + c.getHealthPoints() + " de points de vie et a " + c.getDamagePoints() + " points de dommage causé.");
        }

        var1 = this.list_badOne;
        var2 = var1.length;

        for(var3 = 0; var3 < var2; ++var3) {
            c = var1[var3];
            var10000 = System.out;
            var10001 = getClassName(c.getClass());
            var10000.println(var10001 + " " + c.getName() + " possède " + c.getHealthPoints() + " de points de vie et a " + c.getDamagePoints() + " points de dommage causé.");
        }

        System.out.println("___________________________________________________________________________________");
    }

    public void afficheCamp(Combatant[] camp, String type) {
        System.out.println("\n___________________________________________________________________________________");
        Combatant[] var3 = camp;
        int var4 = camp.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Combatant c = var3[var5];
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(c.getClass());
            var10000.println(var10001 + " - " + c.getName() + " - " + c.getHealthPoints());
            if (Objects.equals(type, "g")) {
                System.out.println("                             " + Arrays.toString(((Hero)c).getCeCombant()));
            }
        }

        System.out.println("___________________________________________________________________________________");
    }

    public int Rules1(String text) {
        System.out.println(text);

        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextInt();
            } catch (InputMismatchException var3) {
                System.out.println("Veuillez respectez les règles. Saisissez un numéro entre 1 et 5 ! ");
            }
        }
    }

    public String Rules(String text) {
        System.out.println(text);

        while(true) {
            try {
                Scanner sc = new Scanner(System.in);
                return sc.nextLine();
            } catch (InputMismatchException var3) {
                System.out.println("Veuillez choisir un numéro entre 1 et 4 !");
            }
        }
    }
}
