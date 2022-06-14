import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName book
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/17 8:08
 * @Version 1.0
 */
public class book {

    public book(String name, String desc, ImageIcon image) {
        this.name = name;
        this.desc = desc;
        this.image = image;

    }

    private String name;
    private String desc;
    private ImageIcon image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }
}
