package livrarias.DAO;

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
import livraria.classes.autores;
import livraria.classes.editoras;
import livraria.classes.livros;
import livraria.forms.Editoras_Form;

/**
 *
 * @author igos.zampieri
 */
public class livrosDAO {
    
    public void cadastrar(livros l){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO livros (id_editora, id_autor, titulo, ano) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, l.getEditora().getId());
            stmt.setInt(2, l.getAutor().getId());
            stmt.setString(3, l.getTitulo());
            stmt.setInt(4, l.getAno());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editora Cadastrada com Sucesso", "Sucesso ao Cadastrar", 1);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao Banco de Dados", "Erro de Cadastro", 2);
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<livros> listar(){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<livros> livros = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT livros.id_livro, editoras.nome as nome_editora, autores.nome as nome_autor, livros.titulo, livros.ano FROM livros\n"
                            + "inner join editoras on (editoras.id_editora = livros.id_editora)\n"
                            + "inner join autores on (autores.id_autor = livros.id_autor)");
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                livros l = new livros();
                l.setId_livro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAno(rs.getInt("ano"));
                
                editoras e = new editoras();
                e.setNome(rs.getString("nome_editora"));
                l.setEditora(e);
                
                autores a = new autores();
                a.setNome(rs.getString("nome_autor"));
                l.setAutor(a);
                
                livros.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(livrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }
    
    public static List<livros> pesquisar(String texto){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<livros> livros = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT livros.id_livro, editoras.nome as nome_editora, autores.nome as nome_autor, livros.titulo, livros.ano FROM livros\n" +
                            "inner join editoras on (editoras.id_editora = livros.id_editora)\n" +
                            "inner join autores on (autores.id_autor = livros.id_autor) WHERE titulo like ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();
        
            while (rs.next()) {
                livros l = new livros();
                l.setId_livro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAno(rs.getInt("ano"));
                
                editoras e = new editoras();
                e.setNome(rs.getString("nome_editora"));
                l.setEditora(e);
                
                autores a = new autores();
                a.setNome(rs.getString("nome_autor"));
                l.setAutor(a);
                
                livros.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(editorasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }
    
    public void excluir(livros l){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM livros WHERE id_livro = ?");
            stmt.setInt(1, l.getId_livro());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar as Alterações");
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(livros l){
        Connection conn = BancoMysql.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("UPDATE livros SET id_editora = ?, id_autor = ?, titulo = ?, ano = ? where id_livro = ?");
            stmt.setInt(1, l.getEditora().getId());
            stmt.setInt(2, l.getAutor().getId());
            stmt.setString(3, l.getTitulo());
            stmt.setInt(4, l.getAno());
            stmt.setInt(5, l.getId_livro());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar as Alterações");
            Logger.getLogger(Editoras_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
