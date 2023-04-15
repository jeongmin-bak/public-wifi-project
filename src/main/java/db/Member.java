package db;

import java.util.Date;

public class Member {
    private String memberType;
    private String userId;
    private String password;
    private String name;

    private String mobile;
    private boolean marketing_yn;
    private Date registerDate;
    
    public String getMemberType() {
        return memberType;
    }

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isMarketing_yn() {
		return marketing_yn;
	}

	public void setMarketing_yn(boolean marketing_yn) {
		this.marketing_yn = marketing_yn;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
