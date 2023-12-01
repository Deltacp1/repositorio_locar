package br.com.gking.database_controller;

import br.com.delta.telalogin.Cadveiculos;
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
    private static Connection connection = null;
    private static String databaseUser = "postgres";
    private static String databasePassword = "18216816";
    
    public Crud(){
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
    
    public static boolean buscarPlaca(Placa placaView) throws SQLException{
        String placa = placaView.getjTextField2Placa().getText();
        
        databaseConnection();
        
        String sqlQuery = "select * from carro where placa = '"+placa+"'";
        
        ResultSet resultPlaca = connection.createStatement().executeQuery(sqlQuery);
        
        if(resultPlaca.next()){
            closeConnection();
            JOptionPane.showMessageDialog(placaView, "Veículo já cadastrado!");/*
            JOptionPane.showMessageDialog(placaView,
                "Placa: " + resultPlaca.getString("placa") +
                "\nMarca: " + resultPlaca.getString("marca") +
                "\nModelo: " + resultPlaca.getString("modelo") +
                "\nAno: " + resultPlaca.getString("ano") +
                "\nCor: " + resultPlaca.getString("cor"));*/
            return true;
        }
        return false;
    }
    
    public static void cadastrarVeiculoNoBanco(String placa, String marca, String modelo, int ano, String cor, int quilometragem, String categoria, boolean disponibilidade ) throws SQLException{
        databaseConnection();
        String sqlQuery = "insert into carro (placa, marca, modelo, ano, cor, quilometragem, categoria, disponibilidade) values ('"+placa+"', '"+marca+"', '"+modelo+"', '"+ano+"', '"+cor+"', '"+quilometragem+"', '"+categoria+"', '"+disponibilidade+"')";
        connection.createStatement().executeQuery(sqlQuery);
    }
}
