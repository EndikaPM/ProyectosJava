import Enum.Tipo;

import java.util.concurrent.TimeUnit;

public class Alfanumerico implements Runnable{

    private Tipo tipo;

    public Alfanumerico(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try{
            if (tipo == Tipo.Numero){
                for (int i = 1; i <= 10 ; i++) {
                    System.out.println(i);
                    TimeUnit.SECONDS.sleep(1);
                }
            }else {
                for (char c = 'A'; c <= 'Z' ; c++) {
                    System.out.println(c);
                    TimeUnit.SECONDS.sleep(1);
                }
            }
        }catch(InterruptedException i){
            System.out.println(i.getMessage());
        }
    }
}
