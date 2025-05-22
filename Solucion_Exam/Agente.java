import java.util.Random;
public class Agente {
    private int id;
    private int fila;
    private int columna;
    private ColaDeMensajes colaMensajes;
    private MatrizComida matriz;
    private Random aleatorio;

    //Constructor del agente 
    public Agente(int id, int filaInicial, int columnaInicial, ColaDeMensajes colaMensajes, MatrizComida matriz) {
        this.id = id;
        this.fila = filaInicial;
        this.columna = columnaInicial;
        this.colaMensajes = colaMensajes;
        this.matriz = matriz;
        this.aleatorio = new Random();
    }
    //Método para mover aleatorio 
    public void moverAleatorio(Agente[] todosLosAgentes) {
        int nuevaFila, nuevaColumna;
        do {
            int df = aleatorio.nextInt(3) - 1; 
            int dc = aleatorio.nextInt(3) - 1;
            nuevaFila = fila + df;
            nuevaColumna = columna + dc;
        } while (!matriz.enRango(nuevaFila, nuevaColumna));

        // Revisar si hay comida
        if (matriz.getMatriz()[nuevaFila][nuevaColumna] > 0) {
            System.out.println("Agente Insecto " + id + " recolectó comida en (" + nuevaFila + "," + nuevaColumna + ")");
            matriz.getMatriz()[nuevaFila][nuevaColumna] = 0;

            // Enviar mensaje a todos los otros agentes
            for (Agente otro : todosLosAgentes) {
                if (otro.getId() != this.id) {
                    enviarMensaje(otro.getId(), "Recolecté comida en (" + nuevaFila + "," + nuevaColumna + ")");
                }
            }
        } else {
            System.out.println("Agente Insecto " + id + " se movió a celda vacía (" + nuevaFila + "," + nuevaColumna + ")");
        }

        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    //Método para enviiar un mensaje 
    public void enviarMensaje(int idDestinatario, String contenido) {
        Mensaje nuevoMensaje = new Mensaje(0, id, idDestinatario, contenido);
        colaMensajes.agregarMensaje(nuevoMensaje);
    }
    //Método para procesar los mensajes 
    public void procesarMensajes() {
        Mensaje mensajeActual = colaMensajes.siguienteMensaje(id);
        while (mensajeActual != null) {
            System.out.println("Agente Insecto " + id + " recibió: " + mensajeActual);
            colaMensajes.extraerMensaje(id);
            mensajeActual = colaMensajes.siguienteMensaje(id);
        }
    }
    //Getter del id 
    public int getId() {
        return id;
    }
}
