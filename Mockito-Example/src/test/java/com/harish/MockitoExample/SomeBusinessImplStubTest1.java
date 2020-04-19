package com.harish.MockitoExample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SomeBusinessImplStubTest1 {

	@Test
	public void findGreatestNum() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
		assertEquals(9,businessImpl.findGreatestNum());
	}

}
