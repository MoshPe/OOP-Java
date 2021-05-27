package shop;

import java.util.ArrayList;
import java.util.List;

//this class represent shop with instruments

public class Shop {
	private List<Instrument> instruments = new ArrayList<>();

	public void add(Instrument i) throws MusicShopException {
		if(i==null) throw new MusicShopException("Null instrument");
		instruments.add(i);
	}
	
	//return the instrument with the same serial as the given integer  
	public Instrument get(int serial) throws MusicShopException {
		if (serial < 0)
			throw new MusicShopException("Wrong serial number");
		for (Instrument instrument : instruments) {
			if (instrument.getSerial() == serial)
				return instrument;
		}
		return null;
	}
	//return list with all the instruments serial in the shop
	public List<Integer> allSerials() {
		List<Integer> serials = new ArrayList<>();
		for (Instrument instrument : instruments)
			serials.add(instrument.getSerial());
		return serials;
	}

	// return list with the guitars in store that are 't' type 
	public List<Integer> guitarsOfType(Type t) {
		List<Integer> serials = new ArrayList<>();
		Guitar temp;
		for (Instrument instrument : instruments) {
			if (instrument instanceof Guitar) {
				temp = (Guitar) instrument;
				if (temp.getType().equals(t))	//if the guitar is the same type as the given type - add to list
					serials.add(instrument.getSerial());
			}
		}
		return serials;
	}
	
	//try to sell the instrument with the given serial
	public void sell(int serial) throws MusicShopException {
		if (serial < 0)
			throw new MusicShopException("Wrong serial number");
		for (int i = 0; i < instruments.size(); i++) {
			if (instruments.get(i).getSerial() == serial) {	//found it!
				if (instruments.get(i) instanceof Guitar && countGuitars() == 1)	//if the instrument is the last guitar in the store
					throw new MusicShopException("There is only one guitar in the shop");	//can't sell it
				instruments.remove(i);	//else, remove from store
				return;
			}
		}
		throw new MusicShopException("There is no such instrument");	//didn't found it
	}
	
	//try to sell all the items from the store, return the count of unsellable instruments
	public int sellAll(int[] serials) {
		int unsellableInstrumentsCount = 0;
		for (int i : serials) {
			try {
				sell(i);
			} catch (MusicShopException e) {	// if we can't sell, we catch the exception and increase the counter
				unsellableInstrumentsCount++;
			}
		}
		return unsellableInstrumentsCount;
	}
	
	// helper method to count how many guitar are in the store
	private int countGuitars() {
		int guitarCounter = 0;
		for (Instrument instrument : instruments)
			if (instrument instanceof Guitar)
				guitarCounter++;
		return guitarCounter;
	}

}