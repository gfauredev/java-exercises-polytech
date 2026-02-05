package tp1.ex1.p3;

import lombok.Getter;

@Getter
public class Rectangle {
    private float x;
    private float y;
    private float w;
    private float h;

    Rectangle(float x, float y, float w, float h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    float getPerimeter() {
        return (float) (w * 2 + h * 2);
    }

    float getSurface() {
        return (float) (w * h);
    }

    public String toString() {
        return this.getClass().getSimpleName() + " (" + x + ", " + y +
                ") perim=" + getPerimeter() + ", surf=" + getSurface();
    }

    public void printMe() {
        System.out.println(this);
    }

    static void main() {
        var r = new Rectangle(34, 12.3F, 18, 18);
        r.printMe();
    }
}
