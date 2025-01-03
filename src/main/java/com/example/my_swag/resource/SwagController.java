package com.example.my_swag.resource;
import com.example.my_swag.model.MailDto;
import com.example.my_swag.model.User;
import com.example.my_swag.repository.MailRepo;
import com.example.my_swag.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // To make Rest-API
@RequestMapping(value = "/my_swag")
public class SwagController {
    @Autowired
    UserRepo ur;
    //MailRepo mr = new MailRepo();

    @Autowired
    MailRepo mr;

    @PostMapping(value = "/insert")
    public ResponseEntity<User> insertUser(@RequestBody User u) {
        User us = ur.save(u);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<List<User>> showUser()
    {
        List<User> list = ur.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PostMapping("/delete/{mail}")
    public ResponseEntity<User> deleteUser(@PathVariable("mail") String mail)
    {
        User us = ur.findByMail(mail);
        ur.deleteByMail(mail);
        return new ResponseEntity<>(us,HttpStatus.OK);
    }

    @PostMapping("/login/{mail}/{pass}")
    public ResponseEntity<User> userLogin(@PathVariable("mail")String mail,@PathVariable("pass")String pass)
    {
        User us = ur.findByMailAndPass(mail,pass);
        return new ResponseEntity<>(us,HttpStatus.OK);
    }

    @PostMapping("/update/{mail}/{pass}/{name}/{age}/{mobile}")
    public ResponseEntity<User> updateUser(@PathVariable("mail")String mail,@PathVariable("pass")String pass,@PathVariable("name")String name,@PathVariable("age")String age,@PathVariable("mobile")String mobile)
    {
        User us = ur.findByMail(mail);
        ur.updateFromUser(mail,pass,name,Integer.parseInt(age),mobile);
        return new ResponseEntity<>(us,HttpStatus.OK);
    }

    @PostMapping("/mail")
    public void sendEmail(@RequestBody MailDto emailDto)
    {
        mr.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getText());
        //emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getText());
    }
}
