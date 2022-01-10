package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }
}
