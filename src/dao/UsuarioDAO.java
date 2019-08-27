/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Tiago Alves
 */
public class UsuarioDAO {
    private Connection connection;
    Long id;
    String nome, cpf, email, telefone;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Metodo para adicionar um usuario no banco de dados
    public void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    //Metodo para listar todos os usuarios do banco de dados
    public List<Usuario> getUsuario(){
        String sql = "SELECT * FROM usuario";
        
        List<Usuario> listarUsuarios = new ArrayList<Usuario>();
        
        ResultSet rs = null;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                
                //Recupera o ID do usuario do banco e atribui ao objeto
                usuario.setId(rs.getLong("id"));

                //Recupera o nome do banco e atribui ao objeto
                usuario.setNome(rs.getString("nome"));

                //Recupera o CPF do banco e atribui ao objeto
                usuario.setCpf(rs.getString("cpf"));

                //Recupera o email do banco e atribui ao objeto
                usuario.setEmail(rs.getString("email"));
                
                //Recupera o telefone do banco e atribui ao objeto
                usuario.setTelefone(rs.getString("telefone"));

                //Adiciono o contato recuperado a lista de contatos
                listarUsuarios.add(usuario);
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return listarUsuarios;
    }
}
