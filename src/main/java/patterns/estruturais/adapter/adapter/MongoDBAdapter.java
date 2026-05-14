package patterns.estruturais.adapter.adapter;

import patterns.estruturais.adapter.api.DatabaseOperations;
import patterns.estruturais.adapter.legacy.MongoDBDatabase;

/**
 * Adapter para MongoDB Database.
 * Adapta a interface legada do MongoDB para a interface padrão DatabaseOperations.
 */
public class MongoDBAdapter implements DatabaseOperations {

    private final MongoDBDatabase mongoDatabase;

    public MongoDBAdapter(MongoDBDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @Override
    public void connect() {
        mongoDatabase.establishConnection();
    }

    @Override
    public void disconnect() {
        mongoDatabase.terminateConnection();
    }

    @Override
    public Object select(String query) {
        // Converte query SQL-like para filtro MongoDB
        String collection = extractCollectionFromQuery(query);
        String filter = extractFilterFromQuery(query);
        return mongoDatabase.findDocument(collection, filter);
    }

    @Override
    public void insert(String table, Object data) {
        mongoDatabase.saveDocument(table, data);
    }

    @Override
    public void update(String table, Object data, String condition) {
        mongoDatabase.modifyDocument(table, data, condition);
    }

    @Override
    public void delete(String table, String condition) {
        mongoDatabase.removeDocument(table, condition);
    }

    private String extractCollectionFromQuery(String query) {
        // Simulação de extração de coleção da query
        return query.contains("FROM") ? query.split("FROM")[1].trim().split(" ")[0] : "documents";
    }

    private String extractFilterFromQuery(String query) {
        // Simulação de extração de filtro da query
        return query.contains("WHERE") ? query.split("WHERE")[1].trim() : "{}";
    }
}
