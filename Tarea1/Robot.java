public class Robot {
    private String nombre;
    private int puntosVida;  // vida entre 50 y 100
    private int ataque;      // ataque entre 10 y 20

    // Constructor
    public Robot(String nombre, int puntosVida, int ataque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    //setters
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }

    public void setPuntosVida(int puntosVida){
        this.puntosVida = puntosVida;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;

    }

    // Método para atacar a otro robot
    public void atacar(Robot otroRobot) {
        if (this.estaVivo() && otroRobot.estaVivo()) {
            otroRobot.puntosVida -= this.ataque;
            if (otroRobot.puntosVida < 0) {
                otroRobot.puntosVida = 0;
            }
            System.out.println(this.nombre + " ataca a " + otroRobot.nombre + " causando " + this.ataque + " de daño.");
        }
    }

    // Método para saber si el robot sigue vivo
    public boolean estaVivo() {
        return puntosVida > 0;
    }

    
}