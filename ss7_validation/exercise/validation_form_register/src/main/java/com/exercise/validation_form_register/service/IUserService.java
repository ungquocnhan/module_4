package com.exercise.validation_form_register.service;

import com.exercise.validation_form_register.handle.DuplicateEmailException;
import com.exercise.validation_form_register.model.User;

public interface IUserService {
    void save(User user) throws DuplicateEmailException;
}
