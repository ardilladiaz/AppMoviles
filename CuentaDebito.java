

//Subclase: Especializada para implementarla como una cuenta de débito 

public class CuentaDebito extends CuentaBancaria {

    // Método para administración de fondos: Ingreso
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Transacción exitosa: Depósito realizado.");
        }
    }

    // Método para administración de fondos: Retiro
    public boolean retirar(double monto) {
        // Validación: El saldo nunca debe quedar en negativo
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }
}