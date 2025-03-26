package api.Rest.jogos.controller;

import api.Rest.jogos.model.Game;
import api.Rest.jogos.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> getGames(){
        return service.getGames();
    }

    @GetMapping("/top5")
    public List<Game> getTop5Games(){
        return service.getTop5Games();
    }

    @GetMapping("/developer/{name}")
    public List<Game> getGamesFromDeveloper(@PathVariable String name){
        return service.getGamesFromDeveloper(name);
    }
}
