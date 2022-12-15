package com.case_study.case_study_module_4.service.impl;

import com.case_study.case_study_module_4.model.user.MyUserDetail;
import com.case_study.case_study_module_4.model.user.User;
import com.case_study.case_study_module_4.repository.IUerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUerRepository uerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = uerRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }
        return new MyUserDetail(user);
    }
}
