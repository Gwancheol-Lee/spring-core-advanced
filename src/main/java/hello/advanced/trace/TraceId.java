package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
	private String id;
	private int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}
	
	private TraceId(String id, int level) {
		this.id = id;
		this.level = level;
	}
	// 트랜잭션 아이디 생성
	private String createId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}
	// 트랜잭션 다음 로직에서 찍힌 로그 아이디 생성
	public TraceId createNextId() {
		return new TraceId(id, level + 1);
	}
	// 트랜잭션 이전 로직에서 찍힌 로그 아이디 생성	
	public TraceId createPreviousId() {
		return new TraceId(id, level - 1);
	}
	
	public boolean isFirstLevel() {
		return level == 0;
	}
	
	public String getId() { 
		return id;
	}
	
	public int getLevel() {
		return level;
	}
}
