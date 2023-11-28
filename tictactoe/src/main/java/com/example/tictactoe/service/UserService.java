package com.example.tictactoe.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.tictactoe.data.model.Statistics;
import com.example.tictactoe.data.model.User;
import com.example.tictactoe.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(String.format("User with username={%s} not found", username));
        }
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException(String.format("User with id={%d} not found", id));
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean save(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setStatistics(new Statistics());
        userRepository.save(user);
        return true;
    }

    public boolean deleteById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
