package com.unionpay.shadower.example.dubbo.service;

import com.unionpay.shadower.example.api.AddressService;

public class AddressServiceImpl implements AddressService{

	@Override
	public String getAddress(int id) {
		return "address-"+id;
	}

}
