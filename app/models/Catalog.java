package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.data.validation.Constraints.Min;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Catalog extends Model {

    @Id
    public long id;

    @Required(message = "値段を入力してください。")
    public Integer price;

    @Required(message = "名前を入力してください。")
    @MaxLength(value = 100, message = "100文字以下で入力してください。")
    public String name;

    @Required(message = "説明文を入力してください。")
    @MaxLength(value = 500, message = "500文字以下で入力してください。")
    public String intro;

    @Required(message = "URLを入力してください。")
    public String imgUrl;

    public static final Finder<Long, Catalog> find = new Finder<Long,Catalog>(Catalog.class);


}
