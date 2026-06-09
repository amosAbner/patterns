package patterns.estruturais.proxy.realsubject;

import patterns.estruturais.proxy.subject.YouTubeLib;

/**
 * Classe que atua como o Real Subject (Sujeito Real) no padrão.
 * Contém a lógica de negócio real, simulando chamadas custosas de rede.
 */
public class RealYouTubeService implements YouTubeLib {

    @Override
    public String getVideoInfo(String videoId) {
        simularRede(1500); // Latência de rede para obter informações
        return "Video-Info [ID: " + videoId + ", Titulo: 'Design Patterns em Java', Duracao: '12:45']";
    }

    @Override
    public byte[] downloadVideo(String videoId) {
        simularRede(2000); // Latência de rede maior para download
        return new byte[]{12, 43, 67, 12, 98}; // Simulação de bytes baixados
    }

    private void simularRede(int millis) {
        System.out.println("-> [REDE] Conectando aos servidores do YouTube em cache-origin...");
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
