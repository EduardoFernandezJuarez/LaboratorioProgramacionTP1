public class TestComposite {
    public static void main(String[] args) {
        Pasillo pasilloUno = new Pasillo("pasillo uno");
        Pasillo pasilloDos = new Pasillo("pasillo dos");
        /* duda
        si ponemos Ambiente pasilloDos = new Pasillo("pasillo dos") no nos reconoce el metodo agregar
        en el video que vimos ponia el metodo agregar y eliminar del composite pero no lo quisimos hacer 
        xq despues lo "bloqueaba" en la hoja */

        Ambiente habitacionA = new Habitacion("habitacion A", 50);
        Ambiente habitacionB = new Habitacion("habitacionB", 80);
        Ambiente habitacionC = new Habitacion("habitacionC", 100);

        pasilloUno.agregar(habitacionA);
        pasilloDos.agregar(habitacionB);
        pasilloDos.agregar(habitacionC);

        System.out.println(pasilloUno.toString());
        System.out.println(pasilloDos.toString());
        System.out.println(habitacionA.toString());
        System.out.println(habitacionB.toString());
        System.out.println(habitacionC.toString());
    }
}
