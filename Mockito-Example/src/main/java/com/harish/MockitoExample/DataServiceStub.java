package com.harish.MockitoExample;

/**
 * @author htavva
 * This is Stub. We created this because the implementation is unkonwn.
 * The disadvantage is when ever new methods are added, we have to change the stubs as well.
 * Also when ever we want to test lets say this case with different set of integers like {23,56,78}
 * we have to write another stub and let that method send new data. These are the disadvantages of stubs.
 */
public class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {4,5,9};
	}

}
