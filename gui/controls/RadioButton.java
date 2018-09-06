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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;


/**
 * @author Barış Meral
 * @since 2018.09.06
 * @version 1.0
 * @see javax.swing.JComponent
 */

public class RadioButton extends JComponent implements MouseListener ,ActionListener{


  private Point point = new Point(0,0);
  private boolean checked =false;
  private String defaultString="";
  private Font defaultFont = new Font("Arial",0,16);
  private Color foreGroundColor = Color.black;

    /**
     * default constructor
     */
  public RadioButton(){

      lengthControl(defaultString,defaultFont);
      defaultString=null;
addMouseListener(this);
  }

    /**
     * set text
     * @param text
     */
  public RadioButton(String text){
      defaultString = text;
      lengthControl(defaultString,defaultFont);
      addMouseListener(this);
  }

    /**
     * set checked
     * @param checked
     */
  public RadioButton(boolean checked){
      lengthControl(defaultString,defaultFont);
      this.checked = checked;
      defaultString=null;
      addMouseListener(this);
  }
    private Dimension dimension = new Dimension(this.getFontMetrics(defaultFont).stringWidth(defaultString)+10,20);

    /**
     * paint this component
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    lengthControl(defaultString,defaultFont);

        g.setColor(Color.gray);
       g.drawOval(point.x,point.y,19,19);
        g.setColor(new Color(230,230,230));
        g.fillOval(point.x+1,point.y+1,17,17);

      g.drawOval(point.x+2,point.y+2,16,16);
      g.setColor(new Color(166,166,166));

        g.fillOval(point.x+2,point.y+2,15,15);


              if (defaultString!=null) {
            g.setColor(foreGroundColor);
            g.setFont(defaultFont);
            g.drawString(defaultString, point.x + 23, point.y + defaultFont.getSize());

                }

      if (checked){
           g.setColor(new Color(51, 119, 255));
           g.drawOval(point.x+3,point.y+3,13,13);
           g.setColor(new Color(102, 153, 255));
           g.fillOval(point.x+3,point.y+3,12,12);
           g.setColor(new Color(230, 242, 255));
           g.fillOval(point.x+3,point.y+3,7,7);
        }


    }

    @Override
    public Dimension getPreferredSize() {
        lengthControl(defaultString,defaultFont);
        return dimension;
    }

    @Override
    public Dimension getMaximumSize() {
        lengthControl(defaultString,defaultFont);
        return dimension;
    }

    @Override
    public Dimension getMinimumSize() {
        lengthControl(defaultString,defaultFont);
        return dimension;
    }

    /**
     * set text
     * @param text
     */
    public void setText(String text){
      this.defaultString = text;
      lengthControl(defaultString,defaultFont);
      repaint();
    }

    /**
     *
     * @return defaultString
     */
    public String getText(){
      return defaultString;

    }

    /**
     * set checked
     * @param checked
     */
    public void setChecked(boolean checked){
      this.checked = checked;
      repaint();
    }

    /**
     *
     * @return is checked
     */
    public boolean getChecked(){
      return checked;
    }

    /**
     * set defaultFont
     * @param font
     */
    public void setFont(Font font){
      defaultFont=font;

      repaint();
    }

    /**
     *
     * @return defaultFont
     */
    public Font getFont(){
      return defaultFont;
    }

    /**
     * set text color
     * @param fg
     */
    @Override
    public void setForeground(Color fg) {
        this.foreGroundColor = fg;
        repaint();
    }

    /**
     * checked true or false please not editable
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

       if (checked) {
           checked = false;
           repaint();
       }
       else{
           checked=true;
       repaint();
       }
    }


    /**
     * set component dimension width dimension.width = text.length by font metrics
     * @param defaultString
     * @param font
     */
    private void lengthControl(String defaultString,Font font){
              if (defaultString==null || defaultString==" ") {
                  dimension.width = 20;
                  repaint();
              }
              else {
                  dimension.width = this.getFontMetrics(font).stringWidth(defaultString) + 25;
                  repaint();
              }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}






















