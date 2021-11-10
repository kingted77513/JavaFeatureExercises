package work_tool;

import java.awt.Point;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HyperText {
    private Point leftUpper;
    private Point rightLower;
}
