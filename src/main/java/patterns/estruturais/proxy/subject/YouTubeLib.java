package patterns.estruturais.proxy.subject;

/**
 * Interface que atua como o Subject (Sujeito) no padrão Proxy.
 * Define a interface comum para o serviço real e o proxy, de modo que
 * o cliente possa interagir com o proxy de forma transparente.
 */
public interface YouTubeLib {
    
    /**
     * Obtém informações detalhadas de um vídeo.
     * @param videoId ID do vídeo
     * @return informações textuais do vídeo
     */
    String getVideoInfo(String videoId);

    /**
     * Simula o download do arquivo de vídeo.
     * @param videoId ID do vídeo
     * @return bytes representativos do vídeo (simulados)
     */
    byte[] downloadVideo(String videoId);
}
