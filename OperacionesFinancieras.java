//Interfaz que define las operaciones básicas
public interface OperacionesFinancieras {


	//Define la firma para el ingreso de dinero.
    void depositar(double monto);


    //Define la firma para el retiro de dinero.
    //@return true si la operación es exitosa.
    boolean retirar(double monto);
}