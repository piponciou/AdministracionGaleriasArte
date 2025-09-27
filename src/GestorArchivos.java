import java.io.*;
import java.util.ArrayList;
import java.nio.file.*;

public class GestorArchivos {

    // Guarda lista de obras en archivo CSV
    public static void guardarObras(ArrayList<Obra> obras, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
        for (Obra obra : obras) {
            String linea = String.join(",",
                escapeCsv(obra.getTitle()),
                escapeCsv(obra.getAutor().getRut()), // guardamos rut del autor para enlazar
                String.valueOf(obra.getYear()),
                String.valueOf(obra.getCost()),
                escapeCsv(obra.getStatus())
            );
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
    }

    // Lee lista de obras desde archivo CSV
    public static ArrayList<Obra> cargarObras(String filename, ArrayList<Artista> artistas) throws IOException {
        ArrayList<Obra> obras = new ArrayList<>();
        ArrayList<String> lineas = (ArrayList<String>) Files.readAllLines(Paths.get(filename));
        for (String linea : lineas) {
            String[] datos = parseCsvLine(linea);
            if (datos.length < 5) continue;
            String titulo = datos[0];
            String rutAutor = datos[1];
            int anio = Integer.parseInt(datos[2]);
            double costo = Double.parseDouble(datos[3]);
            String estado = datos[4];

            // Buscar artista por rut
            Artista autor = encontrarArtistaPorRut(artistas, rutAutor);
            if (autor != null) {
                Obra obra = new Obra(titulo, autor, anio, costo, estado);
                obras.add(obra);
            }
        }
        return obras;
    }

    // Guarda lista de artistas en archivo CSV
    public static void guardarArtistas(ArrayList<Artista> artistas, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Artista artista : artistas) {
            String linea = String.join(",",
                escapeCsv(artista.getRut()),
                escapeCsv(artista.getNombre()),
                String.valueOf(artista.getEdad())
            );
            bw.write(linea);
            bw.newLine();
        }
        bw.close();
    }

    // Lee lista de artistas desde archivo CSV
    public static ArrayList<Artista> cargarArtistas(String filename) throws IOException {
        ArrayList<Artista> artistas = new ArrayList<>();
        ArrayList<String> lineas = (ArrayList<String>) Files.readAllLines(Paths.get(filename));
        for (String linea : lineas) {
            String[] datos = parseCsvLine(linea);
            String rut = datos[0];
            String nombre = datos[1];
            int edad = Integer.parseInt(datos[2]);
            Artista artista = new Artista(rut, nombre, edad);
            artistas.add(artista);
        }
        return artistas;
    }

    // Encuentra artista por rut en lista
    private static Artista encontrarArtistaPorRut(ArrayList<Artista> artistas, String rut) {
        for (Artista artista : artistas) {
            if (artista.getRut().equals(rut)) {
                return artista;
            }
        }
        return null;
    }

    // Escapa caracteres especiales CSV (coma, salto línea, comillas)
    private static String escapeCsv(String campo) {
        if (campo.contains(",") || campo.contains("\"") || campo.contains("\n")) {
            campo = campo.replace("\"", "\"\"");
            campo = "\"" + campo + "\"";
        }
        return campo;
    }

    // Parsea línea CSV considerando comillas y comas interiores
    private static String[] parseCsvLine(String linea) {
        ArrayList<String> campos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean enComillas = false;
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c == '"') {
                enComillas = !enComillas; // alterna estado
            } else if (c == ',' && !enComillas) {
                campos.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        campos.add(sb.toString());
        return campos.toArray(new String[0]);
    }
}