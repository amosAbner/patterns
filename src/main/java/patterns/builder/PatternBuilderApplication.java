package patterns.builder;

import patterns.builder.service.BuilderService;

/**
 * Classe principal para executar os exemplos do padrão Builder.
 */
public class PatternBuilderApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Builder
        BuilderService builderService = new BuilderService();
        builderService.executarExemplos();
    }
}
