package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.GameCategory;
//import com.ssafy.db.repository.CategoryRepository;
import com.ssafy.db.repository.BoardRepositorySupport;
/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */

/**

  * @FileName : StasisServiceImpl.java
  * @Project : ssafy-web-project
  * @Date : 2022. 8. 3 
  * @작성자 : 박찬호
  * @변경이력 :
  * @프로그램 설명 :
  */
@Service("StatisService")
public class StatisServiceImpl implements StatisService {
//	@Autowired
//	CategoryRepository categoryRepository;
//	
//	@Autowired
//	CategoryRepositorySupport categoryRepositorySupport;

	/**
	 * @Method Name : getCategory
	 * @작성일 : 2022. 8. 3
	 * @작성자 : 박찬호
	 * @변경이력 : 
	
	 * @Method 설명 :
	 * @param 
	 * @return
	 */
	@Override
	public List<GameCategory> getCategory() {
		
		return null;
	}

	
}
