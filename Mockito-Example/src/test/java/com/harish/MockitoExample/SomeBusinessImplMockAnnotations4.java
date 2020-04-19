package com.harish.MockitoExample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

// This annotation must be there to use @Mock, @InjectMocks annotations.
// This MockitoJUnitRunner class looks at those annotations and initialize 
// mocks and injects before starting test cases.
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockAnnotations4 {

	@Mock
	List listMock;

	@Test
	public void test1() {

		when(listMock.size()).thenReturn(10).thenReturn(20);

		assertEquals(10, listMock.size()); //It returns 10 first time
		assertEquals(20, listMock.size()); // Then returns 20
		assertEquals(20, listMock.size()); // Then return last returned thing in the subsequent calls.
	}

	@Test
	public void test2() {

		// For specific parameter.
		when(listMock.get(0)).thenReturn("Some String");

		assertEquals("Some String", listMock.get(0));
		// Parameterized method will return null if something other than specified in mock is sent
		// as parameter.
		assertEquals(null, listMock.get(3));

	}

	@Test
	public void test3() {

		// For generic parameter.
		// Note: If we have 2 parameters and we are sending 1 generic parameter, then
		// other parameter must be generic.
		when(listMock.get(Mockito.anyInt())).thenReturn("Some String");

		assertEquals("Some String", listMock.get(1));
		assertEquals("Some String", listMock.get(3));
		assertEquals("Some String", listMock.get(100));
	}

}
