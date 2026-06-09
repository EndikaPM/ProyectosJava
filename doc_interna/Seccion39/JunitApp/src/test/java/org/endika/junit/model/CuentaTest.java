package org.endika.junit.model;

import org.endika.junit.excetions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


class CuentaTest {
    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        this.cuenta  = new Cuenta("Andres", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        System.out.println("Iniciando metodo");

        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName()+ " "+ testInfo.getTestMethod().orElse(null).getName() +
                " con las etiquetas "+ testInfo.getTags());
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
    @Tag("Cuenta")
    void testNombreCuenta() {


        System.out.println(testInfo.getTags());

        if (testInfo.getTags().contains("cuenta")) System.out.println("Hacer algo si la contiene");
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

    @Nested
    class SistemaOperativoTest{
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

    }

    @Nested
    class JavaVersionTest{
        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void SoloJDK8() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_21)
        void TestNoJDK21() {
        }
    }

    @Nested
    class SystemProperties{
        @Test
        void ImprimirSystremPropertiesTest() {
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
    }

    @Nested
    class VariablesAmbienteTest{
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



    @Test
    void testSaldoCuentaDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testSaldoCuentaDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, ()-> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        });
        System.out.println("Independientemente de que el sea true o false el resto del codigo\n " +
                "Se ejecute y lo que pongas aquí se va a a ejecutar.");

    }

    // Se repite el metodo es util cuando tienes algún atributo aleatorio
    @DisplayName("Probando Debito Cuenta Repetir!")
    @RepeatedTest(value = 5, name="{displayname} - Repeticion numero {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
//Los parametros se pasan como argumentos son paramewtros de Junit para sacar informacion de la repetiocion o mas parametros
        if(info.getCurrentRepetition() == 3){
            System.out.println("esta es la repetición " + info.getCurrentRepetition());
        }

        this.cuenta.debito(new BigDecimal(100));

        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest{
        @ParameterizedTest(name="numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500","700","1000.12345"})// pueden ser float  o lo que necesitas
        void testDebitoCuentaValueSource(String monton) {

            cuenta.debito(new BigDecimal(monton));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) >= 0);

        }

        @ParameterizedTest(name="numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1, 100", "2, 200", "3, 300", "4, 500","5, 700","6, 1000.12345"})
        void testDebitoCuentaCSVSource(String index, String monto) {
            System.out.println(index + "-> " + monto);

            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) >= 0);

        }

        @ParameterizedTest(name="numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCSVFileSource( String monto) {

            cuenta.debito(new BigDecimal(monto));

            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) >= 0);

        }
        @ParameterizedTest(name="numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200, 100, John, Andres", "250, 200, Maria, MAria", "300, 300,  John, John", "510, 500, Andres, Andres"
                ,"750, 700, Pepe, Pepe","1000.12345, 1000.12345, John, Jhon"})
        void testDebitoCuentaCSVSource2(String saldo, String monto, String nombreEsperado, String nombreActual) {
            System.out.println(saldo + "-> " + monto);

            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(nombreActual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(cuenta.getPersona(), nombreEsperado);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);

        }
    }

    @Tag("param")
    @ParameterizedTest(name="numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("MontoList")
    void testDebitoCuentaMethodSource( String monto) {

        this.cuenta.debito(new BigDecimal(monto));

        assertNotNull(cuenta.getSaldo());
        assertTrue(this.cuenta.getSaldo().compareTo(BigDecimal.ZERO) >= 0);

    }


    private static List<String> MontoList(){
        return Arrays.asList("100", "200", "300", "500","700","1000.12345");
    }

    @Nested
    @Tag("timeOut")
    class EjemploTimeOutTest{
        @Test
        @Timeout(1)
        void PruebaTimeOut() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 1000, unit = TimeUnit.MICROSECONDS)
        void PruebaTimeOut2() throws InterruptedException {
            TimeUnit.MICROSECONDS.sleep(900);
        }

        @Test
        void testTimeOutAssertions() {
            assertTimeout(Duration.ofSeconds(5), () ->{
                TimeUnit.MICROSECONDS.sleep(4000);
            });
        }
    }
}