package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.javastart.controller.PrintingRunnable;

@SpringBootApplication
public class SpringDeployCargoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDeployCargoApplication.class, args);

		Thread thread = new Thread(new PrintingRunnable( 60));
		thread.start();
	}
}
