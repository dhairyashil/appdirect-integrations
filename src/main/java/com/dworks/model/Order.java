package com.dworks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dworks.dto.model.ItemDTO;
import com.dworks.dto.model.OrderDTO;

@Entity
@Table(name="consumer_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String editionCode;
	private String addonOfferingCode;
	private String pricingDuration;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Item> items;

	public Order() {	}

	public Order(OrderDTO orderDTO) {
		this.editionCode = orderDTO.getEditionCode();
		this.addonOfferingCode = orderDTO.getAddonOfferingCode();
		this.pricingDuration = orderDTO.getPricingDuration();

		List<Item> items = new ArrayList<>();
		for (ItemDTO dto : orderDTO.getItems()) {
			Item item = new Item(dto);
			item.setOrder(this);
			items.add(item);
		}

		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEditionCode() {
		return editionCode;
	}

	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}

	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}

	public String getPricingDuration() {
		return pricingDuration;
	}

	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
