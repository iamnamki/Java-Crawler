package namkiManggo;

import namkiManggo.Category.category;

public class StoreInfoDTO {
	private String img;
	private String category;
	private String name;
	private String link;
	private String addr;
	private String tel;
	private String price;
	private String openinghours;

	public StoreInfoDTO() {

	}

	public StoreInfoDTO(String img, String category, String name, String link) {
		super();
		this.img = img;
		this.category = category;
		this.name = name;
		this.link = link;
	}

	
	public StoreInfoDTO(String img, String name, String addr, String tel, String price, String openinghours) {
		super();
		this.img = img;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.price = price;
		this.openinghours = openinghours;
	}

	public StoreInfoDTO(String img, String category, String name, String addr, String tel, String price,
			String openinghours) {
		super();
		this.img = img;
		this.category = category;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.price = price;
		this.openinghours = openinghours;
	}

	public StoreInfoDTO(String img, String category, String name, String link, String addr, String tel, String price,
			String openinghours) {
		super();
		this.img = img;
		this.category = category;
		this.name = name;
		this.link = link;
		this.addr = addr;
		this.tel = tel;
		this.price = price;
		this.openinghours = openinghours;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOpeninghours() {
		return openinghours;
	}

	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "StoreInfoDTO [category=" + category + ", name=" + name + ", addr=" + addr + ", tel=" + tel + ", price="
				+ price + ", openinghours=" + openinghours + ", img=" + img + ", link=" + link + "]";
	}

}
