import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class main {
    static boolean terminado = false;
    static Casa laCasita = new Casa();
    public static void main(String[] args) {
        

        ExecutorService executor = Executors.newFixedThreadPool(4);

        // cada hilo recorre la casa hasta limpiar una pieza
        Runnable limpiar = () -> task();

        while(!terminado){ // los hilos terminan cuando la casa queda toda limpia 
            executor.submit(limpiar);
        }

        executor.shutdown();
        try {
            /* Le indico al ejecutor cuando debe de terminar de ejecutar los hilos pendientes*/
            if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        
        } catch (Exception e) {
            System.out.println("Error en el cierre de EXECUTOR SERVICE -> " + e);
            System.out.println("CIERRE FORZADO DE EXECUTOR SERVICE");
            executor.shutdownNow();
        }
    }

    public synchronized static void task(){
        terminado = laCasita.generarLimpieza();
        // System.out.println("Terminado --> " + terminado);
    }
}
