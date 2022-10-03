package com.epic.invoicecheck.services;

import com.epic.invoicecheck.entity.LoginEntity;
import com.epic.invoicecheck.repository.LoginEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class LoginService {
    private final LoginEntityRepository loginEntityRepository;

    public boolean chekPwd(String userNr, String pwd){
        LoginEntity loginData = loginEntityRepository.findByUserNr(userNr.toUpperCase());
        log.info(loginData.toString());
        log.info(loginData.getTel1());
        log.info(pwd);
        if (loginData != null){
            return Objects.equals(loginData.getTel1(), pwd);
        } else{
            return false;
        }
    }
}
