package br.com.maripuri.mydom.config.audit;

import jakarta.persistence.*;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table(name = "aud_revision_info")
@AttributeOverrides({ 
	@AttributeOverride(name = "timestamp", column = @Column(name = "rev_timestamp")),
//  @AttributeOverride(name = "id", column = @Column(name = "revision_id")) 
})
@RevisionEntity(AuditRevisionListenerImpl.class)
public class AuditRevisionEntity extends DefaultRevisionEntity {
	private static final long serialVersionUID = 1L;

	
	@Column(name = "user_id")
	private String userId;	
	
	@Column(name = "user_ip")
	private String userIp;	
	
	@Column(name = "username")
	private String username;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	

}