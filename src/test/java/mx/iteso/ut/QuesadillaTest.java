package mx.iteso.ut;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import static org.mockito.Mockito.*;

import java.util.Random;

public class QuesadillaTest
{
   Quesadilla quesadilla;
   Queso mockedQueso;
   Tortilla mockedTortilla;
   Tortilla mockedTortillaInterna;
   
   static Random rand = new Random(System.currentTimeMillis());

   @Before
   public void setUp(){
      quesadilla = new Quesadilla();
      mockedTortilla = mock(Tortilla.class);
      mockedQueso = mock(Queso.class);
      quesadilla.setQueso(mockedQueso);
      quesadilla.setTortilla(mockedTortilla);
      rand = new Random(System.currentTimeMillis());
      quesadilla.setHeatLevel(rand.nextInt(100));
      mockedTortillaInterna = mock(Tortilla.class);
      quesadilla.setTortillaInterna(mockedTortillaInterna);
   }
   @Test
   public void quesadillaPerfecta(){
      when(mockedTortilla.getToastTemperature()).thenReturn(30);
      when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22, 35);
      when(mockedQueso.getMeltingTemperature()).thenReturn(30);
      when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22, 32);
      
      when(mockedQueso.isMelted()).thenReturn(true);
      when(mockedTortilla.isToasted()).thenReturn(true);
      
      assertTrue(quesadilla.prepareSingle().equals("Perfect quesadilla"));
      verify(mockedTortilla,times(1)).toast(true);
      verify(mockedQueso,times(1)).melt(true);
   }
   @Test
   public void quesadillaBuena(){
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   
	   when(mockedQueso.isMelted()).thenReturn(true);
	   when(mockedTortilla.isToasted()).thenReturn(false);
	   
	   assertTrue(quesadilla.prepareSingle().equals("Good quesadilla"));
	   verify(mockedTortilla,never()).toast(true);
	   verify(mockedQueso,times(1)).melt(true);
   }
   @Test
   public void quesadillaTerrible(){
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   
	   when(mockedQueso.isMelted()).thenReturn(false);
	   when(mockedTortilla.isToasted()).thenReturn(true);
	   
	   assertTrue(quesadilla.prepareSingle().equals("Terrible quesadilla"));
	   verify(mockedTortilla,times(1)).toast(true);
	   verify(mockedQueso,never()).melt(true);
   }
   @Test
   public void noHayGas(){
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)*/
	   
	   when(mockedQueso.isMelted()).thenReturn(false);
	   when(mockedTortilla.isToasted()).thenReturn(false);
	   
	   assertTrue(quesadilla.prepareSingle().equals("You ran out of gas"));
	   verify(mockedTortilla,never()).toast(true);
	   verify(mockedQueso,never()).melt(true);
	   verify(mockedTortillaInterna,never()).toast(true);
   }
   @Test
   public void perfectDoubleQuesadilla() {
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   when(mockedTortillaInterna.getToastTemperature()).thenReturn(30);
	   when(mockedTortillaInterna.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35);
	   
	   when(mockedQueso.isMelted()).thenReturn(true);
	   when(mockedTortilla.isToasted()).thenReturn(true);
	   when(mockedTortillaInterna.isToasted()).thenReturn(true);
	      
	   assertTrue(quesadilla.prepareSingle().equals("Perfect double quesadilla"));
	   verify(mockedTortilla,times(1)).toast(true);
	   verify(mockedQueso,times(1)).melt(true);
	   verify(mockedTortillaInterna,times(1)).toast(true);
   }
   @Test
   public void okDoubleQuesadilla() {
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   when(mockedTortillaInterna.getToastTemperature()).thenReturn(30);
	   when(mockedTortillaInterna.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35);
	   
	   when(mockedQueso.isMelted()).thenReturn(true);
	   when(mockedTortilla.isToasted()).thenReturn(true);
	   when(mockedTortillaInterna.isToasted()).thenReturn(false);
	      
	   assertTrue(quesadilla.prepareSingle().equals("OK double quesadilla"));
	   verify(mockedTortilla,times(1)).toast(true);
	   verify(mockedQueso,times(1)).melt(true);
	   verify(mockedTortillaInterna,never()).toast(true);  
   }
   @Test
   public void terribleDoubleQuesadilla() {
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   when(mockedTortillaInterna.getToastTemperature()).thenReturn(30);
	   when(mockedTortillaInterna.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35);
	   
	   when(mockedQueso.isMelted()).thenReturn(false);
	   when(mockedTortilla.isToasted()).thenReturn(true);
	   when(mockedTortillaInterna.isToasted()).thenReturn(false);
	      
	   assertTrue(quesadilla.prepareSingle().equals("Terrible double quesadilla"));
	   verify(mockedTortilla,never()).toast(true);
	   verify(mockedQueso,times(1)).melt(true);
	   verify(mockedTortillaInterna,never()).toast(true);  
   }
   @Test
   public void goodDoubleQuesadilla() {
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   when(mockedTortillaInterna.getToastTemperature()).thenReturn(30);
	   when(mockedTortillaInterna.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35);
	   
	   when(mockedQueso.isMelted()).thenReturn(true);
	   when(mockedTortilla.isToasted()).thenReturn(false);
	   when(mockedTortillaInterna.isToasted()).thenReturn(false);
	      
	   assertTrue(quesadilla.prepareSingle().equals("Good double quesadilla"));
	   verify(mockedTortilla,times(1)).toast(true);
	   verify(mockedQueso,never()).melt(true);
	   verify(mockedTortillaInterna,never()).toast(true);  
   }
   @Test
   public void unholyQuesadilla() {
	   when(mockedTortilla.getToastTemperature()).thenReturn(30);
	   when(mockedTortilla.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35); //2,6,10,14,18,22
	   when(mockedQueso.getMeltingTemperature()).thenReturn(30);
	   when(mockedQueso.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,32);//rand.nextInt(90)
	   when(mockedTortillaInterna.getToastTemperature()).thenReturn(30);
	   when(mockedTortillaInterna.getCurrentTemperature()).thenReturn(2,6,10,14,18,22,35);
	   
	   when(mockedQueso.isMelted()).thenReturn(false);
	   when(mockedTortilla.isToasted()).thenReturn(true);
	   when(mockedTortillaInterna.isToasted()).thenReturn(true);
	      
	   assertTrue(quesadilla.prepareSingle().equals("Unholy quesadilla"));
	   verify(mockedTortilla,never()).toast(true);
	   verify(mockedQueso,times(1)).melt(true);
	   verify(mockedTortillaInterna,times(1)).toast(true);  
   }
}
