package com.pknu.backboard;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.repository.BoardRepository;

@SpringBootTest
class BackboardApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertJpa(){
		Board board1 = new Board();
		board1.setTitle("첫번째 게시글"); // @Setter에서 자동 생성해주는 메서드
		board1.setContent("내용은 없음");
		board1.setCreateDate(LocalDateTime.now());

		Board board2 = new Board();
		board2.setTitle("두번째 게시글"); 
		board2.setContent("내용은 없음");
		board2.setCreateDate(LocalDateTime.now());

		this.boardRepository.save(board1); // INSERT 실행
		this.boardRepository.save(board2); // INSERT 실행

	}

	@Test
	void testSelectJpa(){
		List<Board> all = this.boardRepository.findAll();

		assertEquals(2, all.size());

		Board board = all.get(0);
		assertEquals("첫번째 게시글", board.getTitle());

		
	}
	@Test
	void testSelectOneJpa(){
		// Optional -> Null 허용
		Optional<Board> opBoard = this.boardRepository.findById(2L);
		if(opBoard.isPresent()){
			Board board = opBoard.get();
			assertEquals("내용은 없음",board.getContent());
		}
		
	}

	@Test
	void testSelectByTitle(){
		Board board = this.boardRepository.findByTitle("두번째 게시글");
		assertEquals(2L, board.getBno());
	}
	@Test
	void testSelectByTitleLike(){
		List<Board> boards = this.boardRepository.findByTitleLike("%게시글%");
		assertEquals(2, boards.size());

		Board board = boards.get(0); // 첫번째 게시글
		assertEquals("첫번째 게시글", board.getTitle());
	}

	@Test
	void testDeleteLastOne(){
		assertEquals(2, boardRepository.count());
		Optional<Board> opBoard = this.boardRepository.findById(2L);
		assertTrue(opBoard.isPresent());

		Board board = opBoard.get();
		this.boardRepository.delete(board);
		assertEquals(1, boardRepository.count());
	}

	@Test // 수정 테스트
	void testUpdateOne(){
		Optional<Board> opBoard = this.boardRepository.findById(1L); // 1번 보드데이터 가져오기
		assertTrue(opBoard.isPresent());// 가져온 데이터가 있는지 여부 체크

		Board board = opBoard.get(); // Optional<Board>가 NULL이면 get()할 수 없음
		board.setContent("내용이 테스트에서 변경되었습니다");

		this.boardRepository.save(board);
	}

}
