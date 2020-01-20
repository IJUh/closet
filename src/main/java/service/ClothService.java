package service;

import model.Cloth;

public interface ClothService {
	
	public void setClothMapper(Cloth cloth);
	public Cloth getCloth();
	public int registerCloth(Cloth clothModel);

}
