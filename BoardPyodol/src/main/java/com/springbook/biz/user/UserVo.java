package com.springbook.biz.user;


public class UserVo  {
	private String id;
	private String password;
	private String name;
	private String role;
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#getId()
	 */
	public String getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#getPassword()
	 */
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#setPassword(java.lang.String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#getName()
	 */
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#getRole()
	 */
	public String getRole() {
		return role;
	}
	/* (non-Javadoc)
	 * @see com.springbook.biz.user.UserService#setRole(java.lang.String)
	 */
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + ", getId()="
				+ getId() + ", getPassword()=" + getPassword() + ", getName()=" + getName() + ", getRole()=" + getRole()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
