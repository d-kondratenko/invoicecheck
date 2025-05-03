package com.epic.invoicecheck.controllers;

import com.epic.invoicecheck.models.LoginForm;
import com.epic.invoicecheck.services.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

//    @CrossOrigin
    @GetMapping("/login")
    public String getLoginForm(Model model){
        model.addAttribute("login", new LoginForm());
        return "login";
    }

//    @CrossOrigin
    @PostMapping("/login")
    public Object loginSuccesful(@ModelAttribute LoginForm loginForm, Model model){
        if(loginService.chekPwd(loginForm.getUserName(),loginForm.getPassword())){
           RedirectView redirectView = new RedirectView();
           redirectView.setUrl("/invoicecheck/uploadform");
//           redirectView.setUrl("/uploadform");
            return redirectView;
        } else {
            model.addAttribute("login",new LoginForm());
            return "login";
        }
    }
}
