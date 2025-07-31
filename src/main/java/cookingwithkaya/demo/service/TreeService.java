package cookingwithkaya.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cookingwithkaya.demo.treeSchema.Choice;
import cookingwithkaya.demo.treeSchema.Scene;
import cookingwithkaya.demo.treeSchema.Tree;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TreeService {

    public Tree loadTree() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new ClassPathResource("static/tree.json").getInputStream(),
                Tree.class
        );
    }
}
