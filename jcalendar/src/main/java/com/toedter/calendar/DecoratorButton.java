/*
 * Copyright (C) 2019 Ruslan Lopez Carro.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package com.toedter.calendar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.UIManager;

/**
 * A button that doesn't react on clicks or focus changes. Thanks to Thomas
 * Schaefer for the focus hint.
 *
 * @author RuslanLopez
 */
public class DecoratorButton extends JButton {

    private static final long serialVersionUID = -5306477668406547496L;

    private Color decorationBackgroundColor;
    private boolean decorationBackgroundVisible;
    private boolean decorationBordersVisible;
    private Color sundayForeground;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form DecoratorButton
     */
    public DecoratorButton() {
        this(Color.DARK_GRAY, true, true, new Color(164, 0, 0));
    }

    public DecoratorButton(Color decorationBackgroundColor, boolean decorationBackgroundVisible, boolean decorationBordersVisible, Color sundayForeground) {
        this.decorationBackgroundColor = decorationBackgroundColor;
        this.decorationBackgroundVisible = decorationBackgroundVisible;
        this.decorationBordersVisible = decorationBordersVisible;
        this.sundayForeground = sundayForeground;
        initComponents();
    }

    @Override
    public void addMouseListener(MouseListener l) {
    }

    @Override
    public boolean isFocusable() {
        return false;
    }

    @Override
    public void paint(Graphics g) {
        if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
            // this is a hack to get the background painted
            // when using Windows Look & Feel
            if (decorationBackgroundVisible) {
                g.setColor(decorationBackgroundColor);
            } else {
                g.setColor(sundayForeground);
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            if (isBorderPainted()) {
                setContentAreaFilled(true);
            } else {
                setContentAreaFilled(false);
            }
        }
        super.paint(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(decorationBackgroundColor);
        setBorderPainted(decorationBordersVisible);
        setContentAreaFilled(decorationBackgroundVisible);
    }// </editor-fold>//GEN-END:initComponents

}
