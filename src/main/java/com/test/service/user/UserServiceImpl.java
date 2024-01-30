package com.test.service.user;

import com.test.exception.DataInputException;
import com.test.exception.EmailExistsException;
import com.test.model.Role;
import com.test.model.User;
import com.test.model.UserPrinciple;
import com.test.model.dto.UserCreateReqDTO;
import com.test.repository.RoleRepository;
import com.test.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return UserPrinciple.build(userOptional.get());
    }

    @Override
    public User create(UserCreateReqDTO userCreateReqDTO) {

        if (!userCreateReqDTO.getPassword().equals(userCreateReqDTO.getConfirmPassword())) {
            throw new DataInputException("Mật khẩu xác nhận không khớp");
        }

        if (userRepository.existsByUsername(userCreateReqDTO.getUsername())) {
            throw new EmailExistsException("Tài khoản đã được sử dụng, vui lòng hãy nhập lại!");
        }

        Role role = roleRepository.findByCode(userCreateReqDTO.getRoleCode()).orElseThrow(() -> {
            throw new DataInputException("Mã vai trò không hợp lệ");
        });

        User user = userCreateReqDTO.toUser(role);
        user.setPassword(passwordEncoder.encode(userCreateReqDTO.getPassword()));
        user = userRepository.save(user);

        return user;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteById(String id) {

    }
}
