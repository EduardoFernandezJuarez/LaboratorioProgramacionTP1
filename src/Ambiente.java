public abstract class Ambiente {
    protected String nombre;
    protected int mugre;

    public Ambiente(String nombre, int mugre) {
        this.nombre = nombre;
        this.mugre = mugre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMugre(){
        return mugre;
    }

    public String toString(){
        return "Ambiente " + nombre + " tiene "+ mugre + "% de mugre! \n";
    }

    public synchronized boolean limpiar(){
        boolean exito = false;
        if (mugre > 0){
            mugre -= 10;
            System.out.println("el hilo " + Thread.currentThread().getName() + " esta limpiando la habitacion " + nombre + "\n quedo " + mugre + "% de mugre");
            if (mugre <= 0){
                mugre = 0;
            }
            exito = true;
        }
        return exito;
    }
}
