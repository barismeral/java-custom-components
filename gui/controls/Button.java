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

/**
 * @author Baris Meral
 * @since 2018.09.03
 * @version 1.0
 * @apiNote jdk 8
 *
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JComponent  implements MouseListener{

    private Dimension dimension = new Dimension(0,0);
    private Point point = new Point(0,0);
    private String defaultText = "Button";
    private Color backGround = Color.lightGray;
    private Color foreGround = Color.WHITE;
    private Font defaultFont = new Font("Arial",Font.PLAIN,14);
    private LineBorder defaultLineBorder = new LineBorder(Color.darkGray);
    private ImageIcon imageIcon;
    private Boolean icon=false;
    private int fontHeight;

    /**
     * add mouse listener
     * add created tooltip
     * oto sizes
     */
    public Button(){

        addMouseListener(this);
        createToolTip();
        enableInputMethods(true);
        otoOrigin();
    }

    /**
     * set button text
     * @param text
     */
    public Button(String text){

        createToolTip();
        this.defaultText=text;
        addMouseListener(this);
        enableInputMethods(true);
        otoOrigin();

    }

    /**
     * override JComponent Method
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        otoOrigin();
            /* is icon? */
        if (icon){
            imageIcon.paintIcon(this,g,point.x,point.y);
            setBorder(null);
        }
          /* not icon */
       else {

            g.setColor(Color.darkGray);
            g.drawRect(point.x, point.y, dimension.width, dimension.height);
            g.setColor(backGround);
            g.fillRect(point.x, point.y, dimension.width, dimension.height);
            g.setColor(foreGround);
            g.setFont(defaultFont);
            g.drawString(defaultText, point.x+17, point.y+defaultFont.getSize()+3);
            setBorder(defaultLineBorder);
        }

    }

    /**
     * ser Component dimension
     * @param dimension
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * set component font
     * @param font
     */
    @Override
    public void setFont(Font font) {
        defaultFont = font;
        otoOrigin();
        repaint();
    }

    /**
     * set component disable icon
     * @param text
     */
    public void setDisableIcon(String text){

        icon = false;
        imageIcon=null;
        defaultText=text;
        repaint();

    }

    /**
     * set button icon
     * @param path
     */
    public void setIcon(String path){

        imageIcon = new ImageIcon(path);
        dimension.width =imageIcon.getIconWidth();
        dimension.height =imageIcon.getIconHeight();
        icon=true;
        repaint();

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
    public Dimension getMinimumSize() { return dimension; }

    /**
     * set a component dimensions
     * @param width
     * @param height
     */
    public void setDimension(int width,int height){
        dimension.height=height;
        dimension.width=width;
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        backGround=Color.white;
        foreGround=Color.BLACK;
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        backGround= new Color(166, 166, 166);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        backGround= new Color(166, 166, 166);
        repaint();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        backGround=Color.lightGray;
        foreGround=Color.WHITE;
        repaint();
    }

    /**
     * oto origin method
     * set a dimension height and width from font
     *
     */
    private void otoOrigin(){

            FontMetrics fontMetrics = getFontMetrics(defaultFont);
            dimension.height = fontMetrics.getHeight()+6;
            fontHeight=fontMetrics.getHeight();
            int fontLength = fontMetrics.stringWidth(defaultText);
            dimension.width=fontLength+34;
            repaint();
    }

    /**
     * set tooltip
     * @param text
     */
    @Override
    public void setToolTipText(String text) {
        super.setToolTipText(text);
    }
}
