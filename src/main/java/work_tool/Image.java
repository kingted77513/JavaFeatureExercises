package work_tool;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {

    private String fileName;
    private int width;
    private int height;
}
