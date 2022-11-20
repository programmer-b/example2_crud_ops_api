package com.dantech.example2.Repo;

import com.dantech.example2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
