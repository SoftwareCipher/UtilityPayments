package com.utilitypayments.repo;

import com.utilitypayments.models.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<SecurityProperties.User, Long>{
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findUserByEmail(@Param("email") String email);
}
