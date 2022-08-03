package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD
import lombok.ToString;

import java.util.Date;

import javax.persistence.*;
/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="game_conference_rooms")
public class GameConferenceRoom extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name = "is_normal")
	boolean isNormal;
	
	@Column(name= "Game_categories_uid")
	int gameCategoriesUid;
	
	@Column(name="game_category_topics_uid")
	Integer gameCategoryTopicsUid;
	
	@Column(name="room_admin_user_uid")
	int roomAdminUserUid;
	
	@Column(name="conference_room_url")
	String conferenceRoomUrl;
	
	@Column(name="start_time")
	Date startTime;
	
	@Column(name="end_time")
	Date endTime;
	
	@Column(name="custom_password")
	String customPassword;
	
	@Column(name="title")
	String title;
	
	@Column(name="custom_topic")
	String customTopic;

	@Column(name="custom_answer_A")
	String customAnswerA;

	@Column(name="custom_answer_B")
	String customAnswerB;

	@Column(name = "game_start")
	boolean gameStart;
=======

import java.util.Date;

import javax.persistence.*;
/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@Table(name="game_conference_rooms")
public class GameConferenceRoom extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name = "is_normal")
	boolean isNormal;
	
	@Column(name= "game_categories_uid")
	int gameCategoriesUid;
	
	@Column(name="game_category_topics_uid")
	int gameCategoryTopicsUid;
	
	
	@Column(name="room_admin_user_uid")
	int roomAdminUserUid;
	
	@Column(name="conference_room_url")
	String conferenceRoomUrl;
	
	@Column(name="start_time")
	Date startTime;
	
	@Column(name="end_time")
	Date endTime;
	
	@Column(name="custom_passworrd")
	int customPassword;
	

	
	@Column(name="title")
	String title;
	
	@Column(name="custom_topic")
	String customTopic;

	@Column(name="custom_answer_A")
	String customAnswerA;

	@Column(name="custom_answer_B")
	String customAnswerB;
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git

}
