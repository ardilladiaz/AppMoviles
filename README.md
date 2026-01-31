<h1>Proyecto Alke Wallet</h1>

<h2>1. Arquitectura y Estructura del Código</h2>
<p>El sistema utiliza una arquitectura modular fundamentada en los principios de la <strong>Paradigma de Orientación a Objetos</strong> para garantizar la escalabilidad y el mantenimiento.</p>
        
<h3>Diagrama de Clases:</h3>
<ul>
<li><strong>CuentaBancaria</strong> <em>(Superclase)</em>: Define el atributo protegido <em>saldo</em> y el método <em>getSaldo()</em>. Establece que toda cuenta nueva inicia con un saldo de 0.0.</li>
<li><strong>OperacionesFinancieras</strong> <em>(Interfaz)</em>: Define las firmas de los métodos <em">depositar</em> y <em">retirar</em>, permitiendo la reutilización de código y estandarización de procesos.</li>
<li><strong>CuentaDebito</strong> <em>(Subclase)</em>: Implementa la lógica específica. Se asegura de que no se realicen depósitos negativos y que los retiros no superen el saldo disponible, evitando saldos negativos.</li>
</ul>

<h2>2. Funcionalidades Implementadas</h2>
<p>El programa principal (<em>AlkeWalletApp.java</em>) gestiona el flujo de usuario a través de una aplicación de consola.</p>
        
<ul>
<li><strong>Administración de Fondos</strong>: Permite la creación de una cuenta (vía <em>registro/login</em>), visualización de <em>saldo</em>, <em>ingresos</em> y <em>retiros</em>.</li>
<li><strong>Conversión de Moneda</strong>: Incluye un menú de operaciones para visualizar el saldo en <em>Dólares</em> (USD) y <em>Euros</em> (EUR).</li>
<li><strong>Valores de conversión</strong>: USD = 873.36 | EUR = 1028.22 (Viernes 30/ Enero).</li>
<li><strong>Estructuras de Control</strong>: Se utilizan bucles <em>while</em> y <em>do-while</em> para la persistencia del menú y validación de credenciales, junto con sentencias <em>switch</em> para la selección de operaciones.</li>
</ul>

<h2>3. Calidad y Pruebas Unitarias</h2>
<p>Para garantizar un software confiable, se implementaron testeos utilizando <em>JUnit 5</em>.</p>
        
<h3>Validaciones Críticas:</h3>
<ul>
<li>Suma correcta de ingresos tras un depósito.</li>
<li>Bloqueo de retiros cuando el monto supera el saldo disponible.</li>
<li>Precisión decimal en la conversión de divisas (margen de error de 0.01).</li>
<li>Rechazo de depósitos con montos negativos.</li>
<li>Validar retiro exitoso con saldo suficiente.</li>
</ul>

<h2>4. Estándares de Codificación y Documentación</h2>
<p>Se aplicaron buenas prácticas de desarrollo para asegurar la legibilidad del código:</p>
        
<ul>
<li><strong>Convención de Nombres</strong>: Uso de <em>CamelCase</em> para clases (ej. <em>CuentaBancaria</em>) y para métodos y variables (ej. <em>menuOperaciones</em>).</li>
<li><strong>Comentarios en el código</strong>: Se emplearon comentarios para explicar la lógica interna y en métodos clave para facilitar la lectura y entendimiento.</li>
<li><strong>Legibilidad del Código</strong>: Siguiendo las buenas prácticas de programación, se organizó el código en clases separadas y métodos con responsabilidades únicas para facilitar el mantenimiento.</li>
</ul>
