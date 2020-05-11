package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // This means that this class is a Controller
@RequestMapping(path="/mettflix") // This means URL's start with /demo (after Application path)
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody boolean addNewMovie(@RequestParam String name, @RequestParam String genre, 
			@RequestParam String bewertung ) {
		
		Movie m = new Movie();
		m.setName(name);
		m.setGenre(genre);
		m.setBewertung(bewertung);		
		movieRepository.save(m);
		
		
		return true;
	}
	
	@DeleteMapping(path=("/delete"))
	public @ResponseBody boolean deleteMovie(@RequestParam String id) {
		
		
		
		movieRepository.deleteById(Integer.valueOf(id));
		return true;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
}
