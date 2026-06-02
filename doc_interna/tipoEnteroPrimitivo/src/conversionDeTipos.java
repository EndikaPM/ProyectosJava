public class conversionDeTipos {
    public static void main(String[] args) {
        String numStr = "50";

        int numInt = Integer.parseInt(numStr);
        System.out.println("numInt = " + numInt);

        String realStr = "98765.43e-3";//movemos la coma con notacion cientifica y lo parseamos
        double realdoDouble = Double.parseDouble(realStr);
        System.out.println("realdoDouble = " + realdoDouble);

        String logicoStr = "true";
        boolean logicoBoolean = Boolean.parseBoolean(logicoStr);
        System.out.println("logicoBoolean = " + logicoBoolean);
    }
}
