package com.innova.controller;

import com.innova.dto.UserRegisterDTO;
import com.innova.entity.UserEntity;
import com.innova.repository.IUserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class UserController {

    @Autowired
    IUserRepository iUserRepository;

    // http://localhost:8080/userRegister
    @GetMapping("/userRegister")
    public String getUserRegister(Model model){
        model.addAttribute("form_key",new UserRegisterDTO());
        return "userRegister";
    }

    // http://localhost:8080/userRegister
    @PostMapping("/userRegister")
    public String postUserRegister(@Valid @ModelAttribute("form_key") UserRegisterDTO dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata Var!");
            log.info(dto);
            return "userRegister";
        }else{
            UserEntity userEntity=UserEntity.builder()
                    .userID(0L)
                    .userName(dto.getUserName())
                    .userMail(dto.getUserMail())
                    .build();
            iUserRepository.save(userEntity);
            log.info(dto);
            return "success";
        }
    }
}
