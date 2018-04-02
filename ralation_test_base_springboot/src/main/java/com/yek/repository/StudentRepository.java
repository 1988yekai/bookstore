package com.yek.repository;

import com.querydsl.core.types.Predicate;
import com.yek.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * UserInfo持久化类
 * Created by yek on 2018-2-24.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, QuerydslPredicateExecutor<Student> {
    /**
     * 通过username查找用户信息
     */
    List<Student> findAll();

//    @Query(value = "SELECT u.uid,u.username,u.name,u.password,u.salt,u.state FROM UserInfo u",
//            countQuery = "SELECT count(*) FROM UserInfo",
//            nativeQuery = true)
    //查询指定列
//    @Query(value = "SELECT u.uid,u.username,u.name,u.state FROM UserInfo u")
//    @Query(value = "SELECT new UserInfo(u.uid,u.username,u.name,u.state) FROM UserInfo u")
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAll(Predicate predicate, Pageable pageable);

    Optional<Student> findOne(Predicate predicate);
}
