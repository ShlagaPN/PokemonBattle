package pokemon;


import attacks.Attack;
import java.util.List;


public class Pokemon {
    private String name;
    private int health;
    private List<Attack> attacks;

    public Pokemon(String name, int health, List<Attack> attacks) {
        this.name = name;
        this.health = health;
        this.attacks = attacks;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    //metodo para recibir daño
    public void receiveDamage (int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0; //para evitar numeros negativos
    }

    //metodo par atacar
    public void attack(Pokemon opponent, Attack attack) {
        int damage = attack.getBaseDamage();
        System.out.println(this.name + " usó " + attack.getName() + "!");
        System.out.println("Daño base " + attack.getBaseDamage());
        opponent.receiveDamage(damage);
        System.out.println(opponent.getName() + " recibió " + damage + " de daño. Salud restante: " + opponent.getHealth());

    }

    //metodo toString para mostrar info
    @Override
    public String toString() {
        return name + " - Salud: " + health;

    }







}
