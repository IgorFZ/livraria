package livrarias.DAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import livraria.classes.autores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import livraria.BancoMysql;
import livraria.classes.editoras;
import livraria.forms.Autores_Form;

public class autoresDAO {
    
    public void cadastrar(autores e){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO autores (nome, endereco, numero, bairro, cidade, cpf) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getEndereco());
            stmt.setInt(3, e.getNumero());
            stmt.setString(4, e.getBairro());
            stmt.setString(5, e.getCidade());
            stmt.setBigDecimal(6, new BigDecimal(e.getCpf())); 
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Autor Cadastrado com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao Banco de Dados", "Erro de Cadastro", 2);
            Logger.getLogger(Autores_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<autores> listar(){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<autores> autores = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM autores");
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                autores a = new autores();
                a.setId(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome"));
                a.setEndereco(rs.getString("endereco"));
                a.setNumero(rs.getInt("numero"));
                a.setBairro(rs.getString("bairro"));
                a.setCidade(rs.getString("cidade"));
                a.setCpf(new BigInteger(rs.getString("cpf")));
                
                autores.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(autoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores;
    }
}
