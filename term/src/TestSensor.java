import lzl.Sensor;

import java.util.Scanner;

public class TestSensor {
    static void printhelp() {
        System.out.println(
                "Usage:\n" +
                "\tl: light RGB, 灯光颜色\n" +
                "\ts: speed S, 风扇转速\n" +
                "\tb: brightness, 光照强度\n" +
                "\th: humiture, 温湿度\n");
    }
    public static void main(String[] args) {
        System.load("/home/pi/sensor.so");
        Sensor sensor = new Sensor();
        Scanner scan = new Scanner(System.in);
        printhelp();
        while (true) {
            String line = scan.nextLine();
            String[] arr = line.split("\\s+");
            switch (arr[0]) {
            case "l":
                sensor.set_light(arr[1]);
                break;
            case "s":
                sensor.set_speed(Integer.parseInt(arr[1]));
                break;
            case "b":
                System.out.println(sensor.get_brightness());
                break;
            case "h":
                System.out.println(sensor.get_humiture());
                break;
            case "?":
                printhelp();
                break;
            default:
                System.out.println("<Invalid command>");
                break;
            }
        }
    }
}
