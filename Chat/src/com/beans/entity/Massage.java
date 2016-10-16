package com.beans.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "massage")
// @JsonIgnoreProperties(value = { "handler", "userSender" , "usesRetriever" })

public class Massage implements Serializable {
	@Id
	@Column(name = "id")
	private int id;

	public Massage(String msg, User userSender, User userRetriever, int check_id,int friendShipId,java.util.Date datee) {
		super();
		this.msg = msg;
		this.friendShipId=friendShipId;
		this.userSender = userSender;
		this.userRetriever = userRetriever;
		this.check = new HaveRead(check_id);
		this.date=new Date(datee.getTime());
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Massage() {
		super();
	}

	@Column(name = "msg")
	private String msg;
	@Column(name="friend_ship_id")
	private int friendShipId;
	@Column(name="date")
      private Date date;

	public int getFriendShipId() {
		return friendShipId;
	}

	public void setFriendShipId(int friendShipId) {
		this.friendShipId = friendShipId;
	}

	@ManyToOne(fetch = FetchType.EAGER)

	@JoinColumn(name = "user_sender", referencedColumnName = "id")
	private User userSender;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_retriever", referencedColumnName = "id")
	private User userRetriever;
	@ManyToOne
	@JoinColumn(name = "read_id", referencedColumnName = "id")
	private HaveRead check;

	public HaveRead getCheck() {
		return check;
	}

	public void setCheck(HaveRead check) {
		this.check = check;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getUserSender() {
		return userSender;
	}

	public void setUserSender(User userSender) {
		this.userSender = userSender;
	}

	public User getUserRetriever() {
		return userRetriever;
	}

	public void setUserRetriever(User userRetriever) {
		this.userRetriever = userRetriever;
	}

}
