package 제1장_도형_면적의_합을_구하기;

import java.util.Scanner;

abstract class Shape {
	
	protected double x;
	protected double y;
	
	protected Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public abstract void draw();
	public abstract double getArea();
}

class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println
			("Rectangle: " + x + ", " + y + ", " + width + ", " + height);
		
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
}
class Circle extends Shape {
	private double radius;
	public static final double PI = 3.14;
	
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("Circle: " + x + ", " + y + ", " + radius);
	}
	
	@Override
	public double getArea() {
		return radius * radius * PI;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noShape = scan.nextInt();
		Shape[] shapes = new Shape[noShape];
		for (int i = 0; i < noShape; i++) {
			String s = scan.next();
			if (s.equals("Rectangle")) {
				double x, y, width, height;
				x = scan.nextDouble();
				y = scan.nextDouble();
				width = scan.nextDouble();
				height = scan.nextDouble();
				shapes[i] = new Rectangle(x, y, width, height);
			} else if (s.equals("Circle")) {
				double x, y, radius;
				x = scan.nextDouble();
				y = scan.nextDouble();
				radius = scan.nextDouble();
				shapes[i] = new Circle(x, y, radius);
			}
		}
		// 면적 계산
		double sumArea = 0;
		for (Shape shape : shapes) {
			sumArea += shape.getArea();
		}
		System.out.printf("%.2f", sumArea);			
	}
}