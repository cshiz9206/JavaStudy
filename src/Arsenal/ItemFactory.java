package Arsenal;

public abstract class ItemFactory {
	protected abstract void printLog(int type);
	protected abstract Item createItem(int type);
	
	public Item newInstance(int type) {
		Item item;
		printLog(type);
		item = createItem(type);
		return item;
	}
}
