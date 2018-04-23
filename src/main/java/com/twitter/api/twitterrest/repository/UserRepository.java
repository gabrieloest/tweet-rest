package com.twitter.api.twitterrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.api.twitterrest.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
