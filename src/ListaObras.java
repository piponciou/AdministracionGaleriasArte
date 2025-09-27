import java.util.*;

public class ListaObras {
    private ArrayList<Obra> obras;
    private HashMap<String, Obra> mapaObras;

    public ListaObras() {
        this.obras = new ArrayList<>();
        this.mapaObras = new HashMap<>();
    }

    public ListaObras(ListaObras listaObras) {
        this.obras = new ArrayList<>(listaObras.obras);
        this.mapaObras = new HashMap<>();
        for (Obra obra : this.obras) {
            this.mapaObras.put(obra.getTitle(), obra);
        }
    }

    // Agrega obra solo si el titulo no está repetido
    public boolean agregarObra(Obra obra) {
        String titulo = obra.getTitle();
        if (mapaObras.containsKey(titulo)) {
            return false; // Ya existe una obra con ese título
        }
        obras.add(obra);
        mapaObras.put(titulo, obra);
        
        return true;
    }

    public ArrayList<Obra> getObras() {
        return new ArrayList<>(obras); // copia defensiva
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = new ArrayList<>(obras); // copia defensiva
        // Actualiza el mapa
        mapaObras.clear();
        for (Obra obra : this.obras) {
            mapaObras.put(obra.getTitle(), obra);
        }
    }

    public void mostrarTodasObras() {
        for (Obra obra : obras) {
            obra.mostrarDatosObra();
            System.out.println("--------------------");
        }
    }

    public void mostrarObrasPorEstado(String status) {
        for (Obra obra : obras) {
            obra.mostrarDatosObra(status);
            System.out.println("--------------------");
        }
    }

    public Obra buscarPorTitulo(String titulo) {
        return mapaObras.get(titulo);
    }

    //Requerimiento  2.4 y 2.9
    public void eliminarObraPorTitulo(String titulo) throws ObraNoEncontradaException {
        Obra obra = mapaObras.remove(titulo);
        if (obra == null) {
            throw new ObraNoEncontradaException("Obra no encontrada con título: " + titulo);
        }
        obras.remove(obra);
}


    //Requerimiento  2.4
    // Modificar el estado de una obra identificada por título
    public boolean modificarEstadoObra(String titulo, String nuevoEstado) {
        Obra obra = mapaObras.get(titulo);
        if (obra != null) {
            obra.setStatus(nuevoEstado);
            return true; // Modificado con éxito
        }
        return false; // Obra no encontrada
    }
    //REQUERIMIENTO 2.5
    public ArrayList<Obra> filtrarPorEstado(String estado) {
        ArrayList<Obra> resultado = new ArrayList<>();
        for (Obra obra : obras) {
            if (obra.getStatus().equalsIgnoreCase(estado)) {
                resultado.add(obra);
            }
        }
        return resultado;
    }

}
