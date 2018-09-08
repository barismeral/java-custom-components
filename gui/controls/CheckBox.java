
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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 * @author Barış Meral
 * @since 2018.09.07
 * @version 1.0
 * @see javax.swing.JComponent
 */

public class CheckBox extends JComponent implements MouseListener{


    private Point point = new Point(0,0);
    private boolean checked =false;
    private String defaultString="";
    private Font defaultFont = new Font("Arial",0,16);
    private Color foreGroundColor = Color.black;

    /**
     * default constructor
     */
    public CheckBox(){

        lengthControl(defaultString,defaultFont);
        defaultString=null;
        addMouseListener(this);
    }

    /**
     * set text
     * @param text
     */
    public CheckBox(String text){
        defaultString = text;
        lengthControl(defaultString,defaultFont);
        addMouseListener(this);
    }

    /**
     * set checked
     * @param checked
     */
    public CheckBox(boolean checked){
        lengthControl(defaultString,defaultFont);
        this.checked = checked;
        defaultString=null;
        addMouseListener(this);
    }
    private Dimension dimension = new Dimension(this.getFontMetrics(defaultFont).stringWidth(defaultString)+10,22);

    /**
     * paint this component
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);
        lengthControl(defaultString,defaultFont);

        g2D.setColor(Color.darkGray);
        g2D.drawRect(point.x,point.y,20,20);

        g2D.setColor(Color.lightGray);
        g2D.fillRect(point.x+1,point.y+1,19,19);
        g2D.setColor(Color.gray);
        g2D.fillRect(point.x+3,point.y+3,15,15);





        if (defaultString!=null) {
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.setColor(foreGroundColor);
            g2D.drawString(defaultString,point.x+25,point.y+defaultFont.getSize());

        }

        if (checked){

           g2D.setColor(new Color(0, 89, 179));
           g2D.setStroke(new BasicStroke(4));
           g2D.drawLine(5,6,9,13);
           g2D.drawLine(9,13,20,1);


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


}






















