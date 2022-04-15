package org.vh.involvement.involvementtask.common.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class AppUser extends UsernamePasswordAuthenticationToken {

    private String tenant;

    public AppUser(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public AppUser(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
        super(usernamePasswordAuthenticationToken.getPrincipal(), usernamePasswordAuthenticationToken.getCredentials(), usernamePasswordAuthenticationToken.getAuthorities());
    }

    public String getUserId() {
        return this.getPrincipal().toString();
    }

}
