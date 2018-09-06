package com.murphy.wechat.mini.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.murphy.wechat.mini.security.entity.UserDO;


@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<UserDO, Long> {
    UserDO findByUsername(String username);
}