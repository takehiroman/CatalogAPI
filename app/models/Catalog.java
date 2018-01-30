package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Required;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catalog extends Model {

    @Id
    public long id;

    public int value;

    @Required(message = "名前を入力してください。")
    @MaxLength(value = 100, message = "100文字以下で入力してください。")
    public String name;

    @MaxLength(value = 500, message = "500文字以下で入力してください。")
    public String intro;

    public String imgUrl;

    public static final Finder<Long, Catalog> find = new Finder<Long,Catalog>(Catalog.class);

    public Catalog(long id, int value, String name, String intro, String imgUrl) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.intro = intro;
        this.imgUrl = imgUrl;
    }

}
