package entity;

public class Pet {
	
	private int PId;
	private String PName;
	private int PCat;
	private int Pprice;
	public Pet(int pId, String pName, int pCat, int pprice) {
		PId = pId;
		PName = pName;
		PCat = pCat;
		Pprice = pprice;
	}
	public Pet() {
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPCat() {
		return PCat;
	}
	public void setPCat(int pCat) {
		PCat = pCat;
	}
	public int getPprice() {
		return Pprice;
	}
	public void setPprice(int pprice) {
		Pprice = pprice;
	}
	@Override
	public String toString() {
		return "Pet [PId=" + PId + ", PName=" + PName + ", PCat=" + PCat + ", Pprice=" + Pprice + "]";
	}
	
	
	

}
