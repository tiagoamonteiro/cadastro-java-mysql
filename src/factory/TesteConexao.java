/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author Tiago Alves
 */
public class TesteConexao {
    public static void main(String [] args) throws SQLException{
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão abetta!");
        connection.close();   
    }
}
