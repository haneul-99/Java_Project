package com.project.ssm.matching;

/**
 * 매칭 완료된 회원과 상대방 정보 클래스입니다.
 * @author yangha-eun
 *
 */
public class MatchingResultUser {
	
	// 1,21453024,최찬형,26,의예과,남자,19946531,손진재,25,의예과,여자
	
	private int matchingNumber; // 번호 고유키
	
	private String myId;	// ID(학번)
	private String myName;	// 이름
	private int myAge;		// 나이
	private String myMajor;	// 전공
	private String myGender;// 성별
	
	private String otherId;		// 매칭된사람(ID(학번))
	private String otherName;	// 매칭된사람 이름
	private int otherAge;		// 매칭된사람 나이
	private String otherMajor;	// 매칭된사람 전공
	private String otherGender;	// 매칭된사람 성별
	
	private String category; // 카테고리
	
	public int getMatchingNumber() {
		return matchingNumber;
	}
	public void setMatchingNumber(int matchingNumber) {
		this.matchingNumber = matchingNumber;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public int getMyAge() {
		return myAge;
	}
	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}
	public String getMyMajor() {
		return myMajor;
	}
	public void setMyMajor(String myMajor) {
		this.myMajor = myMajor;
	}
	public String getMyGender() {
		return myGender;
	}
	public void setMyGender(String myGender) {
		this.myGender = myGender;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public int getOtherAge() {
		return otherAge;
	}
	public void setOtherAge(int otherAge) {
		this.otherAge = otherAge;
	}
	public String getOtherMajor() {
		return otherMajor;
	}
	public void setOtherMajor(String otherMajor) {
		this.otherMajor = otherMajor;
	}
	public String getOtherGender() {
		return otherGender;
	}
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
