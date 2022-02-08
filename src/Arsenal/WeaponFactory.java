package Arsenal;

public class WeaponFactory extends ItemFactory {

	@Override
	protected void printLog(int type) {
		// TODO Auto-generated method stub
		System.out.print("log> »ý¼º : ");
	}

	@Override
	protected Item createItem(int type) {
		// TODO Auto-generated method stub
		Item item = null;
		switch(type) {
		case 0:
			item = new Sword();
			break;
		case 1:
			item = new Staff();
			break;
		case 2:
			item = new Hammer();
			break;
		}
		return item;
	}
}
