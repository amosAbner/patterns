package patterns.estruturais.adapter.legacy;

/**
 * Classe legada do MySQL com interface incompatível.
 * Representa um sistema antigo que não segue o padrão DatabaseOperations.
 */
public class MySQLDatabase {

    public void openConnection() {
        System.out.println("MySQL: Conexão aberta com sucesso");
    }

    public void closeConnection() {
        System.out.println("MySQL: Conexão fechada");
    }

    public String executeQuery(String sql) {
        System.out.println("MySQL: Executando query: " + sql);
        return "Resultado da consulta MySQL: " + sql;
    }

    public void executeUpdate(String sql) {
        System.out.println("MySQL: Executando update: " + sql);
    }

    public void executeDelete(String sql) {
        System.out.println("MySQL: Executando delete: " + sql);
    }
}
