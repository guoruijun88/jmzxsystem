package com.jm.vo;

public class PriceVo {

	//车辆售价
	private Integer startPrice;
	private Integer endPrice;
	//车辆日租价格
	private Integer rentStartPrice;
	private Integer rentEndPrice;
	//车辆保证�?
	private Integer depositStartPrice;
	private Integer depositEndPrice;
	public Integer getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}
	public Integer getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
	}
	public Integer getRentStartPrice() {
		return rentStartPrice;
	}
	public void setRentStartPrice(Integer rentStartPrice) {
		this.rentStartPrice = rentStartPrice;
	}
	public Integer getRentEndPrice() {
		return rentEndPrice;
	}
	public void setRentEndPrice(Integer rentEndPrice) {
		this.rentEndPrice = rentEndPrice;
	}
	public Integer getDepositStartPrice() {
		return depositStartPrice;
	}
	public void setDepositStartPrice(Integer depositStartPrice) {
		this.depositStartPrice = depositStartPrice;
	}
	public Integer getDepositEndPrice() {
		return depositEndPrice;
	}
	public void setDepositEndPrice(Integer depositEndPrice) {
		this.depositEndPrice = depositEndPrice;
	}
	
	
}
