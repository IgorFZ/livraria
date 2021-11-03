package livraria.DAO;

import livraria.classes.editoras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import livraria.BancoMysql;
import livraria.forms.Editoras_Form;

public class editorasDAO {
    
    public void cadastrar(editoras e){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO editoras (nome) VALUES (?)");
            stmt.setString(1, e.getNome());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editora Cadastrada com Sucesso", "Sucesso ao Cadastrar", 1);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao Banco de Dados", "Erro de Cadastro", 2);
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<editoras> listar(){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<editoras> editoras = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM editoras");
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                editoras e = new editoras();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));
            
                editoras.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return editoras;
    }
    
    public void alterar(editoras e){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("UPDATE editoras SET nome = ? where id_editora = ?");
            stmt.setString(1, e.getNome());
            stmt.setInt(2, e.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar as Alterações");
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(editoras e){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM editoras WHERE id_editora = ?");
            stmt.setInt(1, e.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar as Alterações");
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<editoras> pesquisar(String texto){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<editoras> editoras = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM editoras WHERE nome like ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                editoras e = new editoras();
                e.setId(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));
            
                editoras.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return editoras;
    }
    
}
