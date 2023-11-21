package com.example.demo.usuario.service;

import com.example.demo.usuario.dto.UserDTO;
import com.example.demo.usuario.repository.UserRepository;
import org.hibernate.sql.Update;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.usuario.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ModelMapper mapper = new ModelMapper();

    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public UserDTO getUserId(Long id) {
        User user = userRepository.findById(id).orElse(null);

        return mapper.map(user, UserDTO.class);
    }

    public String update(String email, User updated_user) {

        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if(optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setEmail(updated_user.getEmail());
            existingUser.setPassword(updated_user.getPassword());
            existingUser.setPhone(updated_user.getPhone());
            existingUser.setFirstName(updated_user.getFirstName());
            existingUser.setLastName(updated_user.getLastName());
            existingUser.setProfilePic(updated_user.getProfilePic());
            existingUser.setBirth(updated_user.getBirth());
            existingUser.setRole(updated_user.getRole());

            userRepository.save(existingUser);

            return "Updated";
        }

        return "Not Found";
    }
    public String patch(String email, User updatedUser) {
        Boolean exist = userRepository.existsByEmail(email);
        User existing_user;
        if (exist) {
            existing_user = userRepository.findByEmail(email);
        }
        else {
            existing_user = null;
        }

        if (existing_user != null) {
            if (updatedUser.getEmail() != null) {
                existing_user.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getPassword() != null) {
                existing_user.setPassword(updatedUser.getPassword());
            }
            if (updatedUser.getPhone() != null) {
                existing_user.setPhone(updatedUser.getPhone());
            }
            if (updatedUser.getFirstName() != null) {
                existing_user.setFirstName(updatedUser.getFirstName());
            }
            if (updatedUser.getLastName() != null) {
                existing_user.setLastName(updatedUser.getLastName());
            }
            if (updatedUser.getProfilePic() != null) {
                existing_user.setProfilePic(updatedUser.getProfilePic());
            }
            if (updatedUser.getBirth() != null) {
                existing_user.setBirth(updatedUser.getBirth());
            }
            if (updatedUser.getRole() != null) {
                existing_user.setRole(updatedUser.getRole());
            }
            userRepository.save(existing_user);
            return "Updated";
        }

        return "Not found";

    }

    public boolean deleteUser(String email) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        } else {
            return false;
        }
    }
}
