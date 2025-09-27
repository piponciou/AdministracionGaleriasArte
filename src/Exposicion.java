import java.util.ArrayList;

public class Exposicion {
    private String nombreExposicion;
    private String fechaInicio;
    private String fechaTermino;
    private String lugar;
    private ListaObras obrasExpuestas;

    public Exposicion(String nombreExposicion, String fechaInicio, String fechaTermino, String lugar) {
        this.nombreExposicion = nombreExposicion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.lugar = lugar;
        this.obrasExpuestas = new ListaObras();
    }

    public String getNombreExposicion() { return nombreExposicion; }
    public void setNombreExposicion(String nombreExposicion) { this.nombreExposicion = nombreExposicion; }
    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }
    public String getFechaTermino() { return fechaTermino; }
    public void setFechaTermino(String fechaTermino) { this.fechaTermino = fechaTermino; }
    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    
    public ListaObras getObrasExpuestas() {
        return new ListaObras(this.obrasExpuestas); //copia defensiva
    }
    public void setObrasExpuestas(ListaObras obrasExpuestas) { 
        this.obrasExpuestas = new ListaObras(obrasExpuestas); //copia defensiva
    }

    // Para agregar una obra a la exposición
    public void agregarObra(Obra obra) {
        obrasExpuestas.agregarObra(obra);
    }
    // Método para mostrar los datos de la exposición y las obras
    public void mostrarDatosExposicion() {
        System.out.println("Nombre de la exposición: " + nombreExposicion);
        System.out.println("Fecha Inicio: " + fechaInicio);
        System.out.println("Fecha Termino: " + fechaTermino);
        System.out.println("Lugar: " + lugar);
        System.out.println("Obras expuestas:");
        obrasExpuestas.mostrarTodasObras();
    }
    // Sobrecargado: muestra solo por estado
    public void mostrarDatosExposicion(String status) {
        System.out.println("Nombre de la exposición: " + nombreExposicion);
        System.out.println("Fecha Inicio: " + fechaInicio);
        System.out.println("Fecha Termino: " + fechaTermino);
        System.out.println("Lugar: " + lugar);
        System.out.println("Obras expuestas con estado " + status + ":");
        obrasExpuestas.mostrarObrasPorEstado(status);
    }
    //REQUIRIMIENTO 2.5, ya teniendo la exposicion llama a la funcion
    
    public ArrayList<Obra> filtrarObrasPorEstado(String estado) {
        return obrasExpuestas.filtrarPorEstado(estado);
    }
}