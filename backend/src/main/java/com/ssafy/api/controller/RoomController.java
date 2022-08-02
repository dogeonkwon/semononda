package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.api.request.RoomRequest;
import com.ssafy.api.response.BoardResponse;
import com.ssafy.api.response.RoomResponse;
import com.ssafy.api.service.RoomService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.GameConferenceRoom;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "게임 방 API", tags = { "Room" })
@RestController
@RequestMapping("api/room")
public class RoomController {
	@Autowired
	RoomService roomService;

	@PostMapping("/create")
	@ApiOperation(value = "게임 방 생성(등록)", notes = "게임방 생성(등록)")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> createRoom(
			@RequestBody @ApiParam(value = "방 정보", required = true) RoomRequest roomInfo) {

		System.out.println("방 생성 controller");
		System.out.println(roomInfo.toString());
		GameConferenceRoom room = roomService.createRoom(roomInfo);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/list")
	@ApiOperation(value = "room list 정보", notes = "게임 방 전체 목록")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임 방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<List<GameConferenceRoom>> getRoomList() {
		List<GameConferenceRoom> rooms = roomService.getNormalRoom();
		if (rooms == null) {
			return new ResponseEntity<List<GameConferenceRoom>>(rooms, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<GameConferenceRoom>>(rooms, HttpStatus.OK);
		}
	}

	@GetMapping("")
	@ApiOperation(value = "uid로 room 검색 ", notes = "uid로 room검색")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<RoomResponse> findRoomByUid(
			@ApiParam(value = "room uid", required = true) @RequestParam("uid") int uid) {

		GameConferenceRoom room = roomService.findRoomByUid(uid);
		if (room == null) {
			return ResponseEntity.status(400).body(RoomResponse.of(400, "Bad responce", room));
		} else {
			return ResponseEntity.status(200).body(RoomResponse.of(200, "Success", room));
		}
	}

	@PutMapping("")
	@ApiOperation(value = "게임 방 주제, (커스텀)비밀번호 변경, 게임중 상태 변화 같은 게임 방 변동사항", notes = "게임 방 변동사항")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends RoomResponse> updateRoomByUid(
			@RequestBody @ApiParam(value = "글 정보", required = true) RoomRequest roomInfo) {
		GameConferenceRoom room = roomService.findRoomByUid(roomInfo.getUid());

		if (room == null) {
			System.out.println("없데이트 할 방이 없습니다.");
			return ResponseEntity.status(400).body(RoomResponse.of(400, "Success", room));
		} else {
			roomService.updateRoom(room, roomInfo);
			return ResponseEntity.status(200).body(RoomResponse.of(200, "Success", room));
		}
	}

	@DeleteMapping("")
	@ApiOperation(value = "room 방 삭제", notes = "방장이 나간 방 삭제")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임 방 없음"), @ApiResponse(code = 500, message = "서버 오류") })

	public ResponseEntity<? extends BaseResponseBody> deleteBoardByUid(
			@ApiParam(value = "room uid", required = true) @RequestParam("uid") int uid) {
		GameConferenceRoom room = roomService.findRoomByUid(uid);
		if (room != null) {
			roomService.deleteRoomByUid(room);
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "success"));
		} else {
			return ResponseEntity.status(200).body(BaseResponseBody.of(404, "failed"));
		}
	}

	@GetMapping("/word")
	@ApiOperation(value = "title로 room 검색 ", notes = "title로 room 검색")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<List<GameConferenceRoom>> findRoomByTitle(
			@ApiParam(value = "room uid", required = true) @RequestParam("title") String title) {

		List<GameConferenceRoom> rooms = roomService.findRoomByRoomTitle(title);
		System.err.println("controller : " + title);
		if (rooms == null) {
			return new ResponseEntity<List<GameConferenceRoom>>(rooms, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<GameConferenceRoom>>(rooms, HttpStatus.OK);
		}
	}

}
