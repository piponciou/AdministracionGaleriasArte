import java.util.ArrayList;

public class ListaObras {
    // Internamente usará ArrayList, pero el resto de clases sólo usan estos métodos públicos
    private ArrayList<Obra> obras;

    public ListaObras() {
        this.obras = new ArrayList<>();
    }
    public void agregarObra(Obra obra) {
        obras.add(obra);
    }
    public ArrayList<Obra> getObras() {
    return new ArrayList<>(obras); // copia defensiva
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
}
