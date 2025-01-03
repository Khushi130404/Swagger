package com.example.my_swag.repository;

import com.example.my_swag.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {

    public User findByMail(String mail);

    public User findByMailAndPass(String mail,String pass);

    @Transactional
    @Modifying
    @Query("delete from User us where us.mail =:mail")
    public void deleteByMail(String mail);

    @Transactional
    @Modifying
    @Query("update User us set us.pass = :pass, us.name = :name, us.age = :age, us.mobile = :mobile where us.mail = :mail")
    public void updateFromUser(String mail,String pass,String name,int age,String mobile);
}
