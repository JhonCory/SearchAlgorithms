package mars;

public class Tuple<X,Y> {
	public X _0;
	public Y _1;

	public Tuple(X x, Y y) {
		this._0 = x;
		this._1 = y;
	}

	public boolean equals(Object that) {
		try {
			Tuple tuple = (Tuple) that;
			return (tuple._0 == _0 && tuple._1 == _1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int hashCode() {
		return (100000*Integer.valueOf(_0.toString()) + Integer.valueOf(_1.toString()));
	}

	public String toString() {
		return ("("+_0.toString()+","+_1.toString()+")");
	}
}
