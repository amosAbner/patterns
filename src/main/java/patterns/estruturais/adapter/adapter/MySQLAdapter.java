package patterns.estruturais.adapter.adapter;

import patterns.estruturais.adapter.api.DatabaseOperations;
import patterns.estruturais.adapter.legacy.MySQLDatabase;

/**
 * Adapter para MySQL Database.
 * Adapta a interface legada do MySQL para a interface padrão DatabaseOperations.
 */
public class MySQLAdapter implements DatabaseOperations {

    private final MySQLDatabase mysqlDatabase;

    public MySQLAdapter(MySQLDatabase mysqlDatabase) {
        this.mysqlDatabase = mysqlDatabase;
    }

    @Override
    public void connect() {
        mysqlDatabase.openConnection();
    }

    @Override
    public void disconnect() {
        mysqlDatabase.closeConnection();
    }

    @Override
    public Object select(String query) {
        return mysqlDatabase.executeQuery("SELECT " + query);
    }

    @Override
    public void insert(String table, Object data) {
        mysqlDatabase.executeUpdate("INSERT INTO " + table + " VALUES (" + data + ")");
    }

    @Override
    public void update(String table, Object data, String condition) {
        mysqlDatabase.executeUpdate("UPDATE " + table + " SET " + data + " WHERE " + condition);
    }

    @Override
    public void delete(String table, String condition) {
        mysqlDatabase.executeDelete("DELETE FROM " + table + " WHERE " + condition);
    }
}
