package br.com.gking.database_controller;

import br.com.delta.telalogin.Placa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gking
 */

public class Crud {
    private static Placa placaView;
    private static Connection connection = null;
    private static String databaseUser = "postgres";
    private static String databasePassword = "18216816";
    
    public Crud(Placa placaView){
        this.placaView = placaView;
    }
    
    public static void databaseConnection() throws SQLException{
       try{
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LocarDatabase", databaseUser, databasePassword);
       } catch(ClassNotFoundException e) {
           System.out.println("Driver não localizado: " + e.getMessage());
       } catch(SQLException ex) {
           System.out.println("Erro ao acessar o banco: " + ex.getMessage());
       }
    }
    
    public static void  closeConnection() throws SQLException{
        if(connection != null){
            connection.close();
        }
    }
    
    public static void buscarPlaca() throws SQLException{
        String placa = placaView.getjTextField2Placa().getText();
        
        databaseConnection();
        
        String sqlQuery = "select * from carro where placa = '"+placa+"'";
        
        ResultSet resultPlaca = connection.createStatement().executeQuery(sqlQuery);
        
        if(resultPlaca.next()){
            JOptionPane.showMessageDialog(placaView,
                    "Placa: " + resultPlaca.getString("placa") +
                    "\nMarca: " + resultPlaca.getString("marca") +
                    "\nModelo: " + resultPlaca.getString("modelo") +
                    "\nAno: " + resultPlaca.getString("ano") +
                    "\nCor: " + resultPlaca.getString("cor"));
        } else {
            JOptionPane.showMessageDialog(placaView, "Placa não consta no banco de dados!");
        }
        closeConnection();
    }
}
