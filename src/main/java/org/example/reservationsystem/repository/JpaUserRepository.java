package org.example.reservationsystem.repository;

import org.example.reservationsystem.entity.User;
import org.example.reservationsystem.entity.projection.UserLoginProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
    UserLoginProjection findProjectionByUserName(String username);

}
