package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.UserVisitCount;
import com.pxp.SQLite.demo.entity.keys.UserVisitCountKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVisitCountRepository extends JpaRepository<UserVisitCount, UserVisitCountKey> {

  @Query("SELECT COUNT(*) FROM UserVisitCount e WHERE id=?1 and url=?2")
  int count(String id, String url);
}
