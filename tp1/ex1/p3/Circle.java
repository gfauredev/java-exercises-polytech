package tp1.ex1.p3;

import lombok.Getter;

@Getter
public class Circle {
    float x;
    float y;
    float rad;
    // diameter: pas pertinent, calculable
    // perimeter: pas pertinent, calculable
    // surface: pas pertinent, calculable

    Circle(float x, float y, float rad) {
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    float getDiameter() {
        return rad * 2;
    }

    float getPerimeter() {
        return (float) (Math.PI * getDiameter());
    }

    float getSurface() {
        return (float) (Math.PI * Math.pow(rad, 2));
    }

    public String toString() {
        return "Cercle (" + x + ", " + y + ") r=" + rad + ", perim=" +
                getPerimeter() + ", surf=" + getSurface();
    }

    public void printMe() {
        System.out.println(this);
    }

    static void main() {
        var c = new Circle(34, 12.3F, 18);
        c.printMe();
    }
}
