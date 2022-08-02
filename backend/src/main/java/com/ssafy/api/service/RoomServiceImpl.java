package com.ssafy.api.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.RoomRequest;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.repository.RoomRepository;
import com.ssafy.db.repository.RoomRepositorySupport;

/**
 * 
 * @packageName : com.ssafy.api.service
 * @fileName : RoomServiceImpl.java
 * @author : 김유정
 * @date : 2022.08.01
 * @description :
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	RoomRepositorySupport roomRepositorySupport;

	@Override
	public GameConferenceRoom createRoom(RoomRequest roomRegisterInfo) {
		GameConferenceRoom room = new GameConferenceRoom();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		room.setNormal(roomRegisterInfo.isNormal());
		room.setGameCategoriesUid(roomRegisterInfo.getGameCategoriesUid());
		room.setGameCategoryTopicsUid(roomRegisterInfo.getGameCategoryTopicsUid());
		room.setRoomAdminUserUid(roomRegisterInfo.getRoomAdminUserUid());
		room.setConferenceRoomUrl(roomRegisterInfo.getConferenceRoomUrl());
		room.setStartTime(timestamp);
		room.setCustomPassword(roomRegisterInfo.getCustomPassword());
		room.setTitle(roomRegisterInfo.getTitle());
		room.setCustomTopic(roomRegisterInfo.getCustomTopic());
		room.setCustomAnswerA(roomRegisterInfo.getCustomAnswerA());
		room.setCustomAnswerB(roomRegisterInfo.getCustomAnswerB());
		room.setGameStart(roomRegisterInfo.isGameStart());
		return roomRepository.save(room);

	}

	@Override
	public List<GameConferenceRoom> findRoomByRoomTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameConferenceRoom> getNormalRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GameConferenceRoom> getCustomRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameConferenceRoom updateRoom(GameConferenceRoom room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameConferenceRoom findRoomByUid(int uid) {
		GameConferenceRoom room = new GameConferenceRoom();
		room = roomRepositorySupport.findRoomByRoomUid(uid);
		return room;
	}

	@Override
	public void deleteRoomByUid(GameConferenceRoom room) {
		roomRepository.delete(room);

	}

}
