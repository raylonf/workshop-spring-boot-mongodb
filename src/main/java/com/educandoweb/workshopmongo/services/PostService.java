package com.educandoweb.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.repository.PostRepository;
import com.educandoweb.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	 
	@Autowired
	private PostRepository repo;
	
	

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String txt){
		return repo.searchTitle(txt);
	}
	
	public List<Post> fullSearch(String txt, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(txt, minDate, maxDate);
		
	}
}
