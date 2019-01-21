package site.palex.pChat.domain;

import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
//Из-за отсутствия аннотации @Table, предполагается, что сущность будет соответствовать таблице с названием Message
public class  Message {


    @Id     //Свойство id аннотировано как @Id, так что JPA распознает его как ID объекта.
    @GeneratedValue(strategy=GenerationType.AUTO)   //также аннотировано как @GeneratedValue, означая, что ID должен генерироваться автоматически.
    private Integer id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) // говорим что связь от одного пользователя к множеству сообщений
    @JoinColumn(name = "user_id")   //Нужно чтобы в базе это поле называлось User_id, а не author
    private User author;

    public Message() {  //private
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }


}
