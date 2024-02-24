package in.priya.binding;

import org.springframework.stereotype.Component;

@Component
public class ResetPwdForm {
	
	private Integer userId;
	private String newPwd;
	private String confirmPwd;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	
	
	
	
	

}
