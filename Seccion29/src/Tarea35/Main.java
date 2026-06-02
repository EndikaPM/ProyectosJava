package Tarea35;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{System.out.print("Dime la fecha de nacimiento en este formato \ndd/MM/yyyy: ");
            String fechaNacimiento = new Scanner(System.in).nextLine();
            LocalDate fecha = LocalDate.parse(fechaNacimiento,df);
            Period edad = fecha.until(LocalDate.now());
            /*int edadAno = (int) fecha.until(LocalDate.now(), ChronoUnit.YEARS); asi sacas solo el año
            es un metodo a recordar
             */
            System.out.printf("La persona tiene:\n\t\t\t %d Años %d Meses %d Dias",
                    edad.getYears(),edad.getMonths(),edad.getDays());
        }catch (DateTimeParseException e){
            System.out.println("No es un formato valido:");
            main(args);
        }
    }
}