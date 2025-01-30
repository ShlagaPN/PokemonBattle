package main;

import attacks.Attack;
import java.util.Arrays;
import java.util.Scanner;
import pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear ataques
        Attack thunderbolt = new Attack("Thunderbolt", 50);
        Attack tackle = new Attack("Tackle", 30);
        Attack vineWhip = new Attack("Vine Whip", 40);
        Attack quickAttack = new Attack("Quick Attack", 20);

        // Crear Pokémon con múltiples ataques
        Pokemon pikachu = new Pokemon("Pikachu", 100, Arrays.asList(thunderbolt, quickAttack));
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 100, Arrays.asList(tackle, vineWhip));

        // Mostrar estado inicial
        System.out.println("Estado inicial:");
        System.out.println(pikachu);
        System.out.println(bulbasaur);

        // Sistema de turnos
        boolean isBattleOver = false;
        boolean pikachuTurn = true; // Define quién comienza

        while (!isBattleOver) {
            System.out.println("\n--- Nuevo turno ---");

            if (pikachuTurn) {
                System.out.println("Turno de Pikachu");
                pikachu.showAttacks();
                System.out.print("Elige un ataque (1-" + pikachu.getAttackCount() + "): ");
                int choice = scanner.nextInt() - 1;

                Attack chosenAttack = pikachu.getAttack(choice);
                if (chosenAttack != null) {
                    pikachu.attack(bulbasaur, chosenAttack);
                } else {
                    System.out.println("Selección inválida, se pierde el turno.");
                }
            } else {
                System.out.println("Turno de Bulbasaur");
                bulbasaur.showAttacks();
                System.out.print("Elige un ataque (1-" + bulbasaur.getAttackCount() + "): ");
                int choice = scanner.nextInt() - 1;

                Attack chosenAttack = bulbasaur.getAttack(choice);
                if (chosenAttack != null) {
                    bulbasaur.attack(pikachu, chosenAttack);
                } else {
                    System.out.println("Selección inválida, se pierde el turno.");
                }
            }

            // Mostrar estado actual de los Pokémon
            System.out.println("\nEstado actual:");
            System.out.println(pikachu);
            System.out.println(bulbasaur);

            // Verificar si el combate ha terminado
            if (pikachu.isDefeated()) {
                System.out.println("\nPikachu ha sido derrotado. ¡Bulbasaur gana!");
                isBattleOver = true;
            } else if (bulbasaur.isDefeated()) {
                System.out.println("\nBulbasaur ha sido derrotado. ¡Pikachu gana!");
                isBattleOver = true;
            }

            // Alternar turno
            pikachuTurn = !pikachuTurn;

            // Pausa opcional para que el usuario presione Enter antes de continuar
            if (!isBattleOver) {
                System.out.println("Presiona Enter para continuar al siguiente turno...");
                scanner.nextLine();
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}

