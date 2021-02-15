package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

	public static String dataHoraPrintScreen() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMdd_hh_mm_ss_SSS").format(timestamp);
	}
}
