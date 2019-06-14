package resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.moviecatalogservice.model.CatalogItem;
import com.sample.moviecatalogservice.model.Movie;
import com.sample.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/catalog/{userId}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogItem> getCatalog(@PathVariable String userId)
	{
		System.out.println("Hello");

		//get all rated movies corresponding to user ID
		// for each movie ID call movie info service to get details
		List<Rating> ratings=Arrays.asList(
				new Rating(1234, 4),
				new Rating(123, 5));

		
		return ratings.stream().map(rating -> 
		{
			Movie movie=restTemplate.getForObject("http://localhost:8083/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(),"testDesc",rating.getRatings());
		}).collect(Collectors.toList());

		
		/*return Collections.singletonList(
				new CatalogItem("testMovieName","testDesc",4)
				);*/
	}
}
