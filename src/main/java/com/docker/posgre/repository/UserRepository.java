package com.docker.posgre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.posgre.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
