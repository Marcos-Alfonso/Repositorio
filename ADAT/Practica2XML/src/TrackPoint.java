public class TrackPoint {
    private double lng;
    private double lat;
    private double ele;
    private String time;

    public TrackPoint(double lng, double lat, double ele, String time) {
        this.lng = lng;
        this.lat = lat;
        this.ele = ele;
        this.time = time;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public double getEle() {
        return ele;
    }

    public String getTime() {
        return time;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setEle(double ele) {
        this.ele = ele;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
