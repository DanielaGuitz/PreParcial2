package umg.ejercicio.DataBase.DAO;

import umg.ejercicio.DataBase.Conexion.Conexion;
import umg.ejercicio.DataBase.Model.ChampionsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampionsDAO {
    //Ingreso de nuevo equipo en la Base de Datos
    public boolean insertar(ChampionsModel seleccion) {
        String sql = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, seleccion.getNombre());
            pstmt.setString(2, seleccion.getPais());
            pstmt.setString(3, seleccion.getCiudad());
            pstmt.setString(4, seleccion.getEstadio());
            pstmt.setInt(5, seleccion.getFundacion());
            pstmt.setString(6,seleccion.getEntrenador());
            pstmt.setString(7, seleccion.getWebOficial());
            pstmt.setString(8, seleccion.getFacebook());
            pstmt.setString(9, seleccion.getTwitter());
            pstmt.setString(10, seleccion.getInstagram());
            pstmt.setString(11, seleccion.getPatrocinadorPrincipal());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //Obtener equipos de la Base de Datos

    public List<ChampionsModel> obtenerTodos() {
        List<ChampionsModel> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipos_champions";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ChampionsModel equipo = new ChampionsModel();
                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setPais(rs.getString("pais"));
                equipo.setCiudad(rs.getString("ciudad"));
                equipo.setEstadio(rs.getString("estadio"));
                equipo.setFundacion(rs.getInt("fundacion"));
                equipo.setEntrenador(rs.getString("entrenador"));
                equipo.setWebOficial(rs.getString("web_oficial"));
                equipo.setFacebook(rs.getString("facebook"));
                equipo.setTwitter(rs.getString("twitter"));
                equipo.setInstagram(rs.getString("instagram"));
                equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                equipos.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipos;
    }

    //Actualizacion de equipos de la Base de Datos
    public boolean actualizar(ChampionsModel equipo) {
        String sql = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, equipo.getNombre());
            pstmt.setString(2, equipo.getPais());
            pstmt.setString(3, equipo.getCiudad());
            pstmt.setString(4, equipo.getEstadio());
            pstmt.setInt(5, equipo.getFundacion());
            pstmt.setString(6, equipo.getEntrenador());
            pstmt.setString(7, equipo.getWebOficial());
            pstmt.setString(8, equipo.getFacebook());
            pstmt.setString(9, equipo.getTwitter());
            pstmt.setString(10, equipo.getInstagram());
            pstmt.setString(11, equipo.getPatrocinadorPrincipal());
            pstmt.setInt(12, equipo.getIdEquipo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Eliminacion de un equipo de la base de datos por medio del ID
    public boolean eliminar(int idEquipo) {
        String sql = "DELETE FROM equipos_champions WHERE id_equipo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEquipo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    //Obtener un equipo por su ID
    public ChampionsModel obtenerPorId(int idEquipo) {
        String sql = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idEquipo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ChampionsModel equipo = new ChampionsModel();
                    equipo.setIdEquipo(rs.getInt("id_equipo"));
                    equipo.setNombre(rs.getString("nombre"));
                    equipo.setPais(rs.getString("pais"));
                    equipo.setCiudad(rs.getString("ciudad"));
                    equipo.setEstadio(rs.getString("estadio"));
                    equipo.setFundacion(rs.getInt("fundacion"));
                    equipo.setEntrenador(rs.getString("entrenador"));
                    equipo.setWebOficial(rs.getString("web_oficial"));
                    equipo.setFacebook(rs.getString("facebook"));
                    equipo.setTwitter(rs.getString("twitter"));
                    equipo.setInstagram(rs.getString("instagram"));
                    equipo.setPatrocinadorPrincipal(rs.getString("patrocinador_principal"));
                    equipo.setCreadoEn(rs.getTimestamp("creado_en"));
                    return equipo;
                }
            }


        } catch (SQLException e) {


            e.printStackTrace();
        }
        return null;

    }

}
