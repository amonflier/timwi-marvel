package com.amonflier.marvel.marvel.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.amonflier.marvel.marvel.model.Character;

@RestController
@RequestMapping(value = "/api/characters")
public class CharacterController {
    private List<Character> characters = new ArrayList<Character>();
    CharacterController() {
        this.characters = buildCharacters();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Character> getCharacters() {
        return this.characters;
    }

    List<Character> buildCharacters() {
        List<Character> chars = new ArrayList<>();
        Character char1 = buildCharacter(1, "venu", "image1", "venu@email.com");
        Character char2 = buildCharacter(2, "krishna", "image2", "krish@email.com");
        chars.add(char1);
        chars.add(char2);
        return chars;
    }

    Character buildCharacter(int id, String name, String thumbnail, String description) {
        Character character = new Character(id, name, thumbnail, description);
        return character;
    }
}
