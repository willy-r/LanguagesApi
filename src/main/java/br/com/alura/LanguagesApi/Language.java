package br.com.alura.LanguagesApi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="mainLanguages")
public class Language {
    @Id
    private String id;
    private String title;
    private String image;
    private Integer ranking;

    public Language(String title, String image, Integer ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public Integer getRanking() {
        return ranking;
    }
}
