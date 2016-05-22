/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.ui;
import com.bjut.dao.*;
import com.bjut.manager.*;
import com.bjut.mintime.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author huipu
 */
public class Client extends JFrame implements ActionListener,ListSelectionListener{
    private MapPanel map;
    private IOPanel ioPanel;
    private LinePanel linePanel;
    private Container con;
    private LineInterface lineFactory;
    private StationInterface stationFactory;
    
    public Client(){
        super("Suabway");
        con=getContentPane();
        map = new MapPanel();
        ioPanel = new IOPanel(this);
        linePanel = new LinePanel(this);
        lineFactory = new LineImpl();
        stationFactory = new StationImpl();
    }
    
    public void init(){
        setBounds(0,0,1366,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        con.setLayout(null);
        
        map.init();
        con.add(map);
        map.setLocation(0,0);
        ioPanel.init();
        con.add(ioPanel);
        ioPanel.setLocation(1023,0);
        linePanel.init();
        con.add(linePanel);
        linePanel.setLocation(1023,362);
        
        setVisible(true);
    }

    
    public static void main(String args[]){
        Client client = new Client();
        client.init();
    }
    
    /**
     * 出行方式查询监听器
     * @param e 
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        String startName = ioPanel.getStartStationText().getText();
        String endName = ioPanel.getEndStationText().getText();
        String message = checkStation(startName,endName);
        if(message != null){
            JOptionPane.showMessageDialog(null,message,"输入检查",JOptionPane.ERROR_MESSAGE);
        }else{
            Station startStation = stationFactory.getStation(startName);
            Station endStation = stationFactory.getStation(endName);
            MinTime mt = new MinTime(startStation,endStation);
            Result result = null;
            //选择算法
            if(e.getSource() == ioPanel.getMinTimeButton()){
                if(ioPanel.getIsBusy().isSelected()){
                    result = mt.Dijkstra(true, true);
                }else{
                    result = mt.Dijkstra(false, true);
                } 
            }else{
                 if(ioPanel.getIsBusy().isSelected()){
                    result = mt.Dijkstra(true, false);
                }else{
                    result = mt.Dijkstra(false, false);
                } 
            }
            ioPanel.getResultArea().setText(showResult(result));
            //绘制路线
            map.setResult(result);
            map.repaint();
        }
    }

    /**
     * 
     * @param e 
     * 线路查询监听器
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            JList list = (JList ) e.getSource() ;
  	Object selectedValue = list.getSelectedValue();
        StringBuffer lineString = new StringBuffer();
        Line line = lineFactory.getLine(selectedValue.toString());
        int i;
        for(i = 0;i< line.getStations().size()-1;i++){
            lineString.append(line.getStations().get(i));
            lineString.append("-->");
        }
        lineString.append(line.getStations().get(i));
  	linePanel.getLinesArea().setText(lineString.toString());
        
        drawLine(line);
        }
    }
    /**
     * 画线路信息
     * @param line 
     */
    public void drawLine(Line line){
        Result result = new Result();
        for(int i = 0;i < line.getStations().size();i++){
            result.stationList.add(stationFactory.getStation(line.getStations().get(i)));
        }
        result.tranStations.add(line.getStations().get(0));
        map.setResult(result);
        map.repaint();
    }
    /**
     * 检查站点是否合法
     */
    public String checkStation(String startName,String endName){
        String startStation = startName.trim();
        String endStation = endName.trim();
        if(startStation.equals("") || endStation.equals("")){
            return "起始站点或者终点站不能为空";
        }
        if(startStation.equals(endStation)){
            return "起始站和终点站不能相同";
        }
        if(!stationFactory.haveStation(startStation)){
            return "暂不支持该起始站";
        }
        if(!stationFactory.haveStation(endStation)){
            return "暂不支持该终点站";
        }
        return null;
    }
    
    /**
     * 解析查询结果
     */
    public String showResult(Result result){
        StringBuffer resultString = new StringBuffer();
        String temp = null;
        for(int i = 0;i < result.stationList.size();i++){
            resultString.append(result.stationList.get(i).getStationName());
            if(i != result.stationList.size()-1){
                resultString.append("-->");
            }
        }
        resultString.append("\n共用时：");
        resultString.append(result.totalTime);
        temp = "\n从"+result.tranStations.get(0)+"站乘坐"+result.tranLines.get(0);
        resultString.append(temp);
        for(int i = 1;i < result.tranLines.size();i++){
            temp = "\n在"+result.tranStations.get(i)+"站换乘"+result.tranLines.get(i);
            resultString.append(temp);
        }
        temp = "到达" + result.tranStations.get(result.tranStations.size()-1) + "站";
        resultString.append(temp);
        resultString.append("\n换乘次数：");
        resultString.append(result.changes);
        return resultString.toString();
    }
}
