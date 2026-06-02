package CalcularFecha;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CalcularEdad {
    public static void main(String[] args) {
        Date fecha;
        Calendar fechaActual = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

        System.out.println("Dime la fecha con el formato ~yyyy/MM/dd~");
        try {
            fecha = formato.parse(new Scanner(System.in).nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Date fechaActualDate = fechaActual.getTime();

        int edad = fechaActualDate.getYear() - fecha.getYear();

        if ( fechaActualDate.getMonth() <= fecha.getMonth() && fechaActualDate.getDay() < fecha.getDay()) {
            edad --;
        }
        System.out.println("La edad de el usuario es de: " + edad + " años");
    }
}