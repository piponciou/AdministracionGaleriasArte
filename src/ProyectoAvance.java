import java.io.*;
public class ProyectoAvance {
    public static void main(String[] args) throws IOException{
        Galeria galeria = new Galeria();

        // Datos hardcodeados
        Artista art1 = new Artista("11.111.111-1","Van Gogh",30);
        galeria.agregarArtista(art1);

        Obra obra1 = new Obra("La noche estrellada",art1,1889,1050000,"DISPONIBLE");
        galeria.agregarObraAArtista(art1.getRut(), obra1);

        Artista art2 = new Artista("22.222.222-2","Leonardo da Vinci",50);
        galeria.agregarArtista(art2);

        Obra obra2 = new Obra("Autorretrato",art1,1889,1100000,"DISPONIBLE");
        galeria.agregarObraAArtista(art1.getRut(), obra2);

        Obra obra3 = new Obra("La última cena",art2,1497,3000000,"PRESTADO");
        galeria.agregarObraAArtista(art2.getRut(), obra3);

        Exposicion exp1 = new Exposicion("TIME & LINE","12-11-2025","18-11-2025","París");
        galeria.agregarExposicion(exp1);
        galeria.agregarObraAExposicion(exp1.getNombreExposicion(), obra1);
        galeria.agregarObraAExposicion(exp1.getNombreExposicion(), obra2);
        galeria.agregarObraAExposicion(exp1.getNombreExposicion(), obra3);

        // Menú de consola que cumple 
        galeria.menu();
    }
}
