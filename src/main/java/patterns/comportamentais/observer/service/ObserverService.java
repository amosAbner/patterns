package patterns.comportamentais.observer.service;

import patterns.comportamentais.observer.observer.Observer;
import patterns.comportamentais.observer.observer.EmailSubscriber;
import patterns.comportamentais.observer.observer.SmsSubscriber;
import patterns.comportamentais.observer.subject.CanalNoticias;

/**
 * Serviço responsável por demonstrar o funcionamento prático do padrão Observer.
 */
public class ObserverService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO OBSERVER - CANAL DE NOTÍCIAS");
        System.out.println("==================================================\n");

        // 1. Instanciando o Publicador (Subject/Canal de Notícias)
        CanalNoticias canalTech = new CanalNoticias("Tech Insiders");

        // 2. Instanciando os Observadores (Inscritos)
        Observer joao = new EmailSubscriber("João Silva", "joao.silva@email.com");
        Observer maria = new EmailSubscriber("Maria Santos", "maria.santos@email.com");
        Observer carlos = new SmsSubscriber("Carlos Souza", "+55 (11) 99999-8888");

        // 3. Cadastrando inscrições
        System.out.println("--- 1. Realizando Inscrições ---");
        canalTech.inscrever(joao);
        canalTech.inscrever(maria);
        canalTech.inscrever(carlos);
        System.out.println();

        // 4. Publicando notícia (todos devem receber)
        System.out.println("--- 2. Publicando Notícia Geral ---");
        canalTech.publicarNoticia("Java 23 lançado oficialmente com grandes novidades!");
        System.out.println();

        // 5. Cancelando inscrição de Maria
        System.out.println("--- 3. Cancelamento de Inscrição ---");
        canalTech.desinscrever(maria);
        System.out.println();

        // 6. Publicando nova notícia (apenas João e Carlos devem receber)
        System.out.println("--- 4. Publicando Nova Notícia ---");
        canalTech.publicarNoticia("Arquiteturas orientadas a eventos ganham destaque no mercado corporativo.");
    }
}
