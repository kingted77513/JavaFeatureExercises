package work_tool;

import java.awt.Point;
import lombok.Builder;

@Builder
public class AppCoordinationCounter {

    private Image image;
    private Button button;
    private InputField input;
    private HyperText privacy;  // 用戶隱私
    private HyperText policy;   // 注冊協議

    private void printInputFieldSetting() {
        System.out.println("--- register-input input ---");

        final int inputWidth = input.getRightLower().x - input.getLeftUpper().x;
        final int inputHeight = input.getRightLower().y - input.getLeftUpper().y;

        final double ratioBuffer = 0.01;
        final double inputWidthRatio = ((double) inputWidth / image.getWidth()) + ratioBuffer;
        final double inputHeightRatio = ((double) inputHeight / image.getHeight()) + ratioBuffer;

        System.out.printf("width: %.4fvw;%n", (inputWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (inputHeightRatio * 100));
        System.out.printf("font-size: %.4fvh;%n", (inputHeightRatio * 100));

        final double locationBuffer = 0.005;
        final double inputWidthLocation = ((double) input.getLeftUpper().x / image.getWidth()) - locationBuffer;
        final double inputHeightLocation = ((double) input.getLeftUpper().y / image.getHeight()) - locationBuffer;
        System.out.printf("transform: translate(%.4fvw, %.4fvh);%n", (inputWidthLocation * 100), (inputHeightLocation * 100));
    }

    private void printButtonSetting() {
        System.out.println("--- register-button ---");

        final double buttonWidthRatio = (double) button.getWidth() / image.getWidth();
        final double buttonHeightRatio = (double) button.getHeight() / image.getHeight();

        System.out.printf("width: %.4fvw;%n", (buttonWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (buttonHeightRatio * 100));
    }

    private void printPrivacy() {
        System.out.println("--- privacy ---");
        printHyperTextSetting(privacy);
    }

    private void printHyperTextSetting(HyperText hyperText) {

        final int inputWidth = hyperText.getRightLower().x - hyperText.getLeftUpper().x;
        final int inputHeight = hyperText.getRightLower().y - hyperText.getLeftUpper().y;

        final double textWidthRatio = (double) inputWidth / image.getWidth();
        final double textHeightRatio = (double) inputHeight / image.getHeight();

        System.out.printf("width: %.4fvw;%n", (textWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (textHeightRatio * 100));

        final double textWidthLocation = (double) hyperText.getLeftUpper().x / image.getWidth();
        final double textHeightLocation = (double) hyperText.getLeftUpper().y / image.getHeight();
        System.out.printf("transform: translate(%.4fvw, %.4fvh);%n", (textWidthLocation * 100), (textHeightLocation * 100));
    }

    private void printPolicy() {
        System.out.println("--- policy ---");
        printHyperTextSetting(policy);
    }

    public static void main(String[] args) {
        Image image = new Image(750, 1335);

        InputField input = InputField.builder()
            .leftUpper(new Point(192, 801))
            .rightLower(new Point(630, 827))
            .build();

        Button button = new Button(607, 77);

        HyperText privacy = HyperText.builder()
            .leftUpper(new Point(326, 1016))
            .rightLower(new Point(492, 1039))
            .build();

        HyperText policy = HyperText.builder()
            .leftUpper(new Point(510, 1016))
            .rightLower(new Point(630, 1039))
            .build();

        AppCoordinationCounter counter = AppCoordinationCounter.builder()
            .image(image)
            .button(button)
            .input(input)
            .privacy(privacy)
            .policy(policy)
            .build();
        counter.printInputFieldSetting();
        counter.printButtonSetting();
        counter.printPrivacy();
        counter.printPolicy();
    }
}
