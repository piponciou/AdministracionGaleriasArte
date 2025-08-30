import java.io.*;

public class Galeria {
    private ListaArtistas artistas;
    private ListaExposiciones exposiciones;

    public Galeria() {
        artistas = new ListaArtistas();
        exposiciones = new ListaExposiciones();
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
