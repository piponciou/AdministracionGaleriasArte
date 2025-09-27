import java.io.*;
import java.util.ArrayList;

public class Galeria {
    private ListaArtistas artistas;
    private ListaExposiciones exposiciones;

    public Galeria() {
        artistas = new ListaArtistas();
        exposiciones = new ListaExposiciones();
    }
    
    //DEL REQUERIMIENTO 2.2
    // Método para cargar artistas y obras
    public void cargarDatos() {
        try {
            ArrayList<Artista> listaArt = GestorArchivos.cargarArtistas("artistas.csv");
            artistas = new ListaArtistas();
            artistas.setArtistas(listaArt); // asigna la lista cargada

            ArrayList<Obra> listaObras = GestorArchivos.cargarObras("obras.csv", artistas.getArtistas());
            for (Obra obra : listaObras) {
                Artista autor = artistas.buscarPorRut(obra.getAutor().getRut());
                if (autor != null) {
                    autor.agregarObra(obra); // enlaza obra con artista
                }
            }
        }catch (IOException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
        }
    }

    // Método para guardar artistas y obras
    public void guardarDatos() {
        try {
            GestorArchivos.guardarArtistas(artistas.getArtistas(), "artistas.csv");

            ArrayList<Obra> todasObras = new ArrayList<>();
            for (Artista artista : artistas.getArtistas()) {
                todasObras.addAll(artista.getObras().getObras());
            }
            GestorArchivos.guardarObras(todasObras, "obras.csv");
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    public void agregarArtista(Artista artista) {
        artistas.agregarArtista(artista);
    }
    //Requerimiento 2.9
    public Artista buscarArtistaPorRut(String rut) throws ArtistaNoEncontradoException{
        Artista artista = artistas.buscarPorRut(rut);
        if (artista == null) {
            throw new ArtistaNoEncontradoException("Artista no encontrado con RUT: " + rut);
        }
        return artista;
    }
    public void agregarObraAArtista(String rut, Obra obra)throws ArtistaNoEncontradoException{
        Artista artista = buscarArtistaPorRut(rut);
        if (artista != null) artista.agregarObra(obra);
    }
    
    //sobreescritura de metodo recien implementada
    public void agregarObraAArtista(Artista artista, Obra obra) {
        if (artista != null){
            artista.agregarObra(obra);
        }else{
            System.out.println("ERROR");   
        }
    }
    public void mostrarArtistas() {
        artistas.mostrarArtistas();
    }
    public void agregarExposicion(Exposicion exposicion) {
        exposiciones.agregarExposicion(exposicion);
    }
    public Exposicion buscarExposicionPorNombre(String nombre) {
        return exposiciones.buscarPorNombre(nombre);
    }
    public void agregarObraAExposicion(String nombreExp, Obra obra) {
        Exposicion exp = buscarExposicionPorNombre(nombreExp);
        if (exp != null) exp.agregarObra(obra);
    }
    public void mostrarExposiciones() {
        exposiciones.mostrarExposiciones();
    }
    
    //getter de ArrayList de artistas y exposiciones
    public ArrayList<Artista> getArrayListArtista(){
        return artistas.getArtistas();
    }
    
    public ArrayList<Exposicion> getArrayListExposicion(){
        return exposiciones.getExposiciones();
    }
    
    //FUNCIONES NUEVAS DE REQUERIMIENTO 2.4
    // Editar estado de una obra asociada a un artista
    public void editarEstadoObraDeArtista(String rutArtista, String tituloObra, String nuevoEstado) throws ArtistaNoEncontradoException{
        Artista artista = buscarArtistaPorRut(rutArtista);
        if (artista != null) {
            Obra obra = (artista.getObras()).buscarPorTitulo(tituloObra);
            if (obra != null) {
                obra.setStatus(nuevoEstado);
                System.out.println("Estado de obra actualizado correctamente.");
            } else {
                System.out.println("No se encontró la obra con título: " + tituloObra);
            }
        } else {
            System.out.println("No se encontró al artista con rut: " + rutArtista);
        }
    }

    // Eliminar una obra de una exposición
    public void eliminarObraDeExposicion(String nombreExposicion, String tituloObra) throws ObraNoEncontradaException {
        Exposicion exposicion = buscarExposicionPorNombre(nombreExposicion);
        if (exposicion == null) {
            System.out.println("No se encontró la exposición con nombre: " + nombreExposicion);
            return;
        }
        exposicion.getObrasExpuestas().eliminarObraPorTitulo(tituloObra);
        System.out.println("Obra eliminada correctamente de la exposición.");
}

    
}