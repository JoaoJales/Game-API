package api.Rest.jogos.repository;

import api.Rest.jogos.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT g FROM Game g GROUP BY g ORDER BY MAX(g.rating) DESC LIMIT 5")
    List<Game> top5Games();

    @Query("SELECT g FROM Game g GROUP BY g ORDER BY MAX(g.released) DESC LIMIT 5")
    List<Game> mostRecentTop5Games();

    @Query("SELECT g FROM Game g WHERE g.developer ILIKE %:developer%")
    List<Game> getGamesFromDelevoper(String developer);
}
