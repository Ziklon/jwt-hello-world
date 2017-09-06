package com.darkbit.sample.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtUser  implements UserDetails {

    @JsonIgnore
    private final Long id;

    private final String username;
    private final String firstName;
    private final String lastName;
    @JsonIgnore
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    @JsonIgnore
    private final Date lastPasswordResetDate;


    public JwtUser(
            Long id,
            String username,
            String firstName,
            String lastName,
            String email,
            String password, Collection<? extends GrantedAuthority> authorities,
            boolean enabled,
            Date lastPasswordResetDate
    ) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public  JwtUser(UserDetails userDetails){
        this.authorities = userDetails.getAuthorities();
        this.username = userDetails.getUsername();
        this.password = userDetails.getPassword();
        this.enabled = userDetails.isEnabled();
        this.lastPasswordResetDate = null;
        this.lastName = null;
        this.email = null;
        this.firstName = null;
        this.id = null;

    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
