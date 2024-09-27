package com.utilitypayments.repo;

import com.utilitypayments.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserEntity findUserByEmail(@Param("email") String email);
}
