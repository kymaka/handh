package creatures;

public class Player extends Creature {

  public Player(int attack, int defence, int health, int lowerDamage, int upperDamage) {
    super(attack, defence, health, lowerDamage, upperDamage, "Player");
    this.healsCount = 4;
  }

  private int healsCount;

  public void heal() {
    if (healsCount != 0) {
      if (this.getCurrentHealth() != this.getMaxHealth()) {
        this.setCurrentHealth((int) (this.getCurrentHealth() + this.getMaxHealth() * 0.3));
        System.out.println("Player is healed. Health is " + this.getCurrentHealth());
        healsCount--;

        System.out.println("Healing potions left: " + healsCount);
      } else {
        System.out.println("Health is full.");
      }
    } else {
      System.out.println("No healing potions left.");
    }
  }
}
