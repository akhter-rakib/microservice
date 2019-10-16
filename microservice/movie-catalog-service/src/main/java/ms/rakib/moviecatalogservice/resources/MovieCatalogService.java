package ms.rakib.moviecatalogservice.resources;

import ms.rakib.moviecatalogservice.model.CatalogItem;
import ms.rakib.moviecatalogservice.model.Movie;
import ms.rakib.moviecatalogservice.model.Rating;
import ms.rakib.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {
    //get all rated movie id
    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
        return ratings.getUserRating().stream().map(rating -> {
            //for each movie id, call movie info and get details
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            //put them all together
            return new CatalogItem(movie.getName(), "Desktop", rating.getRating());
        }).collect(Collectors.toList());
    }
}
