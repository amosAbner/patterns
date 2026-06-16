package patterns.comportamentais.command.service;

import patterns.comportamentais.command.command.Command;
import patterns.comportamentais.command.command.LigarLuzCommand;
import patterns.comportamentais.command.command.DesligarLuzCommand;
import patterns.comportamentais.command.command.AjustarArCondicionadoCommand;
import patterns.comportamentais.command.invoker.ControleRemoto;
import patterns.comportamentais.command.receiver.Luz;
import patterns.comportamentais.command.receiver.ArCondicionado;

/**
 * Serviço que demonstra o funcionamento e a simulação prática do padrão Command.
 */
public class CommandService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO COMMAND - AUTOMAÇÃO RESIDENCIAL");
        System.out.println("==================================================\n");

        // 1. Instanciando os Receivers (Dispositivos)
        Luz luzSala = new Luz("Sala de Estar");
        ArCondicionado arQuarto = new ArCondicionado("Quarto Principal");

        // 2. Instanciando o Invoker (Controle Remoto)
        ControleRemoto controle = new ControleRemoto();

        // 3. Executando comandos de luz
        System.out.println("--- 1. Controlando a Luz da Sala ---");
        Command ligarLuz = new LigarLuzCommand(luzSala);
        Command desligarLuz = new DesligarLuzCommand(luzSala);

        // Associando o comando de ligar luz e apertando o botão
        controle.setCommand(ligarLuz);
        controle.pressionarBotao();

        // Associando o comando de desligar luz e apertando o botão
        controle.setCommand(desligarLuz);
        controle.pressionarBotao();
        System.out.println();

        // 4. Executando comandos de ar condicionado
        System.out.println("--- 2. Controlando o Ar Condicionado ---");
        Command arDezoitoGraus = new AjustarArCondicionadoCommand(arQuarto, 18);
        
        controle.setCommand(arDezoitoGraus);
        controle.pressionarBotao();
        System.out.println();

        // 5. Executando comandos de desfazer (Undo)
        System.out.println("--- 3. Desfazendo Comandos Efetuados (Undo) ---");
        
        // 5.1 Desfazer o ar condicionado (volta para desligado)
        controle.pressionarDesfazer();
        
        // 5.2 Desfazer desligar luz (liga a luz novamente)
        controle.pressionarDesfazer();
        
        // 5.3 Desfazer ligar luz (desliga a luz)
        controle.pressionarDesfazer();

        // 5.4 Desfazer sem comandos restantes
        controle.pressionarDesfazer();
    }
}
