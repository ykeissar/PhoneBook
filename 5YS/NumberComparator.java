import java.util.Comparator;

//This comparator is used for demonstrations in Test classes.
public class NumberComparator implements Comparator<Integer> {

	public NumberComparator() {
		super();
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return Integer.compare(o1, o2);
	}
}
