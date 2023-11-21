package org.backy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxServiceImplTest {

	@Autowired
	private SampleTxServiceImpl impl;
	
	@Test
	public void test() {
		String str = "PropertyKeys\r\n"
				+ "이름   설명\r\n"
				+ "kakao_account.profile   카카오계정의 프로필 소유 여부\r\n"
				+ "실시간 닉네임과 프로필 사진 URL\r\n"
				+ "kakao_account.name   카카오계정의 이름 소유 여부, 이름 값\r\n"
				+ "kakao_account.email   카카오계정의 이메일 소유 여부\r\n"
			;
		log.info("length > " + str.getBytes().length);
		impl.addData(str);
	}

}
