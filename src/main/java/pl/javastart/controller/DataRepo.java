package pl.javastart.controller;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepo {

    private List<Point> pointList;

    public DataRepo() {
        this.pointList = new ArrayList<>();
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void addPoint(Point newPoint) {
        this.pointList.add(newPoint);
    }
}
