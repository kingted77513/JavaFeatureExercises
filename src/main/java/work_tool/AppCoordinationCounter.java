package work_tool;


import java.util.Arrays;
import java.util.List;

public class AppCoordinationCounter {

    private List<Image> images;
    private Image button;

    public AppCoordinationCounter(Image... images) {
        this.images = Arrays.asList(images);
    }

    public void setButton(Image button) {
        this.button = button;
    }

    public void printImageRatio() {
        int totalHeight = getTotalHeight();
        for (Image image : images) {
            double ratio = (double) image.getHeight() / totalHeight;
            System.out.printf("%s ratio is %.4f %s%n", image.getFileName(), (ratio * 100), "%");
        }
    }

    private int getTotalHeight() {
        return images.stream().mapToInt(Image::getHeight).sum();
    }

    public void printButtonRatio() {
        double widthRatio = (double) button.getWidth() / getWidth();
        System.out.printf("button width ratio %.4f %s%n", (widthRatio * 100), "%");

        double heightRatio = (double) button.getHeight() / getTotalHeight();
        System.out.printf("button height ratio %.4f %s%n", (heightRatio * 100), "%");
    }

    private int getWidth() {
        return images.get(0).getWidth();
    }

    public static void main(String[] args) {
        Image image1 = new Image("login_h5_1.png", 750, 1009);
        Image image2 = new Image("login_h5_2.png", 750, 609);
        Image image3 = new Image("login_h5_3.png", 750, 321);
        Image button = new Image("login_button_h5.png", 588, 77);

        AppCoordinationCounter counter = new AppCoordinationCounter(image1, image2, image3);
        counter.setButton(button);
        counter.printImageRatio();
        counter.printButtonRatio();

    }
}
