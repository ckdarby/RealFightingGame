package com.RyanBonner;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Input input = Input.initalize(new Scanner(System.in));

        String humanName = input.askName();

        double computerOPWeight = getComputerSkillLevel(
                input.askComputerSkillLevel()
        );


        //@todo print Hello
        Output.println(Output.HELLO_X, humanName);

        Player human = new Player(humanName);
        human.setHealth(Player.generateStat(100, 1000));
        human.setAttackDamage(Player.generateStat(10, 100));
        human.setDoubleAttackChance(Player.generateStat(1, 100));
        Output.println(human.toString());

        Player computer = new Player("KappaDelta");
        computer.setHealth(Player.generateStat(100, 1000, computerOPWeight));
        computer.setAttackDamage(Player.generateStat(10, 100, computerOPWeight));
        computer.setDoubleAttackChance(Player.generateStat(1, 100, computerOPWeight));
        Output.println(computer.toString());

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

            executeBothPlayers(firstAttacker, secondAttacker);
        }

        if (human.isDead()) {
            Output.println(Output.X_HAS_WON, computer.getName());
        } else {
            Output.println(Output.X_HAS_WON, human.getName());
        }
    }

    private static double getComputerSkillLevel(String computerSkillLevel) {

        if (computerSkillLevel == null) {
            computerSkillLevel = "easy";
        }

        switch (computerSkillLevel) {
            default:
            case "easy":
                return .75;
            case "medium":
                return 1.0;
            case "hard":
                return 2;
            case "god":
                return 3;
        }
    }

    private static boolean isGameEnded(int playerHealth, int computerHealth) {
        return playerHealth <= 0 || computerHealth <= 0;
    }

    private static void executeBothPlayers(Player firstAttacker, Player secondAttacker) {

        executeSinglePlayer(firstAttacker, secondAttacker);

        if (!secondAttacker.isDead()) {
            executeSinglePlayer(secondAttacker, firstAttacker);
        }

    }

    private static void executeSinglePlayer(Player attackerA, Player attackerB) {
        int remainingHealth;
        int attackerATotalDamage = attackerA.getTotalAttack();
        String attackerAName = attackerA.getName();
        remainingHealth = attackerB.loseHealth(attackerATotalDamage);

        Output.println(Output.PLAYER_TITLE_X, attackerAName);

        if (attackerA.isDoubleAttack()) {
            Output.println(Output.X_GOT_DOUBLE_ATTACK, attackerAName);
        }

        Output.println(Output.X_ATTACKS_DAMAGE_Y, attackerAName, Integer.toString(attackerATotalDamage));
        Output.println(Output.X_HAS_Y_HEALTH, attackerB.getName(), Integer.toString(remainingHealth));

        Output.println("\n");
        pause(2);
    }

    private static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignore) {
        }
    }
}

