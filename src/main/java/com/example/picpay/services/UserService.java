package com.example.picpay.services;

import com.example.picpay.domain.user.User;
import com.example.picpay.domain.user.UserType;
import com.example.picpay.dtos.UserDTO;
import com.example.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender == null || amount == null){
            throw new IllegalArgumentException("Usuario nao existe");
        }
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Lojista não pode enviar");//ESSE É O ERRO
        }

        if (amount.compareTo(sender.getBalance()) > 0 ) {//esse >0 serve pra informar se a situação é verdade
            throw new Exception("Não tem esse valor de saldo");
        }
    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new Exception("Usuario nao encontrado")
                );
    }
    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO userDTO){
        User newUser = new User(userDTO);
        this.saveUser(newUser);
        return newUser;
    }


    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
