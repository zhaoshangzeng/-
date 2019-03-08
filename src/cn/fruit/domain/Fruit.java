package cn.fruit.domain;

import java.io.Serializable;

/**
 * ˮ��������Ϣ��
 * @author zzshang
 *
 */
public class Fruit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;	//��ʶ
	private String name;	//����
	private String description;		//����
	private int day;	//�ϼ�����
	private double delprice;	//Ҫɾ���ļ۸�
	private double price;	//��ʽ�۸�
	private double discount; //�ۿ���
	private String unit; //���㵥λ
	private String tip;	//��Ч��ʾ����������棩
	private String pictureUrla;	//ͼƬ��ַǰ�벿��(�̶�)
	private String pictureUrlb; //ͼƬ��ַ��벿��(��ͼƬ����)
	private String pictureUrl; //ͼƬ��ַ
	private int amount; //��������
	private double totalPrice; //�۸�x����
	
	{
		pictureUrla = "${pageContext.request.contextPath }/img/";
		amount = 1;
	}
	public Fruit(String id, String name, String description, int day, double delprice,
					String unit, String tip, String pictureUrlb) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.day = day;
		this.delprice = delprice;
		this.unit = unit;
		this.tip = tip;
		this.pictureUrlb = pictureUrlb;
		jsdiscount();
		jsprice();
		jssumprice();
		hbUrl();
	}
	public Fruit() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public double getDelprice() {
		return delprice;
	}
	public void setDelprice(double delprice) {
		this.delprice = delprice;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getPictureUrla() {
		return pictureUrla;
	}
	public void setPictureUrla(String pictureUrla) {
		this.pictureUrla = pictureUrla;
	}
	public String getPictureUrlb() {
		return pictureUrlb;
	}
	public void setPictureUrlb(String pictureUrlb) {
		this.pictureUrlb = pictureUrlb;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//�����ϼ��������ۿ�
	private void jsdiscount(){
		int day = this.day;
		switch(day){
			case 1:
				discount = 9.5;
				break;
			case 2:
				discount = 9;
				break;
			case 3:
				discount = 8.5;
		}
	}
	//�����ۿۺ�۸�
	public void jsprice(){
		price = delprice * discount * 0.1;
		price = (double) Math.round(price * 100) / 100;	//ֻȡ����λ 
	}
	//���㹺��������۸�
	public void jssumprice(){
		totalPrice = price * amount;
		totalPrice = (double) Math.round(totalPrice * 100) / 100;
	}
	//�ϲ���ַ
	private void hbUrl(){
		this.pictureUrl = this.pictureUrla + this.pictureUrlb;
	}
	
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", description="
				+ description + ", day=" + day + ", delprice=" + delprice
				+ ", price=" + price + ", discount=" + discount + ", unit="
				+ unit + ", tip=" + tip + ", pictureUrla=" + pictureUrla
				+ ", pictureUrlb=" + pictureUrlb + ", pictureUrl=" + pictureUrl
				+ ", amount=" + amount + ", totalPrice=" + totalPrice + "]";
	}
	
}
