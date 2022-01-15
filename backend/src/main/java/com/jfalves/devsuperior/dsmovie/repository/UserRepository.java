package com.jfalves.devsuperior.dsmovie.repository;

import com.jfalves.devsuperior.dsmovie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
