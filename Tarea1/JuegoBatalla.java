import java.util.Scanner;
import java.util.Random;

public class JuegoBatalla {
    private Robot[] robots;

    public void iniciarBatalla() {
        Random random = new Random();

        while (robotsVivos() > 1) {
            int atacante = random.nextInt(robots.length);
            int defensor = random.nextInt(robots.length);

            if (atacante != defensor && robots[atacante].estaVivo() && robots[defensor].estaVivo()) {
                robots[atacante].atacar(robots[defensor]);

                if (!robots[defensor].estaVivo()) {
                    System.out.println(robots[defensor].getNombre() + " ha sido destruido. \n");

                } else {
                    System.out.println("Vida restante de " + robots[defensor].getNombre() + ": "
                            + robots[defensor].getPuntosVida() + "\n");
                }
            }

        }

    }

    // Método para mostrar al robot ganador
    public void mostrarGanador() {
        for (Robot rb : robots) {
            if (rb.estaVivo()) {
                System.out.println(rb.getNombre() + " ha ganado la batalla!!!");
                return;
            }

        }
    }

    // Método para contar los robots vivos
    private int robotsVivos() {
        int vivos = 0;
        for (Robot rb : robots) {
            if (rb.estaVivo())
                vivos++;

        }
        return vivos;
    }

    // Método main, como corre el programa
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        JuegoBatalla juego = new JuegoBatalla(); // Se crea un objeto del juego

        int cantidad;
        do {
            System.out.println("Cuántos robots participarán en la batalla? (2 a 10)");
            cantidad = escaner.nextInt();
            escaner.nextLine();
            if (cantidad < 2 || cantidad > 10) {
                System.out.println("La cantidad es incorrecta, deber de ser de entre 2 a 10");
            }

        } while (cantidad < 2 || cantidad > 10);

        juego.robots = new Robot[cantidad]; 

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Registrando robot #" + (i + 1));

            System.out.println("¿Cuál es el nombre del robot? ");
            String nombre = escaner.nextLine();

            int vida;
            do {
                System.out.println("¿Cuál es la vida de:  " + nombre + "?" + " (Tiene que ser de entre 50 y 100) ");
                vida = escaner.nextInt();
                if (vida < 50 || vida > 100) {
                    System.out.println("Vida inválida. \n");
                }
            } while (vida < 50 || vida > 100);

            int ataque;
            do {
                System.out.println("¿De cuánto es el poder de " + nombre + "?" + " (Tiene que ser de entre 10 y 20)");
                ataque = escaner.nextInt();
                if (ataque < 10 || ataque > 20) {
                    System.out.println("El poder de ataque no es válido \n");
                }
            } while (ataque < 10 || ataque > 20);

            escaner.nextLine();
            juego.robots[i] = new Robot(nombre, vida, ataque);
        }
        System.out.println("\n ¡¡¡Comienza la batalla!!!");
        juego.iniciarBatalla();
        juego.mostrarGanador();
        escaner.close();
    }

}
