package com.project.ssm.matching;

/**
 * 매칭 정보에 등록된 회원 클래스입니다.
 * @author yangha-eun
 *
 */
public class MatchingUser {
	//17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
	
	private String id;		// ID(학번)
	private String name;	// 이름
	private int age;		// 나이
	private String major;	// 전공
	private String gender;	// 성별
	private int height;		// 키
	private int weight;		// 몸무게
	private String cc;		// 과CC가능여부
	private String exercise;// 운동종목
	private double grade;	// 학점
	private String study;	// 공부
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getStudy() {
		return study;
	}
	public void setStudy(String study) {
		this.study = study;
	}
	
}
