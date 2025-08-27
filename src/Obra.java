public class Obra{
    private String title;
    private Artista autor;                                                                             
    private int year;
    private double cost;
    private String status;

    
    /*---------------------------------METODO CONSTRUCTOR---------------------------------*/
    public Obra(String title, Artista autor, int year, double cost, String status) {
        this.title = title;
        this.autor = autor;
        this.year = year;
        this.cost = cost;
        this.status = status;
    }

    /*---------------------------------SETTERS Y GETTERS----------------------------------*/
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Artista getAutor(){
        return autor;
    }
    public void setAutor(Artista autor){
        this.autor = autor;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public double getCost(){
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    /*----------------------------------------------------------------------------------------*/

    
    /*---------------------------------METODOS IMPLEMENTADOS---------------------------------*/
    public void mostrarDatosObras() {
        System.out.println("Datos de la Obra ");
        System.out.println("Titulo: " + this.title);
        System.out.println("Artista: " + this.autor.getNombre());
        System.out.println("Año: " + this.year);
        System.out.println("Costo: $" + this.cost);
        System.out.println("Estado: " + this.status);
    }
    /*--------------------------------------------------------------------------------------------*/
    
    /*---------------------------------SOBRECARGA DE METODO---------------------------------------*/
    /*Metodo que me permite mostrar los datos solo de las obras que tengan el mismo estado que el de pasado como parametro(status)*/
    public void mostrarDatosObras(String status){
        if(this.status.equals(status)){
            System.out.println("Datos de la Obra ");
            System.out.println("Titulo: " + this.title);
            System.out.println("Artista: " + this.autor.getNombre());
            System.out.println("Año: " + this.year);
            System.out.println("Costo: $" + this.cost);
            System.out.println("Estado: " + this.status);
        }
    }
    /*------------------------------------------------------------------------------------------*/
}

