package learn.jwt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2018-8-15.
 */
public class TestGraphics2D {

    static Color COLOR = Color.BLACK;
    static Font REGULAR = new Font("楷体", Font.PLAIN, 100);

    public static void draw() throws Exception{

        String uri = "input.jpg";
        String tarImPath = "output.jpg";
        Path path = Paths.get(uri);

        Image image = ImageIO.read(path.toFile());
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);

        BufferedImage bufImg = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufImg.createGraphics();
        graphics2D.drawImage(image, 0, 0, imageWidth, imageHeight, null);
        graphics2D.setFont(REGULAR);
        graphics2D.setColor(COLOR);


        graphics2D.drawLine(10, 20, 200, 250);

        graphics2D.dispose();

        FileOutputStream outImgStream = new FileOutputStream(tarImPath);
        ImageIO.write(bufImg, "jpg", outImgStream);
        outImgStream.flush();
        outImgStream.close();

    }
}
