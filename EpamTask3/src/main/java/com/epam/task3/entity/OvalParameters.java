package com.epam.task3.entity;

public class OvalParameters {
	private double perimeter;
    private double square;

    public OvalParameters(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getSquare() {
        return square;
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    public void setSquare(double square) {
        this.square = square;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(perimeter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(square);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		OvalParameters other = (OvalParameters) obj;
		if (Double.doubleToLongBits(perimeter) != Double.doubleToLongBits(other.perimeter))
			return false;
		if (Double.doubleToLongBits(square) != Double.doubleToLongBits(other.square))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OvalRecorder [perimeter=");
		builder.append(perimeter);
		builder.append(", square=");
		builder.append(square);
		builder.append("]");
		return builder.toString();
	}
}