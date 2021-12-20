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
        System.out.println("--- register-input ---");
        final int inputWidth = input.getRightLower().x - input.getLeftUpper().x;
        final int inputHeight = input.getRightLower().y - input.getLeftUpper().y;

        final double ratioBuffer = 0.01;
        final double inputWidthRatio = ((double) inputWidth / image.getWidth()) + ratioBuffer;
        final double inputHeightRatio = ((double) inputHeight / image.getHeight()) + ratioBuffer;

        System.out.printf("width: %.4fvw;%n", (inputWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (inputHeightRatio * 100));
        System.out.println();
        System.out.println("position: absolute;");
        System.out.println("top: 0%;");
        System.out.println("left: 0%;");

        final double locationBuffer = 0.005;
        final double inputWidthLocation = ((double) input.getLeftUpper().x / image.getWidth()) - locationBuffer;
        final double inputHeightLocation = ((double) input.getLeftUpper().y / image.getHeight()) - locationBuffer;
        System.out.printf("transform: translate(%.4fvw, %.4fvh);%n", (inputWidthLocation * 100), (inputHeightLocation * 100));

        System.out.println("--- register-input input ---");
        System.out.printf("width: %.4fvw;%n", (inputWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (inputHeightRatio * 100));

        final double fontRatio = 0.5;
        System.out.printf("font-size: %.4fvh;%n", ((inputHeightRatio * 100) * fontRatio));
    }

    private void printButtonSetting() {
        System.out.println("--- register-button ---");

        final double buttonWidthRatio = (double) button.getWidth() / image.getWidth();
        final double buttonHeightRatio = (double) button.getHeight() / image.getHeight();

        System.out.printf("width: %.4fvw;%n", (buttonWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (buttonHeightRatio * 100));
        System.out.println();
        System.out.println("position: absolute;");
        System.out.println("top: 0%;");
        System.out.println("left: 50%;");


        final double ratio = 0.1;
        final double upperLocation = (button.getUpper() + ((button.getLower() - button.getUpper()) * ratio))
            / image.getHeight();
        System.out.printf("transform: translate(-50%s %.4fvh);%n", "%,", (upperLocation * 100));
    }

    private void printPrivacy() {
        System.out.println("--- privacy ---");
        printHyperTextSetting(privacy);
    }

    private void printHyperTextSetting(final HyperText hyperText) {

        final int inputWidth = hyperText.getRightLower().x - hyperText.getLeftUpper().x;
        final int inputHeight = hyperText.getRightLower().y - hyperText.getLeftUpper().y;

        final double textWidthRatio = (double) inputWidth / image.getWidth();
        final double textHeightRatio = (double) inputHeight / image.getHeight();

        System.out.printf("width: %.4fvw;%n", (textWidthRatio * 100));
        System.out.printf("height: %.4fvh;%n", (textHeightRatio * 100));

        System.out.println();
        System.out.println("position: absolute;");
        System.out.println("top: 0%;");
        System.out.println("left: 0%;");

        final double textWidthLocation = (double) hyperText.getLeftUpper().x / image.getWidth();
        final double textHeightLocation = (double) hyperText.getLeftUpper().y / image.getHeight();
        System.out.printf("transform: translate(%.4fvw, %.4fvh);%n", (textWidthLocation * 100), (textHeightLocation * 100));
    }

    private void printPolicy() {
        System.out.println("--- policy ---");
        printHyperTextSetting(policy);
    }

    public static void main(final String[] args) {
        final int imageWidth = 750;
        final int imageHeight = 1334;
        final int buttonWidth = 607;
        final int buttonHeight = 77;

        final Image image = new Image(imageWidth, imageHeight);

        final int inputLU_X = 191;
//        final int inputLU_X = (750 / 2) - 200;   // center case
        final int inputLU_Y = 1069;
        final int inputRL_Y = 1098;
        final InputField input = InputField.builder()
            .leftUpper(new Point(inputLU_X, inputLU_Y))
            .rightLower(new Point(inputLU_X + 400, inputRL_Y))
            .build();

        final int buttonTopLocation = 1129;
        final int buttonFooterLocation = 1259;
        final Button button = Button.builder()
            .width(buttonWidth)
            .height(buttonHeight)
            .upper(buttonTopLocation)
            .lower(buttonFooterLocation)
            .build();

        final int privacyLU_X = 334;
        final int privacyLU_Y = 1258;
        final int privacyRL_X = 488;
        final int privacyRL_Y = 1280;
        final HyperText privacy = HyperText.builder()
            .leftUpper(new Point(privacyLU_X, privacyLU_Y))
            .rightLower(new Point(privacyRL_X, privacyRL_Y))
            .build();

        final int policyLU_X = 502;
        final int policyRL_X = 614;
        final HyperText policy = HyperText.builder()
            .leftUpper(new Point(policyLU_X, privacyLU_Y))
            .rightLower(new Point(policyRL_X, privacyRL_Y))
            .build();

        final AppCoordinationCounter counter = AppCoordinationCounter.builder()
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
