package lzl;

public class Sensor {
    static {
        System.load("/home/pi/sensor.so");
    }
    public Sensor() {
        this.init();
        set_light(this.color);
        set_speed(this.speed);
    }
    private String color = "r";
    private int speed = 0;
    // 初始化硬件传感器
    public native void init();
    // 获取温湿度
    public native String get_humiture();
    // 获取光照强度
    public native String get_brightness();
    // 设置灯光颜色
    private native void setLight(String color);
    public String get_light() { return color; }
    public void set_light(String color) {
        this.color = color;
        setLight(color);
    }
    // 设置电机速度
    private native void setSpeed(int speed);
    public int get_speed() { return speed; }
    public void set_speed(int speed) {
        this.speed = speed;
        setSpeed(speed);
    }
}
