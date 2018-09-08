package gui.controls;

import javax.swing.*;
import java.awt.*;

public class PictureBox extends JComponent {


    private Dimension dimension = new Dimension(340,210);
    private Point point = new Point(0,0);
    private ImageIcon imageIcon;
    private Image image;
    private String imagePath;

    public final int ICON_WIDTH_SIZE = 30;
    public final int ICON_HEIGTH_SIZE = 30;

    public final int NORMAL_WIDTH_SIZE = 100;
    public final int NORMAL_HEIGHT_SIZE = 100;

    public final int LARGE_WIDTH_SIZE = 500;
    public final int LARGE_HEIGHT_SIZE = 500;


     {
        createToolTip();

    }

   public PictureBox(){

        this(null,30,30);



    }

   public PictureBox(String imagePath){

         this.imagePath = imagePath;
          //dimension.height=100;
          //dimension.width=100;

    }

  public PictureBox(String imagePath, int width, int height){
        this.imagePath = imagePath;
        dimension.width=width;
        dimension.height=height;


    }


        @Override
    public void paint(Graphics g) {
            super.paintComponent(g);



        if (imageResize()==null){


        }

        else {
            imageResize().paintIcon(this, g, point.x, point.y);


        }
    }

    @Override
    public Dimension getPreferredSize() {


        return dimension;

    }

    @Override
    public Dimension getMaximumSize() {

        return dimension;
    }

    @Override
    public Dimension getMinimumSize() {

        return dimension;
    }



    private ImageIcon imageResize(){

        if (imagePath==null){

            return null;
        }
        else {
            imageIcon = new ImageIcon(imagePath);
            image = imageIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);

            return new ImageIcon(image);
        }

    }



    public void setPictureSize(int w,int h) {
        dimension.width=w;
        dimension.height=h;
        repaint();
    }

    public Dimension getPictureSize(){
        return dimension;
    }

    public void setPicturePath(String path){

        imagePath = path;
        repaint();
    }
    public String getpicturePath(){

        return imagePath;
    }

    @Override
    public void setToolTipText(String text) {
        super.setToolTipText(text);
    }
}
