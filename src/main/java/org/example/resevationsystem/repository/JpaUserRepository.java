package org.example.resevationsystem.repository;

import org.example.resevationsystem.entity.User;
import org.example.resevationsystem.entity.projection.UserLoginProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
    UserLoginProjection findProjectionByUserName(String username);

}
