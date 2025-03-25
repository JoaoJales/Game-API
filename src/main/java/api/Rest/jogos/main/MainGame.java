package api.Rest.jogos.main;

import api.Rest.jogos.model.DataGame;
import api.Rest.jogos.model.DataIdGame;
import api.Rest.jogos.model.DataResults;
import api.Rest.jogos.model.Game;
import api.Rest.jogos.repository.GameRepository;
import api.Rest.jogos.service.ConsumesApi;
import api.Rest.jogos.service.ConvertData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

public class MainGame {
    private GameRepository repository;

    private Scanner scanner = new Scanner(System.in);
    private final String BASE_ADDRESS = "https://api.rawg.io/api/games/";
    private final String API_KEY = "&key=29167cc2543347a3af346d156b9babfa";
    private ConsumesApi consumes = new ConsumesApi();
    private ConvertData convertData = new ConvertData();

    public MainGame(GameRepository repository){
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search Games
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            System.out.print("Digite uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    searchGames();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void searchGames() {
        var idGame = getIdGame();
        DataGame dataGame = getDataGame(idGame);

        Game game = new Game(dataGame);
        repository.save(game);


        System.out.printf(game.toString());

    }

    private DataGame getDataGame(Integer idGame) {
        var json = consumes.getData(BASE_ADDRESS+idGame+"?"+API_KEY);
        DataGame dataGame = convertData.getData(json, DataGame.class);
        return dataGame;
    }

    private Integer getIdGame(){
        System.out.println("Digite o titulo do Jogo:");
        var title = scanner.nextLine();

        var json = consumes.getData("https://api.rawg.io/api/games?&page=1&page_size=1&search="+title.toLowerCase().replace(' ','+')+API_KEY);
        DataResults results = convertData.getData(json, DataResults.class);

        return Integer.valueOf(results.results().getFirst().id());
    }
}
