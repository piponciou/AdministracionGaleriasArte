package proyectoFinal;

// Clase Artista que hereda Persona y añade obras
public class Artista extends Persona {
    private ListaObras obras;

    public Artista(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
        obras = new ListaObras();
    }

    public Artista(Artista artista) {
        super(artista.getRut(), artista.getNombre(), artista.getEdad());
        this.obras = new ListaObras(artista.getObras());
    }

    public ListaObras getObras() {
        return new ListaObras(obras); // copia defensiva
    }

    public void setObras(ListaObras obras) {
        this.obras = new ListaObras(obras); // copia defensiva
    }

    public void agregarObra(Obra obra) {
        this.obras.agregarObra(obra);
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Obras del artista:");
        obras.mostrarTodasObras();
    }
}
