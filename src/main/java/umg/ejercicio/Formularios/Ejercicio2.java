package umg.ejercicio.Formularios;

import umg.ejercicio.DataBase.Model.Ejercicio2Model;
import umg.ejercicio.DataBase.Service.Ejercicio2Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2  extends JFrame{
    private JPanel Panel3;
    private JPanel PanelEjercicio2;
    private JLabel lblTituloEj;
    private JPanel PanelDatosBot;
    private JLabel lblID;
    private JTextField textFieldIDUsuario;
    private JLabel lblCarne;
    private JTextField textFieldCarnet;
    private JLabel lblNombre;
    private JTextField textFieldNombre;
    private JLabel lblCorreo;
    private JTextField textFieldCorreo;
    private JLabel lblSeccion;
    private JTextField textFieldSeccion;
    private JButton buttonAgregar;
    private JButton buttonBuscar;
    private JButton buttonActualizar;
    private JButton buttonEliminar;
    private JLabel lblTelegramID;
    private JTextField textFieldTelegramID;
    private JLabel lblActivo;
    private JTextField textFieldActivo;

    private Ejercicio2Service ejercicio2Service = new Ejercicio2Service();

    public  Usuario () {
        setContentPane(Panel3);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ejercicio2Service usuario = new Ejercicio2Service();
                usuario.setNombre(textFieldNombre.getText());
                usuario.setCarne(textFieldCarnet.getText());
                usuario.setCorreo(textFieldCorreo.getText());
                try {
                    if (ejercicio2Service.checkEmailDuplicated(usuario.getCorreo())) {
                        JOptionPane.showMessageDialog(null, "El correo ya se encuentra en uso Por favor, utiliza otro correo.");
                        return;
                        //Si el correo existe, salir.
                    }
                    ejercicio2Service.createUser(usuario);
                    JOptionPane.showMessageDialog(null, "El nuevo usuario a sido creado exitosamente.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear el usuario:  " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textFieldIDUsuario.getText());
                    String nombre = textFieldNombre.getText();
                    String carnet = textFieldCarnet.getText();
                    String correo = textFieldCorreo.getText();
                    Ejercicio2Model usuario = new Ejercicio2Model(id, carnet, nombre, correo, "");

                    boolean actualizado = ejercicio2Service.actualizarUser(usuario);

                    if (actualizado) {
                        JOptionPane.showMessageDialog(null, "El usuario se a actualizado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El ID debe ser un numero valido.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String idText = textFieldIDUsuario.getText();

                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese un ID para eliminarlo del registro.");
                        return;
                    }

                    int id = Integer.parseInt(idText);

                    int confirmar = JOptionPane.showConfirmDialog(
                            null,
                            "¿Estas seguro de que desea eliminar el registro con el ID " + id + "?",
                            "Confirmar Eliminacion",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirmar == JOptionPane.YES_OPTION) {
                        boolean eliminado = ejercicio2Service.eliminarUser(id);

                        if (eliminado) {
                            JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: El ID debe ser un numero valido.");
                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario: " + ex.getMessage());
                    ex.printStackTrace();
                }

            }
        });


        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carnetUsuario = textFieldCarnet.getText().isEmpty() ? null : textFieldCarnet.getText();
                try {
                    Ejercicio2Model usuarioEncontrado = ejercicio2Service.getUserByCarne(carnetUsuario);
                    if (usuarioEncontrado != null) {
                        textFieldIDUsuario.setText(Integer.toString(usuarioEncontrado.getId()));
                        textFieldNombre.setText(usuarioEncontrado.getNombre());
                        textFieldCarnet.setText(usuarioEncontrado.getCarne());
                        textFieldCorreo.setText(usuarioEncontrado.getCorreo());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el usuario.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

    }
    private void limpiarCampos() {
        textFieldIDUsuario.setText("");
        textFieldNombre.setText("");
        textFieldCarnet.setText("");
        textFieldCorreo.setText("");
    }
}

}
