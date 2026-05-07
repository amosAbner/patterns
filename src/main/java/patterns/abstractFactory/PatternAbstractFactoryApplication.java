package patterns.abstractFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.abstractFactory.service.AbstractFactoryService;

@SpringBootApplication
public class PatternAbstractFactoryApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrao Abstract Factory
        AbstractFactoryService abstractFactoryService = new AbstractFactoryService();
        abstractFactoryService.executarExemplos();
    }
}

