package com.viniciuscrispim.sbmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciuscrispim.sbmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


}
