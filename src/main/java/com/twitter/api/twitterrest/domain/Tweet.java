package com.twitter.api.twitterrest.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tweet {

	@Id
	@GeneratedValue
	private Integer tweetId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@NotNull
	@Size(min = 5, max = 20, message = "")
	private String title;

	@NotNull
	@Size(min = 1, max = 140, message = "")
	private String message;

	public Tweet() {
	}

	public Tweet(Integer postId, Date date, String title, String message) {
		this.tweetId = postId;
		this.date = date;
		this.title = title;
		this.message = message;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("Tweet [tweetId=%s, date=%s, title=%s, message=%s]", tweetId, date, title, message);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweetId == null) ? 0 : tweetId.hashCode());
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
		Tweet other = (Tweet) obj;
		if (tweetId == null) {
			if (other.tweetId != null) {
				return false;
			}
		} else if (!tweetId.equals(other.tweetId)) {
			return false;
		}
		return true;
	}
}
