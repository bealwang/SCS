/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.ui;

import com.bjut.mintime.Result;
import com.bjut.mintime.Station;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author huipu
 */
public class MapPanel extends JComponent{
    private Image imgSubway;
    private ArrayList<Point> line;
    private Result result;
    
    public MapPanel(){
        imgSubway = new ImageIcon("img\\subway.png").getImage();
        line = new ArrayList<Point>();
        setSize(1023,768);
    }
    
    public void init(){
        repaint();
    }
   
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        float thick=6.0f;
        int count = 0;
        g2d.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.BLACK);
        g.drawImage(imgSubway,0,0,this);
        //画路线
        for (int i = 0 ; i < line.size(); i++){
           if(!result.tranStations.isEmpty() && result.tranStations.contains(result.stationList.get(i).getStationName())){
                //改变颜色，画站点
                g2d.drawOval(line.get(i).x-3, line.get(i).y-3, 6, 6);
                g2d.setColor(changeColor(count));
                count++;
            }
            if (i != line.size()-1){
                g2d.drawLine (line.get(i).x , line.get(i).y ,
                line.get(i+1).x , line.get(i+1).y);
            }else{
                g2d.drawOval(line.get(i).x-3, line.get(i).y-3, 6, 6);
            } 
        }
    }
    /**
     * 动态改变颜色
     * @param count
     * @return 
     */
    public Color changeColor(int count){
        if(count == 0){
            return Color.BLUE;
        }
        if(count == 1){
            return Color.RED;
        }
        if(count == 2){
            return Color.YELLOW;
        }
        if(count ==3){
            return Color.ORANGE;
        }
        if(count == 4){
            return Color.CYAN;
        }
        return Color.BLACK;
    }

    /**
     * @param line the line to set
     */
    public void setLine(ArrayList<Point> line) {
        this.line = line;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Result result) {
        line.clear();
        this.result = result;
        for(Station s:result.stationList){
            this.line.add(s.getPosition());
        }
    }
}
