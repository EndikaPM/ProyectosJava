import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
UsuarioRepositorioImple usuRepo = new UsuarioRepositorioImple();
        Scanner sc = new Scanner(System.in);
        int op = -1;
        do{
            System.out.print("Deleccione la opcion que desea ejecutar\n" +
                    "1. Añadir Usuario\n" +
                    "2. Actualizar Usuario\"" +
                    "3. Listar Usuarios\n" +
                    "4. Eliminar Usuario\n" +
                    "0 .Salir\n" +
                    "== ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1-> {
                    UsuarioEntidad usu = getUsuarioEntidad(sc);
                    usuRepo.add(usu);
                }
                case 2->{
                    UsuarioEntidad usu = getUsuarioEntidad(sc);
                    usuRepo.update(usu);
                }
                case 3 ->usuRepo.listar().forEach(System.out::println);
                case 4->{
                    System.out.print("Dime el ID del usuario: ");
                    Long id = sc.nextLong();
                    usuRepo.delete(id);
                }
                case 0-> conexionBBDD.getConexion().close();
            }
        }while (op != 0);
        sc.close();
        System.out.println("👋 Aplicación finalizada.");

    }

    private static UsuarioEntidad getUsuarioEntidad(Scanner sc) {
        System.out.print("Dime el nombre del usuario:");
        String nombre = sc.nextLine();
        System.out.print("Dime la contraseña del usuario:");
        String password = sc.nextLine();
        System.out.print("Dime e-main del usuario:");
        String eMail = sc.nextLine();
        UsuarioEntidad u = new UsuarioEntidad(nombre,password,eMail);
        return u;
    }
}