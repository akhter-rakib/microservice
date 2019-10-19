package ms.rakib.ratingsdataservice.resources;

import ms.rakib.ratingsdataservice.model.Rating;
import ms.rakib.ratingsdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatingList(@PathVariable("userId") String userId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("123", 4),
                new Rating("123", 5)
        );
        //wrap the list into an object to protect returning list to client . why ? plz google
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratingList);
        return userRating;
    }
}

