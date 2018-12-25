
import java.util.Comparator;

public class EntryComparatorByNumber implements Comparator<PhoneEntry> {

	@Override
	public int compare(PhoneEntry t, PhoneEntry t1) {
		return t.getNumber() - t1.getNumber();
	}

}
