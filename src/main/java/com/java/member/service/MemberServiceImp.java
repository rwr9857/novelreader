package com.java.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

		MemberDto member = memberDao.loginCheck(id, pw);

		int m_num = member.getM_NUM();
		String premission = member.getM_PERMISSION();
		LogAspect.logger.info(LogAspect.LogMsg + m_num + "\t" + premission);

		mav.addObject("m_num", m_num);
		mav.addObject("id", id);
		mav.addObject("premission", premission);

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

	@Override
	public void naverlogin(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String code = request.getParameter("code");
		String state = request.getParameter("state");
		LogAspect.logger.info(LogAspect.LogMsg + code + "," + state);

		String access_token = "";

		// access_token 받아오기
		String reqURL = "https://nid.naver.com/oauth2.0/token";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=k7RIM1ejpagn8MbzDO3E"); // 발급받은 Client ID 값
			sb.append("&client_secret=Zx8CBh_NIp"); // 발급받은 Client secret 값
			sb.append("&code=" + code);
			sb.append("&state=" + state);
			bw.write(sb.toString());
			bw.flush();

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

			// 받아온 json 출력
			LogAspect.logger.info(LogAspect.LogMsg + "response body : " + result);

			// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			access_token = element.getAsJsonObject().get("access_token").getAsString();

			LogAspect.logger.info(LogAspect.LogMsg + "access_token : " + access_token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 사용자 정보 받아오기
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		String header = "Bearer " + access_token; // Bearer 다음에 공백 추가

		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Authorization", header);
		String result = get(apiURL, requestHeaders);

		LogAspect.logger.info(LogAspect.LogMsg + "response body : " + result);

		// Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
		JsonParser parser = new JsonParser();
		JsonElement element1 = parser.parse(result);

		JsonObject naver_response = element1.getAsJsonObject().get("response").getAsJsonObject();

		String naver_id = naver_response.getAsJsonObject().get("id").getAsString();
		LogAspect.logger.info(LogAspect.LogMsg + "naver_id : " + naver_id);
		
		mav.setViewName("member/naverLoginOk");

	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		BufferedReader lineReader = null;
		try {
			lineReader = new BufferedReader(streamReader);
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

}
