import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main extends JFrame{
        private int WINDOW_WIDTH = 1000;
        private int WINDOW_HEIGHT = 500;
        private int BUTTONHEIGHT = 40;
        private int BUTTONX = WINDOW_WIDTH/2-75;


    public static void main(String[] args) throws Exception{
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver\\chromedriver.exe");
//        ChromeDriver driver = new ChromeDriver();
////      driver.manage().window().maximize();
        File file = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\clipart1103568.png");
        Main main = new Main();
        main.colorShiftRight(file);
        main.colorShiftLeft(file);
        main.intenseColor(file,1.5);
        main.greyScale(file);
        main.contracts(file);
        main.flipImage(file);


    }

    public Main(){
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(false);


        //דוד פה אתה צריך לשים את התיבת טקסט

        JButton colorShiftRight = new JButton("ColorShiftRight");
        colorShiftRight.setBounds(BUTTONX,120,150,40);
        colorShiftRight.addActionListener((event) -> {

        });
        this.add(colorShiftRight);

        JButton colorShiftLeft = new JButton("ColorShiftLeft");
        colorShiftLeft.setBounds(BUTTONX,colorShiftRight.getY()+BUTTONHEIGHT+10,150,40);
        colorShiftLeft.addActionListener((event) -> {

        });
        this.add(colorShiftLeft);

        JButton intenseColor = new JButton("IntenseColor");
        intenseColor.setBounds(BUTTONX,colorShiftLeft.getY()+BUTTONHEIGHT+10,150,40);
        intenseColor.addActionListener((event) -> {

        });
        this.add(intenseColor);

        JButton greyScale = new JButton("GreyScale");
        greyScale.setBounds(BUTTONX, intenseColor.getY()+BUTTONHEIGHT+10, 150, 40);
        greyScale.addActionListener((event) -> {

        });
        this.add(greyScale);

        JButton contracts = new JButton("Contracts");
        contracts.setBounds(BUTTONX, greyScale.getY()+BUTTONHEIGHT+10, 150, 40);
        contracts.addActionListener((event) -> {

        });
        this.add(contracts);

        JButton flipImage = new JButton("FlipImage");
        flipImage.setBounds(BUTTONX, contracts.getY()+BUTTONHEIGHT+10, 150, 40);
        flipImage.addActionListener((event) -> {

        });
        this.add(flipImage);


    }

    public void colorShiftRight(File file) throws Exception {
        if(file.exists()){
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int pixel = image.getRGB(x,y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(green, blue, red);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\COLORSHIFTRIGHTclipart1103568.png");
            ImageIO.write(image, "png", output);
        }// סוגר שבודק האם הקובץ קיים
    }// end of the changeColor function
    public void colorShiftLeft(File file) throws Exception {
        if(file.exists()){
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int pixel = image.getRGB(x,y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(blue, red, green);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\COLORSHIFTLEFTclipart1103568.png");
            ImageIO.write(image, "png", output);
        }// סוגר שבודק האם הקובץ קיים
    }// end of the changeColor function

    public void intenseColor (File file, double by) throws Exception{
        BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                double increaseRed = red*by;
                if(increaseRed>255){
                    increaseRed = 255;
                }
                double increaseGreen = green*by;
                if(increaseGreen>255){
                    increaseGreen = 255;
                }
                double increaseBlue = blue*by;
                if(increaseBlue>255){
                    increaseBlue = 255;
                }
                Color newColor = new Color((int) increaseRed, (int) increaseGreen, (int) increaseBlue);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
        File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\INCREASECOLORclipart1103568.png");
        ImageIO.write(image, "png", output);
    }
    public void greyScale(File file) throws Exception {
        if(file.exists()){
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int pixel = image.getRGB(x,y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    int average = (red + green + blue)/3;
                    Color newColor = new Color(average, average, average);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\GREYSCALEclipart1103568.png");
            ImageIO.write(image, "png", output);
        }
    }
    public void contracts(File file) throws Exception {
        if(file.exists()){
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int pixel = image.getRGB(x,y);
                    Color color = new Color(pixel);
                    int red = color.getRed();
                    int green = color.getGreen();
                    int blue = color.getBlue();
                    Color newColor = new Color(255-red, 255-green, 255-blue);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\CONTRACTSclipart1103568.png");
            ImageIO.write(image, "png", output);
        }
    }

    public void flipImage(File file) throws Exception {
        if(file.exists()){
            BufferedImage image = ImageIO.read(file);// כדי להשתמש בתמונה
            BufferedImage outputImage = ImageIO.read(file);
            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int pixel = image.getRGB(x,y);
                    Color color = new Color(pixel);
                    outputImage.setRGB(image.getWidth()-x-1,y,color.getRGB());

                }
            }
            File output = new File ("C:\\Users\\User\\Pictures\\imagesToJava\\FLIPIMAGEclipart1103568.png");
            ImageIO.write(outputImage, "png", output);
        }
    }

}//  של סוף המחלקה Main
