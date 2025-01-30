package pokemon;

import attacks.Attack;
import java.util.List;

public class Pokemon {
    private String name;
    private int hp;
    private List<Attack> attacks;

    public Pokemon(String name, int hp, List<Attack> attacks) {
        this.name = name;
        this.hp = hp;
        this.attacks = attacks;
    }

    public boolean isDefeated() {
        return hp <= 0;
    }

    public void attack(Pokemon target, Attack attack) {
        System.out.println(name + " usa " + attack.getName() + "!");
        target.receiveDamage(attack.getBaseDamage());
    }

    private void receiveDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    // Mostrar lista de ataques disponibles
    public void showAttacks() {
        for (int i = 0; i < attacks.size(); i++) {
            System.out.println((i + 1) + ". " + attacks.get(i).getName() + " (Poder: " + attacks.get(i).getBaseDamage() + ")");
        }
    }

    // Obtener la cantidad de ataques disponibles
    public int getAttackCount() {
        return attacks.size();
    }

    // Obtener un ataque específico por índice
    public Attack getAttack(int index) {
        if (index >= 0 && index < attacks.size()) {
            return attacks.get(index);
        }
        return null;
    }

    @Override
    public String toString() {
        return name + " - HP: " + hp;
    }
}


 




