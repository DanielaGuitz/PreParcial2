package umg.ejercicio.Formularios;

import umg.ejercicio.DataBase.Model.ChampionsModel;
import umg.ejercicio.DataBase.Service.ChampionsService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static com.google.protobuf.Any.pack;

public class Champions extends JFrame {
    private JPanel Formulario1;
    private JLabel lblTitulo;
    private JPanel PanelChampions;
    private JPanel PanelDatos;
    private JLabel lblNombre;
    private JTextField textFieldNombre;
    private JLabel lblID;
    private JTextField textFieldID;
    private JLabel lblPais;
    private JTextField textFieldPais;
    private JLabel lblCiudad;
    private JTextField textFieldCiudad;
    private JLabel lblEstadio;
    private JTextField textFieldEstadio;
    private JLabel lblEntrenador;
    private JTextField textFieldEntrenador;
    private JLabel lblFundacion;
    private JTextField textFieldFundacion;
    private JPanel PanelRedes;
    private JLabel lblWeb;
    private JTextField textFieldWebOficial;
    private JLabel lblFacebook;
    private JTextField textFieldFacebook;
    private JLabel lblInstagram;
    private JTextField textFieldInstagram;
    private JLabel lblTwitter;
    private JTextField textFieldTwitter;
    private JLabel lblPatrocinador;
    private JTextField textFieldPatrocinador;
    private JButton buttonAgregar;
    private JButton buttonBuscar;
    private JPanel PanelBotones1;
    private JPanel PanelBotones2;
    private JButton buttonActualizar;
    private JButton buttonEliminar;
    private ChampionsService service = new ChampionsService();
    private ChampionsModel seleccion  = new ChampionsModel();



    public Champions (){
        setContentPane(Formulario1);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    seleccion.setNombre(textFieldNombre.getText());
                    seleccion.setPais(textFieldPais.getText());
                    seleccion.setCiudad(textFieldCiudad.getText());
                    seleccion.setEstadio(textFieldEstadio.getText());
                    seleccion.setFundacion(Integer.parseInt(textFieldFundacion.getText()));
                    seleccion.setEntrenador(textFieldEntrenador.getText());
                    seleccion.setWebOficial(textFieldWebOficial.getText());
                    seleccion.setFacebook(textFieldFacebook.getText());
                    seleccion.setTwitter(textFieldTwitter.getText());
                    seleccion.setInstagram(textFieldInstagram.getText());
                    seleccion.setPatrocinadorPrincipal(textFieldPatrocinador.getText());

                    service.insertarEquipo(seleccion);
                    JOptionPane.showMessageDialog(null, "El equipo a sido agregado exitosamente ");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Ha habido un error en los datos numericos: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el equipo: " + ex.getMessage());
                }

            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    seleccion.setIdEquipo(Integer.parseInt(textFieldID.getText()));
                    seleccion.setNombre(textFieldNombre.getText());
                    seleccion.setPais(textFieldPais.getText());
                    seleccion.setCiudad(textFieldCiudad.getText());
                    seleccion.setEstadio(textFieldEstadio.getText());
                    seleccion.setFundacion(Integer.parseInt(textFieldFundacion.getText()));
                    seleccion.setEntrenador(textFieldEntrenador.getText());
                    seleccion.setWebOficial(textFieldWebOficial.getText());
                    seleccion.setFacebook(textFieldFacebook.getText());
                    seleccion.setTwitter(textFieldTwitter.getText());
                    seleccion.setInstagram(textFieldInstagram.getText());
                    seleccion.setPatrocinadorPrincipal(textFieldPatrocinador.getText());


                    service.actualizarEquipo(seleccion);
                    JOptionPane.showMessageDialog(null, "El equipo se actualizo exitosamente");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ha habido un error en los datos numericos: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el equipo: " + ex.getMessage());
                }

            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idEquipo = Integer.parseInt(textFieldID.getText());


                    service.eliminarEquipo(idEquipo);
                    JOptionPane.showMessageDialog(null, "El equipo a sido eliminado exitosamente");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error con el ID: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha surgido un error al eliminar el equipo: " + ex.getMessage());
                }

            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del equipo que desea buscar");
                if (nombreBusqueda != null && !nombreBusqueda.isEmpty()) {
                    try {
                        List<ChampionsModel> equipos = service.obtenerTodosLosEquipos();

                        ChampionsModel equipoEncontrado = equipos.stream()
                                .filter(eq -> eq.getNombre().toLowerCase().contains(nombreBusqueda.toLowerCase()))
                                .findFirst()
                                .orElse(null);

                        if (equipoEncontrado != null) {
                            mostrarEquipoEnFormulario(equipoEncontrado);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encuentra ningun equipo con ese nombre", "El equipo no a sido encontrado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al buscar el equipo: " + ex.getMessage());
                    }
                }
            }

            private void mostrarEquipoEnFormulario(ChampionsModel equipo) {
                textFieldID.setText(String.valueOf(equipo.getIdEquipo()));
                textFieldNombre.setText(equipo.getNombre());
                textFieldPais.setText(equipo.getPais());
                textFieldCiudad.setText(equipo.getCiudad());
                textFieldEstadio.setText(equipo.getEstadio());
                textFieldFundacion.setText(String.valueOf(equipo.getFundacion()));
                textFieldEntrenador.setText(equipo.getEntrenador());
                textFieldWebOficial.setText(equipo.getWebOficial());
                textFieldFacebook.setText(equipo.getFacebook());
                textFieldTwitter.setText(equipo.getTwitter());
                textFieldInstagram.setText(equipo.getInstagram());
                textFieldPatrocinador.setText(equipo.getPatrocinadorPrincipal());
            }



        });
    }


    }

