package com.pknu.backboard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pknu.backboard.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{

    // SELECT * FROM member WHERE username = ?
    Optional<Member> findByUsername(String username);
    Optional<Member> findByEmail(String email);
}
