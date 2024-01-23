package com.j2seon.mongotest.user.repository;

import com.j2seon.mongotest.user.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
  Optional<Users> findByLoginId(String loginId);

}
