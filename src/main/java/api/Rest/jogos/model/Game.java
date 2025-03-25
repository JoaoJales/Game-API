package api.Rest.jogos.model;

import api.Rest.jogos.service.GeminiQuery;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static api.Rest.jogos.service.GeminiQuery.getDescription;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;
    private LocalDate released;
    private String developer;
    private Double rating;
    private String background_image;
    @Column(length = 1000)
    private String description;

    public Game () {}

    public Game(DataGame dataGame) {
        this.name = dataGame.name();
        try {
            this.released = LocalDate.parse(dataGame.released());
        }catch (DateTimeParseException ex){
            this.released = null;
        }
        this.background_image = dataGame.background_image();
        try {
            this.rating = Double.valueOf(dataGame.rating());
        }catch (NumberFormatException e){
            this.rating = 0.0;
        }
        this.developer = dataGame.developers().getFirst().name().toString();


        this.description = GeminiQuery.getDescription(dataGame.name());
    }


    public String getName() {
        return name;
    }
    public LocalDate getReleased() {
        return released;
    }
    public String getBackground_image() {
        return background_image;
    }
    public Double getRating() {
        return rating;
    }
    public String getDeveloper() {
        return developer;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", released=" + released +
                ", rating=" + rating +
                ", developers=" + developer +
                ", description="+ description +
                ", background_image='" + background_image;
    }
}
