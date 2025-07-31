package cookingwithkaya.demo.controller;

import cookingwithkaya.demo.service.TreeService;
import cookingwithkaya.demo.treeSchema.Tree;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/tree")
public class TreeController {

    private final TreeService treeLoader;

    public TreeController(TreeService treeLoader) {
        this.treeLoader = treeLoader;
    }

    @GetMapping
    public Tree getTree() throws IOException {
        return treeLoader.loadTree();
    }

}
