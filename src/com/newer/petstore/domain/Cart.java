package com.newer.petstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * 购物车
 * 
 * @author wtao
 *
 */
public class Cart {

	// 关系型数据库的主键
	private int id;
	
	private BigDecimal total;

	// 用户账号
	private Account account;

	// 商品、数量
	private HashMap<Product, Integer> map = new HashMap<>();

	public Cart() {
	}

	/**
	 * 购物车总金额
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		Set<Product> keys =  map.keySet();
		for (Product p : keys) {
			int n = map.get(p);
			total = total.add(
					p.getPrice().multiply(BigDecimal.valueOf(n)));
		}
		return total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public HashMap<Product, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Product, Integer> map) {
		this.map = map;
	}

}
