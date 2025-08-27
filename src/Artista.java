import java.util.ArrayList;

public class Artista {
    private String rut;
    private String nombre;
    private int edad;
    private ArrayList<Obra> obras;

    public Artista(String rut,String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.obras = new ArrayList<>();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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
     
  