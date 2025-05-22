public class Mensaje {
    private int idFuente;
    private int idEmisor;
    private int idDestinatario;
    private String contenido;

    // Constructor del Mensaje
    public Mensaje(int idFuente, int idEmisor, int idDestinatario, String contenido) {
        this.idFuente = idFuente;
        this.idEmisor = idEmisor;
        this.idDestinatario = idDestinatario;
        this.contenido = contenido;
    }

    // Getters
    public int getIdFuente() {
        return idFuente;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public String getContenido() {
        return contenido;
    }
    //toString para que la presentacon del mensaje se vea bien 
    public String toString() {
        return "De: " + idEmisor + " Para: " + idDestinatario + " Contenido: " + contenido;
    }

}