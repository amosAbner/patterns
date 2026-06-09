package patterns.estruturais.proxy.service;

import patterns.estruturais.proxy.proxy.YouTubeCacheProxy;

/**
 * Serviço que demonstra o uso do padrão Proxy.
 * Mede os tempos de execução para provar a eficácia do caching do Proxy.
 */
public class ProxyService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO PROXY - CACHE DE DOWNLOADS");
        System.out.println("==================================================\n");

        // Instancia o Proxy de forma direta (inicialização preguiçosa do serviço real controlada pelo proxy)
        YouTubeCacheProxy proxy = new YouTubeCacheProxy();

        // 1. Primeira requisição de informações (lenta)
        System.out.println("--- 1. Buscando dados do video 'java-design-patterns' ---");
        long inicio = System.currentTimeMillis();
        String info1 = proxy.getVideoInfo("java-design-patterns");
        long tempo1 = System.currentTimeMillis() - inicio;
        System.out.println("Resultado: " + info1);
        System.out.println("Tempo gasto: " + tempo1 + " ms\n");

        // 2. Segunda requisição de informações (instantânea do cache)
        System.out.println("--- 2. Re-buscando dados do video 'java-design-patterns' (Cache) ---");
        inicio = System.currentTimeMillis();
        String info2 = proxy.getVideoInfo("java-design-patterns");
        long tempo2 = System.currentTimeMillis() - inicio;
        System.out.println("Resultado: " + info2);
        System.out.println("Tempo gasto: " + tempo2 + " ms\n");

        // 3. Primeiro download (lento)
        System.out.println("--- 3. Baixando arquivo do video 'java-design-patterns' ---");
        inicio = System.currentTimeMillis();
        byte[] file1 = proxy.downloadVideo("java-design-patterns");
        long tempo3 = System.currentTimeMillis() - inicio;
        System.out.println("Arquivo de tamanho: " + file1.length + " bytes baixado.");
        System.out.println("Tempo gasto: " + tempo3 + " ms\n");

        // 4. Segundo download (instantâneo do cache)
        System.out.println("--- 4. Re-baixando arquivo do video 'java-design-patterns' (Cache) ---");
        inicio = System.currentTimeMillis();
        byte[] file2 = proxy.downloadVideo("java-design-patterns");
        long tempo4 = System.currentTimeMillis() - inicio;
        System.out.println("Arquivo de tamanho: " + file2.length + " bytes retornado.");
        System.out.println("Tempo gasto: " + tempo4 + " ms\n");

        // 5. Vídeo diferente (lento novamente)
        System.out.println("--- 5. Solicitando outro video 'spring-microservices' ---");
        inicio = System.currentTimeMillis();
        String info3 = proxy.getVideoInfo("spring-microservices");
        long tempo5 = System.currentTimeMillis() - inicio;
        System.out.println("Resultado: " + info3);
        System.out.println("Tempo gasto: " + tempo5 + " ms");
    }
}
