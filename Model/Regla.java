package Model;

public class Regla {
    String cadena = "primero";

    public Regla() {

    }

    public void metodo1(int valor) throws Exception {
        this.metodo2(valor);
        this.cadena = "segundo";
    }

    public void metodo2(int valor) throws Exception {
        if (valor == 1) {
            throw new Exception("entra");
        }
    }
}
