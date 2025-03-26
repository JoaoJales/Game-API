package api.Rest.jogos.service;


import api.Rest.jogos.model.Game;
import api.Rest.jogos.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<Game> getGames(){
        return repository.findAll();
    }

    public List<Game> getTop5Games(){
        return repository.top5Games();
    }

    public List<Game> getGamesFromDeveloper(String developer){
        return repository.getGamesFromDelevoper(developer);
    }
}
