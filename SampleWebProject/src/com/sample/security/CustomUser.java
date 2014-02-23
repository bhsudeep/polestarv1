/*
 * 
 */
package com.sample.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomUser.
 */
public class CustomUser extends User implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6346119265724059523L;
	
	/** The id. */
	private long id;
	
	/** The password. */
	private String password;
	
	/** The userId. */
	private String userId;
	
	/** The username. */
	private String username;
	
	/** The display name. */
	private String displayName;
	
	/** The roles. */
	private Set<GrantedAuthority> roles;
	
	/** The last login date. */
	private Date lastLoginDate;
	
	/** The force change pwd. */
	private Boolean forceChangePwd;
	
	/** The random token. */
	private String randomToken;
	
	private String roleName;
	
	private Long roleId;
	
	/**
	 * Instantiates a new custom user.
	 * 
	 * @param id the id
	 * @param password the password
	 * @param username the username
	 * @param roles the roles
	 * @param accountNonExpired the account non expired
	 * @param accountNonLocked the account non locked
	 * @param credentialsNonExpired the credentials non expired
	 * @param enabled the enabled
	 */
	public CustomUser(long id,String userId, String password, String username,
			Set<GrantedAuthority> roles, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired,
			boolean enabled,String roleName, Long roleId) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, 
				roles);
		this.id = id;
		this.userId = userId;
		this.password="";
		this.username = username;
		this.roles = roles;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.roleName = roleName;
		this.roleId = roleId;
	}

	

	/**
	 * Gets the roles.
	 * 
	 * @return the roles
	 */
	public Set getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 * 
	 * @param roles the new roles
	 */
	public void setRoles(Set roles) {
		this.roles = roles;
	}

	/** The account non expired. */
	private boolean accountNonExpired;
	
	/** The account non locked. */
	private boolean accountNonLocked;
	
	/** The credentials non expired. */
	private boolean credentialsNonExpired;
	
	/** The enabled. */
	private boolean enabled;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#getAuthorities()
	 */
	public List<GrantedAuthority> getAuthorities() {
		List list = new ArrayList();
		for (GrantedAuthority role : roles) {
			list.add(new GrantedAuthorityImpl(role.getAuthority()));
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#getPassword()
	 */
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#getUsername()
	 */
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#isAccountNonExpired()
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#isAccountNonLocked()
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#isCredentialsNonExpired()
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.User#isEnabled()
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the last login date.
	 * 
	 * @return the last login date
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * Sets the last login date.
	 * 
	 * @param lastLoginDate the new last login date
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * Gets the force change pwd.
	 * 
	 * @return the force change pwd
	 */
	public Boolean getForceChangePwd() {
		return forceChangePwd;
	}

	/**
	 * Sets the force change pwd.
	 * 
	 * @param forceChangePwd the new force change pwd
	 */
	public void setForceChangePwd(Boolean forceChangePwd) {
		this.forceChangePwd = forceChangePwd;
	}

	/**
	 * Gets the display name.
	 * 
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 * 
	 * @param displayName the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the random token.
	 * 
	 * @return the random token
	 */
	public String getRandomToken() {
		return randomToken;
	}

	/**
	 * Sets the random token.
	 * 
	 * @param randomToken the new random token
	 */
	public void setRandomToken(String randomToken) {
		this.randomToken = randomToken;
	}



	public long getUkey() {
		return id;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getRoleName() {
		return roleName;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public Long getRoleId() {
		return roleId;
	}



	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result
				+ ((forceChangePwd == null) ? 0 : forceChangePwd.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastLoginDate == null) ? 0 : lastLoginDate.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((randomToken == null) ? 0 : randomToken.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomUser other = (CustomUser) obj;
		if (accountNonExpired != other.accountNonExpired)
			return false;
		if (accountNonLocked != other.accountNonLocked)
			return false;
		if (credentialsNonExpired != other.credentialsNonExpired)
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (enabled != other.enabled)
			return false;
		if (forceChangePwd == null) {
			if (other.forceChangePwd != null)
				return false;
		} else if (!forceChangePwd.equals(other.forceChangePwd))
			return false;
		if (id != other.id)
			return false;
		if (lastLoginDate == null) {
			if (other.lastLoginDate != null)
				return false;
		} else if (!lastLoginDate.equals(other.lastLoginDate))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (randomToken == null) {
			if (other.randomToken != null)
				return false;
		} else if (!randomToken.equals(other.randomToken))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
}
