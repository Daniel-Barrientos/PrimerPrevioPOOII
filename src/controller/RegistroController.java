package controller;

import evento.Evento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Bebida;
import model.Comida;
import view.RegistroView;
import view.RifaView;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class RegistroController implements ActionListener {

    private final RegistroView registroView;
    private final RifaView rifaVew;
    private final Evento evento;

    public RegistroController(RegistroView registroView, RifaView rifaVew) {
        this.evento = Evento.obtenerInstancia();
        this.registroView = registroView;
        this.rifaVew = rifaVew;
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        registroView.btnGuardarRefrigerio.addActionListener(controller);
        registroView.btnRegistrar.addActionListener(controller);
        registroView.btnRifa.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().contentEquals("Registrar")) {

            String dni = registroView.txtDNI.getText();
            String nombre = registroView.txtNombre.getText();
            String apellido = registroView.txtApellido.getText();
            int edad = Integer.parseInt(registroView.txtEdad.getText());
            String telPadre = registroView.txtTelPadre.getText();
            int numRifa = Integer.parseInt(registroView.txtNumRifa.getText());

            evento.agregarNino(dni, nombre, apellido, edad, telPadre, numRifa);

            registroView.txtDNI.setText("");
            registroView.txtApellido.setText("");
            registroView.txtEdad.setText("");
            registroView.txtNombre.setText("");
            registroView.txtNumRifa.setText("");
            registroView.txtTelPadre.setText("");
        }

        if (e.getActionCommand().contentEquals("Guardar refrigerio")) {

            String dni = registroView.txtDNI.getText();
            String tmpBebida = registroView.cmbBebida.getSelectedItem().toString();
            String tmpComida = registroView.cmbComida.getSelectedItem().toString();

            Comida comida;

            if (tmpComida.equalsIgnoreCase("Perro Caliente")) {
                comida = Comida.Perro_Caliente;
            } else if (tmpComida.equalsIgnoreCase("Hamburguesa")) {
                comida = Comida.Hamburguesa;
            } else {
                comida = Comida.Papitas_McDonald;
            }

            evento.seleccionarRefrigerio(dni, Bebida.valueOf(tmpBebida), comida);

        }

        if (e.getActionCommand().contentEquals("Rifa")) {

            RifaController rifaController = new RifaController(registroView, rifaVew);
            rifaVew.setVisible(true);
            registroView.setVisible(false);
            
        }

    }

}
