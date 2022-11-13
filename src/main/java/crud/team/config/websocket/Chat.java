package crud.team.config.websocket;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private String type;
    private String sender;
    private String receiver;
    private String data;

    public void setChat(String sender) {
        this.sender = sender;
    }

    public void newConnect() {
        this.type = "new";
    }

    public void closeConnect() {
        this.type = "close";
    }
}

// {"type" : "", "sender" : "me", "receiver" : "session key", "data" : "contents"}