package patterns.factory.service;

import patterns.factory.factory.PersonagemFactory;
import patterns.factory.factory.PersonagemFactory.TipoPersonagem;
import patterns.factory.model.Personagem;

/**
 * Serviço que demonstra como utilizar o padrão Factory.
 * <p>
 * Aqui você verá exemplos práticos de:
 * 1. Criar personagens usando a Factory
 * 2. Trabalhar com os objetos criados polimorficamente
 * 3. Os benefícios do padrão Factory
 */
public class FactoryService {

    /**
     * Executa todos os exemplos do padrão Factory.
     */
    public void executarExemplos() {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║      EXEMPLO DE USO DO PADRÃO FACTORY - PERSONAGENS       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");

        // Exemplo 1: Criando heróis usando a Factory
        exemplo1_CriandoHerois();

        // Exemplo 2: Criando vilões usando a Factory
        exemplo2_CriandoViloes();

        // Exemplo 3: Banco de personagens - usando a Factory para criar múltiplos personagens
        exemplo3_BancoDePersonagens();

        // Exemplo 4: Criando personagens com String (útil para leitura de dados externos)
        exemplo4_CriandoComString();
    }

    /**
     * Exemplo 1: Demonstra como criar heróis usando a Factory.
     */
    private void exemplo1_CriandoHerois() {
        System.out.println("\n--- Exemplo 1: Criando Heróis ---\n");

        // Criando heróis utilizando a Factory
        Personagem heroi1 = PersonagemFactory.criarPersonagem(
                TipoPersonagem.HEROI,
                "Superman",
                "Super força e voo",
                10,
                8
        );

        Personagem heroi2 = PersonagemFactory.criarPersonagem(
                TipoPersonagem.HEROI,
                "Batman",
                "Inteligência e tecnologia",
                8,
                10
        );

        // Exibindo informações e executando ações
        heroi1.exibirDescricao();
        heroi1.executarAcao();

        heroi2.exibirDescricao();
        heroi2.executarAcao();
    }

    /**
     * Exemplo 2: Demonstra como criar vilões usando a Factory.
     */
    private void exemplo2_CriandoViloes() {
        System.out.println("\n--- Exemplo 2: Criando Vilões ---\n");

        // Criando vilões utilizando a Factory
        Personagem vilao1 = PersonagemFactory.criarPersonagem(
                TipoPersonagem.VILAO,
                "Lex Luthor",
                "Inteligência brilhante",
                6,
                10
        );

        Personagem vilao2 = PersonagemFactory.criarPersonagem(
                TipoPersonagem.VILAO,
                "Coringa",
                "Caos e loucura",
                7,
                8
        );

        // Exibindo informações e executando ações
        vilao1.exibirDescricao();
        vilao1.executarAcao();

        vilao2.exibirDescricao();
        vilao2.executarAcao();
    }

    /**
     * Exemplo 3: Demonstra o poder do Factory Pattern ao gerenciar múltiplos objetos polimorficamente.
     */
    private void exemplo3_BancoDePersonagens() {
        System.out.println("\n--- Exemplo 3: Banco de Personagens ---\n");

        // Criando um array de personagens (misturando heróis e vilões)
        Personagem[] personagens = new Personagem[4];

        personagens[0] = PersonagemFactory.criarPersonagem(TipoPersonagem.HEROI, "Mulher Maravilha", "Força divina", 9, 9);
        personagens[1] = PersonagemFactory.criarPersonagem(TipoPersonagem.VILAO, "Thanos", "Poder infinito", 10, 9);
        personagens[2] = PersonagemFactory.criarPersonagem(TipoPersonagem.HEROI, "Homem Aranha", "Agilidade e força", 8, 8);
        personagens[3] = PersonagemFactory.criarPersonagem(TipoPersonagem.VILAO, "Magneto", "Controle magnético", 9, 10);

        // Iterando sobre os personagens e exibindo suas ações
        System.out.println("Todos os personagens em ação:\n");
        for (Personagem personagem : personagens) {
            personagem.executarAcao();
        }
    }

    /**
     * Exemplo 4: Criando personagens usando String como tipo (útil ao ler de arquivo ou entrada do usuário).
     */
    private void exemplo4_CriandoComString() {
        System.out.println("\n--- Exemplo 4: Criando Personagens com String ---\n");

        // Esta função é útil quando o tipo vem de uma fonte externa
        String[] tipos = {"HEROI", "VILAO", "HEROI"};
        String[] nomes = {"Capitão América", "Doctor Doom", "Homem de Ferro"};
        String[] habilidades = {"Liderança e força", "Magia e tecnologia", "Tecnologia avançada"};

        for (int i = 0; i < tipos.length; i++) {
            try {
                Personagem personagem = PersonagemFactory.criarPersonagem(
                        tipos[i],
                        nomes[i],
                        habilidades[i],
                        7 + i,
                        8 - i
                );
                personagem.executarAcao();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao criar personagem: " + e.getMessage());
            }
        }
    }
}

