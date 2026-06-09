package patterns.estruturais.decorator.service;

import patterns.estruturais.decorator.component.Beverage;
import patterns.estruturais.decorator.concretecomponent.Espresso;
import patterns.estruturais.decorator.concretecomponent.SimpleCoffee;
import patterns.estruturais.decorator.decorator.MilkDecorator;
import patterns.estruturais.decorator.decorator.SugarDecorator;
import patterns.estruturais.decorator.decorator.WhippedCreamDecorator;

/**
 * Serviço que demonstra o uso do padrão Decorator por meio de exemplos práticos de café.
 */
public class DecoratorService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO DECORATOR - CAFETERIA DINÂMICA");
        System.out.println("==================================================\n");

        // Exemplo 1: Café Simples sem Adicionais
        System.out.println("--- Exemplo 1: Café Simples sem Adicionais ---");
        Beverage cafeSimples = new SimpleCoffee();
        imprimirPedido(cafeSimples);
        System.out.println();

        // Exemplo 2: Café Espresso com Leite e Açúcar
        System.out.println("--- Exemplo 2: Café Espresso + Leite + Açúcar ---");
        Beverage espressoComLeiteEAçucar = new Espresso();
        espressoComLeiteEAçucar = new MilkDecorator(espressoComLeiteEAçucar);
        espressoComLeiteEAçucar = new SugarDecorator(espressoComLeiteEAçucar);
        imprimirPedido(espressoComLeiteEAçucar);
        System.out.println();

        // Exemplo 3: Café Simples com tudo (Leite, Chantilly, Açúcar)
        System.out.println("--- Exemplo 3: Café Simples + Leite + Chantilly + Açúcar ---");
        Beverage cafeCompleto = new SimpleCoffee();
        cafeCompleto = new MilkDecorator(cafeCompleto);
        cafeCompleto = new WhippedCreamDecorator(cafeCompleto);
        cafeCompleto = new SugarDecorator(cafeCompleto);
        imprimirPedido(cafeCompleto);
        System.out.println();

        // Exemplo 4: Café Espresso duplo com Chantilly (Chantilly duplo)
        System.out.println("--- Exemplo 4: Café Espresso + Chantilly Duplo ---");
        Beverage espressoSuperChantilly = new Espresso();
        espressoSuperChantilly = new WhippedCreamDecorator(espressoSuperChantilly);
        espressoSuperChantilly = new WhippedCreamDecorator(espressoSuperChantilly);
        imprimirPedido(espressoSuperChantilly);
    }

    private void imprimirPedido(Beverage beverage) {
        System.out.println("Descrição do Pedido: " + beverage.getDescription());
        System.out.printf("Preço Total       : R$ %.2f\n", beverage.getCost());
    }
}
