package com.example.nplus1.repository;

import com.example.nplus1.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "group_with_all_associations", type = EntityGraph.EntityGraphType.FETCH)
    List<User> findAll();
}
