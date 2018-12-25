
public class Phonebook {

	private BinarySearchTree<PhoneEntry> namesTree;
	private BinarySearchTree<PhoneEntry> numbersTree;

	public Phonebook() {
		namesTree = new BinarySearchTree<>(new EntryComparatorByName());
		numbersTree = new BinarySearchTree<>(new EntryComparatorByNumber());
	}

	public PhoneEntry lookUp(String name) {
		// create an Entry with the given name and a "dummy" number (1)
		// This "dummy" number will be ignored when executing getData
		PhoneEntry lookFor = new PhoneEntry(name, 1);
		return namesTree.findData(lookFor);
	}

	public PhoneEntry lookUp(int number) {
		// create an Entry with a "dummy" name and the given number
		// This "dummy" name will be ignored when executing getData
		PhoneEntry lookFor = new PhoneEntry("dummy", number);
		return numbersTree.findData(lookFor);
	}

	public void balance() {
		namesTree = new BinarySearchTree<>(namesTree);
		numbersTree = new BinarySearchTree<>(numbersTree);
	}

	public Object exportNames() {
		return this.namesTree;
	}

	public Object exportNumbers() {
		return this.numbersTree;
	}

	// END OF Given code -----------------------------------
	public boolean add(PhoneEntry newEntry) {
		if (newEntry == null)
			return false;
		if (!numbersTree.contains(newEntry) && !namesTree.contains(newEntry)) {
			numbersTree.insert(newEntry);
			namesTree.insert(newEntry);
			return true;
		}
		return false;
	}

	public boolean delete(String name) {
		PhoneEntry foundData = lookUp(name);
		if (foundData != null) {
			namesTree.remove(foundData);
			numbersTree.remove(foundData);
			return true;
		}
		return false;
	}

	public boolean delete(int number) {
		PhoneEntry foundData = lookUp(number);
		if (foundData != null) {
			numbersTree.remove(foundData);
			namesTree.remove(foundData);
			return true;
		}
		return false;
	}

}
