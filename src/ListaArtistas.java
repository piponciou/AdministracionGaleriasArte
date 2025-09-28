import java.util.ArrayList;
import java.util.HashMap;

public class ListaArtistas {
    private ArrayList<Artista> artistas;
    private HashMap<String, Artista> mapaRut;

    public ListaArtistas() {
        this.artistas = new ArrayList<>();
        this.mapaRut = new HashMap<>();
    }
    
    public void agregarArtista(Artista artista) {
        artistas.add(artista);
        //basicamente se hace esto por que al momento de buscar el rut hay problemas con el "." y "-" del rut, por lo que se guarda en el hashMap sin eso
        String rutNormalizado = artista.getRut().replaceAll("[.\\-\\s]", "").toLowerCase();
        mapaRut.put(rutNormalizado, artista);
    }
    public Artista buscarPorRut(String rut) {
        //se formatea el rut para dejarlo sin puntos y guion y asi poder buscarlo en el hashMap correctamente
        String rutNormalizado = rut.replaceAll("[.\\-\\s]", "").toLowerCase();
        return mapaRut.get(rutNormalizado);
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
    //requirimiento 2.10 que se llama desde galeria reporteArchivoFinal()
    public ArrayList<String> ObrasCSV() {
        ArrayList<String> obA = new ArrayList<>();
        for (int i = 0; i < artistas.size(); i++) {
            obA.addAll(artistas.get(i).getObras().obtenerObrasCSV());
        }
        return obA;
    }
    //Requerimiento 2.12: eliminar elementos de el primer nivel.

    public boolean eliminarArtistaPorRut(String rut) throws ArtistaNoEncontradoException {
        String rutNormalizado = rut.replaceAll("[.\\-\\s]", "").toLowerCase();
        Artista artista = mapaRut.remove(rutNormalizado);
        
        if (artista != null) {
            artistas.remove(artista);
            return true;
        }
        throw new ArtistaNoEncontradoException("Artista con RUT " + rutNormalizado + " no encontrado");
    }
    
}