package PruebaStatic;

public class Cliente {

        static int idTota = 1;
        private int id;
        private String nombre;

        public Cliente(String nombre)
        {
            this.nombre = nombre;
            this.id = idTota ++;
        }

        public void setId() {
            this.id --;
            idTota--;
        }


        @Override
        public String toString() {
            return "Cliente{ID: " + this.id + " , nombre: " + this.nombre + "}\n";
        }
}
