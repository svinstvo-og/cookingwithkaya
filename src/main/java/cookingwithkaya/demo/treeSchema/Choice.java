package cookingwithkaya.demo.treeSchema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    @JsonProperty("text")
    private String name;
    @JsonProperty("next")
    public String nextSceneName;
    public String achievement;
}
