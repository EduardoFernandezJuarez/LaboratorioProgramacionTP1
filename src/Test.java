import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    private static int i  = 0;
    public static void main(String[] args) {
        Pasillo pasilloUno = new Pasillo("pasillo uno");
        Pasillo pasilloDos = new Pasillo("pasillo dos");
        /* duda
        si ponemos Ambiente pasilloDos = new Pasillo("pasillo dos") no nos reconoce el metodo agregar
        en el video que vimos ponia el metodo agregar y eliminar del composite pero no lo quisimos hacer 
        xq despues lo "bloqueaba" en la hoja */

        /* como Ambiente funciona como interfaz, deberiamos definir todos los metodos ahi? el agregar, eliminar y limpiar
        y despues solo definirlos en las subclases? (poo 101) */

        Habitacion habitacionA = new Habitacion("habitacion A", 50);
        Habitacion habitacionB = new Habitacion("habitacion B", 80);
        Habitacion habitacionC = new Habitacion("habitacion C", 100);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Habitacion habitaciones[] = new Habitacion[3];
        habitaciones[0] = habitacionA;
        habitaciones[1] = habitacionB;
        habitaciones[2] = habitacionC;

        pasilloUno.agregar(habitacionA);
        pasilloDos.agregar(habitacionB);
        pasilloDos.agregar(habitacionC);

        /* System.out.println(pasilloUno.toString());
        System.out.println(pasilloDos.toString());
        System.out.println(habitacionA.toString());
        System.out.println(habitacionB.toString());
        System.out.println(habitacionC.toString()); */
    
        Runnable limpiar = () -> {
            int h = i % 3;
            System.out.println("El hilo " + Thread.currentThread().getName() + " esta limpiando la habitacion " + (h+1));
            habitaciones[h].limpiar();
            System.out.println(habitaciones[h].toString());
        };

        for(i=0; i<10; i++){
            executor.submit(limpiar);
            /* try {
                Thread.sleep(5); // mal, era para probar nomas 
            } catch (InterruptedException e) {
                e.printStackTrace();
            } */
        }

        executor.shutdown();
        try {
            /* Le indico al ejecutor cuando debe de terminar de ejecutar los hilos pendientes*/
            if (!executor.awaitTermination(8000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        
        } catch (Exception e) {
            System.out.println("Error en el cierre de EXECUTOR SERVICE -> " + e);
            System.out.println("CIERRE FORZADO DE EXECUTOR SERVICE");
            executor.shutdownNow();
        }

    }
}
