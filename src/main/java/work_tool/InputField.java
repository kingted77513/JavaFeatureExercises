package work_tool;

import java.awt.Point;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InputField {
    private Point leftUpper;
    private Point rightLower;
}
