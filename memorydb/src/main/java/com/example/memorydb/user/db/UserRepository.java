package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max); //이게 제일 편할 수도 있다

    @Query(
            value = "select * from user as u where u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max);


}
