package cookingwithkaya.demo.controller;

import cookingwithkaya.demo.service.TreeService;
import cookingwithkaya.demo.treeSchema.Tree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class VideoController {

    private final TreeService treeService;

    public VideoController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/{sceneId}")
    public ResponseEntity<InputStreamResource> getVideo(@PathVariable String sceneId) throws IOException {
        Tree tree = treeService.loadTree();

        String videoFileName = "static/videos/" + tree.getScenes().get(sceneId).getVideoName();
        log.info("got vid {}", videoFileName);

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
