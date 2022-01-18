package com.java.member.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.java.aop.LogAspect;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

@Component
public class MemberServiceImp implements MemberService {
  @Autowired
  private MemberDao memberDao;

  @Override
  public void memberRegisterOk(ModelAndView mav) {
    Map<String, Object> map = mav.getModelMap();
    MemberDto memberDto = (MemberDto) map.get("memberDto");

    if (memberDto.getM_NICKNAME().equals("관리자")) {
      memberDto.setM_PERMISSION("MA");
    } else {
      memberDto.setM_PERMISSION("BA");
    }
    LogAspect.logger.info(LogAspect.LogMsg + memberDto.toString());

    int check = memberDao.memberInsert(memberDto);
    LogAspect.logger.info(LogAspect.LogMsg + check);

    mav.addObject("check", check);
    mav.setViewName("member/registerOk");
  }

  @Override
  public void memberLoginOk(ModelAndView mav) {
    Map<String, Object> map = mav.getModelMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");

    String id = request.getParameter("M_ID");
    String pw = request.getParameter("M_PW");
    LogAspect.logger.info(LogAspect.LogMsg + "M_ID:" + id + "," + "M_PW:" + pw);

    String premission = memberDao.loginCheck(id, pw);
    LogAspect.logger.info(LogAspect.LogMsg + premission);

    mav.addObject("premission", premission);
    mav.addObject("id", id);
    
    mav.setViewName("member/loginOk");


  }


  @Override
  public void kakaologin(ModelAndView mav) {
    Map<String, Object> map = mav.getModelMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");

    String token = request.getParameter("token");
    LogAspect.logger.info(LogAspect.LogMsg + token);

    // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
    JsonParser parser = new JsonParser();
    JsonElement element = parser.parse(token);

    String access_Token = element.getAsJsonObject().get("access_token").getAsString();
    LogAspect.logger.info(LogAspect.LogMsg + "access_Token : " + access_Token);



    // access_token을 이용하여 사용자 정보 가져오기
    String reqURL2 = "https://kapi.kakao.com/v2/user/me";
    try {
      URL url = new URL(reqURL2);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");

      // 요청에 필요한 Header에 포함될 내용
      conn.setRequestProperty("Authorization", "Bearer " + access_Token);

      // 결과 코드가 200이라면 성공
      int responseCode = conn.getResponseCode();
      LogAspect.logger.info(LogAspect.LogMsg + "responseCode : " + responseCode);


      // 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
      BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String line = "";
      String result = "";

      while ((line = br.readLine()) != null) {
        result += line;
      }

      // kakao에서 받아온 json 출력
      LogAspect.logger.info(LogAspect.LogMsg + "response body : " + result);

      // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
      JsonParser parser1 = new JsonParser();
      JsonElement element1 = parser1.parse(result);


      String kakao_id = element1.getAsJsonObject().get("id").getAsString();

      LogAspect.logger.info(LogAspect.LogMsg + kakao_id);

      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }



  }


}
