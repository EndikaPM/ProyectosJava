package org.endika.junit.model;

import org.endika.junit.excetions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;


class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest(){
        this.cuenta  = new Cuenta("Andres", new BigDecimal("1000.12345"));
        System.out.println("Iniciando metodo");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el metodo");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("inicializando el test -Para iniciar un recurso o una conexion");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test -para cerrar un recurso.");
    }

    @Test
    @DisplayName("Probando nombre de la cuenta")// Asi describes lo que hace para que aparezca en pantalla
    void testNombreCuenta() {

        //cuenta.setPersona("Andres");
        String esperado = "Andres";
        String real = cuenta.getPersona();

        assertNotNull(real, () -> "La cuenta no puede ser nula");/* () -> con esta lamba lo que pasas es una invocación futura de un mensaje de error
        que solo carga el String si falla si no no carga el String en memoria mas eficiente  */
        assertEquals(esperado, real, () -> "El nombre no es lo que se esperaba");//assert es como afirmar que algo es Equals Igual
        assertTrue(real.equals("Andres"));
    }

    @Test
    void testSaldoCuenta() {
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.997"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.997"));

        //assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);
    }

    @Test
    void testDebitoCuenta() {

        this.cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        this.cuenta.credito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void dineroInsuficienteException() {

        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });

        String actual = exception.getMessage();
        String esperado = "Dinero insuficiente";

        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuenta() {
        Cuenta origen = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta destino = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setName("Banco del Estado");
        banco.transferir(origen, destino, new BigDecimal("500"));

        assertEquals("2000", origen.getSaldo().toPlainString());
        assertEquals("2000.8989", destino.getSaldo().toPlainString());
    }

    @Test
    @Disabled//para saltar el metodo que falla si quieres seguir desarrollando y ya lo comprobarás
    void testRelacionBancoCuenta() {
        fail();// esto fuerza que el método falle
        Cuenta origen = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta destino = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(origen);
        banco.addCuenta(destino);
        banco.setName("Banco del Estado");

        assertAll(
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco del Estado", origen.getBanco().getName()),
                () -> assertEquals("Andres", banco.getCuentas().stream()
                                .filter(c -> c.getPersona().equals("Andres"))
                                .findFirst()
                                .get().getPersona()),
                //Estos dos metodos el de arriba y el de abajo son dos formas de llegar al mismo punto
                () -> assertTrue(banco.getCuentas().stream()
                                .anyMatch(c -> c.getPersona().equals("John Doe")))
        );

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void TestSoloWindows() {
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    void TestSoloMacLinux() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void TestnoWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void SoloJDK8() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_21)
    void TestNoJDK21() {
    }

    @Test
    void ImprimirSystremProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    // Una expresión regular para comparar sería .*23.* para decirle todas las que sean versión 23. la que sea...
    @EnabledIfSystemProperty(named = "java.version", matches = "23")
    void JavaVersion() {

    }

    @Test// los mismo se des1habilita si no es una arquitectura X64
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void DisableSiESArquitectura32() {
    }

    @Test
    void ImprimirVariavlesAmbiente() {
        Map<String, String> getenv = System.getenv();
        getenv.forEach((k,v) -> System.out.println(k +": "+ v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "COMPUTERNAME", matches = "MSI_754I13447" )
    void TestJavaHome() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "12")
    void TestNumberProcesor() {
    }
}