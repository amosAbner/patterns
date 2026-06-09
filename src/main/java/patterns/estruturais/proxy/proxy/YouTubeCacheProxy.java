package patterns.estruturais.proxy.proxy;

import patterns.estruturais.proxy.realsubject.RealYouTubeService;
import patterns.estruturais.proxy.subject.YouTubeLib;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que atua como o Proxy no padrão.
 * Ela implementa a mesma interface, controla o acesso ao serviço real (preguiçoso/lazy loading)
 * e gerencia caches em memória para acelerar as requisições subsequentes dos clientes.
 */
public class YouTubeCacheProxy implements YouTubeLib {
    
    private YouTubeLib realService;
    private final Map<String, String> cacheInfo = new HashMap<>();
    private final Map<String, byte[]> cacheVideos = new HashMap<>();

    /**
     * Retorna a instância real do serviço por meio de inicialização tardia (lazy loading).
     */
    private YouTubeLib getRealService() {
        if (realService == null) {
            System.out.println("-> [PROXY] Inicializando o RealYouTubeService de forma tardia...");
            realService = new RealYouTubeService();
        }
        return realService;
    }

    @Override
    public String getVideoInfo(String videoId) {
        if (!cacheInfo.containsKey(videoId)) {
            System.out.println("-> [PROXY] Informacao do video '" + videoId + "' nao encontrada no cache.");
            String info = getRealService().getVideoInfo(videoId);
            cacheInfo.put(videoId, info);
            return info;
        }
        
        System.out.println("-> [PROXY] Retornando informacao do video '" + videoId + "' DIRETAMENTE do cache.");
        return cacheInfo.get(videoId);
    }

    @Override
    public byte[] downloadVideo(String videoId) {
        if (!cacheVideos.containsKey(videoId)) {
            System.out.println("-> [PROXY] Arquivo do video '" + videoId + "' nao encontrado no cache.");
            byte[] file = getRealService().downloadVideo(videoId);
            cacheVideos.put(videoId, file);
            return file;
        }

        System.out.println("-> [PROXY] Retornando download do video '" + videoId + "' DIRETAMENTE do cache.");
        return cacheVideos.get(videoId);
    }

    /**
     * Permite limpar o cache manualmente se necessário.
     */
    public void resetCache() {
        cacheInfo.clear();
        cacheVideos.clear();
        System.out.println("-> [PROXY] Cache de midia limpo com sucesso.");
    }
}
