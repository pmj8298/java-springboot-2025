package com.pknu.backboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pknu.backboard.entity.Board;
import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

    Board findByTitle(String string); // 제목으로 검색

    List<Board> findByTitleLike(String title); // 비슷한 제목으로 검색

}
