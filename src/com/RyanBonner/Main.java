package com.RyanBonner;

import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        System.out.println("What is your name? ");

        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();

        System.out.println("Hi " + userName + ", would you like to see how strong you are?");
        Random rand = new Random();
        int health = rand.nextInt(1000) + 100;
        int attack = rand.nextInt(100) + 10;
        int attackSpeed = rand.nextInt(7) + 1;
        System.out.println("Your Health is: " + health);
        System.out.println("Your Attack Damage is: " + attack);
        System.out.println("Your Attack Speed is: " + attackSpeed);
        int compHealth = rand.nextInt(1000) + 250;
        int compAttack = rand.nextInt(125) + 25;
        int compAttackSpeed = rand.nextInt(5) + 1;
        System.out.println("..................................");
        System.out.println("Computer's Health is: " + compHealth);
        System.out.println("Computer's Attack Damage is : " + compAttack);
        System.out.println("Computer's Attack Speed is : " + compAttackSpeed);
        //dice roll 1-20
        Random roll = new Random();
        int player1 = roll.nextInt(19) + 1;
        int computer1 = roll.nextInt(19) + 1;


        while (health > 0 && compHealth > 0) {

            if (player1 >= computer1) {
                //player1 attacks 1st
                compHealth = compHealth - attack;
                //computer attacks if not dead
                if (compHealth > 0) {
                    health = health - compAttack;
                }
            } else if (computer1 > player1) {
                health = health - compAttack;

                if (health > 0) {
                    compHealth = compHealth - attack;
                }
            }
        }
        if (health <= 0) {
            System.out.println("Computer Wins!");
        } else {
            System.out.println("User Win!");
        }


    }
}

