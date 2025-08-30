public class Casa {

    private Ambiente[] ambientes = new Ambiente[4];

    public Casa (){
        Pasillo pasilloUno = new Pasillo("pasillo 1");
        Pasillo pasilloDos = new Pasillo("pasillo 2");
        Pasillo pasilloTres = new Pasillo("pasillo 3");
        Pasillo pasilloCuatro = new Pasillo("pasillo 4");
        /* duda
        si ponemos Ambiente pasilloDos = new Pasillo("pasillo dos") no nos reconoce el metodo agregar
        en el video que vimos ponia el metodo agregar y eliminar del composite pero no lo quisimos hacer 
        xq despues lo "bloqueaba" en la hoja */

        /* como Ambiente funciona como interfaz, deberiamos definir todos los metodos ahi? el agregar, eliminar y limpiar
        y despues solo definirlos en las subclases? (poo 101) */

        Habitacion habitacionA = new Habitacion("habitacion 1.1", 50);
        Habitacion habitacionB = new Habitacion("habitacion 2.1", 80);
        Habitacion habitacionC = new Habitacion("habitacion 3.1", 100);
        Habitacion habitacionD = new Habitacion("habitacion 4.1", 100);
        Habitacion habitacionE = new Habitacion("habitacion 1.2", 100);
        Habitacion habitacionF = new Habitacion("habitacion 2.2", 100);
        Habitacion habitacionG = new Habitacion("habitacion casa", 100);

        pasilloUno.agregar(habitacionA);
        pasilloUno.agregar(habitacionE);
        pasilloDos.agregar(habitacionB);
        pasilloDos.agregar(habitacionF);
        pasilloTres.agregar(pasilloCuatro);
        pasilloTres.agregar(habitacionC);
        pasilloCuatro.agregar(habitacionD);

        ambientes[0] = pasilloUno;
        ambientes[1] = habitacionG;
        ambientes[2] = pasilloDos;
        ambientes[3] = pasilloTres;
    }

    public boolean generarLimpieza(){
        boolean exito = false;
        int i = 0;
        while(!exito && i < ambientes.length){
            exito = ambientes[i].limpiar();
            i++;
        }
        return exito;
    }

}
