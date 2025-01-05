package leiloessat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    Connection conn; //criando um objeto do tipo connection chamado conn

   public String url = "jdbc:mysql://localhost:3306/LeiloesSat?serverTimezone=America/Sao_Paulo";
//?useSSL=true&verifyServerCertificate=true
 //Nome da base de dados
    public String user = "root"; //nome do usuário do MySQL
    public String password = "258914m-"; //senha do MySQL 

    public Connection getConn() {
        return conn;
    }

    public boolean conectar() throws SQLException {

        try {
   Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, user, password);
    System.out.println("Conexão realizada com sucesso");
} catch (SQLException e) {
    System.out.println("Erro na conexão: " + e.getMessage());
    e.printStackTrace();
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(conectaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    public void Desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            //posso deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
        }
    }
    
}
    

    
    /*public Connection connectDB(){
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
*/