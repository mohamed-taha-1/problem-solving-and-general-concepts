package dates;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateBuilders {

	public static void main(String[] args) {
		// first  simple date formatter
		
		SimpleDateFormat smd=new SimpleDateFormat("HH:mm a");
		String formattedSMD=smd.format(new Date( System.currentTimeMillis()));
	      smd.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println(formattedSMD);
		
		
		// -- Now go with java time package .... 
		Instant instNow= Instant.now();
		System.out.println( "\n the instant now is "+ instNow );
		
		Instant instNow2= Instant.now(Clock.systemUTC());
		System.out.println( "\n the instant clock now is "+ instNow2 );
		
		//--Local date and time
		LocalDateTime localDt=LocalDateTime.parse("2023-04-18T10:20:45");
		System.out.println(" after 10 days: "+localDt.plusDays(25));

		LocalDateTime localDt2=LocalDateTime.now();
		System.out.println(" after 10 days from now: "+localDt2.plusDays(25));
		System.out.println(" speific day is: "+localDt2.getDayOfMonth());
		System.out.println(" speific year is: "+localDt2.getYear());
		System.out.println(" local date is: "+localDt2.toLocalDate());
		System.out.println(" local time is: "+localDt2.toLocalTime());
		System.out.println(" local time is: "+localDt2.toLocalTime());
		
		
		// -- zone for specific country or can use Clock to catch your system date and time ; but globally for different countries we use Zone class 
		       // ---> but actually you can break this role by added Zone.id to the clock 
		
		

	}

}
