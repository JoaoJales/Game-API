package api.Rest.jogos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataGame(//@JsonProperty("id") Integer id,
                       @JsonProperty("name") String name,
                       @JsonProperty("released") String released,
                       @JsonProperty("background_image") String background_image,
                       @JsonProperty("rating") Double rating,
                       @JsonProperty("developers")List<DataDevelopers> developers) {
}
