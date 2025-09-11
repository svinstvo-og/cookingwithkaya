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
@RequestMapping("/api/image")
@Slf4j
public class ImageController {

    final
    TreeService treeService;

    public ImageController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/{sceneId}")
    public ResponseEntity<InputStreamResource> getVideo(@PathVariable String sceneId) throws IOException {
        Tree tree = treeService.loadTree();

        String imageFileName = "static/images/" + tree.getScenes().get(sceneId).getImageName();
        log.info("got image {}", imageFileName);

        ClassPathResource imageFile = new ClassPathResource(imageFileName);

        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/jpg"));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(imageFile.contentLength())
                .body(new InputStreamResource(imageFile.getInputStream()));
    }
}
