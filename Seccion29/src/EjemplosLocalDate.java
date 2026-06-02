import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemplosLocalDate {
    public static  void main(String[]args){
        //------------------ para sacar la fecha de hoy--------------------
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        // --------------------para generar la que yo quiera------------------
        LocalDate gererarFecha = LocalDate.of(2025, 01,15);
        System.out.println("gererarFecha = " + gererarFecha);
        LocalDate gererarFecha2 = LocalDate.of(2025, Month.JANUARY,18);
        System.out.println("gererarFecha2 = " + gererarFecha2);
        // ---------------------Generar y parsear de un String-------------------------------
        gererarFecha = LocalDate.parse("2025-09-21");
        System.out.println("gererarFecha Parseada de String = " + gererarFecha);
        String fechaConFormatoPersonal = "20/09/2025";
        DateTimeFormatter miFormatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // ***Siempre Primero ~~-La fecha -~~ y después ~~El FORMATO QUE SE TRASFORMA~~***
        gererarFecha2 = LocalDate.parse(fechaConFormatoPersonal, miFormatoFecha);
        System.out.println("miFormatoFecha parseadfo desde String \"Muy Util\" = " + gererarFecha2);
        // ---------------------Sumar y restar DIA MES Y AÑO facil-------------------------------
        LocalDate sumarDiaMesAno = LocalDate.now().plusDays(1);// sumas x dias
        System.out.println("1 dia mas = " + sumarDiaMesAno);
        sumarDiaMesAno.minusDays(2);// restas x dias
        System.out.println("2 Dias menos = " + sumarDiaMesAno);
        sumarDiaMesAno.plusMonths(1);// sumas X meses
        System.out.println("1 mes mas =  " + sumarDiaMesAno);
        sumarDiaMesAno.minusMonths(2);// respas X meses
        System.out.println("2  meses menos = " + sumarDiaMesAno);
        sumarDiaMesAno.plusYears(1);// sumas X años
        System.out.println("1 Año mas = " + sumarDiaMesAno);
        sumarDiaMesAno.minusYears(2);// Restas X años
        System.out.println("2 meses menos = " + sumarDiaMesAno);
        // ---------------------utilizando ChronoUnir ---------------------------------------
        sumarDiaMesAno.minus(1, ChronoUnit.MONTHS);
        sumarDiaMesAno.plus(1, ChronoUnit.MONTHS);
        sumarDiaMesAno.minus(1, ChronoUnit.DAYS);
        sumarDiaMesAno.plus(1, ChronoUnit.DAYS);
        sumarDiaMesAno.minus(1, ChronoUnit.YEARS);
        sumarDiaMesAno.plus(1, ChronoUnit.YEARS);
        // -------------------Optener el dia de la Semana,------------------------------------
        DayOfWeek diaDeSeman = gererarFecha.getDayOfWeek();
        System.out.println("diaDeSeman generarFecha= " + diaDeSeman);
        diaDeSeman = LocalDate.parse("2025-10-12").getDayOfWeek();
        System.out.println("diaDeSeman manual= " + diaDeSeman);
        //-----------------Numero de mes----------------------------------------------
        int once = LocalDate.of(2025,12,11).getDayOfMonth();
        System.out.println("sacas el dia del en numer de la fecha deseada = \n\t"+once);
        //-----------------Numero de Año----------------------------------------------
        System.out.println("Dias que has pasado en una fecha de todo el año de 1  al 366");
         int diasEnElAno = LocalDate.of(2025,12,31).getDayOfYear();
        System.out.println("\t"+diasEnElAno);//dis desde el inico hasta donde estamos
        diasEnElAno = LocalDate.of(2025,1,1).getDayOfYear();
        System.out.println("\t"+diasEnElAno+"--\n ES Bisiesto--");// van del 1 al 366
        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto "+LocalDate.now().getYear()+"= " + esBisiesto);
        esBisiesto = LocalDate.of(2020,1,1).isLeapYear();
        System.out.println("esBisiesto 2020 = " + esBisiesto);
        //==============Comparar FECHAS=============================
        boolean esAnterior = LocalDate.of(2025,8,21).isBefore(LocalDate.of(2025,8,20));
        System.out.println("esAnterior = " + esAnterior);
        boolean esPosterior = LocalDate.of(2025,8,21).isAfter(LocalDate.of(2025,8,20));
        System.out.println("esPosterior = " + esPosterior);
        boolean esIgual = LocalDate.of(2025,8,21).isEqual(LocalDate.of(2025,8,21));
        System.out.println("esIgual = " + esIgual);
        //-------------------Como convertirlo a español en vez de que imprima en ingles--------------------
        Month mes = fechaActual.getMonth();// Optenemos el mes
        System.out.println("Mes = " + mes);// mes en Ingles
        System.out.println("numero del mes = " + mes.getValue());// Dia numero del mes
        System.out.println("Mes Español = " + mes.getDisplayName(TextStyle.FULL, Locale.of("es","Es")));
        System.out.println("======================================================================================================");
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("diaSemana = " + diaSemana);
        System.out.println("numero de la semana = " + diaSemana.getValue());
        System.out.println("En español el dia de la semana = " + diaSemana.getDisplayName(TextStyle.FULL, Locale.of("es","Es")));
        //------------------------------Horas--------------------------------------
        LocalTime ahora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");// la a es para AM y PM
        String horaFormate = ahora.format(df);// el format solo para Time y Parse para Date o datetimi
        System.out.println(horaFormate);
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("HH:mm:ss a");// La HH o hh es para 24 h o 12 h
        horaFormate = ahora.format(df2);
        System.out.println(horaFormate);
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);



    }
}
