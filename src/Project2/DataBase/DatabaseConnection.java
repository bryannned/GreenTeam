/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rymnd
 */
public class DatabaseConnection {

    
    protected Connection conn;
    
    protected void openConnection() {
        if (conn == null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"
                     //   + System.getProperty("user.dir")
                       // + System.getProperty("file.separator")
                        + "database; create=true");
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

protected void closeConnection() {
    try{
        if (conn != null) {
            conn.close();
            conn = null;
        }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    }
}
