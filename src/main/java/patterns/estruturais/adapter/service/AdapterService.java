package patterns.estruturais.adapter.service;

import patterns.estruturais.adapter.adapter.MongoDBAdapter;
import patterns.estruturais.adapter.adapter.MySQLAdapter;
import patterns.estruturais.adapter.api.DatabaseOperations;
import patterns.estruturais.adapter.legacy.MongoDBDatabase;
import patterns.estruturais.adapter.legacy.MySQLDatabase;

/**
 * Serviço que demonstra o uso do padrão Adapter.
 * Mostra como diferentes bancos de dados podem ser usados de forma uniforme.
 */
public class AdapterService {

    /**
     * Executa todos os exemplos do padrão Adapter.
     */
    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO ADAPTER - BANCO DE DADOS");
        System.out.println("==================================================\n");

        // Exemplo 1: Usando MySQL através do Adapter
        exemplo1_MySQLAdapter();

        // Exemplo 2: Usando MongoDB através do Adapter
        exemplo2_MongoDBAdapter();

        // Exemplo 3: Usando ambos os bancos de forma uniforme
        exemplo3_Uniformidade();

        // Exemplo 4: Benefícios do padrão Adapter
        exemplo4_Beneficios();
    }

    /**
     * Exemplo 1: Usando MySQL através do Adapter.
     */
    private void exemplo1_MySQLAdapter() {
        System.out.println("\n--- Exemplo 1: MySQL através do Adapter ---\n");

        // Cria o banco MySQL legado
        MySQLDatabase mysqlDb = new MySQLDatabase();

        // Cria o adapter
        DatabaseOperations mysqlAdapter = new MySQLAdapter(mysqlDb);

        // Usa a interface padrão
        mysqlAdapter.connect();

        Object resultado = mysqlAdapter.select("* FROM usuarios WHERE id = 1");
        System.out.println("Resultado: " + resultado);

        mysqlAdapter.insert("usuarios", "'João', 'joao@email.com'");
        mysqlAdapter.update("usuarios", "nome = 'João Silva'", "id = 1");
        mysqlAdapter.delete("usuarios", "id = 2");

        mysqlAdapter.disconnect();
    }

    /**
     * Exemplo 2: Usando MongoDB através do Adapter.
     */
    private void exemplo2_MongoDBAdapter() {
        System.out.println("\n--- Exemplo 2: MongoDB através do Adapter ---\n");

        // Cria o banco MongoDB legado
        MongoDBDatabase mongoDb = new MongoDBDatabase();

        // Cria o adapter
        DatabaseOperations mongoAdapter = new MongoDBAdapter(mongoDb);

        // Usa a interface padrão
        mongoAdapter.connect();

        Object documento = mongoAdapter.select("* FROM produtos WHERE categoria = 'eletronicos'");
        System.out.println("Documento: " + documento);

        mongoAdapter.insert("produtos", "{nome: 'Notebook', preco: 2500}");
        mongoAdapter.update("produtos", "{preco: 2300}", "nome = 'Notebook'");
        mongoAdapter.delete("produtos", "preco < 100");

        mongoAdapter.disconnect();
    }

    /**
     * Exemplo 3: Usando ambos os bancos de forma uniforme.
     */
    private void exemplo3_Uniformidade() {
        System.out.println("\n--- Exemplo 3: Uniformidade entre Bancos ---\n");

        // Cria diferentes bancos
        DatabaseOperations mysql = new MySQLAdapter(new MySQLDatabase());
        DatabaseOperations mongo = new MongoDBAdapter(new MongoDBDatabase());

        // Mesmo código funciona para ambos
        DatabaseOperations[] bancos = {mysql, mongo};
        String[] nomes = {"MySQL", "MongoDB"};

        for (int i = 0; i < bancos.length; i++) {
            System.out.println("=== Trabalhando com " + nomes[i] + " ===");

            bancos[i].connect();
            bancos[i].insert("clientes", "dados do cliente");
            Object resultado = bancos[i].select("* FROM clientes");
            System.out.println("Resultado " + nomes[i] + ": " + resultado);
            bancos[i].disconnect();

            System.out.println();
        }

        System.out.println("Mesmo código funcionou para ambos os bancos!");
    }

    /**
     * Exemplo 4: Benefícios do padrão Adapter.
     */
    private void exemplo4_Beneficios() {
        System.out.println("\n--- Exemplo 4: Benefícios do Adapter ---\n");

        System.out.println("BENEFÍCIOS DO PADRÃO ADAPTER:");
        System.out.println("=============================");
        System.out.println("1. Permite integração de sistemas legados");
        System.out.println("2. Padroniza interfaces incompatíveis");
        System.out.println("3. Código cliente fica independente da implementação");
        System.out.println("4. Facilita manutenção e evolução do sistema");
        System.out.println("5. Permite troca de implementações sem alterar código cliente");

        System.out.println("\nAPLICAÇÃO PRÁTICA:");
        System.out.println("===================");
        System.out.println("- Migração gradual de sistemas legados");
        System.out.println("- Integração com bibliotecas de terceiros");
        System.out.println("- Abstração de APIs diferentes (REST, SOAP, GraphQL)");
        System.out.println("- Compatibilidade entre versões de APIs");
    }
}
