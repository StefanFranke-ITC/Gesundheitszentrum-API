package apis.Manga.API.Controller;

import apis.Manga.API.Entety.Video;
import apis.Manga.API.Repository.VideoRepository;
import apis.Manga.API.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auth/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Video video = videoService.getVideoById(id);
        return ResponseEntity.ok(video);
    }
    
    @GetMapping()
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Video> createVideo(@RequestBody Video video) {
        Video createdVideo = videoService.createVideo(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVideo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
        return ResponseEntity.noContent().build();
    }

    // Weitere Methoden hier hinzufügen, wenn benötigt.
}
