package patterns.criacionais.abstractFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.criacionais.abstractFactory.service.AbstractFactoryService;

@SpringBootApplication
public class PatternAbstractFactoryApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrao Abstract Factory
        AbstractFactoryService abstractFactoryService = new AbstractFactoryService();
        abstractFactoryService.executarExemplos();
    }
}
