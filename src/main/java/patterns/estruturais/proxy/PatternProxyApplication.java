package patterns.estruturais.proxy;

import patterns.estruturais.proxy.service.ProxyService;

/**
 * Classe principal para executar os exemplos do padrão Proxy.
 */
public class PatternProxyApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Proxy
        ProxyService service = new ProxyService();
        service.executarExemplos();
    }
}
