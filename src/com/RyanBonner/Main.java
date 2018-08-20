package com.RyanBonner;

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        System.out.println("What is your name? ");

        Scanner scanner = new Scanner(System.in);

        String humanName = scanner.nextLine();

        System.out.println("Hi " + humanName + ", would you like to see how strong you are?");

        Player human = new Player(humanName);
        human.setHealth(Player.generateStat(100, 1000));
        human.setAttackDamage(Player.generateStat(10, 100));
        human.setAttackSpeed(Player.generateStat(1, 7));
        System.out.print(human.toString());

        int computerOPWeight = 2;
        Player computer = new Player("KappaDelta");
        computer.setHealth(Player.generateStat(100, 1000, computerOPWeight));
        computer.setAttackDamage(Player.generateStat(10, 100, computerOPWeight));
        computer.setAttackSpeed(Player.generateStat(1, 7, computerOPWeight));
        System.out.print(computer.toString());

        int humanRoll = Player.generateStat(1, 20);
        int computerRoll = Player.generateStat(1, 20);

        Player firstAttacker;
        Player secondAttacker;

        while (!isGameEnded(human.getHealth(), computer.getHealth())) {

            //Default assume human won roll
            firstAttacker = human;
            secondAttacker = computer;

            if (computerRoll >= humanRoll) {
                //Computer won the roll
                firstAttacker = computer;
                secondAttacker = human;
            }

            executeTurn(firstAttacker, secondAttacker);
        }

        if (human.isDead()) {
            System.out.println("Computer Wins!");
        } else {
            System.out.println("User Win!");
        }
    }

    private static boolean isGameEnded(int playerHealth, int computerHealth) {
        return playerHealth <= 0 || computerHealth <= 0;
    }

    private static void executeTurn(Player firstAttacker, Player secondAttacker) {
        //First attacker won the roll, attacks first
        int remainingHealth;
        int attackDamage;

        attackDamage = firstAttacker.getAttackDamage();
        System.out.println(firstAttacker.getName() + " attacks with " + attackDamage + "!");

        remainingHealth = secondAttacker.loseHealth(firstAttacker.getAttackDamage());
        System.out.println(secondAttacker.getName() + " has " + remainingHealth + " remaining health.");
        System.out.println("==================================");
        pause(2);

        if (!firstAttacker.isDead()) {
            //Second player attacks human
            attackDamage = secondAttacker.getAttackDamage();
            System.out.println(secondAttacker.getName() + " attacks with " + attackDamage + "!");

            remainingHealth = firstAttacker.loseHealth(secondAttacker.getAttackDamage());
            System.out.println(firstAttacker.getName() + " has " + remainingHealth + " remaining health.");
        }
        System.out.println("==================================");
        pause(2);

    }

    private static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignore ) {}
    }
}

