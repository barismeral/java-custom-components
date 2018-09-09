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
 * @author Baris Meral
 * @since 2018.09.03
 * @version 1.0
 * @apiNote jdk 8
 * @see javax.swing.JComponent
 */

public class Switch extends JComponent implements MouseListener {


    public Switch(){
addMouseListener(this);
    }
    public Switch(boolean key){
        on=key;
    }
    private Dimension dimension = new Dimension(100,40);
    private Point point = new Point(0,0);
    private boolean on=true;

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.gray);
        g.drawRect(point.x+5,point.y+4,dimension.width-9,dimension.height-8);
        g.setColor(Color.white);
        g.drawRect(point.x+6,point.y+6,dimension.width-11,dimension.height-11);
        g.setColor(Color.lightGray);
        g.fillRect(point.x+8,point.y+8,dimension.width-14,dimension.height-13);

        if (on){
            g.setColor(new Color( 81,148,216));
            g.fillRect(point.x+7,point.y+6,dimension.width-11,dimension.height-11);
            g.setColor(Color.darkGray);
            g.fillRect((dimension.width/2)-1,point.y+3,(dimension.width-4)/2,dimension.height-5);
            g.setColor(Color.white);
            g.fillRect(dimension.width/2,point.y+4,(dimension.width-8)/2,dimension.height-7);

            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(Color.WHITE);
            graphics2D.setFont(new Font("Arial",1,16));
            graphics2D.drawString("ON", point.x+15,point.y+26);
        }
        else {

            g.setColor(Color.lightGray);
            g.fillRect(point.x+6,point.y+6,dimension.width-11,dimension.height-11);

            g.setColor(Color.darkGray);
            g.fillRect(point.x+4,point.y+3,(dimension.width-5)/2,dimension.height-5);
            g.setColor(Color.white);
            g.fillRect(point.x+5,point.y+4,(dimension.width-10)/2,dimension.height-7);

         Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(Color.black);
            graphics2D.setFont(new Font("Arial",1,16));
            graphics2D.drawString("OFF", point.x+55,point.y+26);


        }
    }

    @Override
    public Dimension getMinimumSize() {
        return dimension;
    }

    @Override
    public Dimension getMaximumSize() {
        return dimension;
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    /**
     *
     * @return ON or OFF
     */
    public boolean getSwitch(){
        return on;
    }

    /**
     *  Set On or Off
     *  true = on
     *  false = off
     * @param key
     */
    public void setSwitch(boolean key){
        on=key;
        repaint();
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        if (on){
            on=false;
            repaint();
        }
        else {
            on=true;
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
