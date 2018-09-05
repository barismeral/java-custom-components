/*                Copyright (C) 2018  Barış Meral

       This program is free software: you can redistribute it and/or modify
       it under the terms of the GNU General Public License as published by
       the Free Software Foundation, either version 3 of the License, or
       (at your option) any later version.

       This program is distributed in the hope that it will be useful,
       but WITHOUT ANY WARRANTY; without even the implied warranty of
       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
       GNU General Public License for more details.

       You should have received a copy of the GNU General Public License
       along with this program.  If not, see <https://www.gnu.org/licenses/>.
       */



package gui.controls;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Baris Meral
 * @since 2018.09.03
 * @version 1.0
 * @apiNote jdk 8
 * @see javax.swing.JComponent
 */
public class Label extends JComponent {

    private Point point = new Point(1,1);
    private String text;
    private ImageIcon imageIcon=null;
    private Font defaultFont = new Font("Arial",Font.BOLD,20);
    private Color foreGroundColor = Color.BLACK;
    private Color backGroundColor = null;

    /**
     * default constructor null label text
     */
    public Label(){
        this("");

    }

    /**
     * set label text and created
     * @param text
     */
    public Label(String text){

       this.text = text;
       imageIcon=null;
       dimension.height = defaultFont.getSize()+10;
       dimension.width = (text.length()*12);

    }

    private Dimension dimension = new Dimension(0,0);

    /**
     * label add icon set null text
     * @param imageIcon
     */
    public Label(ImageIcon imageIcon){
        text=null;
        this.imageIcon = imageIcon;
        dimension.width=imageIcon.getIconWidth();
        dimension.height=imageIcon.getIconHeight();
    }


    public String getText(){
        return text;
    }


    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    /**
     * painted component label
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (imageIcon==null && text!=null){

            if (backGroundColor != null){
             g.setColor(backGroundColor);
             FontMetrics fontMetrics = g.getFontMetrics();
             int w = fontMetrics.stringWidth(text);
             int h = defaultFont.getSize();
                g.drawRect(point.x-2,point.y,(w*2)-5,h+10);
                g.fillRect(point.x-2,point.y,(w*2)-5,h+10);
                g.setColor(foreGroundColor);
                g.setFont(defaultFont);
                g.drawString(text,point.x+2,point.y+defaultFont.getSize());

            }
            else {
            g.setColor(foreGroundColor);
            g.setFont(defaultFont);
            g.drawString(text,point.x+2,point.y+15);
            setBorder(new EmptyBorder(1,10,1,10));
        }
        }

        else {
            imageIcon.paintIcon(this, g, point.x, point.y);
        }

    }

    /**
     * set label text
     * @param text
     */
    public void setText(String text){

        this.text = text;
        dimension.height = defaultFont.getSize()+10;
        dimension.width = (this.text.length()*12);
        repaint();
    }

    /**
     * set label font
     * @param font
     */
  public void setFont(Font font){

       this.defaultFont = font;
       repaint();

  }

    /**
     * set text color
     * @param foreGroundColor
     */
  public void setForeGround(Color foreGroundColor){

        this.foreGroundColor = foreGroundColor;
        repaint();
  }

    /**
     * set text background color
     * @param backGroundColor
     */
  public void setBackGroundColor(Color backGroundColor){

        this.backGroundColor = backGroundColor;
        repaint();
  }

    /**
     * set icon deleted label text
     * @param imageIcon
     */
  public void setIcon(ImageIcon imageIcon){

        if (imageIcon==null){
            this.text = "label";
            this.imageIcon=null;
            repaint();

        }
        else {

            this.imageIcon = imageIcon;
            dimension.height = imageIcon.getIconHeight();
            dimension.width = imageIcon.getIconWidth();
            repaint();
        }
  }

}
