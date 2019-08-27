/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Tiago Alves
 */
public class ConnectionFactory {
    public Connection getConnection() {
	try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projetojava","mysql","mysql");
	}         
	catch(SQLException excecao) {
            throw new RuntimeException(excecao);
	}
    }
}
