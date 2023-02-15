package com.infinite.runners;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Bottle;
import com.infinite.repository.BottleRepository;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private BottleRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		SimpleDateFormat formatter=new SimpleDateFormat("MM-dd-yyyy mm:HH:ss");	
		Date date=formatter.parse("12-30-2022 12:02:34");
		DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("MM-dd-yyyy mm:HH:ss");
		Bottle bottle=new Bottle(null,"Nike",60.65f,new Date(),LocalDateTime.parse("12-30-2022 12:02:34", formatter2));
		save(bottle);
	}
	
	
	private <S extends Bottle> void  save(S s){
		 repository.save(s);
	}

}
