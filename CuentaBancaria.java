

//Superclase: Define los atributos y métodos comunes

public class CuentaBancaria {
    // Atributo protegido para que las subclases puedan heredarlo
    protected double saldo;

    public CuentaBancaria() {
        // La problemática propuesta sugiere que el saldo inicie en 0
        this.saldo = 0.0;
    }

    // Método común para todas las cuentas
    public double getSaldo() {
        return this.saldo;
    }
}
