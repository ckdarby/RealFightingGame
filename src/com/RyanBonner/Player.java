package com.RyanBonner;

import java.util.Random;

public class Player {

  private int health;
  private int attackDamage;
  private int attackSpeed;
  private String name;

  public Player(String name) {
    this.name = name;
  }

  public static int generateStat(int min, int max) {
    return generateStat(min, max, 1);
  }

  public static int generateStat(int min, int max, int weight) {
    Random randomGenerator = new Random();
    return (randomGenerator.nextInt(max) + min) * weight;
  }

  public String toString() {
    return getName() + "'s stats:" + "\n" +
    "Health is: " + getHealth() + "\n" +
    "Attack Damage is: " + getAttackDamage() + "\n" +
    "Attack Speed is: " + getAttackSpeed() + "\n\n";
  }

  public int getHealth() {
    return health;
  }

  public int getAttackDamage() {
    return attackDamage;
  }

  public int getAttackSpeed() {
    return attackSpeed;
  }

  public String getName() {
    return name;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int loseHealth(int damage) {
    this.setHealth(getHealth() - damage);

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

  public void setAttackSpeed(int attackSpeed) {
    this.attackSpeed = attackSpeed;
  }

  public void setName(String name) {
    this.name = name;
  }
}
