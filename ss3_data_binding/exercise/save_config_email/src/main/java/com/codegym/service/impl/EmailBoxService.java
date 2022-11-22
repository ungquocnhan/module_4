package com.codegym.service.impl;

import com.codegym.model.EmailBox;
import com.codegym.repository.IEmailBoxRepository;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    private IEmailBoxRepository emailBoxRepository;

    @Override
    public List<EmailBox> findAll() {
        return emailBoxRepository.findAll();
    }

    @Override
    public EmailBox findById(int id) {
        return emailBoxRepository.findById(id);
    }

    @Override
    public void update(EmailBox emailBox) {
        emailBoxRepository.update(emailBox);
    }
}
