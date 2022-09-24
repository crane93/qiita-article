package com.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.domain.youtuder.YoutuderRepository;
import com.example.demo.domain.youtuder.Youtuder;
import com.example.demo.domain.video.VideoRepository;
import com.example.demo.domain.video.Video;

@RequiredArgsConstructor
@RestController
public class TestController{

    private final YoutuderRepository youtuderRepository;
    private final VideoRepository videoRepository;

    @GetMapping("/insert/data")
    public String insertData(){
        for(int i = 0; i < 3; i++){
            Youtuder y = youtuderRepository.save(Youtuder.builder()
                .youtuderName("you" + i)
                .build());
            
            videoRepository.save(Video.builder()
                .title("n+1" + i)
                .youtuderId(y.getYoutuderId())
                .build());
        }
        return "insert data";
    }

    @GetMapping("/findAll/youtuder")
    public String findAllYoutuder(){
        List<Youtuder> youtuderList = youtuderRepository.findAll();

        return "findAll Youtuder";
    }

    @GetMapping("/show/NPlusQuery/lazy")
    public String showNPlusQueryAtLazy(){
        List<String> titleList = extractTitle(youtuderRepository.findAll());

        return "to show n+1 query at FetchType.LAZY";
    }

    @GetMapping("/show/joinFetch")
    public String joinFetch(){
        List<Youtuder> youtuderList = youtuderRepository.findAllJoinFetch();

        return "JoinFetch";
    }

    @GetMapping("/show/entityGraph")
    public String entityGraph(){
        List<Youtuder> youtuderList = youtuderRepository.findAllEntityGraph();

        return "EntityGraph";
    }

    private List<String> extractTitle(List<Youtuder> youtuders){
        return youtuders.stream()
                .map(y -> y.getVideos().get(0).getTitle())
                .collect(Collectors.toList());
    }
}