
package model.dao;

import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;


public class ProdutoDAO {
    
public void create(Produto p){

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    try {
        stmt = con.prepareStatement("INSERT INTO produto (nome,qtd,preco)VALUES(?,?,?)");
        stmt.setString(1,p.getNome());
        stmt.setInt(2, p.getQtd());
        stmt.setDouble(3, p.getPreco());
        
        stmt.executeUpdate();
    
        JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error" + ex);
    }finally{
        ConnectionFactory.closeConnection(con, stmt);
    }
}
public List<Produto> read(){

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Produto> produtos = new ArrayList<>();
    
    try {
       stmt = con.prepareStatement("SELECT * FROM produto");
       rs =  stmt.executeQuery();
       while(rs.next()){
       
       Produto produto = new Produto();
       produto.setId(rs.getInt("id"));
       produto.setNome(rs.getNString("nome"));
       produto.setQtd(rs.getInt("qtd"));
       produto.setPreco(rs.getDouble("preco"));
       produtos.add(produto);
       }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error" + ex);
    }finally{
    
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
    
    return produtos;

}

public void update(Produto p){

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    try {
        stmt = con.prepareStatement("UPDATE produto SET nome = ?,qtd = ?,preco = ? WHERE id = ?");
        stmt.setString(1,p.getNome());
        stmt.setInt(2, p.getQtd());
        stmt.setDouble(3, p.getPreco());
        stmt.setInt(4, p.getId());
        stmt.executeUpdate();
    
        JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error a atualizar" + ex);
    }finally{
        ConnectionFactory.closeConnection(con, stmt);
    }
}

public void delete(Produto p){
    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    
    try {
        stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
        stmt.setInt(1, p.getId());
        stmt.executeUpdate();
    
        JOptionPane.showMessageDialog(null, "Deletado do banco");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error ao Deletar" + ex);
    }finally{
        ConnectionFactory.closeConnection(con, stmt);
    }
    
}

 public List<Produto> readBuscar(String nome){
 
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Produto> produtos = new ArrayList<>();
    
    try {
       stmt = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
       stmt.setString(1, "%"+nome+"%");
       rs =  stmt.executeQuery();
       while(rs.next()){
       
       Produto produto = new Produto();
       produto.setId(rs.getInt("id"));
       produto.setNome(rs.getNString("nome"));
       produto.setQtd(rs.getInt("qtd"));
       produto.setPreco(rs.getDouble("preco"));
       produtos.add(produto);
       }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error" + ex);
    }finally{
    
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
 
    return produtos;
 }

}








