import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TestExServ {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
    
        Runnable limpiar = () -> {
            System.out.println("El hilo " + Thread.currentThread().getName() + " esta limpiando!");
        };

        for(int i=0; i<10; i++){
            executor.execute(limpiar);
        }

        executor.shutdown();
    }
}
