public class Obra {
    private String titulo;
    private Artista autor;
    private int año;
    private double costo;
    private String estado;

    public Obra(String titulo, Artista autor, int año, double costo, String estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.costo = costo;
        this.estado = estado;
    }

 
    public String getTitle(){ return titulo; }
    public void setTitle(String title){ this.titulo = title; }
    
    
    public Artista getAutor(){ 
        return new Artista(this.autor); 
    }
    public void setAutor(Artista autor){
        this.autor = new Artista(autor); 
    }
    
    
    
    public int getYear(){ return año; }
    public void setYear(int year){ this.año = year; }
    public double getCost(){ return costo; }
    public void setCost(double cost){ this.costo = cost; }
    public String getStatus(){ return estado; }
    public void setStatus(String status){ this.estado = status; }

    // Método original, muestra los datos de la obra
    public void mostrarDatosObra() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Artista: " + this.autor.getNombre());
        System.out.println("Año: " + this.año);
        System.out.println("Costo: $" + this.costo);
        System.out.println("Estado: " + this.estado);
    }
    // Sobrecarga para mostrar solo si coincide status
    public void mostrarDatosObra(String status){
        if(this.estado.equals(status)){
            mostrarDatosObra();
        }
    }
}
