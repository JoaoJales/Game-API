package api.Rest.jogos;

import api.Rest.jogos.main.MainGame;
import api.Rest.jogos.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class JogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JogosApplication.class, args);
	}

}

//@SpringBootApplication
//public class JogosApplication implements CommandLineRunner {
//	@Autowired
//	private GameRepository repository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(JogosApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		MainGame main = new MainGame(repository);
//		main.showMenu();
//	}
//}

