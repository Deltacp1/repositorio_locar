/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gking.controller;

import br.com.gking.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gking
 */
public class database {
    private static Connection connection = null;
    private static final String databaseUser = "postgres";
    private static final String databasePassword = "18216816";
    
    public database(){
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
    
    /*public static Statement createStatement() throws SQLException{
        return connection.createStatement();
    }
    
    public static ResultSet executeQuery(Statement statement, String query) throws SQLException{
        return statement.executeQuery(query);
    }*/
    
    public static Cliente consultarCliente(String nome) throws SQLException{
        Cliente cliente = null;
        
        databaseConnection();

        String sqlQuery = "select * from cliente where nome = '"+nome+"'";

        var databaseClientReturn = connection.createStatement().executeQuery(sqlQuery);
        
        if(databaseClientReturn.next()){
            cliente = new Cliente(Long.parseLong(databaseClientReturn.getString("cpf")),
                                  databaseClientReturn.getString("nome"),
                                  Long.parseLong(databaseClientReturn.getString("telefone")),
                                  databaseClientReturn.getString("email")
                                 );
        }
        
        closeConnection();
        return cliente;
    }
    
    public static boolean cadastrarCliente(Cliente cliente) throws SQLException{
        databaseConnection();
        
        String sqlQuery = ("insert into cliente (cpf, nome, telefone, email) values ('"+cliente.getCpf()+"', '"+cliente.getNome()+"', '"+cliente.getTelefone()+"', '"+cliente.getEmail()+"')");
        
        return connection.createStatement().execute(sqlQuery);
    }
    
    public static boolean atualizarCliente(long cpf, Cliente cliente) throws SQLException{
        databaseConnection();
        
        String sqlQuery = "update cliente set cpf = '"+cliente.getCpf()+"', nome = '"+cliente.getNome()+"', telefone = '"+cliente.getTelefone()+"', email = '"+cliente.getEmail()+"' where cpf = '"+cpf+"'";
        
        return connection.createStatement().execute(sqlQuery);
    }
    
    public static boolean deletarCliente(long cpf){
        try {
            databaseConnection();
            
            String sqlQuery = "delete from cliente where cpf = '"+cpf+"'";
            
            return connection.createStatement().execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
