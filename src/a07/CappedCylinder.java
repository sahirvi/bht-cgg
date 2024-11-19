package a07;

import cgtools.*;

public class CappedCylinder extends Group implements Shape {


    public CappedCylinder(Point center, double height, double radius,  Material material) {
        super(
                new Plane(center, Vector.direction(0, 1, 0), radius, material), // Boden
                new Plane(Vector.add(center, Vector.direction(0, height, 0)), Vector.direction(0, 1, 0),radius, material), // Deckel
                new Cylinder(center, height, radius, material) // Mantelfläche
                );
    }
}