/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucas.mintime;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author huipu
 */
public class MinTime {
    Station startStation;
    Station endStation;
    private HashSet<Integer> V;
    private HashSet<Integer> X;
    private HashSet<Integer> Y;
    private ArrayList<Integer> L;
    
    public MinTime(Station startStation,Station endStation){
        this.startStation = startStation;
        this.endStation = endStation;
        Init();
    }
    public MinTime(){
        
    }
    
    public void Init() {
        int startId = startStation.getId();
       V = new HashSet<Integer>();//存放顶点名称
       for (int i = 1; i < 200; i++){
           V.add(i);
       }
       X = new HashSet<Integer>();
       X.add(startId);//集合X存放源点1
       Y = new HashSet<Integer>(V);//集合Y初始化
       Y.remove(startId);//Y = V -｛1｝
       L = new ArrayList<Integer>(200);
       for (int j = 0; j < 201; j++){
           L.add(Integer.MAX_VALUE);
       }
       L.set(startId, 0);
    }
    
    public Result Dijkstra(boolean isBusy,boolean isMinTime){
        ArrayList<Result> resultList = new ArrayList<Result>();
        ArrayList<Station> neighbor = startStation.getNeighbor();
        for(Station s:neighbor){
            Result result = new Result();
            result.stationList.add(startStation);
            result.station = s;
            result.curLine = getCurLine(startStation,s);
            result.changes = 0;
            result.tranLines.add(result.curLine);
            result.tranStations.add(startStation.getStationName());
            //result.totalTime = getTime(isBusy,null,result);
            result.totalTime = startStation.getNextTime();
            L.set(s.getId(), result.totalTime);
            resultList.add(result);
            if(s.getId() == endStation.getId()){
                        result.stationList.add(s);
                        return result;
                    }
        }
        
        while(!Y.isEmpty()){
            Result result ;
            if(isMinTime){
                result = getMinTime(resultList);
            }else{
                result = getMinTran(resultList);
            }
            if(result.station.getIstranstation() == 1){
                tranStation(isBusy,result,resultList);
                continue;
            }
            if(!result.checked){
                Y.remove(result.station.getId());
            }
            X.add(result.station.getId());
            neighbor = result.station.getNeighbor();
            for(Station s:neighbor){
                if(!X.contains(s.getId())){
                    if(s.getLineList().contains(result.curLine)){
                        Result tempResult = new Result();
                        //tempResult.preStation = result.station;
                        tempResult.stationList.addAll(result.stationList);
                        tempResult.stationList.add(result.station);
                        tempResult.station = s;
                        tempResult.curLine = result.curLine;
                        tempResult.tranLines.addAll(result.tranLines);
                        tempResult.tranStations.addAll(result.tranStations);
                        tempResult.changes = result.changes;
                        if(Y.contains(s.getId()) && getTime(isBusy,result,tempResult) + result.totalTime < L.get(s.getId())){
                            tempResult.totalTime = getTime(isBusy,result,tempResult) + result.totalTime;
                            if(s.getIstranstation() == 0){    //如果是换乘站，则不更新L
                                L.set(s.getId(), tempResult.totalTime);
                            }
                            resultList.add(tempResult);
                        }
                        if(s.getId() == endStation.getId()){
                            tempResult.stationList.add(s);
                            tempResult.tranStations.add(s.getStationName());
                            return tempResult;
                        }
                    }
                }
            }
        }
        return null;
        
    }
    /**
     * 
     * @param curStation
     * @param nextStation
     * @return 两相邻站之间的路线
     */
    public String getCurLine(Station curStation,Station nextStation){
        if(curStation.getIstranstation() == 0){
            return curStation.getStopLineName();
        }
        if(nextStation.getIstranstation() == 0){
            return nextStation.getStopLineName();
        }
        for(String s:curStation.getLineList()){
            if(nextStation.getLineList().contains(s)){
                return s;
            }
        }
        return null;
    }
    /**
     * 
     * @param resultList
     * @return 获得最短时间
     */
    public Result getMinTime(ArrayList<Result> resultList){
        int index = 0;
        for(int i = 0;i < resultList.size();i++){
            if(resultList.get(i).totalTime < resultList.get(index).totalTime){
                index = i;
            }
        }
        Result result = resultList.get(index);
        resultList.remove(index);
        return result;
    }
    /**
     * 
     * @param resultList
     * @return 获得最少换乘次数
     */
    public Result getMinTran(ArrayList<Result> resultList){
        int index = 0;
        for(int i = 0;i < resultList.size();i++){
            if(resultList.get(i).changes < resultList.get(index).changes){
                index = i;
            }
        }
        Result result = resultList.get(index);
        resultList.remove(index);
        return result;
    }
    /**
     * 
     * @param result
     * @return 是否走过该点
     */
    public boolean haveStation(Result result){
        for(Station s:result.stationList){
            if(s.getStationName().equals(result.station.getStationName())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param preLine
     * @param curLine
     * @param curStation
     * @param nextStation
     * @return 两个站点之间的花费时间
     */
    public int getTime(boolean isBusy,Result preResult,Result curResult){
        Station curStation = preResult.station;
        Station nextStation = curResult.station;
        int time = 0;

        if(curStation.getId() < nextStation.getId()){
            time = curStation.getNextTime();
        }else{
            time = nextStation.getNextTime();
        }

        return time;
    }
    /**
     * 
     * @param isBusy
     * @param result 
     * 换乘站的处理
     */
    public void tranStation(boolean isBusy,Result result,ArrayList<Result> resultList){
        int time = 0;
        if(isBusy){
            time = result.station.getBusytime();
        }else{
            time = result.station.getCommentime();
        }
        result.station.setIstranstation(0);
        result.checked = true;    //换乘站按照线路区分
        resultList.add(result);
        for(String s:result.station.getLineList()){
            if(!s.equals(result.curLine)){
                Result temp = new Result();
                temp.curLine = s;
                temp.checked = true;
                temp.station = result.station;
                temp.stationList.addAll(result.stationList);
                temp.totalTime = result.totalTime + time;
                temp.changes = result.changes +1;
                temp.tranLines.addAll(result.tranLines);
                temp.tranLines.add(s);
                temp.tranStations.addAll(result.tranStations);
                temp.tranStations.add(result.station.getStationName());
                resultList.add(temp);
            }
        }
    }
    /**
     * 
     * @param isBusy
     * @param station
     * @return 获得换乘车站的换乘时间
     */
    public int getTranTime(boolean isBusy,Station station){
        int time = 0;
        if(isBusy){
            time = station.getBusytime();
        }else{
            time = station.getCommentime();
        }
        return time;
    }
    
}
