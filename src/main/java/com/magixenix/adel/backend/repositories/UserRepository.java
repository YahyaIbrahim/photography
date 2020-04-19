package com.magixenix.adel.backend.repositories;

import com.magixenix.adel.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findFirstById(Long userid);

    User findByEmailAndPassword(String email, String password);



}
