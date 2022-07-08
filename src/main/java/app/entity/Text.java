package app.entity;

import javax.persistence.*;

@Entity
public class Text
{
    @Id
    @SequenceGenerator(name="Text_SEQUENCE_GENERATOR",sequenceName="Text_SEQUENCE",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Text_SEQUENCE_GENERATOR")
    private Long id;
    @Column(length=999)
    private String text;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text=text;
    }
}