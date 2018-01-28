package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catalog extends Model {

    @Id
    public long id;

    public int value;

    public String name;

    public String intro;

    public String imgUrl;

    public static Finder<Long, Catalog> find = new Finder<Long,Catalog>(Catalog.class);

    public Catalog(long id, int value, String name, String intro, String imgUrl) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.intro = intro;
        this.imgUrl = imgUrl;
    }
}
