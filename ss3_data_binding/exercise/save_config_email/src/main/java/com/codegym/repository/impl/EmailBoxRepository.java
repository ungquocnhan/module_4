package com.codegym.repository.impl;

import com.codegym.model.EmailBox;
import com.codegym.repository.IEmailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    private static List<EmailBox> emailBoxList;

    static {
        emailBoxList = new ArrayList<>();
        emailBoxList.add(new EmailBox(1, "English", 25, false, "Thor King, Asgard"));
        emailBoxList.add(new EmailBox(2, "Vietnamese", 10, true, "Hung Vuong King, Viet Nam"));
        emailBoxList.add(new EmailBox(3, "Japanese", 5, false, "Thor King, Japan"));
        emailBoxList.add(new EmailBox(4, "Chinese", 50, true, "Fire King, China"));
        emailBoxList.add(new EmailBox(5, "English", 25, false, "Black Panther King, Wakanda"));
    }

    @Override
    public List<EmailBox> findAll() {
        return emailBoxList;
    }

    @Override
    public EmailBox findById(int id) {
        for (EmailBox emailBox : emailBoxList) {
            if (emailBox.getId() == id) {
                return emailBox;
            }
        }
        return null;
    }

    @Override
    public void update(EmailBox emailBox) {
        EmailBox emailBox1 = findById(emailBox.getId());
        emailBox1.setLanguages(emailBox.getLanguages());
        emailBox1.setPageSize(emailBox.getPageSize());
        emailBox1.setSpamsFilter(emailBox.isSpamsFilter());
        emailBox1.setSignature(emailBox.getSignature());
    }
}
