package com.kodlama.io.rentACar.dataAccess.abstracts;

import com.kodlama.io.rentACar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
