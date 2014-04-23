package phoenix.interfaceSample;

public interface Relatable {
	// this (object calling isLargerThan)
	// and other must be instances of
	// the same class returns 1, 0, -1
	// if this is greater // than, equal
	// to, or less than other
	/**
	 * 比较形状大小的接口方法
	 * 
	 * @param other
	 * @return
	 */
	public int isLargerThan(Relatable other);
}
