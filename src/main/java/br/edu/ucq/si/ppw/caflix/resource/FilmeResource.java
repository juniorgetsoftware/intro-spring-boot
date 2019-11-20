package br.edu.ucq.si.ppw.caflix.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ucq.si.ppw.caflix.entity.Filme;
import br.edu.ucq.si.ppw.caflix.repository.FilmeRepository;

@RestController
@RequestMapping("/filmes")
public class FilmeResource {

	@Autowired
	private FilmeRepository filmeRepository;

	@GetMapping
	public List<Filme> filmes() {
		return filmeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Filme cadastrar(@RequestBody Filme filme) {
		return filmeRepository.save(filme);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		filmeRepository.deleteById(id);
	}

}