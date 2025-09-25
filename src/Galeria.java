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
    public Artista buscarArtistaPorRut(String rut) {
        return artistas.buscarPorRut(rut);
    }
    public void agregarObraAArtista(String rut, Obra obra) {
        Artista artista = buscarArtistaPorRut(rut);
        if (artista != null) artista.agregarObra(obra);
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
    public void editarEstadoObraDeArtista(String rutArtista, String tituloObra, String nuevoEstado) {
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
    public void eliminarObraDeExposicion(String nombreExposicion, String tituloObra) {
        Exposicion exposicion = buscarExposicionPorNombre(nombreExposicion);
        if (exposicion != null) {
            boolean eliminado = exposicion.getObrasExpuestas().eliminarObraPorTitulo(tituloObra);
            if (eliminado) {
                System.out.println("Obra eliminada correctamente de la exposición.");
            } else {
                System.out.println("No se encontró la obra con título: " + tituloObra + " en la exposición.");
            }
        } else {
            System.out.println("No se encontró la exposición con nombre: " + nombreExposicion);
        }
    }

    public void menu() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;

        while (opcion != 9) {
            System.out.println("\n----- ADMINISTRACIÓN DE GALERÍA DE ARTE -----");
            System.out.println("1. Agregar artista");
            System.out.println("2. Agregar obra a artista");
            System.out.println("3. Agregar exposición");
            System.out.println("4. Agregar obra a exposición");
            System.out.println("5. Mostrar lista de artistas y sus obras");
            System.out.println("6. Mostrar lista de exposiciones y sus obras");
            System.out.println("9. Salir");
            System.out.print("Ingrese opción: ");

            opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1:
                    System.out.print("RUT artista: ");
                    String rut = lector.readLine();
                    System.out.print("Nombre artista: ");
                    String nombre = lector.readLine();
                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(lector.readLine());
                    agregarArtista(new Artista(rut, nombre, edad));
                    System.out.println("Artista agregado.");
                    break;
                case 2:
                    System.out.print("RUT artista para obra: ");
                    rut = lector.readLine();
                    Artista art = buscarArtistaPorRut(rut);
                    if (art != null) {
                        System.out.print("Título obra: ");
                        String tit = lector.readLine();
                        System.out.print("Año: ");
                        int year = Integer.parseInt(lector.readLine());
                        System.out.print("Valor: ");
                        double val = Double.parseDouble(lector.readLine());
                        System.out.print("Estado [DISPONIBLE, VENDIDO, PRESTADO]: ");
                        String est = lector.readLine();
                        agregarObraAArtista(rut, new Obra(tit, art, year, val, est));
                        System.out.println("Obra agregada al artista.");
                    } else {
                        System.out.println("Artista no existe.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre exposición: ");
                    String nomExp = lector.readLine();
                    System.out.print("Fecha inicio: ");
                    String fechaIni = lector.readLine();
                    System.out.print("Fecha término: ");
                    String fechaTer = lector.readLine();
                    System.out.print("Lugar: ");
                    String lug = lector.readLine();
                    agregarExposicion(new Exposicion(nomExp, fechaIni, fechaTer, lug));
                    System.out.println("Exposición agregada.");
                    break;
                case 4:
                    System.out.print("Nombre exposición para obra: ");
                    nomExp = lector.readLine();
                    Exposicion exp = buscarExposicionPorNombre(nomExp);
                    if (exp != null) {
                        System.out.print("RUT artista creador de la obra: ");
                        rut = lector.readLine();
                        art = buscarArtistaPorRut(rut);
                        if (art != null) {
                            System.out.print("Título obra: ");
                            String tit = lector.readLine();
                            System.out.print("Año: ");
                            int year = Integer.parseInt(lector.readLine());
                            System.out.print("Valor: ");
                            double val = Double.parseDouble(lector.readLine());
                            System.out.print("Estado [DISPONIBLE, VENDIDO, PRESTADO]: ");
                            String est = lector.readLine();
                            Obra nuevaObra = new Obra(tit, art, year, val, est);
                            agregarObraAExposicion(nomExp, nuevaObra);
                            System.out.println("Obra agregada a exposición.");
                        } else {
                            System.out.println("Artista no existe.");
                        }
                    } else {
                        System.out.println("Exposición no existe.");
                    }
                    break;
                case 5:
                    mostrarArtistas();
                    break;
                case 6:
                    mostrarExposiciones();
                    break;
                case 9:
                    System.out.println("Salir.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}