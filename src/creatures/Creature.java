package creatures;

import java.util.Random;

public class Creature {

  public Creature(
      int attack, int defence, int health, int lowerDamage, int upperDamage, String name) {
    this.name = name;
    setAttack(attack);
    setDefence(defence);
    setMaxHealth(health);
    setCurrentHealth(health);
    setDamage(lowerDamage, upperDamage);
  }

  private int attack;
  private int defence;
  private int maxHealth;

  private int currentHealth;
  private int lowerDamage;

  private int upperDamage;

  private boolean isDead;

  private String name;

  private final Random dice = new Random();

  public void attack(Creature target) {
    System.out.println("============");
    if (target.isDead) {
      System.out.println(target.getName() + " is already dead.");
      System.out.println("============");
      return;
    }
    int modif = this.getAttack() - target.getDefence() + 1;
    System.out.println(this.getName() + " Modifier is " + modif);
    int result;
    result = dice.nextInt(6) + 1;
    System.out.println("Roll " + result);
    for (int i = 2; i <= modif && result < 5; i++) {
      result = dice.nextInt(6) + 1;
      System.out.println("Roll " + result);
    }
    if (result >= 5) {
      int dmg =
          dice.nextInt((this.getUpperDamage() - this.getLowerDamage()) + 1) + this.getLowerDamage();
      System.out.println("Damage dealt " + dmg);
      target.setCurrentHealth(target.getCurrentHealth() - dmg);
      System.out.println(
          "Target ( " + target.getName() + " ) health is: " + target.getCurrentHealth());
      if (target.getCurrentHealth() <= 0) {
        target.setDead(true);
        System.out.println("Target ( " + target.getName() + " ) is Dead");
      }
    } else {
      System.out.println("Miss");
    }
    System.out.println("============");
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    if (checkBounds(attack)) {
      this.attack = attack;
    }
  }

  public int getDefence() {
    return defence;
  }

  public void setDefence(int defence) {
    if (checkBounds(defence)) {
      this.defence = defence;
    }
  }

  public int getMaxHealth() {
    return this.maxHealth;
  }

  public int getCurrentHealth() {
    return this.currentHealth;
  }

  public void setMaxHealth(int health) {
    this.maxHealth = health;
  }

  public void setCurrentHealth(int health) {
    if (health > this.getMaxHealth()) {
      this.currentHealth = this.maxHealth;
    } else {
      this.currentHealth = health;
    }
  }

  public int getLowerDamage() {
    return lowerDamage;
  }

  public int getUpperDamage() {
    return upperDamage;
  }

  public void setLowerDamage(int lowerDamage) {
    this.lowerDamage = lowerDamage;
  }

  public void setUpperDamage(int upperDamage) {
    this.upperDamage = upperDamage;
  }

  public void setDamage(int lower, int upper) {
    this.lowerDamage = lower;
    this.upperDamage = upper;
  }

  public boolean isDead() {
    return isDead;
  }

  public void setDead(boolean dead) {
    isDead = dead;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private boolean checkBounds(int value) {
    if (value >= 1 && value <= 30) {
      return true;
    } else throw new RuntimeException("Value can be from 1 to 30 only.");
  }
}
