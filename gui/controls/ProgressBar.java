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
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Baris Meral
 * @since 2018.09.03
 * @version 1.0
 * @apiNote jdk 8
 * @see java.awt.Component
 * @see javax.swing.JComponent
 *
 */

public class ProgressBar extends JComponent {

    private Dimension dimension = new Dimension(200, 30);
    private Point point = new Point(1, 1);
    private int defaultValue = 0;
    private int stringValue;
    private int stringX;
    private Font defaultFont = new Font("Arial",1,16);
    private Color defaultProgressColor = Color.green;
    private Color defaultStringColor = Color.white;
    private boolean stringEnabled=false;

    public final int MIN_WIDTH = 100;
    public final int MAX_WIDTH = 1000;


    /**
     * default constructor
     */
  public ProgressBar() {


      this(100,20);


    }

    /**
     * string painted enable?
     * @param stringPaintedEnabled
     */
    public ProgressBar(boolean stringPaintedEnabled){

      this(100,200);
      stringEnabled =stringPaintedEnabled;

    }

    /**
     *  progressbar size
     * @param width
     * @param height
     */
   public ProgressBar(int width,int height){

      if (width%100==0){
          dimension.width = width;
          if (height>9 && height<65)
          dimension.height = height;
          else
              throw new NumberFormatException("");
      }

      else {
          throw new NumberFormatException(width+"It should be multiples of 100. \n" +
                  "Can not be less than 100 and not greater than 1000");
      }

    }



    @Override
    public Dimension getMinimumSize() {
        return dimension;
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
          setOpaque(true);

        g.setColor(Color.lightGray);
        g.fill3DRect(point.x + 1, point.y + 1, dimension.width - 1, dimension.height + 1, true);
        g.setColor(Color.WHITE);
        g.draw3DRect(point.x, point.y, dimension.width - 1, dimension.height - 1, true);
        g.setColor(defaultProgressColor);
        g.fill3DRect(point.x+1, point.y,defaultValue, dimension.height - 2, true);
     g.setColor(defaultStringColor);

    otoTextAlignment();
     g.setFont(defaultFont);

     if (stringEnabled) {
         g.drawString("%" + String.valueOf(stringValue), stringX, defaultFont.getSize());
     }
        setBorder(new LineBorder(Color.darkGray, 1));

    }

    /**
     * set progressbar value
     * @param value
     */
    public void setValue(int value) {
if (value>=101 ||value<0)return;


      else {

  int i = dimension.width / 100;
    int j = value * i;
    this.defaultValue = j;

   stringValue = value;
    repaint();
}
    }

    /**
     * get value
     * @return
     */
    public int getValue(){

        return stringValue;
    }

    /**
     * set string color
     * @param color
     */
    public void SetStringColor(Color color){

      defaultStringColor = color;

    }

    /**
     * oto text alignment in paintComponents method
     */
    private void otoTextAlignment(){

    defaultFont = new Font(defaultFont.getFamily(),0,dimension.height-14);

        stringX = (dimension.width/2)-10;


    }

    /**
     * set String enabled
     * @param enabled
     */
  public void setStringEnabled(boolean enabled){

      this.stringEnabled = enabled;
  }

    /**
     *
     * @return dimension of size
     */
    @Override
    public Dimension getSize() {
        return dimension;
    }

    /**
     *
     * @return point x & y
     */
    @Override
    public Point getLocation() {
        return point;
    }

    @Override
    public int getWidth() {
        return dimension.width;
    }
}