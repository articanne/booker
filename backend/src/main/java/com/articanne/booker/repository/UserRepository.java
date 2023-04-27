package com.articanne.booker.repository;

import com.articanne.booker.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);

    Page<User> findAllByOrderByIdAsc(Pageable pageable);

    @EntityGraph(attributePaths = {"roles"})
    Page<User> findByUsernameContainingIgnoreCase(String search, Pageable pageable);

}
