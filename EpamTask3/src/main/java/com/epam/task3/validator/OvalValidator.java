package com.epam.task3.validator;

import com.epam.task3.entity.SemiAxis;

public class OvalValidator {

	public static boolean semiAxisesFormOval(SemiAxis semiAxis, SemiAxis semiAxis2) {
		if (semiAxis == null || semiAxis2 == null) {
			return false;
		}
		if (semiAxis.getA().equals(semiAxis2.getA()) || semiAxis.getA().equals(semiAxis2.getB())
				|| semiAxis.getB().equals(semiAxis2.getA()) || semiAxis.getB().equals(semiAxis2.getB())) {
			if (semiAxis.getLength() > 0 && semiAxis2.getLength() > 0) {
				return true;
			}
		}
		return false;
	}
}
