/**
 * Week 7 · S7 assignment · Problem 4 The Traffic Light
 *
 * Color changes only through next(): RED -> GREEN -> YELLOW -> RED.
 * id is final. There is no setter.
 */
public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getColor());
        System.out.println(light.next());
        System.out.println(light.next());
        System.out.println(light.next());
        if (!light.getColor().equals("RED") || !light.getId().equals("TL-9")) {
            throw new AssertionError("Cycle failed");
        }
        System.out.println("Sample checks passed.");
    }
}
