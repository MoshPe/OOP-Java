package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
	private List<Instrument> instruments = new ArrayList<>();

	public void add(Instrument i) throws MusicShopException {
			instruments.add(i);
	}

	public Instrument get(int serial) throws MusicShopException {
		if (serial < 0)
			throw new MusicShopException("Wrong serial number");
		for (Instrument instrument : instruments) {
			if (instrument.getSerial() == serial)
				return instrument;
		}
		return null;
	}

	public List<Integer> allSerials() {
		List<Integer> serials = new ArrayList<>();
		for (Instrument instrument : instruments)
			serials.add(instrument.getSerial());
		return serials;
	}

	public List<Integer> guitarsOfType(Type t) {
		List<Integer> serials = new ArrayList<>();
		Guitar temp;
		for (Instrument instrument : instruments) {
			if (instrument instanceof Guitar) {
				temp = (Guitar) instrument;
				if (temp.getType().equals(t))
					serials.add(instrument.getSerial());
			}
		}
		return serials;
	}

	public void sell(int serial) throws MusicShopException {
		if (serial < 0)
			throw new MusicShopException("Wrong serial number");
		for (int i = 0; i < instruments.size(); i++) {
			if (instruments.get(i).getSerial() == serial) {
				if (instruments.get(i) instanceof Guitar && countGuitars() == 1)
						throw new MusicShopException("There is only one guitar in the shop");
				instruments.remove(i);
				return;
			}
		}
		throw new MusicShopException("There is no such instrument");
	}
	
	public int sellAll(int[] serials) {
		int unsellableInstrumentsCount = 0;
		for (int i : serials) {
			try {
				sell(i);
			}catch(MusicShopException e) {
				unsellableInstrumentsCount++;
			}
		}
		return unsellableInstrumentsCount;
	}

	private int countGuitars() {
		int guitarCounter = 0;
		for (Instrument instrument : instruments)
			if (instrument instanceof Guitar)
				guitarCounter++;
		return guitarCounter;
	}
	
//	public static void main(String[] args) throws MusicShopException {
//		Shop s = new Shop();
//		s.add(new Guitar("Gibson", 1000, Type.ACOUSTIC));
//		s.add(new Piano("Yamaha", 5000, 6));
//		s.add(new Piano("Yamaha", 10000, 7));
//		s.add(new Guitar("Fender", 4000, Type.ELECTRIC));
//
//		System.out.println(s.allSerials());
//		System.out.println(s.sellAll(new int[] {1, 3, 5, 0}));
//		System.out.println(s.allSerials());
//
//	}
}