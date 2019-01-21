package site.palex.pChat.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;   //Значение enum являются реализацией этого класса


    @Override
    public String getAuthority() {
        return name();
    }
}
