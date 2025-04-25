public class Robots {
    private String nombre;
    private int puntosVida;
    private int ataque;

    // constructor
    public Robots(String nombre, int puntosVida, int ataque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getPuntosVida() {
        return this.puntosVida;
    }

    // ver si esta vivo
    public boolean estaVivo() {
        return puntosVida > 0;
    }
}