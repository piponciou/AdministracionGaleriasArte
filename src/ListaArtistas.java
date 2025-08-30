import java.util.ArrayList;
import java.util.HashMap;

public class ListaArtistas {
    private ArrayList<Artista> artistas;
    private HashMap<String, Artista> mapaRut;

    public ListaArtistas() {
        artistas = new ArrayList<>();
        mapaRut = new HashMap<>();
    }
    public void agregarArtista(Artista artista) {
        artistas.add(artista);
        mapaRut.put(artista.getRut(), artista);
    }
    public Artista buscarPorRut(String rut) {
        return mapaRut.get(rut);
    }
    public ArrayList<Artista> getArtistas() {
        //se retorna una copia del arraylist original
        return new ArrayList<>(artistas);
    }
    
    public void setArtistas(ArrayList<Artista> artistas){
        //se crea una copia del arraylist y se le asigna a la original
        this.artistas = new ArrayList<>(artistas);
    }
    // Muestra todos los artistas
    public void mostrarArtistas() {
        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);
            System.out.println("RUT: " + artista.getRut() + ", Nombre: " + artista.getNombre() + ", Edad: " + artista.getEdad());
            System.out.println("Obras:");
            artista.getObras().mostrarTodasObras();
            System.out.println("-----------------------");
        }
    }
}
