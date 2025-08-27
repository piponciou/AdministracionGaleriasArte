import java.util.ArrayList;

public class Exposicion {
        private String nombreExposicion;
        private String fechaInicio;
        private String fechaTermino;
        private String lugar;
        private ArrayList<Obra> obrasExpuestas ; 

        
    /*-------------------------METODO CONSTRUCTOR------------------------------------------------------*/    
    public Exposicion(String nombreExposicion, String fechaInicio, String fechaTermino, String lugar) {
        this.nombreExposicion = nombreExposicion;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.lugar = lugar; 
        this.obrasExpuestas = new ArrayList<>();
    }
    
    /*--------------------------SETTERS Y GETTERS--------------------------------------------------*/
    public String getNombreExposicion() {
        return nombreExposicion;
    }

    public void setNombreExposicion(String nombreExposicion) {
        this.nombreExposicion = nombreExposicion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<Obra> getObrasExpuestas() {
        return obrasExpuestas;
    }

    public void setObrasExpuestas(ArrayList<Obra> obrasExpuestas) {
        this.obrasExpuestas = obrasExpuestas; //Esto lo que hace es reemplazar todo el arraylist por el que se pasa como parametro
    }
        
    public void agregarObra(Obra obra){ //funcion que agrega una obra unitaria al arrayList de obras
        obrasExpuestas.add(obra);
    }
    /*--------------------------------------------------------------------------------------------------------------------*/
    
    /*-------------------METODOS IMPLEMENTADOS----------------------------------------------------------------------------*/
    public void mostrarDatosExposicion() {
        System.out.println("Nombre de la exposicion: " + this.nombreExposicion);
        System.out.println("Fecha Inicio: " + this.fechaInicio);
        System.out.println("Fecha Termino: " + this.fechaTermino);
        System.out.println("Lugar: " + this.lugar);
        System.out.println("Las obras que se expondran seran:");
        
        for(int i = 0; i<obrasExpuestas.size();i++){
            System.out.println("-----------------------------------------------------------");
            (obrasExpuestas.get(i)).mostrarDatosObras();
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/
}

 