package main;

import attacks.Attack;
import pokemon.Pokemon;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear un ataque de prueba
        Attack thunderbolt = new Attack("Thunderbolt", 50);
        Attack tackle = new Attack("Tackle",30);



        //Crear Pokemon de prueba
        Pokemon pikachu = new Pokemon("Pikachu", 100, Arrays.asList(thunderbolt));
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 100, Arrays.asList(tackle));

        //Mostrar estado inicial
        System.out.println(pikachu);
        System.out.println(bulbasaur);

         // Iniciar batalla - necesitas ajustarse, queda pennnnnndiente
        // Ejemplo simple de batalla
        pikachu.attack(bulbasaur, thunderbolt);  // Pikachu usa Thunderbolt
        bulbasaur.attack(pikachu, tackle);        // Bulbasair usa Tackle
    }
}
