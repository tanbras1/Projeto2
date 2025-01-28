package leiloessat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    //public void cadastrarProduto (ProdutosDTO produto){
    // Cadastrar filmes no banco de dados
    public boolean cadastrarProduto(ProdutosDTO p) {

        try {
            conectaDAO con = new conectaDAO();

            //Conexao com o banco de dados
            con.conectar();

            // Instrucao SQL que sera executada
            String sql = "INSERT INTO produtos (nome,valor,status) VALUE (?,?,?)";
            PreparedStatement consulta = con.getConn().prepareStatement(sql);

            consulta.setString(1, p.getNome());
            consulta.setInt(2, p.getValor());
            consulta.setString(3, p.getStatus());

            // Execulta a intrucao SQL
            consulta.execute();

            //Desconectar do banco de dados
            con.Desconectar();
            return true;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro ao cadastrar registro no banco de dados");
            System.out.println("Erro ao cadastrar registro no banco de dados");
            return false;
        }
    }

    //conn = new conectaDAO().connectDB();
    // Metodo para lista os dados
    public List<ProdutosDTO> listarProdutos() {
        // declaracao da variavel lista que sera retornada
        List<ProdutosDTO> listagem = new ArrayList<>();

        try {
            conectaDAO con = new conectaDAO();

            //Conexao com o banco de dados
            con.conectar();

            // Instrucao SQL que sera executada
            String sql = "SELECT * FROM produtos ";
            PreparedStatement consulta = con.getConn().prepareStatement(sql);

            // Execulta a intrucao SQL e pegar os resultados
            ResultSet resposta = consulta.executeQuery();
            while (resposta.next()) {
                ProdutosDTO p = new ProdutosDTO();

                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getInt("valor"));
                p.setStatus(resposta.getString("status"));
                listagem.add(p);
            }
            // Execulta a intrucao SQL (fiquei na duvida se tira ou deixa).
            // consulta.execute();

            //Desconectar do banco de dados
            con.Desconectar();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar registro no banco de dados");

        }
        return listagem;

    }
 public void vender(ProdutosDTO pro, String status) {

        try {
            //ProdutosDTO p = new ProdutosDTO();
            conectaDAO con = new conectaDAO();

            //Conexao com o banco de dados
            con.conectar();

            // Instrucao SQL que sera executada
            String sql = "UPDATE produtos SET status =? WHERE id=?;";
            PreparedStatement consulta = con.getConn().prepareStatement(sql);
            //consulta.setInt(1, f.getId());

            // id parametro par a consulta
            consulta.setString(1, status);
            consulta.setInt(2, pro.getId());
            
            // Execulta a instrucao sql
            consulta.execute();

            //Desconectar do banco de dados
            con.Desconectar();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar registro no banco de dados");
e.printStackTrace();
        }
}
  public ProdutosDTO getPId(int id) {
        ProdutosDTO produto = new ProdutosDTO();
        conectaDAO con = new conectaDAO();
        
        try {
            con.conectar(); 
            
            String sql = "SELECT * FROM produtos WHERE id = ?";
            PreparedStatement consulta = con.getConn().prepareStatement(sql);
            consulta.setInt(1, id);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setStatus(rs.getString("status"));
                // Defina os outros campos do produto aqui
            }
            con.Desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produto;
    }
  public List<ProdutosDTO> listarVendidos() {
        // declaracao da variavel lista que sera retornada
        List<ProdutosDTO> listagem = new ArrayList<>();

        try {
            conectaDAO con = new conectaDAO();

            //Conexao com o banco de dados
            con.conectar();

            // Instrucao SQL que sera executada
            //String sql = "SELECT id, nome, valor, status FROM produtos WHERE status LIKE ?";
            String sql = "SELECT id, nome, valor, status FROM produtos WHERE status = ?";
            PreparedStatement consulta = con.getConn().prepareStatement(sql);
            //consulta.setString(1, "%Vendido%");
            consulta.setString(1,"Vendido");
            // Execulta a intrucao SQL e pegar os resultados
            ResultSet resposta = consulta.executeQuery();
            
            while (resposta.next()) {
                ProdutosDTO p = new ProdutosDTO();

                p.setId(resposta.getInt("id"));
                p.setNome(resposta.getString("nome"));
                p.setValor(resposta.getInt("valor"));
                p.setStatus(resposta.getString("status"));
                listagem.add(p);
            }
            // Execulta a intrucao SQL (fiquei na duvida se tira ou deixa).
            // consulta.execute();

            //Desconectar do banco de dados
            con.Desconectar();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar registro no banco de dados");

        }
        return listagem;

    } 
        
}


<<<<<<< HEAD

=======
>>>>>>> 0f7cb4dcddbee933b18af357bb1e833534c14637
