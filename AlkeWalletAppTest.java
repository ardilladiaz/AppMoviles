
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class AlkeWalletAppTest {

    private CuentaDebito cuenta;

    @BeforeEach
    @DisplayName("Inicializar cuenta antes de cada prueba")
    void setUp() {
        // Inicializamos una cuenta nueva antes de cada prueba (Saldo inicia en 0)
        cuenta = new CuentaDebito();
    }

    @Test
    @DisplayName("Validar suma correcta de ingresos al depositar")
    void testDepositar() {
        cuenta.depositar(5000.0);

        // Validamos que el saldo impacte correctamente
        assertEquals(5000.0, cuenta.getSaldo(), 
            "El saldo debería ser 5000 después del depósito.");
    }

    @Test
    @DisplayName("Bloquear retiros cuando el monto supera el saldo disponible")
    void testRetiroConFondosInsuficientes() {
        cuenta.depositar(3000.0);
        
        // Intentamos retirar más de lo permitido (4000 > 3000)
        boolean resultado = cuenta.retirar(4000.0);
        
        // Verificamos que el sistema bloquee la operación
        assertFalse(resultado, 
            "El retiro debería ser rechazado por fondos insuficientes.");
        assertEquals(3000.0, cuenta.getSaldo(), 
            "El saldo no debería cambiar tras un retiro fallido.");
    }

    @Test
    @DisplayName("Validar precisión decimal en conversión de divisas")
    void testPrecisionConversion() {
        cuenta.depositar(10000.0); // 10.000 CLP
        double valorDolar = 873.36;
        double resultadoEsperado = 10000.0 / valorDolar; // ~11.4500
        
        double saldoEnDolares = cuenta.getSaldo() / valorDolar;
        
        // Validamos la precisión con un margen de error de 0.01
        assertEquals(resultadoEsperado, saldoEnDolares, 0.01, 
            "La conversión a dólares debe mantener la precisión decimal requerida.");
    }
    
    @Test
    @DisplayName("Validar que no se puedan depositar montos negativos")
    void testDepositoNegativo() {
        double saldoInicial = cuenta.getSaldo();
        cuenta.depositar(-1000.0);
        
        assertEquals(saldoInicial, cuenta.getSaldo(), 
            "No se deberían aceptar depósitos con montos negativos.");
    }
    
    @Test
    @DisplayName("Validar retiro exitoso con saldo suficiente")
    void testRetiroExitoso() {
        cuenta.depositar(5000.0);
        boolean resultado = cuenta.retirar(2000.0);
        
        assertTrue(resultado, "El retiro debería ser exitoso.");
        assertEquals(3000.0, cuenta.getSaldo(), 
            "El saldo debería ser 3000 después del retiro.");
    }


}
