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
        String nombreNormalizado = nombre.trim();
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNombreExposicion().trim().equalsIgnoreCase(nombreNormalizado)) {
                return exposicion;
            }
        }
        return null;
    }

    public ArrayList<Exposicion> getExposiciones() {
        //se retorna una lista copia de la original para no romper el principio del encapsulamiento
        return new ArrayList<>(exposiciones);
    }
    public void setExposiciones(ArrayList<Exposicion> exposiciones){
        //se crea un arraylist copia de la pasada por parametro y luego se asigna a la original para no romper el encapsulamiento
        this.exposiciones = new ArrayList<>(exposiciones);
    }
    // Muestra todas las exposiciones y sus obras
    public void mostrarExposiciones() {
        for (int i = 0; i < exposiciones.size(); i++) {
            exposiciones.get(i).mostrarDatosExposicion();
            System.out.println("-----------------------");
        }
    }

}