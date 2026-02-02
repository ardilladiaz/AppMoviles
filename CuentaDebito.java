//Subclase: Especializada para implementarla como una cuenta de débito 

public class CuentaDebito extends CuentaBancaria implements OperacionesFinancieras {

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Ingreso exitoso. Nuevo saldo: $" + this.saldo);
        } else {
            System.out.println("Error: El monto debe ser positivo.");
        }
    }

    @Override
    public boolean retirar(double monto) {
        // Lógica: No permitir que el saldo quede en negativo
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso. Saldo restante: $" + this.saldo);
            return true;
        } else {
            System.out.println("Error: Saldo insuficientes o monto inválido.");
            return false;
        }
    }
}


