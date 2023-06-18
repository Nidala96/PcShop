package com.demo.spring.games.database;

import com.demo.spring.games.entities.Message;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

public class ChatResponse {

    private List<Choice> choices;

    // constructors, getters and setters


    public ChatResponse() {
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public ChatResponse(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {

        private int index;
        private Message message;

        public Choice(int index, Message message) {
            this.index = index;
            this.message = message;
        }
        public Choice() {

        }


        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        // constructors, getters and setters
    }
}

