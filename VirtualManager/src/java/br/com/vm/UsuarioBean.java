/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class UsuarioBean extends NewClass {

    private String idusuario;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private Connection conn;

    public void abrirConexao() throws SQLException, NamingException, ClassNotFoundException {
        if (getConn() != null) {
            return;
        }
        Class.forName("com.mysql.jdbc.Driver");//org.gjt.mm.mysql.Driver
        setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/virtualmanager", "root", "root"));
    }
    //metodo para selecionar todos os campos da tab livros e retornar em forma de lista

    public Result getLista() throws SQLException, NamingException, ClassNotFoundException {
        try {
            abrirConexao();
            Statement stmt = getConn().createStatement();
            ResultSet result = stmt.executeQuery("SELECT * from usuario");
            return ResultSupport.toResult(result);
        } finally {
            fecharConexao();
        }
    }
    //metodo para selecionar e retornar cod e titulo (1 registro da tabela) para ser usado na edição(alterar)

    public Result getEditar() throws SQLException, NamingException, ClassNotFoundException {
        try {
            abrirConexao();
            Statement stmt = getConn().createStatement();
            ResultSet result = stmt.executeQuery("SELECT idusuario, nome, cpf, login, senha from usuario where idusuario = '" + getIdusuario() + "'");
            return ResultSupport.toResult(result);
        } finally {
            fecharConexao();
        }
    }
    //metodo para inserir livro

    public void inserir() throws SQLException, NamingException, ClassNotFoundException {
        try {
            abrirConexao();
            Statement stmt = getConn().createStatement();
            stmt.executeUpdate("INSERT INTO usuario(nome, cpf, login, senha) VALUES ('" + getNome() + "' , '" + getLogin() + "' , '" + getSenha() + "');");
            stmt.close();
        } finally {
            fecharConexao();
        }
    }
    //metodo para alterar livro do banco

    public void alterar() throws SQLException, NamingException, ClassNotFoundException {
        try {
            abrirConexao();
            Statement stmt = getConn().createStatement();
            stmt.executeUpdate("UPDATE usuario SET idusuario = '" + getIdusuario() + "' , nome = '" + getNome() + "' , cpf= '" + getCpf() +"' , login = '" + getLogin() + "' , senha = '" + getSenha() + "' WHERE idusuario = '" + getIdusuario() + "'");
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
        }
    }
    //metodo para excluir livro do banco

    public void excluir() throws SQLException, NamingException, ClassNotFoundException {
        //String result = "erro";  //o metodo seria String caso retornasse algum valor
        try {
            abrirConexao();
            Statement stmt = getConn().createStatement();
            stmt.executeUpdate("delete from usuario where idusuario = '" + getIdusuario() + "'");
            stmt.close();
            //  result = "ok";
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
            //result = "erro";
        }
        //return result;
    }

    public void fecharConexao() throws SQLException {
        if (getConn() == null) {
            return;
        }
        getConn().close();
        setConn(null);
    }

    //getter serve para retornar o valor da variavel
    //setter serve para receber(setar) o valor da variavel
    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //cadastrar é um apelido que chama a página incluir.jsp - mapeado no faces-config
    public String cadastrar() {
        return "cadastrar";
    }

    //editar é um apelido que chama a página alterar.jsp - mapeado no faces-config
    public String editar() {
        return "editar";
    }

    //voltar é um apelido que chama a página index.jsp - mapeado no faces-config
    public String voltar() {
        return "voltar";
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
}