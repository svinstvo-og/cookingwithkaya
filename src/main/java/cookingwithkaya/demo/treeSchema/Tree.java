package cookingwithkaya.demo.treeSchema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
    @JsonProperty("start")
    private String startSceneName;
    @JsonProperty("nodes")
    private HashMap<String, Scene> scenes;
    @JsonProperty("endings")
    private List<String> endingScenesNames;
}
