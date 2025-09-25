public class Visitante extends Persona {
    private String origen;

    public Visitante(String rut, String nombre, int edad, String origen) {
        super(rut, nombre, edad);
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Origen: " + origen);
    }
}