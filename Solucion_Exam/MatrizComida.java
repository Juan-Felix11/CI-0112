import java.util.Random;

public class MatrizComida {
    private int[][] matriz;
    private int filas;
    private int columnas;
    private Random generador;

    // Constructor
    public MatrizComida(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
        generador = new Random();
    }

    // Método para distribuir la comida
    public void distribuirComida(int cantidadCeldas) {

        for (int i = 0; i < cantidadCeldas; i++) {
            int fila = generador.nextInt(filas);
            int columna = generador.nextInt(columnas);

            // Suma 1, si las vecinas estan vacías
            if (todasVecinasVacias(fila, columna)) {
                matriz[fila][columna] += 1;
                // Sino suma todas la vecinas
            } else {
                matriz[fila][columna] += sumaVecinas(fila, columna);
            }
        }
    }

    // Método para ver si las vecinas estan vacias
    private boolean todasVecinasVacias(int fila, int columna) {
        for (int desplazamientoFila = -1; desplazamientoFila <= 1; desplazamientoFila++) {
            for (int desplazamientoColumna = -1; desplazamientoColumna <= 1; desplazamientoColumna++) {
                int filaVecina = fila + desplazamientoFila;
                int columnaVecina = columna + desplazamientoColumna;

                if (enRango(filaVecina, columnaVecina) && matriz[filaVecina][columnaVecina] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método que suma todas las vecinas
    private int sumaVecinas(int fila, int columna) {
        int suma = 0;
        for (int desplazamientoFila = -1; desplazamientoFila <= 1; desplazamientoFila++) {
            for (int desplazamientoColumna = -1; desplazamientoColumna <= 1; desplazamientoColumna++) {
                if (desplazamientoFila == 0 && desplazamientoColumna == 0)
                    continue;

                int filaVecina = fila + desplazamientoFila;
                int columnaVecina = columna + desplazamientoColumna;

                if (enRango(filaVecina, columnaVecina)) {
                    suma += matriz[filaVecina][columnaVecina];
                }
            }
        }
        return suma;
    }

    // Ve si las coordenas estan dentro de la matriz o no
    public boolean enRango(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    // Getter para la matriz
    public int[][] getMatriz() {
        return matriz;
    }

    // Imprime la matriz
    public void imprimirMatriz(int filaInicio, int filaFin, int columnaInicio, int columnaFin) {
        for (int fila = filaInicio; fila <= filaFin; fila++) {
            for (int columna = columnaInicio; columna <= columnaFin; columna++) {
                System.out.print(matriz[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
