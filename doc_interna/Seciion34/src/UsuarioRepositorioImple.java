import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImple implements Repositorio<UsuarioEntidad> {
    public UsuarioRepositorioImple() {
    }

    private Connection conectar() throws SQLException {
        return conexionBBDD.getConexion();
    }

    @Override
    public void add(UsuarioEntidad u) {
        String sqlQuery = "INSERT INTO usuario (username,password,email) VALUES(?,?,?)";
        try(PreparedStatement ps = conectar().prepareStatement(sqlQuery)){
            ps.setString(1, u.getUsuername());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getEmail());
            ps.executeUpdate();

        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<UsuarioEntidad> listar() {
        List<UsuarioEntidad> usuario = new ArrayList<>();
        try(PreparedStatement ps = conectar().prepareStatement("SELECT * FROM usuario;")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs);// comprobar si imprime
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = conectar().prepareStatement("DELETE FROM usuario WHERE id=?")) {
            ps.setLong(1, id);
            ps.executeUpdate();//IMPORTANTE SE TE OLVIDA SIEMPRE!!!!!!
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(UsuarioEntidad u) {
        try(PreparedStatement ps = conectar().prepareStatement("UPDATE usuario SET username = ? password = ? email = ? WHERE id = ?")){
            ps.setString(1,u.getUsuername());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getEmail());
            ps.setLong(4,u.getId());
        }catch (SQLException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
