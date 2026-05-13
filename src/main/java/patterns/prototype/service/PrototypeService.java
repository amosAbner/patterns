package patterns.prototype.service;

import patterns.prototype.model.Endereco;
import patterns.prototype.model.Pessoa;
import patterns.prototype.model.PessoaDeepClone;
import patterns.prototype.registry.PrototipoRegistry;

/**
 * Serviço que demonstra o uso do padrão Prototype.
 * Mostra shallow copy, deep copy e combinação com Builder.
 */
public class PrototypeService {

    /**
     * Executa todos os exemplos do padrão Prototype.
     */
    public void executarExemplos() {
        System.out.println("==============================================");
        System.out.println("  PADRAO PROTOTYPE - CLONAGEM DE OBJETOS");
        System.out.println("==============================================\n");

        exemplo1_ShallowCopy();
        exemplo2_DeepCopy();
        exemplo3_ProblemaShallowVsDeep();
        exemplo4_BuilderComPrototype();
        exemplo5_RegistryDePrototipos();
    }

    /**
     * Exemplo 1: Shallow Copy - Cópia superficial.
     * Objeto Endereco é compartilhado entre original e cópia.
     */
    private void exemplo1_ShallowCopy() {
        System.out.println("\n--- Exemplo 1: Shallow Copy ---\n");

        Endereco endereco = new Endereco("Rua A", "123");
        Pessoa original = new Pessoa("João", 25, endereco);

        try {
            Pessoa copia = (Pessoa) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Copia (Shallow): " + copia);

            System.out.println("\nModificando endereco da copia...");
            copia.getEndereco().setRua("Rua Modificada");

            System.out.println("Original após modificação: " + original);
            System.out.println("Copia após modificação: " + copia);
            System.out.println("\nNote: O endereco foi compartilhado! Ambas sofreram a modificação.");

        } catch (CloneNotSupportedException e) {
            System.out.println("Erro ao clonar: " + e.getMessage());
        }
    }

    /**
     * Exemplo 2: Deep Copy - Cópia profunda.
     * Objeto Endereco também é clonado, totalmente independente.
     */
    private void exemplo2_DeepCopy() {
        System.out.println("\n--- Exemplo 2: Deep Copy ---\n");

        Endereco endereco = new Endereco("Rua B", "456");
        PessoaDeepClone original = new PessoaDeepClone("Maria", 30, endereco);

        try {
            PessoaDeepClone copia = (PessoaDeepClone) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Copia (Deep): " + copia);

            System.out.println("\nModificando endereco da copia...");
            copia.getEndereco().setRua("Rua Diferente");

            System.out.println("Original após modificação: " + original);
            System.out.println("Copia após modificação: " + copia);
            System.out.println("\nNote: O endereco foi clonado! Apenas a copia sofreu a modificação.");

        } catch (CloneNotSupportedException e) {
            System.out.println("Erro ao clonar: " + e.getMessage());
        }
    }

    /**
     * Exemplo 3: Comparação visual entre Shallow e Deep Copy.
     */
    private void exemplo3_ProblemaShallowVsDeep() {
        System.out.println("\n--- Exemplo 3: Shallow vs Deep Copy ---\n");

        Endereco enderecoComum = new Endereco("Rua C", "789");

        try {
            // Shallow Copy
            Pessoa pessoaShallow = new Pessoa("Pedro", 28, enderecoComum);
            Pessoa copiaShallow = (Pessoa) pessoaShallow.clone();

            // Deep Copy
            PessoaDeepClone pessoaDeep = new PessoaDeepClone("Ana", 27, new Endereco("Rua D", "999"));
            PessoaDeepClone copiaDeep = (PessoaDeepClone) pessoaDeep.clone();

            System.out.println("SHALLOW COPY:");
            System.out.println("  Antes: " + pessoaShallow);
            copiaShallow.getEndereco().setNumero("999");
            System.out.println("  Depois (modificou copia): " + pessoaShallow);
            System.out.println("  Problema: Original foi afetado!\n");

            System.out.println("DEEP COPY:");
            System.out.println("  Antes: " + pessoaDeep);
            copiaDeep.getEndereco().setNumero("111");
            System.out.println("  Depois (modificou copia): " + pessoaDeep);
            System.out.println("  Sucesso: Original não foi afetado!");

        } catch (CloneNotSupportedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Exemplo 4: Combinação de Builder com Prototype.
     */
    private void exemplo4_BuilderComPrototype() {
        System.out.println("\n--- Exemplo 4: Builder com Prototype ---\n");

        try {
            // Criar um template com Builder
            PessoaDeepClone template = PessoaDeepClone.builder()
                    .nome("Jose")
                    .idade(28)
                    .endereco(Endereco.builder().rua("Rua E").numero("111").build())
                    .build();

            System.out.println("Template: " + template);

            // Clonar o template e modificar
            PessoaDeepClone copia1 = (PessoaDeepClone) template.clone();
            copia1.setNome("Carlos");
            copia1.getEndereco().setRua("Rua F");

            PessoaDeepClone copia2 = (PessoaDeepClone) template.clone();
            copia2.setNome("Lucas");
            copia2.getEndereco().setNumero("222");

            System.out.println("\nCopia 1: " + copia1);
            System.out.println("Copia 2: " + copia2);
            System.out.println("Template (inalterado): " + template);
            System.out.println("\nVantagem: Template reutilizável para múltiplas cópias!");

        } catch (CloneNotSupportedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Exemplo 5: Registro de Protótipos (Prototype Registry Pattern).
     */
    private void exemplo5_RegistryDePrototipos() {
        System.out.println("\n--- Exemplo 5: Registry de Prototipos ---\n");

        try {
            PrototipoRegistry registry = new PrototipoRegistry();

            // Registrar protótipos pré-configurados
            PessoaDeepClone pessoaPadrao = PessoaDeepClone.builder()
                    .nome("Pessoa Padrao")
                    .idade(25)
                    .endereco(new Endereco("Endereco Padrao", "000"))
                    .build();

            registry.registrar("pessoaPadrao", pessoaPadrao);

            PessoaDeepClone pessoaProfissional = PessoaDeepClone.builder()
                    .nome("Pessoa Profissional")
                    .idade(35)
                    .endereco(Endereco.builder().rua("Rua Comercial").numero("500").build())
                    .build();

            registry.registrar("pessoaProfissional", pessoaProfissional);

            System.out.println("Prototipos registrados:");
            registry.listarPrototipos();

            // Obter e clonar protótipos
            System.out.println("\nCriando cópias a partir do registry:");

            PessoaDeepClone copia1 = (PessoaDeepClone) ((PessoaDeepClone) registry.obter("pessoaPadrao")).clone();
            copia1.setNome("Usuario 1");

            PessoaDeepClone copia2 = (PessoaDeepClone) ((PessoaDeepClone) registry.obter("pessoaProfissional")).clone();
            copia2.setNome("Consultor");

            System.out.println("Copia 1: " + copia1);
            System.out.println("Copia 2: " + copia2);
            System.out.println("\nVantagem: Prototipos centralizados e reutilizáveis!");

        } catch (CloneNotSupportedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

