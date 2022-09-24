package com.example.demo.domain.youtuder;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface YoutuderRepository extends JpaRepository<Youtuder, Integer> {
    /**
        join fetchで参照
     */
    @Query("select o from Youtuder o join fetch o.videos")
    List<Youtuder> findAllJoinFetch();

    /**
        EntityGraphで参照
     */
    @EntityGraph(attributePaths = "videos")
    @Query("select a from Youtuder a")
    List<Youtuder> findAllEntityGraph();
}