package controller;

import evento.Evento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegistroView;
import view.RifaView;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class RifaController implements ActionListener {

    private final Evento evento;
    private final RegistroView registroView;
    private final RifaView rifaVew;

    public RifaController(RegistroView registroView, RifaView rifaVew) {
        this.evento = Evento.instancia;
        this.registroView = registroView;
        this.rifaVew = rifaVew;
        ActionListener(this);
    }

    private void ActionListener(ActionListener controller) {
        rifaVew.btnVolver.addActionListener(controller);
        rifaVew.btnSortear.addActionListener(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().contentEquals("Sortear")) {
            
        }
        
        if (e.getActionCommand().contentEquals("Volver")) {
            
        }
        
    }

}
