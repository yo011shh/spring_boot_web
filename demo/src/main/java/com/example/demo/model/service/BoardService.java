package com.example.demo.model.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.domain.Board;

import com.example.demo.model.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성(부분)
public class BoardService {
@Autowired
private final BoardRepository blogRepository; // 리포지토리 선언
public List<Board> findAll() { // 게시판 전체 목록 조회
return blogRepository.findAll();
}
public Optional<Board> findById(Long id) { // 게시판 특정 글 조회
return blogRepository.findById(id);
}
public Page<Board> findAll(Pageable pageable) {
    return blogRepository.findAll(pageable);
    }

public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
    return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    } // LIKE 검색 제공(대소문자 무시)
public Board save(AddBoardRequest request){
    // DTO가 없는 경우 이곳에 직접 구현 가능
    // public ResponseEntity<Article> addArticle(@RequestParam String title, @RequestParam String content) {
    // Article article = Article.builder()
    // .title(title)
    // .content(content)
    //.build();
    return blogRepository.save(request.toEntity());
    }
public void update(Long id, AddBoardRequest request) {
    Optional<Board> optionalboard = blogRepository.findById(id); // 단일 글 조회
    optionalboard.ifPresent(board -> { // 값이 있으면
    board.update(request.getTitle(), request.getContent()); // 값을 수정
    blogRepository.save(board); // Article 객체에 저장
    });
    }
}
