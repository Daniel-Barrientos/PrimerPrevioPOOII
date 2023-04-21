package model;

import java.util.ArrayList;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Principal {

    private ArrayList<Nino> listaNino;

    public Principal() {
        this.listaNino = new ArrayList<>();
    }

    public void agregarNino(String dni, String nombre, String apellido, int edad, String telPadre, int numRifa) {
        Nino nino = new Nino(dni, nombre, apellido, edad, telPadre, numRifa);
        if (nino.validarEdad(edad)) {
            listaNino.add(nino);
            System.out.println("El niño ha sido agregado correcta mente");
        } else {
            System.err.println("No cumple con la edad permitida para el evento");
        }
    }

    public void seleccionarRefrigerio(String dni, Bebida bebida, Comida comida) {

        Nino nino = buscarNino(dni);
        if (nino != null) {
            nino.setComida(comida);
            nino.setBebida(bebida);
            System.out.println("Boleta: \n[Nombre: " + nino.getNombre() + nino.getApellido() + "]");
            System.out.println("[Comida: " + comida.toString() + ", Bebida: " + bebida.toString() + "]");
        }
    }

    public Nino buscarNino(String dni) {
        for (Nino niño : listaNino) {
            if (niño.getDni().equals(dni)) {
                return niño;
            }
        }
        return null;
    }

    public String realizarSorteo(int numRifa) {
        String mensaje = "El número de rifa " + numRifa + " no se encontró en la lista de participantes.";
        for (Nino nino : listaNino) {
            if (nino.getEstado()) {
                if (nino.getNumRifa() == numRifa) {
                    nino.setEstado(true);
                    return "Ganó Rifa";

                }
            }

        }
        return null;
    }

    public ArrayList<Nino> getListaNino() {
        return listaNino;
    }

    public void setListaNino(ArrayList<Nino> listaNino) {
        this.listaNino = listaNino;
    }

    public static void main(String[] args) {

        Principal principal = new Principal();

        //agrgamos niños al programa
        principal.agregarNino("391283", "Paco", "Gonzales", 10, "310", 1);
        principal.agregarNino("312382", "Sergio", "Perez", 6, "315", 2);
        principal.agregarNino("120921", "Moises", "Torres", 8, "314", 4);
        principal.agregarNino("938792", "Isaac", "Parada", 14, "313", 3);

        //se selecciona el refrigerio
        principal.seleccionarRefrigerio("391283", Bebida.Agua, Comida.Hamburguesa);
        principal.seleccionarRefrigerio("312382", Bebida.Gaseosa, Comida.Papitas_McDonald);
        principal.seleccionarRefrigerio("120921", Bebida.Gaseosa, Comida.Hamburguesa);
        principal.seleccionarRefrigerio("938792", Bebida.Agua, Comida.Perro_Caliente);

        //se realiza el sorteo
    }

}
