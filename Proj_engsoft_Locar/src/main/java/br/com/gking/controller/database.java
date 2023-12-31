/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gking.controller;

import br.com.gking.model.Cliente;
import br.com.gking.model.Reserva;
import br.com.gking.model.Veiculo;
import br.com.gking.view.buscar_clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    
    public static Cliente consultarCliente(long cpf) throws SQLException{
        Cliente cliente = null;
        
        databaseConnection();

        String sqlQuery = "select * from cliente where cpf = '"+cpf+"'";

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
    
    public static boolean cadastrarVeiculo(Veiculo veiculo) throws SQLException{
        databaseConnection();
        
        String sqlQuery = ("insert into veículo (placa, marca, modelo, ano, cor, quilometragem, categoria, disponibilidade) values ('"+veiculo.getPlaca()+"', '"+veiculo.getMarca()+"', '"+veiculo.getModelo()+"', '"+veiculo.getAno()+"', '"+veiculo.getCor()+"', '"+veiculo.getQuilometragem()+"', '"+veiculo.getCategoria()+"', '"+veiculo.isDisponibilidade()+"')");
        
        return connection.createStatement().execute(sqlQuery);
    }
    
    public static Veiculo consultarVeiculo(String placa) throws SQLException{
        Veiculo veiculo = null;
        
        databaseConnection();

        String sqlQuery = "select * from veículo where placa = '"+placa+"'";

        var databaseVeiculoReturn = connection.createStatement().executeQuery(sqlQuery);
        
        if(databaseVeiculoReturn.next()){
            veiculo = new Veiculo(databaseVeiculoReturn.getString("placa"),
                                  databaseVeiculoReturn.getString("marca"),
                                  databaseVeiculoReturn.getString("modelo"),
                                  Integer.parseInt(databaseVeiculoReturn.getString("ano")),
                                  databaseVeiculoReturn.getString("cor"),
                                  Integer.parseInt(databaseVeiculoReturn.getString("quilometragem")),
                                  databaseVeiculoReturn.getString("categoria"),
                                  Boolean.parseBoolean(databaseVeiculoReturn.getString("disponibilidade"))
                                 );
        }
        
        closeConnection();
        return veiculo;
    }
    
    public static boolean atualizarVeiculo(String placa, Veiculo veiculo) throws SQLException{
        databaseConnection();
        
        String sqlQuery = "update veículo set placa = '"+veiculo.getPlaca()+"', marca = '"+veiculo.getMarca()+"', modelo = '"+veiculo.getModelo()+"', cor = '"+veiculo.getCor()+"', ano = '"+veiculo.getAno()+"',quilometragem = '"+veiculo.getQuilometragem()+"', categoria = '"+veiculo.getCategoria()+"', disponibilidade = '"+veiculo.isDisponibilidade()+"' where placa = '"+placa+"'";
        
        return connection.createStatement().execute(sqlQuery);
    }
    
    public static boolean deletarVeiculo(String placa){
        try {
            databaseConnection();
            
            String sqlQuery = "delete from veículo where placa = '"+placa+"'";
            
            return connection.createStatement().execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static int cadastrarReserva(Reserva reserva) throws SQLException{
        var cliente = consultarCliente(reserva.getCpf());
        if(cliente != null){
            var veiculo = consultarVeiculo(reserva.getPlaca());
            if(veiculo != null){
                var verificarDatas = true;
                if(verificarDatas){
                    databaseConnection();
                    String sqlQuery = "insert into reserva (data_retirada, data_retorno, fk_cpf, fk_placa) values ('"+reserva.getDataRetirada()+"', '"+reserva.getDataRetorno()+"', '"+reserva.getCpf()+"', '"+reserva.getPlaca()+"')";
                    var result = connection.createStatement().execute(sqlQuery);
                    return 3;
                }
            } else {
                return 2;
            }
        } else {
            return 1;
        }
        return 0;
    }
    
    public static boolean excluirReserva(Reserva reserva){
        try {
            databaseConnection();
            
            String sqlQuery = "delete from reserva where fk_placa = '"+reserva.getPlaca()+"' and fk_cpf = '"+reserva.getCpf()+"' and data_retirada = '"+reserva.getDataRetirada()+"' and data_retorno = '"+reserva.getDataRetorno()+"'";
            
            return connection.createStatement().execute(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static Reserva consultarReserva(Reserva reserva) throws SQLException{
        databaseConnection();

        String sqlQuery = "select * from reserva where fk_placa = '"+reserva.getPlaca()+"' and fk_cpf = '"+reserva.getCpf()+"' and data_retirada = '"+reserva.getDataRetirada()+"' and data_retorno = '"+reserva.getDataRetorno()+"'";

        var databaseVeiculoReturn = connection.createStatement().executeQuery(sqlQuery);
        
        if(databaseVeiculoReturn.next()){
            return reserva;
        }
        closeConnection();
        return null;
    }
}
