package com.booking.sereal;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class DecoderTest {
	
	@Test
	@SuppressWarnings("unchecked")
	public void sample_v2() throws SerealException, IOException {
		final File file = new File(getClass().getResource("error_response.srl").getFile());
		final Map<String,Object> obj = (Map<String, Object>) Decoder.decode_sereal(file, null);
		
		final String message = new String((byte[])obj.get("message"));
		Assert.assertEquals("Method 'test' not found", message);

		final String code = new String((byte[])obj.get("code"));
		Assert.assertEquals("404", code);
	}
}
