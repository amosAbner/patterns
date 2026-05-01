package patterns.factory.factory;

import patterns.factory.model.Heroi;
import patterns.factory.model.Personagem;
import patterns.factory.model.Vilao;

/**
 * Classe Factory - Responsável por criar instâncias de Personagens.
 *
 * O padrão Factory encapsula a lógica de criação de objetos,
 * permitindo que o código cliente trabalhe com a interface abstrata
 * sem precisar conhecer as classes concretas.
 */
public class PersonagemFactory {

    /**
     * Enum para definir os tipos de personagens disponíveis.
     */
    public enum TipoPersonagem {
        HEROI,
        VILAO
    }

    /**
     * Método factory que cria um personagem baseado no tipo solicitado.
     *
     * @param tipo - Tipo de personagem a ser criado (HEROI ou VILAO)
     * @param nome - Nome do personagem
     * @param habilidade - Habilidade principal do personagem
     * @param forca - Nível de força do personagem (1-10)
     * @param inteligencia - Nível de inteligência do personagem (1-10)
     * @return Instância de Personagem (Heroi ou Vilao)
     * @throws IllegalArgumentException se o tipo não for reconhecido
     */
    public static Personagem criarPersonagem(TipoPersonagem tipo, String nome, String habilidade,
                                            int forca, int inteligencia) {
        switch (tipo) {
            case HEROI:
                return new Heroi(nome, habilidade, forca, inteligencia);
            case VILAO:
                return new Vilao(nome, habilidade, forca, inteligencia);
            default:
                throw new IllegalArgumentException("Tipo de personagem desconhecido: " + tipo);
        }
    }

    /**
     * Método factory alternativo que aceita uma String como tipo.
     * Útil quando o tipo vem de uma configuração ou entrada do usuário.
     *
     * @param tipo - String do tipo ("HEROI" ou "VILAO")
     * @param nome - Nome do personagem
     * @param habilidade - Habilidade principal do personagem
     * @param forca - Nível de força
     * @param inteligencia - Nível de inteligência
     * @return Instância de Personagem
     */
    public static Personagem criarPersonagem(String tipo, String nome, String habilidade,
                                            int forca, int inteligencia) {
        try {
            TipoPersonagem tipoEnum = TipoPersonagem.valueOf(tipo.toUpperCase());
            return criarPersonagem(tipoEnum, nome, habilidade, forca, inteligencia);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: Tipo de personagem inválido. Use 'HEROI' ou 'VILAO'");
            throw e;
        }
    }
}

