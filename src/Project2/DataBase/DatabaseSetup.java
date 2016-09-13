/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2.DataBase;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rymnd
 */
public class DatabaseSetup extends DatabaseConnection {

    public static void setupDatabase() {
        DatabaseSetup dbs = new DatabaseSetup();
        dbs.databaseSetup();
    }

    private void databaseSetup() {
        openConnection();
        try {
// Determine if the COORDINATOR table already exists or not
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, "APP", "COORDINATOR", null);
            if (!rs.next()) {
// If the COORDINATOR table does not already exist we create it 
                PreparedStatement createCoordinatorTable = conn.prepareStatement(
                        "CREATE TABLE APP.COORDINATOR ("
                        + "\"COOR_ID\" INT not null primary key "
                        + "GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "     
                                //this is a sequence for the ID which is a primary key
                        + "\"COOR_PASSWORD\" VARCHAR(100), "
                        + "\"COOR_FNAME\" VARCHAR(100), "
                        + "\"COOR_LNAME\" VARCHAR(100), "
                        + "\"COOR_EMAIL\" VARCHAR(50) "
                        + "\"COOR_MOBILE_NUM\" VARCHAR(100), "
                        + ")");
                createCoordinatorTable.execute();
                                
                            
                // Determine if the STUDENT table already exists or not
            ResultSet rs2 = dbmd.getTables(null, "APP", "STUDENT", null);
            if (!rs2.next()) {
          // If the STUDENT table does not already exist we create it 
// TODO Create the tables other tables for the database here
                PreparedStatement createStudentTable = conn.prepareStatement(
                        "CREATE TABLE APP.STUDENT ("
                        + "\"STU_ID\" INT,"
                        + "\"STU_FNAME\" VARCHAR(100),"
                        + "\"STU_LNAME\" VARCHAR(100),"
                        + "\"STU_MOBILE_NUM\" VARCHAR(100),"
                        + "\"STU_COURSE\" VARCHAR(100),"     
                        + "\"STU_ADDRESS\" VARCHAR(100),"
                        + "\"STU_EMAIL\" VARCHAR(100)");
                createStudentTable.execute();

            }
            
   // If the CONSULTATION table does not already exist we create it 
    ResultSet rs3 = dbmd.getTables(null, "APP", "CONSULTATION", null);
                if (!rs2.next()) {
                PreparedStatement createConsultationTable = conn.prepareStatement(
                        "CREATE TABLE APP.CONSULTATION ("
                        + "\"FORM_ID\" INT,"
                        + "\"FORM_DATE\" DATE,"
                        + "\"FORM_START_TIME\" TIME,"
                        + "\"FORM_END_TIME\" TIME,"
                        + "\"FORM_DESCRIPTION\" VARCHAR(100),"
                        + "\"FORM_NOTE\" VARCHAR(100),"
                        + "\"FORM_CON_TYPE\" VARCHAR(100),"
                        + "\"STU_ID\" INT,"
                        + "\"STU_FNAME\" VARCHAR(100),"
                        + "\"STU_LNAME\" VARCHAR(100),");
                createConsultationTable.execute();

            }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        closeConnection();
    }
}
