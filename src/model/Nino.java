package model;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Nino {

    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String telPadre;
    private int numRifa;
    private Bebida bebida;
    private Comida comida;
    private Rifa rifa;
    private boolean Estado = false;

    public Nino() {
    }

    public Nino(String dni, String nombre, String apellido, int edad, String telPadre, int numRifa) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telPadre = telPadre;
        this.numRifa = numRifa;
    }

    public boolean validarEdad(int edad) {
        return edad > 0 && edad <= 13;
    }

    @Override
    public String toString() {
        return "Num ganador: " + numRifa + "Nombre: " + nombre + apellido + " descripcion de la rifa: " + rifa.getDescripcion();
    }

    public Rifa getRifa() {
        return rifa;
    }

    public void setRifa(Rifa rifa) {
        this.rifa = rifa;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelPadre() {
        return telPadre;
    }

    public void setTelPadre(String telPadre) {
        this.telPadre = telPadre;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public int getNumRifa() {
        return numRifa;
    }

    public void setNumRifa(int numRifa) {
        this.numRifa = numRifa;
    }

}
