package com.nihar.backend.repository;

import com.nihar.backend.entity.ChatHistory;
import com.nihar.backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {

    List<ChatHistory> findByUser(User user);

    @Transactional
    @Modifying
    void deleteByIdAndUser(Long id, User user);

    @Transactional
    @Modifying
    void deleteAllByUser(User user);
}