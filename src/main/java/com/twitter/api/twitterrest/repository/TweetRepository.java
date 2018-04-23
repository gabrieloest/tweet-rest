package com.twitter.api.twitterrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.twitter.api.twitterrest.domain.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	@Query("select t from Tweet t where user.userId = :userId order by date desc")
	List<Tweet> findAllByUserIdOrderByDateDesc(@Param("userId") Integer userId);
}
