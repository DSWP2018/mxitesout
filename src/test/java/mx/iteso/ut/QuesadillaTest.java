package mx.iteso.ut;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Unit test for simple Quesadilla.
 */
public class QuesadillaTest {

	Tortilla tortilla,secondTortilla;
	Queso queso;
	Quesadilla quesadilla = new Quesadilla();

	@Before
	public void setUp() {
		tortilla = mock(Tortilla.class);
	    queso = mock(Queso.class);
		quesadilla.setQueso(queso);
		quesadilla.setTortilla(tortilla);
		secondTortilla = mock(Tortilla.class);
		quesadilla.setSecondTortilla(secondTortilla);
	}

	@Test
	public void quesadillaPerfecta() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Perfect quesadilla", quesadilla.prepareSingle());
		verify(tortilla, atLeastOnce()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaBuena() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Good quesadilla", quesadilla.prepareSingle());
		verify(tortilla, never()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void quesadillaTerrible() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17);

		when(tortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("Terrible quesadilla", quesadilla.prepareSingle());
		verify(tortilla,atLeastOnce()).toast(true);
        verify(queso, never()).melt(true);
	}

	@Test
	public void noHayGas() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(24);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(24);

		when(tortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("You ran out of gas", quesadilla.prepareSingle());
		verify(tortilla, never()).toast(true);
        verify(queso, never()).melt(true);
	}

	@Test
	public void perfectQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(true);
		when(secondTortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Perfect quesadilla", quesadilla.prepareDouble());
		verify(tortilla, atLeastOnce()).toast(true);
		verify(secondTortilla, atLeastOnce()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void goodQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(24);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(true);
		when(secondTortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Good quesadilla", quesadilla.prepareDouble());
		verify(tortilla, atLeastOnce()).toast(true);
		verify(secondTortilla, never()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void notBadQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(24);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,24);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(false);
		when(secondTortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Not bad quesadilla", quesadilla.prepareDouble());
		verify(tortilla, never()).toast(true);
		verify(secondTortilla, atLeastOnce()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void averageQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(24);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(24);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17,21);

		when(tortilla.isToasted()).thenReturn(false);
		when(secondTortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(true);

		Assert.assertEquals("Average quesadilla", quesadilla.prepareDouble());
		verify(tortilla, never()).toast(true);
		verify(secondTortilla, never()).toast(true);
        verify(queso, atLeastOnce()).melt(true);
	}

	@Test
	public void badQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17);

		when(tortilla.isToasted()).thenReturn(true);
		when(secondTortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("Bad quesadilla", quesadilla.prepareDouble());
		verify(tortilla, atLeastOnce()).toast(true);
		verify(secondTortilla, atLeastOnce()).toast(true);
        verify(queso, never()).melt(true);
	}

	@Test
	public void terribleQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17);

		when(tortilla.isToasted()).thenReturn(false);
		when(secondTortilla.isToasted()).thenReturn(true);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("Terrible quesadilla", quesadilla.prepareDouble());
		verify(tortilla, never()).toast(true);
		verify(secondTortilla, atLeastOnce()).toast(true);
        verify(queso, never()).melt(true);
	}

	@Test
	public void wakalaQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(1,5,9,13,17);

		when(tortilla.isToasted()).thenReturn(true);
		when(secondTortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("Wakala quesadilla", quesadilla.prepareDouble());
		verify(tortilla, atLeastOnce()).toast(true);
		verify(secondTortilla, never()).toast(true);
        verify(queso, never()).melt(true);
	}

	@Test
	public void youRanOutOfGasQuesadilla() {

		when(tortilla.getToastTemperature()).thenReturn(22);
		when(tortilla.getCurrentTemperature()).thenReturn(24);

		when(secondTortilla.getToastTemperature()).thenReturn(22);
		when(secondTortilla.getCurrentTemperature()).thenReturn(24);

		when(queso.getMeltingTemperature()).thenReturn(21);
		when(queso.getCurrentTemperature()).thenReturn(24);

		when(tortilla.isToasted()).thenReturn(false);
		when(secondTortilla.isToasted()).thenReturn(false);
		when(queso.isMelted()).thenReturn(false);

		Assert.assertEquals("You ran out of gas xD", quesadilla.prepareDouble());
		verify(tortilla, never()).toast(true);
		verify(secondTortilla, never()).toast(true);
        verify(queso, never()).melt(true);
	}


}
