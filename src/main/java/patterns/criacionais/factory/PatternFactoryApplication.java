package patterns.criacionais.factory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import patterns.criacionais.factory.service.FactoryService;

@SpringBootApplication
public class PatternFactoryApplication {

	public static void main(String[] args) {
		// Executar os exemplos do padrão Factory
		FactoryService factoryService = new FactoryService();
		factoryService.executarExemplos();
	}

}
