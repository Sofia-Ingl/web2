package beans;

import java.io.Serializable;

public class EntryBean implements Serializable {

    private double x;
    private double y;
    private double r;
    private String currentTime;
    private String execTime;
    private boolean isHit;

    public EntryBean() {
        this.x = 0;
        this.y = 0;
        this.r = 0;
        this.currentTime = "";
        this.execTime = "";
        this.isHit = false;
    }

    public EntryBean(double x, double y, double r, String currentTime, String execTime, boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.execTime = execTime;
        this.isHit = isHit;
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public String getExecTime() {
        return execTime;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public void setExecTime(String execTime) {
        this.execTime = execTime;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "EntryBean{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", currentTime='" + currentTime + '\'' +
                ", execTime='" + execTime + '\'' +
                ", isHit=" + isHit +
                '}';
    }
}
