package com.infinite.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.JobSeeker;
import com.infinite.repository.BottleRepository;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private BottleRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		SimpleDateFormat formatter=new SimpleDateFormat("MM-dd-yyyy mm:HH:ss");	
		Date date=formatter.parse("12-30-2022 12:02:34");
		File resumeContentFile=new File("D:\\Pavan\\Personal\\Materials\\Pavan_Resume.docx");
		File photoContentFile=new File("D:\\Pavan\\Personal\\Infinite\\1028276.jpg");
		FileInputStream photoStream=new FileInputStream(photoContentFile);
		FileReader resumeReader=new FileReader(resumeContentFile);
		char[] resume=new char[(int) resumeContentFile.length()];
		byte[] photo=new byte[(int) photoContentFile.length()];
		photoStream.read(photo);
		resumeReader.read(resume);
		JobSeeker seeker=new JobSeeker(null, "Adams", 29, date, photo, resume);
		save(seeker);
	}
	
	
	private <S extends JobSeeker> S  save(S s){
		 return repository.save(s);
	}

}
