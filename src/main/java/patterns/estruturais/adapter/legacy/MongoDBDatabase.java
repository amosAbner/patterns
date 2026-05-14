package patterns.estruturais.adapter.legacy;

/**
 * Classe legada do MongoDB com interface incompatível.
 * Representa um sistema NoSQL com métodos completamente diferentes.
 */
public class MongoDBDatabase {

    public void establishConnection() {
        System.out.println("MongoDB: Conexão estabelecida com sucesso");
    }

    public void terminateConnection() {
        System.out.println("MongoDB: Conexão terminada");
    }

    public Object findDocument(String collection, String filter) {
        System.out.println("MongoDB: Buscando documento em " + collection + " com filtro: " + filter);
        return "Documento MongoDB encontrado: " + filter;
    }

    public void saveDocument(String collection, Object document) {
        System.out.println("MongoDB: Salvando documento em " + collection);
    }

    public void modifyDocument(String collection, Object document, String filter) {
        System.out.println("MongoDB: Modificando documento em " + collection);
    }

    public void removeDocument(String collection, String filter) {
        System.out.println("MongoDB: Removendo documento de " + collection);
    }
}
