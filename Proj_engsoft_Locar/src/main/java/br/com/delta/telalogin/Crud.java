/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.delta.telalogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Delta
 */
public class Crud {
     public static void main(String[] args) throws SQLException{
        System.out.println("Hello World");
    }
     
     public static void delta() throws SQLException{
         Connection connection = null;

        try{
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LocarDatabase", "postgres", "Aashua12680");

            ResultSet rsClient = connection.createStatement().executeQuery("select * from carro");

            while(rsClient.next()){
                System.out.println("Categoria: " + rsClient.getString("placa"));
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Driver não localizado: " + e.getMessage());
        } catch(SQLException ex) {
            System.out.println("Erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
        } 
     }
}
