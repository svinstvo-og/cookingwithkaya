package cookingwithkaya.demo.treeSchema;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scene {
    @JsonProperty("video")
    private String videoName;
    @JsonProperty("image")
    @Nullable
    private String imageName;
    @Nullable
    private String text;
    private List<Choice> choices;
}
