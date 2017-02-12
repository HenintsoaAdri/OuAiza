package model;

public class Region {
	int id;
	String region;
	String imageRegion;

	public Region() {}

	public Region(int id, String region) {
		super();
		this.setId(id);
		this.setRegion(region);
	}
	
	public Region(int id, String region, String imageRegion) {
		super();
		this.setId(id);
		this.setRegion(region);
		this.setImageRegion(imageRegion);
	}
	
	public Region(String region, String imageRegion) {
		super();
		this.setRegion(region);
		this.setImageRegion(imageRegion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getImageRegion() {
		return imageRegion;
	}

	public void setImageRegion(String imageRegion) {
		this.imageRegion = imageRegion;
	}
}
