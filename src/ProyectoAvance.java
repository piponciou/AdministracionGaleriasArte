import java.util.ArrayList;
import java.util.HashMap;

public class ProyectoAvance {

    public static void main(String[] args){
        //creamos el hashmap para los artistas en el main, usando el rut como clave
        
        HashMap<String, Artista> artistas = new HashMap<>();
   
        /*---------------------------INGRESO DE 1 ARTISTA--------------------------------------------*/
        Artista art1 = new Artista("11.111.111-1","Van Gogh",30);
        //REGISTRAMOS UNA OBRA Y LE PASAMOS COMO PARAMETRO AL ARTISTA1
        Obra obra1 = new Obra("La noche estrellada",art1,1889,1050000,"DISPONIBLE");
        //ASOCIAMOS LA OBRA1 DENTRO DEL ARTISTA1
        art1.agregarObra(obra1);
        // AGREGAMOS AL HASHMAP ARTISTA 1
        artistas.put(art1.getRut(), art1);
        
        /*------------------------------------------------------------------------------------------*/
        
        /*En caso de que queramos agregarle otra obra al artista simplemente registramos primero la obra y luego lo asociamos dentro del artista correpondiente*/
        Obra obra2 = new Obra ("Autorretrato",art1,1889,1100000,"DISPONIBLE");
        art1.agregarObra(obra2);
        /*-------------------------------------------------------------------------------------------*/
        
        
        /*----------------------------INGRESO DE OTRO ARTISTA------------------------------------*/
        Artista art2 = new Artista("22.222.222-2","Leonardo da Vinci",50);
        Obra obra3 = new Obra("La última cena",art2,1497,3000000,"PRESTADO");
        art2.agregarObra(obra3);
        // AGREGAMOS AL HASHMAP ARTISTA 2
        artistas.put(art2.getRut(), art2);
        /*------------------------------------------------------------------------------------------*/
        
        
        /*----------------------AHORA REGISTRAREMOS UNA EXPOSICION----------------------------------*/
        Exposicion exp1 = new Exposicion("TIME & LINE","12-11-2025","18-11-2025","París");
        //ahora agregaremos las obras que se presentaran dentro de la exposicion
        exp1.agregarObra(obra1);
        exp1.agregarObra(obra2);
        exp1.agregarObra(obra3);
        /*-------------------------------------------------------------------------------------------*/
        
        
        /*ACA MUESTRO LOS DATOS DE LA EXPOSICION LLAMANDO AL METODO mostrarDatosExposicion()*/
        exp1.mostrarDatosExposicion();
        System.out.println("-------------------------------------------------------------");
        /*------------------------------------------------------------------------------------*/
        
        
        /*ACA PRUEBO EL METODO SOBRECARGADO DE mostrarDatosExposicion, EL CUAL TENEMOS QUE DECIDIR SI TENER UN REGISTRO SOLO PARA LAS OBRAS REGISTRADAS O RECORRER UNO POR UNO PARA SABER EL ESTADO CORRESPONDIENTE*/
        ArrayList<Obra> obraParaMostrar = art1.getObras();
        System.out.println("OBRAS DEL ARTISTA QUE TIENEN EL ESTADO DE DISPONIBLE :");
        System.out.println("---------------------------------------------------------");
        for(int i = 0; i<obraParaMostrar.size(); i++){
            (obraParaMostrar.get(i)).mostrarDatosObras("DISPONIBLE");
            System.out.println("------------------------------------------------------");
        }
        /*----------------------------------------------------------------------------------------------*/
    
        
        /*FIN*/
    }       
}