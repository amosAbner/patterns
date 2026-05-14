package patterns.criacionais.prototype.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * Registro centralizado de protótipos.
 * Permite armazenar e recuperar cópias de protótipos pré-configurados.
 */
public class PrototipoRegistry {

    private final Map<String, Object> prototipos = new HashMap<>();

    /**
     * Registra um protótipo com uma chave.
     */
    public void registrar(String chave, Object prototipo) {
        prototipos.put(chave, prototipo);
    }

    /**
     * Obtém um protótipo armazenado.
     */
    public Object obter(String chave) {
        return prototipos.get(chave);
    }

    /**
     * Remove um protótipo.
     */
    public void remover(String chave) {
        prototipos.remove(chave);
    }

    /**
     * Lista todas as chaves registradas.
     */
    public void listarPrototipos() {
        System.out.println("Prototipos registrados: " + prototipos.keySet());
    }
}

