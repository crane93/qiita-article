package com.example.demo.domain.youtuder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

import com.example.demo.domain.video.Video;

@Getter
@NoArgsConstructor
@Entity
public class Youtuder{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer youtuderId;

    @Column
    private String youtuderName;

    @OneToMany(mappedBy="youtuder", cascade=CascadeType.ALL)
    private List<Video> videos;

    @Builder
    public Youtuder(Integer youtuderId, String youtuderName) {
        this.youtuderName = youtuderName;
    }
}