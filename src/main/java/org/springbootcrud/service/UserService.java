package org.springbootcrud.service;

import org.springbootcrud.dto.UserDto;
import org.springbootcrud.model.User;
import org.springbootcrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDto createUser(UserDto userDto) {


        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());

        User save = repository.save(user);

        userDto.setId(save.getId());
        userDto.setEmail(save.getEmail());
        userDto.setName(save.getName());

        return userDto;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User updateUser(Long id, User userDetails) {
        return repository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return repository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
