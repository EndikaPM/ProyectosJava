import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        /*List<Vuelo> vuelo = new LinkedList<>();
        vuelo.add(new Vuelo("AAL 933", "New York", "Santiago", "29 08 2021 05:39",62));
        vuelo.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", "31 08 2021 04:45",47));
        vuelo.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", "30 08 2021 16:30",52));
        vuelo.add(new Vuelo("DAL 147", "Atlanta", "Santiago", "29 08 2021 13:22",59));
        vuelo.add(new Vuelo("AVA 241", "Bogota", "Santiago", "31 08 2021 14:05",25));
        vuelo.add(new Vuelo("AMX 10", "Mexico City", "Santiago", "30 08 2021 08:45",29));
        vuelo.add(new Vuelo("IBE 6833", "Londres", "Santiago", "29 08 2021 07:41",55));
        vuelo.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", "30 08 2021 10:35",51));
        vuelo.add(new Vuelo("SKU 803", "Lima", "Santiago", "29 08 2021 09:14",48));
        vuelo.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", "31 08 2021 08:33",59));
        vuelo.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", "29 08 2021 15:15",31));
        vuelo.add(new Vuelo("CMP 111", "Panama City", "Santiago", "31 08 2021 08:31",29));
        vuelo.add(new Vuelo("LAT 705", "Madrid", "Santiago", "29 08 2021 22:53",47));
        vuelo.add(new Vuelo("AAL 957", "Miami", "Santiago", "30 08 2021 09:57",60));
        vuelo.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", "30 08 2021 07:41",32));
        vuelo.add(new Vuelo("LAT 1283", "Cancún", "Santiago", "30 08 2021 07:49",35));
        vuelo.add(new Vuelo("LAT 579", "Barcelona", "Santiago", "30 08 2021 07:12",61));
        vuelo.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", "30 08 2021 20:41",58));
        vuelo.add(new Vuelo("LAT 501", "París", "Santiago", "31 08 2021 21:36",49));
        vuelo.add(new Vuelo("LAT 405", "Montevideo", "Santiago", "28 08 2021 20:33",39));

       Comparator<Vuelo> comparator = new Comparator<Vuelo>() {
           public int compare(Vuelo o1, Vuelo o2) {
               return o1.getFechaYhora().compareTo(o2.getFechaYhora());
           }
       };
       Collections.sort(vuelo, comparator);
       Vuelo minimo = new Vuelo("L9T 405", "Montevideo", "Santiago", "28 08 2021 20:33",Integer.MAX_VALUE);
       for (Vuelo vu : vuelo){
           System.out.println(vu);
           if (vu.getCanPasajeros()< minimo.getCanPasajeros()){
               minimo = vu;
           }
       }

        System.out.println("==================================Ultimo vuelo en llegar=============================================== \n" +
                vuelo.getLast());
        System.out.println("======================================= El vuelo con menos pasajeros es ===============================\n" +
                minimo.getNombre() +": "+minimo.getOrigen() +", con " + minimo.getCanPasajeros());*/

        int alatorio = ThreadLocalRandom.current().nextInt(50,200);
        System.out.println("alatorio = " + alatorio);

    }

}