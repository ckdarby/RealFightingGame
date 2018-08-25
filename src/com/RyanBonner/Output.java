package com.RyanBonner;

public class Output {

    public static void println(String output) {
        System.out.println(output);
    }

    public static void println(String output, String... Strings) {
        System.out.println(String.format(output, (Object[]) Strings));
    }

    public static final String WHAT_IS_NAME = "What is your name?";
    public static final String LENGTH_TOO_LONG = "Length can't exceed 15 characters";
    public static final String WHAT_COMPUTER_SKILL_LEVEL = "What skill level of computer do you want to face? [easy, medium, hard, god]";
    public static final String HELLO_X = "Hello %s";
    public static final String DOUBLE_ATTACK_X = "DOUBLE ATTACK FOR %s";
    public static final String PLAYER_TITLE_X = "~%s~";
    public static final String X_ATTACKS_DAMAGE_Y = "%s attacks for %s damage";
    public static final String X_HAS_Y_HEALTH = "%s has %s remaining health";
    public static final String X_GOT_DOUBLE_ATTACK = "%s got double attack!!";
    public static final String X_HAS_WON = "%s wins!!";

//  public static final String LENGTH_TOO_LONG = "Length can't exceed % characters";
}
