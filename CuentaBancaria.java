

//Superclase: Define los atributos y métodos comunes

public abstract class CuentaBancaria {
    // Atributo protegido para ser accedido por las subclases
    protected double saldo;

    public CuentaBancaria() {
        // Requerimiento: El saldo debe iniciar en 0
        this.saldo = 0.0;
    }

    // Proporciona el saldo actual de la cuenta
    public double getSaldo() {
        return this.saldo;
    }
}