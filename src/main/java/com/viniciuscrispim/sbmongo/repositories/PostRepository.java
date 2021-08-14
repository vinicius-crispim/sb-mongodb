package com.viniciuscrispim.sbmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciuscrispim.sbmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
