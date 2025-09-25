import java.util.*;
public class ListaObras {
    // Internamente usará ArrayList, pero el resto de clases sólo usan estos métodos públicos
    private ArrayList<Obra> obras;

    public ListaObras() {
        this.obras = new ArrayList<>();
    }
    
    public ListaObras(ListaObras obras) {
        this.obras = new ArrayList<>(obras.obras);
    }
    
    public void agregarObra(Obra obra) {
        obras.add(obra);
    }
    
    public ArrayList<Obra> getObras() {
        return new ArrayList<>(obras); // copia defensiva
    }
    public void setObras(ArrayList<Obra> obras){
        this.obras = new ArrayList<>(obras); //copia defensiva
    }
    
    // Muestra todas las obras de la lista
    public void mostrarTodasObras() {
        for (int i = 0; i < obras.size(); i++) {
            obras.get(i).mostrarDatosObra();
            System.out.println("--------------------");
        }
    }

    // Muestra sólo las obras de determinado estado (sobrecarga requerida)
    public void mostrarObrasPorEstado(String status) {
        for (int i = 0; i < obras.size(); i++) {
            obras.get(i).mostrarDatosObra(status);
            System.out.println("--------------------");
        }
    }
    // Buscar obra en la lista por título
    public Obra buscarPorTitulo(String titulo) {
        for (Obra obra : obras) {
            if (obra.getTitle().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null; // no encontrada
    }

    // Elimina obra por título y retorna true si se eliminó
    public boolean eliminarObraPorTitulo(String titulo) {
        Iterator<Obra> iter = obras.iterator();
        while (iter.hasNext()) {
            Obra obra = iter.next();
            if (obra.getTitle().equalsIgnoreCase(titulo)) {
                iter.remove();
                return true;
            }
        }
        return false; // no eliminó porque no encontró la obra
    }
}