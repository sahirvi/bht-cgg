package a07;

import java.util.ArrayList;

public class Group implements Shape {

    protected ArrayList<Shape> shapes;


    public Group(){
        shapes = new ArrayList<Shape>();
    }

    public Group(Shape... shapes) {
        this();
        for (Shape s : shapes){
            addShape(s);
        }
    }

    public void addShape(Shape s){
        shapes.add(s);
    }

    public Hit intersect(Ray ray) {
        Hit closest = null;
        for (Shape shape : shapes) {
            Hit hit = shape.intersect(ray);
            if (closest == null || hit != null && hit.t < closest.t) {
                closest = hit;
            }
        }
        return closest;
    }



}