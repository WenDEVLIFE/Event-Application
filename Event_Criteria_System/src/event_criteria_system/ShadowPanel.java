/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event_criteria_system;

import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.geom.*;
import javax.swing.*;

public class ShadowPanel extends JPanel {
    private int roundTopLeft = 50;
    private int roundTopRight = 50;
    private int roundBottomLeft = 50;
    private int roundBottomRight = 50;

    public ShadowPanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2.setColor(Color.GRAY);
        Area area = new Area(createRoundedShape());
        g2.fill(area);
        g2.dispose();
    }

    private Shape createRoundedShape() {
        int width = getWidth();
        int height = getHeight();

        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);

        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));

        if (roundTopRight > 0) {
            area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundTopRight, roundTopRight)));
        }

        if (roundBottomLeft > 0) {
            area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundBottomLeft, roundBottomLeft)));
        }

        if (roundBottomRight > 0) {
            area.intersect(new Area(new RoundRectangle2D.Double(0, 0, width, height, roundBottomRight, roundBottomRight)));
        }

        return area;
    }
}