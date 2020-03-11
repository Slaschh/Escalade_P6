package com.escalade.repositories;

import com.escalade.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);

    Users findByName(String user);


}

