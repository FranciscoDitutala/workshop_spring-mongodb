package com.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.config.dto.UserDTO;
import com.workshopmongo.domain.User;
import com.workshopmongo.repository.userRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private userRepository repository
;	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	public User findById(String id){
		Optional<User> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());

	}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

}
