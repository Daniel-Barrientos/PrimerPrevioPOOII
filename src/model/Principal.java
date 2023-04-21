package model;

import java.util.ArrayList;
import java.util.Random;

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
            System.out.println("Boleta: \n[Nombre: " + nino.getNombre() + " " + nino.getApellido() + "]");
            System.out.println("[Comida: " + comida.toString() + ", Bebida: " + bebida.toString() + "]\n");
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

    //metodo para obtener un permio aletorio de las dos opciones (bono u obsequi)
    public int obtenerPremio() {
        Random rand = new Random();
        return rand.nextInt(listaNino.size()) + 1;
    }

    //metodo para determinar al ganador, ponerle estado de gano un premio en caso de que ya haya ganado, sino cambia su estado y le da el premio
    public String realizarSorteo() {
        //se usa la clase random para obtener un numero aleatorio que determine al ganador
        Random random = new Random();
        int numRifa = random.nextInt(listaNino.size()) + 1;

        //se busca al ganador y se le pone true al estado que significa que ya gano el premio, en caso contrario no hay ganador
        for (Nino nino : listaNino) {
            //se comprueba sino ha ganado un premio
            if (!nino.getEstado()) {
                //se busca al niño ganador se le da el  premio y se le pone estado de que gano
                if (nino.getNumRifa() == numRifa) {

                    int premio = obtenerPremio();
                    nino.setRifa(new Rifa().determinarPremio(premio));
                    nino.setEstado(true);
                    return "¡Felicidades! El niño " + nino.getNombre() + " " + nino.getApellido() + " ha ganado " + nino.getRifa().getDescripcion() + ".";

                }
            } else {
                return "El niño" + nino.getNombre() + " " + nino.getApellido() + "ya ha ganado una la rifa";
            }

        }
        return "No hay ganador en esta rifa.";
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
        System.out.println("-------------------------------------\n");

        //se selecciona el refrigerio
        principal.seleccionarRefrigerio("391283", Bebida.Agua, Comida.Hamburguesa);
        principal.seleccionarRefrigerio("312382", Bebida.Gaseosa, Comida.Papitas_McDonald);
        principal.seleccionarRefrigerio("120921", Bebida.Gaseosa, Comida.Hamburguesa);
        principal.seleccionarRefrigerio("938792", Bebida.Agua, Comida.Perro_Caliente);
        System.out.println("-------------------------------------\n");

        //se realiza el sorteo
        System.out.println(principal.realizarSorteo());
        System.out.println(principal.realizarSorteo());
        
        //
        
    }

}
