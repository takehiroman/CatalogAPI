package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catalog extends Model {

    @Id
    public Long id;

    public int value;

    public String name;

    public String intro;

    public String imgUrl;

    public static Finder<Long, Catalog> find = new Finder<Long,Catalog>(Catalog.class);
}
