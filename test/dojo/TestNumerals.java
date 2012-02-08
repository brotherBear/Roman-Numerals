package dojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumerals {

	@Test
	public void testConvert1() {
		assertEquals("First ", "I", RomanNumeral.get(1));
	}

	@Test
	public void testConvert4() {
		assertEquals("four", "IV", RomanNumeral.get(4));
	}
	
	@Test
	public void testConvert95()
	{
		assertEquals("nintyfive", "XCV", RomanNumeral.get(95));
	}
	
	@Test
	public void testConvert999()
	{
		assertEquals("nineninenine", "CMXCIX", RomanNumeral.get(999));
	}

	@Test
	public void testConvert1717() {
		assertEquals("seventeenseventeen", "MDCCXVII", RomanNumeral.get(1717));
	}
	
	@Test
	public void testConvert3999() {
		assertEquals("", "MMMCMXCIX", RomanNumeral.get(3999));
	}
	
	@Test
	public void testConvert4000() {
		try {
			RomanNumeral.get(4000);
			fail("Not possible!");
		} catch (Exception e) {
			assertEquals("Cannot process numbers > 3999", e.getMessage());
		}
	}
	
	@Test
	public void testConvertMDCCXVII() {
		assertEquals("seventeenseventeen", 1717, RomanNumeral.get("MDCCXVII"));
	}
	@Test
	public void testConvertMCDXVII() {
		assertEquals("seventeenseventeen", 1417, RomanNumeral.get("MCDXVII"));
	}
}
