package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.UserVisitCount;
import com.pxp.SQLite.demo.entity.keys.UserVisitCountKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVisitCountRepository extends
    CassandraRepository<UserVisitCount, UserVisitCountKey> {

  @Query("SELECT COUNT(*) FROM user_visit_count WHERE id=?0 and url=?1")
  int count(String id, String url);
}
