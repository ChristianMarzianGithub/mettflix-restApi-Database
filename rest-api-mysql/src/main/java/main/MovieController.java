package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import org.apache.log4j.Logger;


@Controller
@RequestMapping(path="/mettflix")
public class MovieController {
	@Autowired
	private MovieRepository movieRepository;
	static Logger log = Logger.getLogger(MovieController.class.getName());
	
	@PostMapping(path="/add")
	public @ResponseBody boolean addNewMovie(@RequestParam String name, @RequestParam String genre, 
			@RequestParam String bewertung ) {
		
		log.info("\"mettflix/add\" aufgerufen");
		Movie m = new Movie();
		m.setName(name);
		m.setGenre(genre);
		m.setBewertung(bewertung);		
		movieRepository.save(m);
		return true;
	}
	
	@DeleteMapping(path=("/delete"))
	public @ResponseBody boolean deleteMovie(@RequestParam String id) {
		log.info("\"mettflix/delete\" aufgerufen");
		movieRepository.deleteById(Integer.valueOf(id));
		return true;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Movie> getAllMovies(){
		log.info("\"mettflix/all\" aufgerufen");		
		return movieRepository.findAll();
	}
}
