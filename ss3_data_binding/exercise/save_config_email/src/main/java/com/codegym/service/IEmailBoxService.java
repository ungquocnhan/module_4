package com.codegym.service;

import com.codegym.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {
    List<EmailBox> findAll();

    EmailBox findById(int id);

    void update(EmailBox emailBox);

}
