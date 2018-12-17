import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageTest {

    /**
     * 指定比例进行缩放
     *
     * scale 第一个参数是压缩后图片的宽度, 第二个参数图片的高度 如果是一个参数那么那么宽和高乘以此次参数 可以使大于1 越小图片占用空间越小
     * outputQuality 是图片的质量 只能在0和1之间   不能大于1,参数越小 压缩后的图片的占用空间越小
     * @throws IOException
     */
    @Test
    public void demo1() throws IOException {
        Thumbnails.of("E:/image/yatu.5.jpg")
                .scale(0.25)
                .outputQuality(.5)
                .toFile("E:/image/yatu.2.jpg");

    }

    /**
     * 指定大小进行缩放
     *
     * 若图片横比200小，高比300小，不变
     * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
     * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
     */
    @Test
    public void demo2() throws IOException {
        Thumbnails.of("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250.png").
               size(500,500).toFile("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250_500_500.png");
        Thumbnails.of("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250.png").
               size(300,300).toFile("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250_300_300.png");
        Thumbnails.of("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250.png").
               size(166,166).toFile("E:/image/yuantu/wKgBPFvQHR-AaIYrAAqXljybj1s250_166_166.png");
    }

    /**
     * 不按照比例，指定大小进行缩放
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        /**
         * keepAspectRatio(false) 默认是按照比例缩放的
         */
        Thumbnails.of("D:/install/ideaworkspase/develop/imagetest/src/main/webapp/image/yuantu.png")
                .size(500, 1000).
                keepAspectRatio(false).
                toFile("D:/install/ideaworkspase/develop/imagetest/src/main/webapp/image/500_1000_2.png");
    }

    /**
     * 旋转
     *
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        /**
         * rotate(角度),正数：顺时针 负数：逆时针
         */
        Thumbnails.of("images/test.jpg").size(1280, 1024).rotate(90).toFile("C:/image+90.jpg");
        Thumbnails.of("images/test.jpg").size(1280, 1024).rotate(-90).toFile("C:/iamge-90.jpg");
    }

    /**
     * 裁剪
     *
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        /**
         * 图片中心400*400的区域
         */
        Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("C:/image_region_center.jpg");
        /**
         * 图片右下400*400的区域
         */
        Thumbnails.of("images/test.jpg").sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200).keepAspectRatio(false)
                .toFile("C:/image_region_bootom_right.jpg");
        /**
         * 指定坐标
         */
        Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400, 400).size(200, 200).keepAspectRatio(false).toFile("C:/image_region_coord.jpg");
    }

    /**
     * 转化图像格式
     *
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        /**
         * outputFormat(图像格式)
         */
        Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("png").toFile("C:/image_1280x1024.png");
        Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("gif").toFile("C:/image_1280x1024.gif");

    }

    /**
     * 输出到OutputStream
     *
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {
        /**
         * toOutputStream(流对象)
         */
        OutputStream os = new FileOutputStream("C:/image_1280x1024_OutputStream.png");
        Thumbnails.of("images/test.jpg").size(1280, 1024).toOutputStream(os);
    }

    /**
     * 输出到BufferedImage
     *
     * @throws IOException
     */
    @Test
    public void test9() throws Exception {
        /**
         * asBufferedImage() 返回BufferedImage
         */
        BufferedImage thumbnail = Thumbnails.of("images/test.jpg").size(1280, 1024).asBufferedImage();
        ImageIO.write(thumbnail, "jpg", new File("C:/image_1280x1024_BufferedImage.jpg"));
    }

}
