import java.util.ArrayList;
import java.util.HashMap;

public class ListaExposiciones {
    private ArrayList<Exposicion> exposiciones;
    private HashMap<String, Exposicion> mapaNombre;

    public ListaExposiciones() {
        exposiciones = new ArrayList<>();
        mapaNombre = new HashMap<>();
    }
    public void agregarExposicion(Exposicion exposicion) {
        exposiciones.add(exposicion);
        mapaNombre.put(exposicion.getNombreExposicion(), exposicion);
    }
    public Exposicion buscarPorNombre(String nombre) {
        return mapaNombre.get(nombre);
    }
    public ArrayList<Exposicion> getExposiciones() {
        return exposiciones;
    }
    // Muestra todas las exposiciones y sus obras
    public void mostrarExposiciones() {
        for (int i = 0; i < exposiciones.size(); i++) {
            exposiciones.get(i).mostrarDatosExposicion();
            System.out.println("-----------------------");
        }
    }
}