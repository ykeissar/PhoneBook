
import java.util.Comparator;

public class EntryComparatorByName implements Comparator<PhoneEntry> {

	@Override
	public int compare(PhoneEntry t, PhoneEntry t1) {
		// Applying "toLowerCase" to compare chars by their overall
		// values ('a' vs. 'B')
		String me = t.getName().toLowerCase();
		String other = t1.getName().toLowerCase();
		return me.compareTo(other);
	}

}
