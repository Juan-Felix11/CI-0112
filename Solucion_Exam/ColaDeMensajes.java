public class ColaDeMensajes {
    private static final int MAX = 100;
    private Mensaje[] cola;
    private int frente;
    private int fin;
    private int cantidad;

    //Constructor
    public ColaDeMensajes(){
        cola = new Mensaje[MAX];
        frente = 0;
        fin = 0;
        cantidad = 0;
    }

    public boolean estaVacia(){
        return cantidad == 0;
    }

    public boolean estaLlena(){
        return cantidad == MAX;
    }

    public boolean agregarMensaje(Mensaje mensaje){
        if (estaLlena()) return false;
        cola[fin] = mensaje;
        fin = (fin + 1) % MAX;
        cantidad ++;
        return true;
    }

    //Devuelve el primer mensaje dirigido a un agente sin eliminarlo
    public Mensaje siguienteMensaje(int idAgente){
        if (estaVacia()) return null;
        for (int i = 0; i < cantidad; i++){
            int indice = (frente + i) % MAX;
            if (cola[indice] != null && cola[indice].getIdDestinatario() == idAgente){ 
            return cola[indice];
            }
        }
        return null;
    }

    //Elimina y devuelve el primer mensaje dirigido a un agente 
    public Mensaje extraerMensaje(int idAgente){
        for (int i = 0; i < cantidad; i++){
            int indice = (frente + i) % MAX;
            if (cola[indice] != null && cola[indice].getIdDestinatario() == idAgente){
                Mensaje mensaje = cola[indice];
                for (int j = indice; j != fin; j = (j + 1) % MAX){
                    int siguiente = (j + 1) % MAX;
                    cola[j] = cola[siguiente];
                }
                fin = (fin - 1 + MAX) % MAX;
                cantidad --;
            }
        }
        return null;
    }
    


    
}
