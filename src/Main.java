import creatures.Monster;
import creatures.Player;

public class Main {
  public static void main(String[] args) {
    Player player = new Player(20, 20, 100, 1, 6);
    Monster monsterWeak = new Monster(1, 1, 1, 1, 2, "Lil monster");
    Monster monsterStrong = new Monster(30, 30, 300, 10, 30, "Stronk monster");

    player.attack(monsterWeak);
    player.attack(monsterStrong);
    player.attack(monsterWeak);
    monsterStrong.attack(player);
    player.heal();
    player.heal();
    monsterStrong.attack(player);
    monsterStrong.attack(player);
    monsterStrong.attack(player);
    player.heal();
    player.heal();
    player.heal();
    //Player player2 = new Player(20, 31, 100, 1, 6);
  }
}
