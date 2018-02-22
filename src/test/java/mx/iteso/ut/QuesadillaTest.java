package mx.iteso.ut;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class QuesadillaTest {
	Quesadilla quesadilla;
	Queso mockedQueso;
	Tortilla mockedTortilla, mockedTortilla2;

	@Before
	public void setUp() {
		quesadilla = new Quesadilla();
		mockedTortilla = mock(Tortilla.class);
		mockedTortilla2 = mock(Tortilla.class);
		mockedQueso = mock(Queso.class);
		quesadilla.setQueso(mockedQueso);
		quesadilla.setTortilla(mockedTortilla);
		quesadilla.setTortilla2(mockedTortilla2);
	}

	@Test
	public void quesadillaPerfecta() {
		when(mockedTortilla.getToastTemperature()).thenReturn(20);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);

		when(mockedQueso.isMelted()).thenReturn(true);
		when(mockedTortilla.isToasted()).thenReturn(true);

		Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());

		verify(mockedTortilla, atLeastOnce()).toast(true);
		verify(mockedQueso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaBuena() {
		when(mockedTortilla.getToastTemperature()).thenReturn(24);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);

		when(mockedQueso.isMelted()).thenReturn(true);
		when(mockedTortilla.isToasted()).thenReturn(false);

		Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());
		
		verify(mockedTortilla, never()).toast(true);
		verify(mockedQueso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaTerrible() {
		when(mockedTortilla.getToastTemperature()).thenReturn(20);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(mockedQueso.getMeltingTemperature()).thenReturn(25);
		when(mockedQueso.getCurrentTemperature()).thenReturn(7, 10, 13, 16, 19, 22);

		when(mockedQueso.isMelted()).thenReturn(false);
		when(mockedTortilla.isToasted()).thenReturn(true);

		Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
		
		verify(mockedTortilla, atLeastOnce()).toast(true);
		verify(mockedQueso, never()).melt(true);
	}

	@Test
	public void noHayGas() {
		when(mockedTortilla.getToastTemperature()).thenReturn(20);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(21);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(21);

		when(mockedQueso.isMelted()).thenReturn(false);
		when(mockedTortilla.isToasted()).thenReturn(false);

		Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());
		
		verify(mockedTortilla, never()).toast(true);
		verify(mockedQueso, never()).melt(true);
	}

	@Test
	public void quesadillaExcelente() {
		when(mockedTortilla.getToastTemperature()).thenReturn(20);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
		when(mockedTortilla2.getToastTemperature()).thenReturn(20);
		when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);

		when(mockedQueso.isMelted()).thenReturn(true);
		when(mockedTortilla.isToasted()).thenReturn(true);
		when(mockedTortilla2.isToasted()).thenReturn(true);

		Assert.assertEquals("Excellent quesadilla", quesadilla.prepareDouble());

		verify(mockedTortilla, atLeastOnce()).toast(true);
		verify(mockedTortilla2, atLeastOnce()).toast(true);
		verify(mockedQueso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaFavorable() {
		when(mockedTortilla.getToastTemperature()).thenReturn(24);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
		when(mockedTortilla2.getToastTemperature()).thenReturn(20);
		when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);

		when(mockedQueso.isMelted()).thenReturn(true);
		when(mockedTortilla.isToasted()).thenReturn(false);
		when(mockedTortilla2.isToasted()).thenReturn(true);

		Assert.assertEquals("Favorable quesadilla", quesadilla.prepareDouble());

		verify(mockedTortilla, never()).toast(true);
		verify(mockedTortilla2, atLeastOnce()).toast(true);
		verify(mockedQueso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaPobre() {
        when(mockedTortilla.getToastTemperature()).thenReturn(22);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedTortilla2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedQueso.getMeltingTemperature()).thenReturn(23);
        when(mockedQueso.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);

        when(mockedQueso.isMelted()).thenReturn(false);
		when(mockedTortilla.isToasted()).thenReturn(false);
		when(mockedTortilla2.isToasted()).thenReturn(true);

		Assert.assertEquals("Poor quesadilla", quesadilla.prepareDouble());

		verify(mockedTortilla, never()).toast(true);
		verify(mockedTortilla2, atLeastOnce()).toast(true);
		verify(mockedQueso, never()).melt(true);
	}

	@Test
	public void quesadillaNice() {
        when(mockedTortilla.getToastTemperature()).thenReturn(22);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedTortilla2.getToastTemperature()).thenReturn(22);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedQueso.getMeltingTemperature()).thenReturn(19);
        when(mockedQueso.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);

		when(mockedQueso.isMelted()).thenReturn(true);
		when(mockedTortilla.isToasted()).thenReturn(false);
		when(mockedTortilla2.isToasted()).thenReturn(false);

		Assert.assertEquals("Nice quesadilla", quesadilla.prepareDouble());

		verify(mockedTortilla, never()).toast(true);
		verify(mockedTortilla2, never()).toast(true);
		verify(mockedQueso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaMala() {
        when(mockedTortilla.getToastTemperature()).thenReturn(20);
        when(mockedTortilla.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedTortilla2.getToastTemperature()).thenReturn(20);
        when(mockedTortilla2.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);
        when(mockedQueso.getMeltingTemperature()).thenReturn(25);
        when(mockedQueso.getCurrentTemperature()).thenReturn(6,10,14,18,19,21);

		when(mockedQueso.isMelted()).thenReturn(false);
		when(mockedTortilla.isToasted()).thenReturn(true);
		when(mockedTortilla2.isToasted()).thenReturn(true);

		Assert.assertEquals("Bad quesadilla", quesadilla.prepareDouble());

		verify(mockedTortilla, atLeastOnce()).toast(true);
		verify(mockedTortilla2, atLeastOnce()).toast(true);
		verify(mockedQueso, never()).melt(true);
	}

	@Test
	public void clasesDeCocina() {
		when(mockedTortilla.getToastTemperature()).thenReturn(20);
		when(mockedTortilla.getCurrentTemperature()).thenReturn(21);
		when(mockedTortilla2.getToastTemperature()).thenReturn(20);
		when(mockedTortilla2.getCurrentTemperature()).thenReturn(21);
		when(mockedQueso.getMeltingTemperature()).thenReturn(20);
		when(mockedQueso.getCurrentTemperature()).thenReturn(21);

		when(mockedQueso.isMelted()).thenReturn(false);
		when(mockedTortilla.isToasted()).thenReturn(false);
		when(mockedTortilla2.isToasted()).thenReturn(false);

		Assert.assertEquals("Sign up for cooking classes", quesadilla.prepareDouble());

		verify(mockedTortilla, never()).toast(true);
		verify(mockedTortilla2, never()).toast(true);
		verify(mockedQueso, never()).melt(true);
	}
}