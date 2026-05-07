package patterns.abstractFactory.service;

import patterns.abstractFactory.factory.AltoDesempenhoFactory;
import patterns.abstractFactory.factory.BasicoFactory;
import patterns.abstractFactory.factory.ComputadorFactory;
import patterns.abstractFactory.model.Computador;
import patterns.abstractFactory.model.Desktop;
import patterns.abstractFactory.model.Notebook;

/**
 * Serviço que demonstra o uso do padrão Abstract Factory.
 * Mostra como criar famílias de objetos relacionados sem conhecer suas implementações.
 */
public class AbstractFactoryService {

    /**
     * Executa os exemplos do padrão Abstract Factory.
     */
    public void executarExemplos() {
        System.out.println("========================================================");
        System.out.println("  PADRAO ABSTRACT FACTORY - FAMILIAS DE COMPUTADORES");
        System.out.println("========================================================");

        // Exemplo 1: Família de Alto Desempenho
        exemplo1_FamiliaAltoDesempenho();

        // Exemplo 2: Família Básica
        exemplo2_FamiliaBasica();

        // Exemplo 3: Polimorfismo entre famílias
        exemplo3_PolimorfismoFamilias();
    }

    /**
     * Exemplo 1: Trabalhando com a família de computadores de alto desempenho.
     */
    private void exemplo1_FamiliaAltoDesempenho() {
        System.out.println("\n--- Exemplo 1: Família Alto Desempenho ---\n");

        // Criando a factory para a família de alto desempenho
        ComputadorFactory factory = new AltoDesempenhoFactory();

        // Criando produtos da família
        Desktop desktop = factory.criarDesktop();
        Notebook notebook = factory.criarNotebook();

        System.out.println("Produtos da família ALTO DESEMPENHO:");
        System.out.println("Desktop: " + desktop.obterInformacoes());
        desktop.exibirDetalhes();

        System.out.println("Notebook: " + notebook.obterInformacoes());
        notebook.exibirDetalhes();
    }

    /**
     * Exemplo 2: Trabalhando com a família de computadores básicos.
     */
    private void exemplo2_FamiliaBasica() {
        System.out.println("\n--- Exemplo 2: Família Básica ---\n");

        // Criando a factory para a família básica
        ComputadorFactory factory = new BasicoFactory();

        // Criando produtos da família
        Desktop desktop = factory.criarDesktop();
        Notebook notebook = factory.criarNotebook();

        System.out.println("Produtos da família BÁSICA:");
        System.out.println("Desktop: " + desktop.obterInformacoes());
        desktop.exibirDetalhes();

        System.out.println("Notebook: " + notebook.obterInformacoes());
        notebook.exibirDetalhes();
    }

    /**
     * Exemplo 3: Demonstração do polimorfismo entre diferentes famílias.
     */
    private void exemplo3_PolimorfismoFamilias() {
        System.out.println("\n--- Exemplo 3: Polimorfismo entre Famílias ---\n");

        // Array de diferentes factories (famílias)
        ComputadorFactory[] factories = {
            new AltoDesempenhoFactory(),
            new BasicoFactory()
        };

        String[] nomesFamilias = {"Alto Desempenho", "Básica"};

        // Trabalhando polimorficamente com as factories
        for (int i = 0; i < factories.length; i++) {
            System.out.println("Família: " + nomesFamilias[i]);

            Computador desktop = factories[i].criarDesktop();
            Computador notebook = factories[i].criarNotebook();

            System.out.println("  → Desktop criado: " + desktop.getTipo());
            System.out.println("  → Notebook criado: " + notebook.getTipo());
            System.out.println();
        }

        System.out.println("Benefício: Mesmo código funciona com diferentes famílias!");
        System.out.println("A família específica é determinada apenas pela factory usada.");
    }
}
