package site.palex.pChat.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")//нельзя называть таблицы так же как класс
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private boolean active;


    //Добавляем ролевую систему, админы, модераторы и т.д.
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) //Позволяет не создавать доп. таблицу для хранения Enum. fetch - определяет как подгружать данные из таблицы: по мере необходимости(LASY- ленивый, нужно если много записей) или всегда полностью подгружать все (EAGER - жадный)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))   //Описывает что данное поле будет храниться в отдельной таблице user_role, и соединяться по ключу user_id
    @Enumerated(EnumType.STRING)    //Хотим этот Enum хранить в виде строки
    private Set<Role> roles;    //Сет ролей, которые мы создали заранее

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
