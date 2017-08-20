package com.shanzha.moduls.article.entity;

import java.util.Date;

public class ArticleComment {
	private Long id;

	private Long articleId;

	private Long userId;

	private Long replyUser;

	private Integer likeNumber;

	private Date commentDate;

	private String comment;

	private String userName;

	private String replyUserName;

	private long like;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(Long replyUser) {
		this.replyUser = replyUser;
	}

	public Integer getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(Integer likeNumber) {
		this.likeNumber = likeNumber;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}

}