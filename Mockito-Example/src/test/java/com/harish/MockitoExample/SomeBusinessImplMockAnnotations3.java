package com.harish.MockitoExample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// This annotation must be there to use @Mock, @InjectMocks annotations.
// This MockitoJUnitRunner class looks at those annotations and initialize 
// mocks and injects before starting test cases.
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockAnnotations3 {

	@Mock
	DataService dataMock; // Creates mock

	@InjectMocks
	SomeBusinessImpl businessImpl; // Inject mock into class

	@Test
	public void findGreatestNum() {

		//DataService dataMock = mock(DataService.class);

		when(dataMock.retrieveAllData()).thenReturn(new int[] {5,7,9});

		//SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataMock);

		assertEquals(9,businessImpl.findGreatestNum());
	}

	@Test
	public void findGreatestNum_2() {
		when(dataMock.retrieveAllData()).thenReturn(new int[] {5,7});
		assertEquals(7,businessImpl.findGreatestNum());
	}

}
