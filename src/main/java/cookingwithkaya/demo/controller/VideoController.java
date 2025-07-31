package cookingwithkaya.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/video")
public class VideoController {
    @GetMapping("/{sceneId}")
    public ResponseEntity<InputStreamResource> getVideo(@PathVariable String sceneId) throws IOException {
        String videoFileName = "static/videos/" + sceneId + ".MP4";

        ClassPathResource videoFile = new ClassPathResource(videoFileName);

        if (!videoFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/mp4"));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(videoFile.contentLength())
                .body(new InputStreamResource(videoFile.getInputStream()));
    }
}
