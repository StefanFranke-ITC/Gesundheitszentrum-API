package apis.Manga.API.service;

import apis.Manga.API.repository.VideoRepository;
import apis.Manga.API.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AuthService authService;

    public Video getVideoById(Long id) {
        if (!authService.isAdmin()) return null;
        return videoRepository.findById(id).orElse(null);
    }

    public Video createVideo(Video video) {
        if (!authService.isAdmin()) return null;
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        if (authService.isAdmin()) {
            videoRepository.deleteById(id);
        }
    }
}
