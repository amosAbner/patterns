package patterns.builder.service;

import patterns.builder.builder.ChickenBurguerBuilder;
import patterns.builder.builder.LancheBuilder;
import patterns.builder.builder.LancheDiretor;
import patterns.builder.builder.VeggieBurguerBuilder;
import patterns.builder.builder.XBurguerBuilder;
import patterns.builder.model.Lanche;

/**
 * Serviço que demonstra o uso do padrão Builder.
 * Mostra diferentes formas de construir lanches complexos.
 */
public class BuilderService {

    /**
     * Executa todos os exemplos do padrão Builder.
     */
    public void executarExemplos() {
        System.out.println("==============================================");
        System.out.println("  PADRAO BUILDER - CONSTRUÇÃO DE LANCHES");
        System.out.println("==============================================\n");

        // Exemplo 1: Usando o Diretor (padrão completo)
        exemplo1_UsandoDiretor();

        // Exemplo 2: Builder Fluente direto
        exemplo2_BuilderFluente();

        // Exemplo 3: Customização avançada
        exemplo3_CustomizacaoAvancada();

        // Exemplo 4: Comparação de abordagens
        exemplo4_ComparacaoAbordagens();
    }

    /**
     * Exemplo 1: Usando o Diretor para construção completa.
     * O Diretor coordena todos os passos automaticamente.
     */
    private void exemplo1_UsandoDiretor() {
        System.out.println("\n--- Exemplo 1: Usando Diretor ---\n");

        LancheDiretor diretor = new LancheDiretor();

        // Construindo X-Burguer
        LancheBuilder xBurguerBuilder = new XBurguerBuilder();
        Lanche xBurguer = diretor.construirLanche(xBurguerBuilder);

        System.out.println("X-BURGUER (construído pelo Diretor):");
        xBurguer.mostrarComposicao();

        // Construindo Chicken Burguer
        LancheBuilder chickenBuilder = new ChickenBurguerBuilder();
        Lanche chickenBurguer = diretor.construirLanche(chickenBuilder);

        System.out.println("CHICKEN BURGUER (construído pelo Diretor):");
        chickenBurguer.mostrarComposicao();
    }

    /**
     * Exemplo 2: Usando Builder Fluente diretamente.
     * Controle total sobre cada ingrediente adicionado.
     */
    private void exemplo2_BuilderFluente() {
        System.out.println("\n--- Exemplo 2: Builder Fluente Direto ---\n");

        // Construindo um lanche personalizado com Builder fluente
        Lanche lanchePersonalizado = new Lanche.Builder("Pão australiano", "Hambúrguer duplo")
                .comQueijo("Gouda")
                .comBacon("Bacon crocante")
                .comOvo("Ovo frito")
                .comCebola("Cebola crispy")
                .comMolho("Barbecue")
                .montar();

        System.out.println("LANCHE PERSONALIZADO (Builder Fluente):");
        lanchePersonalizado.mostrarComposicao();

        // Construindo um lanche simples
        Lanche lancheSimples = new Lanche.Builder("Pão francês", "Salsicha").montar();

        System.out.println("LANCHE SIMPLES (apenas obrigatório):");
        lancheSimples.mostrarComposicao();
    }

    /**
     * Exemplo 3: Customização avançada com diferentes combinações.
     */
    private void exemplo3_CustomizacaoAvancada() {
        System.out.println("\n--- Exemplo 3: Customização Avançada ---\n");

        // Lanche vegetariano sem queijo
        Lanche veggieSemQueijo = new Lanche.Builder("Pão integral", "Hambúrguer de lentilha")
                .comAlface("Rúcula")
                .comTomate("Tomate seco")
                .comCebola("Cebola caramelizada")
                .comMolho("Pesto")
                .montar();

        System.out.println("VEGGIE SEM QUEIJO:");
        veggieSemQueijo.mostrarComposicao();

        // Lanche low-carb
        Lanche lowCarb = new Lanche.Builder("Pão low-carb", "Hambúrguer de carne")
                .comQueijo("Cheddar light")
                .comAlface("Mix de folhas")
                .comMolho("Mostarda Dijon")
                .montar();

        System.out.println("LOW-CARB:");
        lowCarb.mostrarComposicao();
    }

    /**
     * Exemplo 4: Comparação entre Diretor e Builder Fluente.
     */
    private void exemplo4_ComparacaoAbordagens() {
        System.out.println("\n--- Exemplo 4: Comparação de Abordagens ---\n");

        LancheDiretor diretor = new LancheDiretor();

        // Mesmo lanche construído de duas formas diferentes
        System.out.println("MESMO LANCHE - DUAS ABORDAGENS:\n");

        // Abordagem 1: Usando Diretor
        LancheBuilder veggieBuilder = new VeggieBurguerBuilder();
        Lanche veggieDiretor = diretor.construirLanche(veggieBuilder);

        System.out.println("ABORDAGEM 1 - DIRETOR:");
        veggieDiretor.mostrarComposicao();

        // Abordagem 2: Builder Fluente
        Lanche veggieFluente = new Lanche.Builder("Pão integral", "Hambúrguer de grão de bico")
                .comQueijo("Queijo vegano")
                .comAlface("Alface roxa")
                .comTomate("Tomate orgânico")
                .comCebola("Cebola caramelizada")
                .comMolho("Molho de tahine")
                .montar();

        System.out.println("ABORDAGEM 2 - BUILDER FLUENTE:");
        veggieFluente.mostrarComposicao();

        System.out.println("DIFERENCAS:");
        System.out.println("   - Diretor: Processo automatizado, menos flexibilidade");
        System.out.println("   - Fluente: Controle total, mais flexibilidade");
        System.out.println("   - Ambos: Separam construcao da representacao final");
    }
}
