package com.example.picpay.repositories;

import com.example.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDocument(String document);


    //findBy acha automaticamente pela tabela Gracas ao JPA

    Optional<User> findById(Long id);

    User findUserById(Long id);
}
