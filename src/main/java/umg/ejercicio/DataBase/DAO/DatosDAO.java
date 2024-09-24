package umg.ejercicio.DataBase.DAO;

import umg.ejercicio.DataBase.Conexion.Conexion;
import umg.ejercicio.DataBase.Model.DatosModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosDAO {


    //Insert un nuevo registro

    public boolean insertar( DatosModel dato) {
        String sql = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, dato.getFechaNacimiento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //Obtener registros

    public List<DatosModel> obtenerTodos() {
        List<DatosModel> datos = new ArrayList<>();
        String sql = "SELECT * FROM tb_datos";
        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                DatosModel dato = new DatosModel();
                dato.setCodigo(rs.getInt("codigo"));
                dato.setNombre(rs.getString("nombre"));
                dato.setApellido(rs.getString("apellido"));
                dato.setDepartamento(rs.getString("departamento"));
                dato.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                datos.add(dato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    //Obtener un registro por su ID

    public DatosModel obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new DatosModel(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("departamento"),
                            rs.getDate("fecha_nacimiento")
                    );
                }
            }
        }
        return null;
    }

    //Actualizar un registro ya existente

    public boolean actualizar(DatosModel dato) {
        String sql = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dato.getNombre());
            pstmt.setString(2, dato.getApellido());
            pstmt.setString(3, dato.getDepartamento());
            pstmt.setDate(4, dato.getFechaNacimiento());
            pstmt.setInt(5, dato.getCodigo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Eliminar un registro por ID
    public boolean eliminar(int codigo) {
        String sql = "DELETE FROM tb_datos WHERE codigo = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }






}
