package com.exercise.validation_form_register.service.impl;

import com.exercise.validation_form_register.handle.DuplicateEmailException;
import com.exercise.validation_form_register.model.User;
import com.exercise.validation_form_register.repository.IUserRepository;
import com.exercise.validation_form_register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) throws DuplicateEmailException {
        try {
            userRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw new DuplicateEmailException();
        }

    }
}
