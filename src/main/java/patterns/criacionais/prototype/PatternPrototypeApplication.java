package patterns.criacionais.prototype;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.criacionais.prototype.service.PrototypeService;

@SpringBootApplication
public class PatternPrototypeApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Prototype
        PrototypeService prototypeService = new PrototypeService();
        prototypeService.executarExemplos();
    }
}

