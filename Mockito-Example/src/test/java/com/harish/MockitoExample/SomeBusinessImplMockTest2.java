package com.harish.MockitoExample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessImplMockTest2 {

	@Test
	public void findGreatestNum() {

		DataService dataMock = mock(DataService.class);
		//dataMock.retrieveAllData() => return new int[] {5,7,9}

		when(dataMock.retrieveAllData()).thenReturn(new int[] {5,7,9});

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataMock);
		assertEquals(9,businessImpl.findGreatestNum());
	}

	@Test
	public void findGreatestNum_2() {

		DataService dataMock = mock(DataService.class);

		when(dataMock.retrieveAllData()).thenReturn(new int[] {5,7});

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataMock);
		assertEquals(7,businessImpl.findGreatestNum());
	}

}
