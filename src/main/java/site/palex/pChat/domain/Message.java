package site.palex.pChat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity // This tells Hibernate to make a table out of this class
//Из-за отсутствия аннотации @Table, предполагается, что сущность будет соответствовать таблице с названием Message
public class Message {

    @Id     //Свойство id аннотировано как @Id, так что JPA распознает его как ID объекта.
    @GeneratedValue(strategy=GenerationType.AUTO)   //также аннотировано как @GeneratedValue, означая, что ID должен генерироваться автоматически.
    private Integer id;

    private String text;
    private String tag;

    public Message() {  //private
    }

    public Message(String text, String tag) {
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


}
