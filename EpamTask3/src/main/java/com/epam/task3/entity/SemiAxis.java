package com.epam.task3.entity;

public class SemiAxis {
	private Point2D a;
	private Point2D b;

	public SemiAxis(Point2D a, Point2D b) {
		this.a = a;
		this.b = b;
	}
		public Point2D getA() {
		return a;
	}
	public void setA(Point2D a) {
		this.a = a;
	}
	public Point2D getB() {
		return b;
	}
	public void setB(Point2D b) {
		this.b = b;
	}
	public double getLength() {
		double xSquaredDifference = Math.pow(b.getX() - a.getX(), 2);
		double ySquaredDifference = Math.pow(b.getY() - a.getY(), 2);
		return Math.sqrt(xSquaredDifference + ySquaredDifference);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SemiAxis other = (SemiAxis) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SemiAxis [a=");
		builder.append(a);
		builder.append(", b=");
		builder.append(b);
		builder.append(", length=");
		builder.append(getLength());
		builder.append("]");
		return builder.toString();
	}
}