package proyectoFinal;

import java.io.*;
import java.util.ArrayList;

public class Galeria {
    private ListaArtistas artistas;
    private ListaExposiciones exposiciones;

    public Galeria() {
        artistas = new ListaArtistas();
        exposiciones = new ListaExposiciones();
    }

    // Método para cargar artistas, obras y exposiciones desde archivos
    public void cargarDatos() throws Exception {
        try {
            ArrayList<Artista> listaArt = GestorArchivos.cargarArtistas("artistas.csv");
            artistas = new ListaArtistas();
            artistas.setArtistas(listaArt);
            ArrayList<Obra> listaObras = GestorArchivos.cargarObras("obras.csv", artistas.getArtistas());
            ArrayList<Exposicion> listaExpos = GestorArchivos.cargarExposiciones("exposiciones.csv");
            exposiciones = new ListaExposiciones();
            exposiciones.setExposiciones(listaExpos);
            // Cargar relación obras - exposiciones
            GestorArchivos.cargarObrasExposicion("obras_exposicion.csv", exposiciones.getExposiciones(), listaObras);
            System.out.println("Datos cargados correctamente en .");
        } catch (IOException e) {
            throw new Exception("Error cargando datos: " + e.getMessage());
        }
    }

    // Método para guardar artistas, obras y exposiciones
    public void guardarDatos() {
        try {
            GestorArchivos.guardarArtistas(artistas.getArtistas(), "artistas.csv");
            ArrayList<Obra> todasObras = new ArrayList<>();
            for (Artista artista : artistas.getArtistas()) {
                todasObras.addAll(artista.getObras().getObras());
            }
            GestorArchivos.guardarObras(todasObras, "obras.csv");
            GestorArchivos.guardarExposiciones(exposiciones.getExposiciones(), "exposiciones.csv");
            // Guardar relación obras-exposiciones
            GestorArchivos.guardarObrasExposicion(exposiciones.getExposiciones(), "obras_exposicion.csv");
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }

    public void agregarArtista(Artista artista) {
        artistas.agregarArtista(artista);
    }

    //Requerimiento 2.9
    public Artista buscarArtistaPorRut(String rut) throws ArtistaNoEncontradoException {
        Artista artista = artistas.buscarPorRut(rut);
        if (artista == null) {
            throw new ArtistaNoEncontradoException("Artista no encontrado con RUT: " + rut);
        }
        return artista;
    }

    public void agregarObraAArtista(String rut, Obra obra) throws ArtistaNoEncontradoException {
        Artista artista = buscarArtistaPorRut(rut);
        if (artista != null) {
            artista.agregarObra(obra);
        }
    }

    //sobreescritura de metodo recien implementada
    public void agregarObraAArtista(Artista artista, Obra obra) throws IllegalArgumentException {
        if (artista != null) {
            artista.agregarObra(obra);
        } else {
            System.out.println("ERROR");
            throw new IllegalArgumentException("El artista no puede ser nulo al agregar obra.");
        }
    }

    public void mostrarArtistas() {
        artistas.mostrarArtistas();
    }

    public void agregarExposicion(Exposicion exposicion) {
        exposiciones.agregarExposicion(exposicion);
    }

    public Exposicion buscarExposicionPorNombre(String nombre) throws Exception{
        return exposiciones.buscarPorNombre(nombre);
    }

    public void agregarObraAExposicion(String nombreExp, Obra obra) throws Exception{
        Exposicion exp = buscarExposicionPorNombre(nombreExp);
        if (exp != null) {
            exp.agregarObra(obra);
        }
    }

    public void mostrarExposiciones() {
        exposiciones.mostrarExposiciones();
    }

    //getter de ArrayList de artistas y exposiciones
    public ArrayList<Artista> getArrayListArtista() {
        return artistas.getArtistas();
    }

    public ArrayList<Exposicion> getArrayListExposicion() {
        return exposiciones.getExposiciones();
    }

    //FUNCIONES NUEVAS DE REQUERIMIENTO 2.4
    // Editar estado de una obra asociada a un artista
    public void editarEstadoObraDeArtista(String rutArtista, String tituloObra, String nuevoEstado) throws ArtistaNoEncontradoException {
        Artista artista = buscarArtistaPorRut(rutArtista);
        if (artista != null) {
            Obra obra = artista.getObras().buscarPorTitulo(tituloObra);
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
    public void eliminarObraDeExposicion(String nombreExposicion, String tituloObra) throws ObraNoEncontradaException, Exception{
        Exposicion exposicion = buscarExposicionPorNombre(nombreExposicion);
        if (exposicion == null) {
            throw new ObraNoEncontradaException("No se encontró la exposición con nombre: " + nombreExposicion);
        }
        exposicion.eliminarObra(tituloObra);
        System.out.println("Obra eliminada correctamente de la exposición.");
    }

    //REQUISITO 2.10
    public void reporteArchivoFinal() {
        String archivoObras = "ReporteDeLasObras.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoObras))) {
            writer.write("TítuloObra|ArtistaNombre|ArtistaRut|AñoDeCreacion|CostoDeObra|EstadoDeObra");
            writer.newLine();
            ArrayList<String> finalObras = artistas.ObrasCSV();
            for (String line : finalObras) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("\nReporte CSV de obras generado: " + archivoObras);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public boolean eliminarArtistaPorRut(String rut) throws ArtistaNoEncontradoException {
        return artistas.eliminarArtistaPorRut(rut);
    }
}
