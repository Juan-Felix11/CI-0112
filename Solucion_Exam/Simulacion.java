public class Simulacion {
    public static void main(String[] args) {

        // Inicializa una nueva cola de mensajes, una nueva matriz mas pequeña, y le
        // distribuye comida
        ColaDeMensajes colaGlobal = new ColaDeMensajes();
        MatrizComida matriz = new MatrizComida(10, 10);
        matriz.distribuirComida(30);
        
        // Inicializa 5 agentes
        Agente[] agentes = new Agente[5];
        agentes[0] = new Agente(1, 0, 0, colaGlobal, matriz);
        agentes[1] = new Agente(2, 9, 9, colaGlobal, matriz);
        agentes[2] = new Agente(3, 0, 9, colaGlobal, matriz);
        agentes[3] = new Agente(4, 9, 0, colaGlobal, matriz);
        agentes[4] = new Agente(5, 5, 5, colaGlobal, matriz);

        // Imprime la matriz inicial
        System.out.println(" MATRIZ DE COMIDA INICIAL ");
        matriz.imprimirMatriz(0, 9, 0, 9);

        // Turnos de simulación
        for (int turno = 1; turno <= 5; turno++) {
            System.out.println("\n TURNO " + turno);

            for (Agente agente : agentes) {
                agente.moverAleatorio(agentes);
            }

            for (Agente agente : agentes) {
                agente.procesarMensajes();
            }
        }
        // Imprime la matriz de comida final
        System.out.println("\n MATRIZ DE COMIDA FINAL");
        matriz.imprimirMatriz(0, 9, 0, 9);
    }
}
