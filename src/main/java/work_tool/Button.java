package work_tool;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Button {
    private int width;
    private int height;
    private int upper;
    private int lower;
}
