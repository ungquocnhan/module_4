package com.codegym.repository;

import com.codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxRepository {
    List<EmailBox> findAll();

    EmailBox findById(int id);

    void update(EmailBox emailBox);

}
