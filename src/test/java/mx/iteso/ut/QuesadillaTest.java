package mx.iteso.ut;

import org.junit.Before;
import org.junit.*;
import org.mockito.exceptions.verification.NeverWantedButInvoked;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;// esta vez se usa mockito por las interfaces que se tienen, no siempre es necesario su uso
//verify método de mockito
//AssertEqual(EXPECTED, ACTUAL);
//TIP usar m[etodo setqueso y settortilla 
/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest

{
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	Tortilla tortilla, tortilla1;
	Queso queso;
	Quesadilla quesadilla, quesadillad;

	@Before
	public void setUp() {
		tortilla = mock(Tortilla.class);
		tortilla1 = mock(Tortilla.class);
		queso = mock(Queso.class);

		quesadilla = new Quesadilla();
		quesadilla.setQueso(queso);
		quesadilla.setTortilla(tortilla);

		quesadillad = new Quesadilla();
		quesadillad.setQueso(queso);
		quesadillad.setTortilla1(tortilla1);
		quesadillad.setTortilla(tortilla);
	}

	@Test
	public void quesadillaPerfecta() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);
		assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
		verify(tortilla, atLeastOnce()).toast(true);
		verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaBuena() {
		when(tortilla.getToastTemperature()).thenReturn(23);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(true);
		assertEquals("Good quesadilla", quesadilla.prepareSingle());
		verify(tortilla, never()).toast(true);
		verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaTerrible() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(23);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);
		assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
		verify(queso, never()).melt(true);
		verify(tortilla, atLeastOnce()).toast(true);
	}

	@Test
	public void quesadillaSinGas() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(22);
		when(tortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(false);
		assertEquals("You ran out of gas", quesadilla.prepareSingle());
		verify(tortilla, never()).toast(true);
		verify(queso, never()).melt(true);

	}

	@Test
	public void quesadillaPerfectaD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(true);
		when(tortilla1.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);
		assertEquals("Perfect quesadilla double", quesadillad.prepareDouble());
		verify(tortilla, times(1)).toast(true);
		verify(tortilla1, times(1)).toast(true);
		verify(queso, times(1)).melt(true);
	}

	@Test
	public void quesadillaAlmostPD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(false);
		when(tortilla1.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);
		assertEquals("Almost Perfect quesadilla double", quesadillad.prepareDouble());
		try {
			verify(tortilla, never()).toast(true);
		} catch (NeverWantedButInvoked e) {

		}
		verify(tortilla1, times(1)).toast(true);
		verify(queso, times(1)).melt(true);
	}

	@Test
	public void quesadillaAlmostGD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(false);
		when(tortilla1.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);
		assertEquals("Almost Good quesadilla double", quesadillad.prepareDouble());
		try {
			verify(tortilla, never()).toast(true);
		} catch (NeverWantedButInvoked e) {

		}
		verify(tortilla1, times(1)).toast(true);
		try {
			verify(queso, never()).melt(true);
		} catch (NeverWantedButInvoked e) {

		}
	}

	@Test
	public void quesadillaBuenaD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(false);
		when(tortilla1.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(true);
		assertEquals("Good quesadilla double", quesadillad.prepareDouble());
		try {
			verify(tortilla, never()).toast(true);
			verify(tortilla1, never()).toast(true);
		} catch (NeverWantedButInvoked e) {
		}
		verify(queso, times(1)).melt(true);
	}

	@Test
	public void quesadillaTerribleD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(true);
		when(tortilla1.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);
		assertEquals("Terrible quesadilla double", quesadillad.prepareDouble());
		verify(tortilla, times(1)).toast(true);
		verify(tortilla1, times(1)).toast(true);
		try {
			verify(queso, never()).melt(true);
		} catch (NeverWantedButInvoked e) {
		}
	}

	@Test
	public void quesadillasinGasD() {
		when(tortilla.getToastTemperature()).thenReturn(20);
		when(tortilla.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla1.getToastTemperature()).thenReturn(20);
		when(tortilla1.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(queso.getMeltingTemperature()).thenReturn(20);
		when(queso.getCurrentTemperature()).thenReturn(2, 6, 10, 14, 18, 22);
		when(tortilla.isToasted()).thenReturn(false);
		when(tortilla1.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(false);
		assertEquals("You ran out of gas double", quesadillad.prepareDouble());
		try {
			verify(tortilla, never()).toast(true);
			verify(tortilla1, never()).toast(true);
			verify(queso, never()).melt(true);
		} catch (NeverWantedButInvoked e) {
		}
	}

}
