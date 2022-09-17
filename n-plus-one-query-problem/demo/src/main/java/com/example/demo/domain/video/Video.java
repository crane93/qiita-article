package com.example.demo.domain.video;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.example.demo.domain.youtuder.Youtuder;

@Getter
@NoArgsConstructor
@Entity
public class Video{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer videoId;

    @Column
    private String title;

    @Column(name = "youtuder_id")
    private Integer youtuderId;

    @ManyToOne
    @JoinColumn(name="youtuder_id", insertable=false, updatable=false)
    private Youtuder youtuder;

    @Builder
    public Video(String title, Integer youtuderId) {
        this.title = title;
        this.youtuderId = youtuderId;
    }
}