package crud.team.entity.channel;


import crud.team.dto.channel.ChannelRequestDto;
import crud.team.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Channel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Channel_id", nullable = false)
    private Long id;

    @Column(name = "Channelname", nullable = false)
    private String channelname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("user_id")
    private User user;

    public Channel(ChannelRequestDto channelRequestDto, User user){
        this.channelname = channelRequestDto.getChannelname();
        this.user = user;
    }

    public void update(ChannelRequestDto channelRequestDto){
        this.channelname = channelRequestDto.getChannelname();

    }
}
