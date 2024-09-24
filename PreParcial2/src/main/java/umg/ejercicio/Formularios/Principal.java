package umg.ejercicio.Formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends  JFrame {



    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel PanelPrincipal;
    private JPanel PanelTLT;
    private JLabel lblEjercicio;
    private JPanel PanelEjercicos;
    private JButton buttonEjercicio1;
    private JButton buttonEjercicio2;
    private JButton buttonEjercicio3;


    public Principal() {
        buttonEjercicio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos datos = new Datos();
                datos.setVisible(true);
                setVisible(false);

            }
        });
        buttonEjercicio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ejercicio2 usuarios = new Ejercicio2();
                usuarios.setVisible(true);
                setVisible(false);

            }
        });
        buttonEjercicio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Champions champions = new Champions();
                champions.setVisible(true);
                setVisible(false);

            }
        });
    }
}
