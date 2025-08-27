import java.util.ArrayList;

public class Artista {
    private String nombre;
    private int edad;
    private ArrayList<Obra> obras;

    public Artista(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.obras = new ArrayList<>();
    }
    
    //metodo para agregar una obra a un artista de forma manual
    public void agregarObra(Obra obra){
        this.obras.add(obra);
    }
    
    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }
}
     
  