package com.twitter.api.twitterrest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer userId;

	@NotNull
	@Size(min = 5, max = 40, message = "")
	private String name;

	@NotNull
	@Size(min = 5, max = 15, message = "")
	private String username;

	@NotNull
	@Size(min = 5, max = 40, message = "")
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tweet> tweets;

	@OneToMany
	private List<User> followedUsers;

	public User() {
	}

	public User(int id, String username, String name, String passowrd) {
		this.userId = id;
		this.setName(name);
		this.setUsername(username);
		this.setPassword(passowrd);
		tweets = new ArrayList<>();
		followedUsers = new ArrayList<>();
	}

	public Integer getId() {
		return userId;
	}

	public void setId(Integer id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public void addTweet(Tweet tweet) {
		tweets.add(tweet);
		tweet.setUser(this);
	}

	public void removeTweet(Tweet tweet) {
		tweets.remove(tweet);
		tweet.setUser(null);
	}

	public List<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(List<User> followedUsers) {
		this.followedUsers = followedUsers;
	}

	@Override
	public String toString() {
		return String.format("Student [userId=%s, name=%s, username=%s, tweets=%s]", userId, name, username, tweets);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

}
