package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.example.demo.domain.youtuder.YoutuderRepository;
import com.example.demo.domain.youtuder.Youtuder;
import com.example.demo.domain.video.VideoRepository;
import com.example.demo.domain.video.Video;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QueryTests {
    
    @Autowired
    private YoutuderRepository youtuderRepository;

    @Autowired
    private VideoRepository videoRepository;

    @BeforeAll
    static void setup(@Autowired YoutuderRepository youtuderRepository, @Autowired VideoRepository videoRepository) {
        Youtuder y = youtuderRepository.save(Youtuder.builder()
            .youtuderName("yuriSAMA")
            .build());

        videoRepository.save(Video.builder()
            .title("n+1")
            .youtuderId(y.getYoutuderId())
            .build());
    }

    @AfterAll
    static void cleanUp(@Autowired YoutuderRepository youtuderRepository, @Autowired VideoRepository videoRepository) {
        youtuderRepository.deleteAll();
        videoRepository.deleteAll();
    }

    @Test
    public void check(){
        List<Youtuder> y = youtuderRepository.findAll();
        List<Video> v = videoRepository.findAll();

        assertEquals(y.get(0).getYoutuderName(), "yuriSAMA");
        assertEquals(v.get(0).getTitle(), "n+1");
    }
}
