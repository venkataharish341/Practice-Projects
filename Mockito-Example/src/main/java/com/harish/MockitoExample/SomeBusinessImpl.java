package com.harish.MockitoExample;


public class SomeBusinessImpl {

	DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public int findGreatestNum() {

		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;

		for(int i: data) {
			if(i > greatest) {
				greatest = i;
			}
		}
		return greatest;
	}
	
}
