package com.RyanBonner;

import java.util.Random;

public class Player {

  private String name;
  private int health;
  private int attackDamage;
  private int doubleAttackChance;

  private boolean isDoubleAttack = true;

  public Player(String name) {
    this.name = name;
  }

  public static int generateStat(int min, int max) {
    return generateStat(min, max, 1);
  }

  public static int generateStat(int min, int max, double weight) {
    Random randomGenerator = new Random();
    return (int) Math.round((randomGenerator.nextInt(max) + min) * weight);
  }

  public String toString() {
    return getName() + "'s stats:" + "\n" +
    "Health is: " + getHealth() + "\n" +
    "Attack Damage is: " + getAttackDamage() + "\n" +
    "Chance for double attack is: " + getDoubleAttackChance() + "%\n\n";
  }

  public int getHealth() {
    return health;
  }

  public int getAttackDamage() {
    return attackDamage;
  }


  public int getTotalAttack() {

    isDoubleAttack = false;
    int totalAttackDamage = getAttackDamage();

    //Double Attack
    totalAttackDamage += doubleAttack(getAttackDamage(), getDoubleAttackChance());

    return totalAttackDamage;
  }

  private int doubleAttack(int attackDamage, int doubleAttackChance) {

    if (generateStat(1, 100) <= doubleAttackChance) {
      //Double attack happens, so return the normal amount of attack damage;
      setDoubleAttack(true);
      return attackDamage;
    }

    //There is no double attack, apply not a additional damage
    return 0;
  }

  public int getDoubleAttackChance() {
    return doubleAttackChance;
  }

  public String getName() {
    return name;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int loseHealth(int damage) {

    int remainingHealth = getHealth() - damage;

    //Can't go below 0
    if (remainingHealth < 0) {
      remainingHealth = 0;
    }

    this.setHealth(remainingHealth);

    return getHealth();
  }

  public boolean isDead() {

    if (this.getHealth() <= 0 ) {
      return true;
    }

    return false;
  }

  public void setAttackDamage(int attackDamage) {
    this.attackDamage = attackDamage;
  }

  public void setDoubleAttackChance(int doubleAttackChance) {
    this.doubleAttackChance = doubleAttackChance;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isDoubleAttack() {
    return isDoubleAttack;
  }

  public void setDoubleAttack(boolean isDoubleAttack) {
    this.isDoubleAttack = isDoubleAttack;
  }
}
