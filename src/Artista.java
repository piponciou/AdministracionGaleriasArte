public class Artista {
    private String rut;
    private String nombre;
    private int edad;
    // CAMBIO IMPORTANTE: ahora tiene ListaObras, no ArrayList
    private ListaObras obras;

    public Artista(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.obras = new ListaObras();
    }
    public Artista(Artista artista){
        this.rut = artista.getRut();
        this.nombre = artista.getNombre();
        this.edad = artista.getEdad();
        this.obras = artista.getObras();
    }
    // Getters y setters igual que antes, sólo cambia el tipo para obras
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public ListaObras getObras() {
        return new ListaObras(this.obras);//copia defensiva 
    }
    public void setObras(ListaObras obras) { 
        this.obras = new ListaObras(obras); //copia defensiva
    }

    // Para agregar una obra al artista
    public void agregarObra(Obra obra) {
        this.obras.agregarObra(obra);
    }
}
