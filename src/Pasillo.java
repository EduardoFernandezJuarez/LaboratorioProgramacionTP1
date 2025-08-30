import java.util.ArrayList;
import java.util.List;

public class Pasillo extends Ambiente{
    protected List<Ambiente> ambientes = new ArrayList<>();
    protected boolean limpio;

    public Pasillo(String nombre) {
        super(nombre, 0);
        limpio = false;
    }

    public void agregar(Ambiente amb){
        ambientes.add(amb);
    }

    public void eliminar(Ambiente amb){
        ambientes.remove(amb);
    }
    
    public int cantHabitaciones(){
        return ambientes.size();
    }

    public synchronized boolean limpiar(){
        boolean exito = false;
        if(!limpio){
            int i = 0;
            while(!exito && i<cantHabitaciones()){
                exito = ambientes.get(i).limpiar();
                i++;
            }
            if(!exito){ // no se pudo limpiar ninguna habitacion xq ya estan todas limpias
                limpio = true;
                System.out.println("todos los ambientes del pasillo " + nombre + " quedaron limpios");
            }
        }
        return exito;
    }
}
