package patterns.estruturais.adapter.api;

/**
 * Interface comum para operações de banco de dados.
 * Define o contrato padrão que todos os bancos devem implementar.
 */
public interface DatabaseOperations {

    /**
     * Conecta ao banco de dados.
     */
    void connect();

    /**
     * Desconecta do banco de dados.
     */
    void disconnect();

    /**
     * Executa uma consulta SELECT.
     */
    Object select(String query);

    /**
     * Executa uma operação INSERT.
     */
    void insert(String table, Object data);

    /**
     * Executa uma operação UPDATE.
     */
    void update(String table, Object data, String condition);

    /**
     * Executa uma operação DELETE.
     */
    void delete(String table, String condition);
}
