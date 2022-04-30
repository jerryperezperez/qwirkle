package Model;

public class ExcepcionCasilla extends Exception {

    public Casilla errorCasilla() {

            System.out.println("ENTRA EN EXCEPCION");
            return new Casilla();

    }
}
