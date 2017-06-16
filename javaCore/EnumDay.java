package javaCore;

public enum EnumDay {
	SUNDAY(1234), MONDAY(2345), TUESDAY(3456), WEDNESDAY(4567), THRUSDAY(5678), FRIDAY(6789), SATURDAY(7890) {
		public String toString() {
			return super.toString();
		}
	};

	private int value;

	private EnumDay(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
