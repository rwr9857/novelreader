package com.java.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		LogAspect.logger.info(LogAspect.LogMsg + memberDto);

		if (memberDto.getM_nickname().equals("관리자")) {
			memberDto.setM_permission("MA");
		} else {
			memberDto.setM_permission("BA");
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

		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		LogAspect.logger.info(LogAspect.LogMsg + "m_id:" + id + "," + "m_pw:" + pw);

		MemberDto member = memberDao.loginCheck(id, pw);

		int numSess = member.getM_num();
		String permissionSess = member.getM_permission();
		String platformSess = member.getM_platform();
		String nicknameSess = member.getM_nickname();
		LogAspect.logger.info(LogAspect.LogMsg + numSess + "\t" + permissionSess + "\t" + platformSess);

		mav.addObject("numSess", numSess);
		mav.addObject("permissionSess", permissionSess);
		mav.addObject("platformSess", platformSess);
		mav.addObject("nicknameSess", nicknameSess);

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
		String kakao_id = "";
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

			kakao_id = element1.getAsJsonObject().get("id").getAsString();

			LogAspect.logger.info(LogAspect.LogMsg + kakao_id);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// db에 값이 있는지 체크
		MemberDto memberCheck = memberDao.pmLoginCheck("kakao", kakao_id);
		LogAspect.logger.info(LogAspect.LogMsg + memberCheck);

		if (memberCheck == null) {
			// 가입
			MemberDto memberDto = new MemberDto();
			memberDto.setM_platform("kakao");	
			memberDto.setM_sns_id(kakao_id);
			memberDto.setM_permission("BA");
			LogAspect.logger.info(LogAspect.LogMsg + memberDto);

			int check = memberDao.memberInsert(memberDto);
			LogAspect.logger.info(LogAspect.LogMsg + check);

			memberCheck = memberDao.pmLoginCheck("kakao", kakao_id);
		}

		int numSess = memberCheck.getM_num();
		String permissionSess = memberCheck.getM_permission();
		String platformSess = memberCheck.getM_platform();
		String nicknameSess = memberCheck.getM_nickname();
		
		LogAspect.logger.info(LogAspect.LogMsg + numSess + "\t" + permissionSess + "\t" + platformSess);
		
		HttpSession session = request.getSession();
		session.setAttribute("numSess", numSess);
		session.setAttribute("permissionSess", permissionSess);
		session.setAttribute("platformSess", platformSess);
		session.setAttribute("nicknameSess", nicknameSess);

		mav.setViewName("member/pmLoginOk");

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


		// db에 값이 있는지 체크
		MemberDto memberCheck = memberDao.pmLoginCheck("naver", naver_id);
		LogAspect.logger.info(LogAspect.LogMsg + memberCheck);

		if (memberCheck == null) {
			// 가입
			MemberDto memberDto = new MemberDto();
			memberDto.setM_platform("naver");
			memberDto.setM_sns_id(naver_id);
			memberDto.setM_permission("BA");
			LogAspect.logger.info(LogAspect.LogMsg + memberDto);

			int check = memberDao.memberInsert(memberDto);
			LogAspect.logger.info(LogAspect.LogMsg + check);

			memberCheck = memberDao.pmLoginCheck("naver", naver_id);
		}

		int numSess = memberCheck.getM_num();
		String permissionSess = memberCheck.getM_permission();
		String platformSess = memberCheck.getM_platform();
		String nicknameSess = memberCheck.getM_nickname();
		LogAspect.logger.info(LogAspect.LogMsg + numSess + "\t" + permissionSess + "\t" + platformSess);
		
		HttpSession session = request.getSession();
		session.setAttribute("numSess", numSess);
		session.setAttribute("permissionSess", permissionSess);
		session.setAttribute("platformSess", platformSess);
		session.setAttribute("nicknameSess", nicknameSess);
		
		mav.setViewName("member/pmLoginOk");
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
	
	
	
	
	
	
	
	


	// -----프로필-----

	@Override
	public void profileNovel(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String nickname = request.getParameter("nickname");
		String pageNumber = request.getParameter("pageNumber");
		LogAspect.logger.info(LogAspect.LogMsg + "닉네임 : " +nickname + " , 페이지 번호 : " + pageNumber); // 닉네임 / 페이지 넘버 확인용

		MemberDto memberDto = memberDao.profileSelect(nickname);
		LogAspect.logger.info(LogAspect.LogMsg + " 프로필 정보 : " + memberDto.toString());
		
		int num = memberDto.getM_num();
		int profileFollowerCount = memberDao.profileFollowerCount(num);
		int profileFollowingCount = memberDao.profileFollowingCount(num);
			
		//팔로우 됐는지 확인용
		HttpSession session=request.getSession();
		int me=0;
		if(session.getAttribute("numSess")!=null) {
			me = (Integer) session.getAttribute("numSess");
		}
		
		LogAspect.logger.info(LogAspect.LogMsg + "본인 : "+me + "  현재 프로필 번호 : "+num);
		
		int followCheck = memberDao.profileFollowCheck(me, num);
		/////////////////
		
		mav.addObject("profileFollowerCount",profileFollowerCount);
		mav.addObject("profileFollowingCount",profileFollowingCount);
		
		mav.addObject("memberDto", memberDto);
		mav.addObject("followCheck",followCheck);//팔로우 됐는지 확인용
		mav.setViewName("member/profileNovel.tiles");
	}
	
	
	
	@Override
	public void profileFollower(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String nickname = request.getParameter("nickname");
		String pageNumber = request.getParameter("pageNumber");
		
		LogAspect.logger.info(LogAspect.LogMsg + "닉네임" + nickname + " , 현재 페이지 번호" + pageNumber); // 닉네임 / 페이지 넘버 확인용

		MemberDto memberDto = memberDao.profileSelect(nickname);
		
		int num = memberDto.getM_num();
		
		int profileFollowerCount = memberDao.profileFollowerCount(num);    //팔로워수
		int profileFollowingCount = memberDao.profileFollowingCount(num);  //팔로잉수		
		
		//팔로워 리스트 페이지 
		
		if (pageNumber == null)
			pageNumber = "1";
		
		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지 : " +currentPage);

		// 한페이지당 게시물 10개/ start 1, end 10
		int listSize = 10;
		int startRow = (currentPage - 1) * listSize + 1;
		int endRow = currentPage * listSize;
		
		LogAspect.logger.info(LogAspect.LogMsg + "팔로워 수" +profileFollowerCount);
		
		List<MemberDto> followerList = null;
		if (profileFollowerCount > 0) {
			followerList = memberDao.profileFollowerList(num, startRow, endRow);
			
		}
		
		
		
		
		
		//팔로우 됐는지 확인용
		HttpSession session=request.getSession();
		int me=0;
		if(session.getAttribute("numSess")!=null) {
			me = (Integer) session.getAttribute("numSess");
		}
		
		LogAspect.logger.info(LogAspect.LogMsg + "본인 : "+me + "  현재 프로필 번호 : "+num);
		
		int followCheck = memberDao.profileFollowCheck(me, num);
		/////////////////
		
		
		
		mav.addObject("listSize",listSize); // 한페이지당 보여지는 팔로워수
		mav.addObject("currentPage", currentPage); // 요청페이지
		mav.addObject("followerList",followerList); //팔로워 리스트
		mav.addObject("profileFollowerCount",profileFollowerCount);// 전체 팔로워 수
		
		mav.addObject("profileFollowingCount",profileFollowingCount);//프로필 상단 - 전체 팔로잉 수
		mav.addObject("memberDto", memberDto); //프로필 상단 - 프로필정보들
		mav.addObject("followCheck",followCheck);//팔로우 됐는지 확인용
		
		mav.setViewName("member/profileFollower.tiles");
	}
	
	
	
	@Override
	public void profileFollowing(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String nickname = request.getParameter("nickname");
		String pageNumber = request.getParameter("pageNumber");
		LogAspect.logger.info(LogAspect.LogMsg + "닉네임 : " + nickname + " , 페이지 번호 : " + pageNumber); // 닉네임 / 페이지 넘버 확인용
		
		MemberDto memberDto = memberDao.profileSelect(nickname);
		LogAspect.logger.info(LogAspect.LogMsg + "프로필 정보 : " + memberDto.toString());
		
		int num = memberDto.getM_num();
				
		//팔로우 됐는지 확인용
		HttpSession session=request.getSession();
		int me=0;
		if(session.getAttribute("numSess")!=null) {
			me = (Integer) session.getAttribute("numSess");
		}
		
		LogAspect.logger.info(LogAspect.LogMsg + "본인 : "+me + "  현재 프로필 번호 : "+num);
		
		int followCheck = memberDao.profileFollowCheck(me, num);
		/////////////////
		
		int profileFollowerCount = memberDao.profileFollowerCount(num);    //팔로워수
		int profileFollowingCount = memberDao.profileFollowingCount(num);  //팔로잉수		
		
		//팔로워 리스트 페이지 
		
		if (pageNumber == null)
			pageNumber = "1";
		
		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지 :" +currentPage);

		// 한페이지당 게시물 10개/ start 1, end 10
		int listSize = 10;
		int startRow = (currentPage - 1) * listSize + 1;
		int endRow = currentPage * listSize;
		
		LogAspect.logger.info(LogAspect.LogMsg + "팔로잉 수 : " + profileFollowingCount);
		
		List<MemberDto> followingList = null;
		if (profileFollowingCount > 0) {
			followingList = memberDao.profileFollowingList(num, startRow, endRow);
			
		}
		
		
		mav.addObject("listSize",listSize); // 한페이지당 보여지는 팔로워수
		mav.addObject("currentPage", currentPage); // 요청페이지
		mav.addObject("followingList",followingList); //팔로잉 리스트
		mav.addObject("profileFollowerCount",profileFollowerCount);//프로필 상단 - 전체 팔로워 수
		
		mav.addObject("profileFollowingCount",profileFollowingCount);//프로필 상단 - 전체 팔로잉 수
		mav.addObject("memberDto", memberDto); //프로필 상단 - 프로필정보들
		mav.addObject("followCheck",followCheck);//팔로우 됐는지 확인용
		
		mav.setViewName("member/profileFollowing.tiles");
		
	}
	
	
	
	
	@Override
	public void profileFollow(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int numSess = Integer.parseInt(request.getParameter("numSess")); //본인
		int num = Integer.parseInt(request.getParameter("num"));         //팔로우 할 사람
		String nickname = request.getParameter("nickname");
		
		int check=memberDao.follow(numSess, num);	
		
		mav.addObject("check",check); //팔로우 insert 확인용
		mav.addObject("nickname",nickname);	  //기존 팔로워 창으로 돌아가기 위함
		
		mav.setViewName("member/follow");
	}
	
	
	@Override
	public void profileFollowDelete(ModelAndView mav) {								//프로필 상단 팔로우 삭제
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int numSess = Integer.parseInt(request.getParameter("numSess")); //본인
		int num = Integer.parseInt(request.getParameter("num"));         //팔로우 취소 할 사람
		String nickname = request.getParameter("nickname");
		
		int check=memberDao.followDelete(numSess, num);	//내가 팔로우를 해제
		
		mav.addObject("check",check); //팔로우취소 Delete 확인용
		mav.addObject("nickname",nickname);	  //기존 팔로워 창으로 돌아가기 위함
		
		mav.setViewName("member/followDelete");
	}
	
	@Override
	public void follower_followDelete(ModelAndView mav) {							//팔로워 삭제
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int numSess = Integer.parseInt(request.getParameter("numSess")); //본인
		int numDel = Integer.parseInt(request.getParameter("numDel"));         //팔로우 취소 할 사람
		String nickname = request.getParameter("nickname");
		String pageNumber = request.getParameter("pageNumber");
		
		if (pageNumber == null)
			pageNumber = "1";
		
		int check=memberDao.followDelete(numDel, numSess);	//다른사람이 나를 팔로우 하는것을 해제
		
		System.out.println(numSess+","+numDel + "," + nickname +"," + pageNumber + ",체크 : "+check);
		
		mav.addObject("check",check); //팔로우취소 Delete 확인용
		mav.addObject("nickname",nickname);	  //기존 팔로워 창으로 돌아가기 위함
		mav.addObject("pageNumber",pageNumber);	  //기존 팔로워 창 해당 페이지로 돌아가기 위함
		
		mav.setViewName("member/follower_followDelete");
	}
	
	@Override
	public void following_followDelete(ModelAndView mav) {							//팔로잉 삭제
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int numSess = Integer.parseInt(request.getParameter("numSess")); //본인
		int numDel = Integer.parseInt(request.getParameter("numDel"));         //팔로우 취소 할 사람
		String nickname = request.getParameter("nickname");
		String pageNumber = request.getParameter("pageNumber");
		
		if (pageNumber == null)
			pageNumber = "1";
		
		System.out.println(numSess+","+numDel + "," + nickname +"," + pageNumber);
		
		int check=memberDao.followDelete(numSess, numDel);	//내가 팔로우 한것을 해제
		
		
		
		mav.addObject("check",check); //팔로잉 취소 Delete 확인용
		mav.addObject("nickname",nickname);	  //기존 팔로잉 창으로 돌아가기 위함
		mav.addObject("pageNumber",pageNumber);	  //기존 팔로워 창 해당 페이지로 돌아가기 위함
		
		mav.setViewName("member/following_followDelete");
	}
	
	
	
	///////////////////프로필 설정
	
	@Override
	public void profileEdit(ModelAndView mav) {							//프로필 수정
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String nickname = request.getParameter("nickname");
		
		MemberDto memberDto = memberDao.profileSelect(nickname);
		
		mav.addObject("memberDto",memberDto); 
		
		mav.setViewName("member/profileEdit.tiles");
	}
	
	
	@Override
	public void nicknameCheck(ModelAndView mav) throws Throwable {			//닉네임 중복체크 Ajax
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String nickname = request.getParameter("nickname");
		
		System.out.println("Ajax 닉네임 가져오기 : " + nickname);
		
		int check=memberDao.nicknameCheck(nickname);
		
		System.out.println("Ajax 중복체크 check : "+check);
		
		PrintWriter out=response.getWriter();  //다시 ajax로 보내는함수들
		out.println(check);			//뭐지?
		out.flush();				//check값을 보냄
		out.close();				//이 함수를 종료.
		
		mav.setViewName("member/profileEdit");
	}
	
	@Override
	public void profileEditOk(ModelAndView mav) throws Throwable {				//프로필 수정 submit
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		System.out.println("프로필수정 테스트 : "+memberDto.toString());
		
		String nickname=null;
		String nicknameSess = request.getParameter("nicknameSess");
		
		String birthday=request.getParameter("birthday");
		
		if(birthday==null||birthday.equals("")) {	//생일 선택을 안했다면
			memberDto.setM_birthday(null);
		}else if(birthday!=null||!birthday.equals("")){//생일 선택을 했다면
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date to = transFormat.parse(birthday);
			memberDto.setM_birthday(to);
		}
		
		
		int check=memberDao.profileEditOk(memberDto);
		
		System.out.println("check : " + check);
		
		
		
		if(memberDto.getM_nickname().equals(nicknameSess)) {//닉네임 수정이 없었다면
			nickname=nicknameSess;
		}else if(!memberDto.getM_nickname().equals(nicknameSess)) {//닉네임을 수정했다면
			nickname=memberDto.getM_nickname();
		}
		
		
		mav.addObject("check",check);
		mav.addObject("nicknameSess",nickname);
		
		mav.setViewName("member/profileEditOk");
	}
	
	
	//////////////////// 계정 설정
	
	@Override
	public void accountEdit(ModelAndView mav) {						//계정 설정
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String nickname = request.getParameter("nickname");
		
		MemberDto memberDto = memberDao.profileSelect(nickname);
		
		mav.addObject("memberDto",memberDto); 
		
		mav.setViewName("member/accountEdit.tiles");
	}
	
	
	@Override
	public void emailCheck(ModelAndView mav) throws Throwable {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String email = request.getParameter("email");
		
		System.out.println("Ajax email 가져오기 : " + email);
		
		int check=memberDao.emailCheck(email);
		
		System.out.println("Ajax 중복체크 check : "+check);
		
		PrintWriter out=response.getWriter();  //다시 ajax로 보내는함수들
		out.println(check);			//뭐지?
		out.flush();				//check값을 보냄
		out.close();				//이 함수를 종료.
		
		mav.setViewName("member/accountEdit");
	}
	
	@Override
	public void accountEditOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		System.out.println("계정설정 테스트 : "+memberDto.toString());
		
		String nickname=request.getParameter("nicknameSess");
		
		int check=0;
		
		if(memberDto.getM_pw()==null ||memberDto.getM_pw().equals("")) {	//비밀번호가 빈칸일때
			System.out.println("비밀번호 변경 없음");
			check=memberDao.accountEditNoPw(memberDto);
		}else {															//비밀번호도 같이 변경할때
			System.out.println("비밀번호 변경함");
			check=memberDao.accountEdit(memberDto);
		}
		
		System.out.println("check : " + check);
		
		
		
		
		mav.addObject("check",check);
		mav.addObject("nicknameSess",nickname);
		
		mav.setViewName("member/accountEditOk");
		
	}
	
	
	
	
	@Override
	public void resign(ModelAndView mav) {					//회원 탈퇴
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int m_num=Integer.parseInt(request.getParameter("m_num"));
		
		int check=memberDao.accountDelete(m_num);
		
		LogAspect.logger.info(LogAspect.LogMsg + "탈퇴 check: "+ check);
		
		mav.addObject("check",check);
		
		mav.setViewName("member/resign");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -----관리자 회원조회-----
	@Override
	public void memberSelect(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber);
		LogAspect.logger.info(LogAspect.LogMsg + "현재 페이지: "+ currentPage);

		// 한 페이지 당 게시물 1page 10개 / start 1, end 10
		int boardSize = 10;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		int count = memberDao.getCount();
		LogAspect.logger.info(LogAspect.LogMsg + count);
		
		List<MemberDto> memberList = null;
		if (count > 0) {
			memberList = memberDao.memberList(startRow, endRow);
			LogAspect.logger.info(LogAspect.LogMsg + memberList.size());
		}

		mav.addObject("boardSize", boardSize); // 한페이지당 게시물 수
		mav.addObject("currentPage", currentPage); // 요청페이지
		mav.addObject("memberList", memberList); // 회원 리스트
		mav.addObject("count", count); // 전체 게시물 수

		mav.setViewName("manager/memberView.tiles1");
	}

}
