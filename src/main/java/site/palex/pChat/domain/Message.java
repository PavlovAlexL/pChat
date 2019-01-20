package site.palex.pChat.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity // This tells Hibernate to make a table out of this class
public class Message {

    @Id     //говорит спрингу что это поле явл. идентификатором
    @GeneratedValue(strategy=GenerationType.AUTO)   //говорим что созданием и прочими параметрами идентификатора занимается Spring
    private Integer id;     //говорим что идентификатор будет целым числом

    private String text;
    private String tag;

    public Message(){
        //Если это @Entity, то обязательно должен быть конструктор без параметров
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

    @Override
    public String toString() {
        return id.toString()+text+tag;
    }
}
