package crud.team.service.channel;


import crud.team.dto.channel.ChannelRequestDto;
import crud.team.dto.channel.ChannelResponseDto;
import crud.team.dto.channel.ResponseDto;
import crud.team.entity.channel.Channel;
import crud.team.entity.user.User;
import crud.team.exception.PostNotFoundException;
import crud.team.exception.UserNotFoundException;
import crud.team.repository.channel.ChannelRepository;
import crud.team.repository.user.UserRepository;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    private User getUser(String userId) {
        User user = UserRepository.findByEmail(userId)
                .orElseThrow(UserNotFoundException::new);
        return user;
    }

    private Channel getChennel(Long channel) {
        Channel channel = ChannelRepository.findById(channel)
                .orElseThrow(PostNotFoundException::new);
        return channel;
    }

    //채널 생성

    public ResponseDto<?> createChannel(ChannelRequestDto channelRequestDto, String email) throws IOException {
        User user = getUser(email);
        Channel channel = new Channel(channelRequestDto, user);

        channelRepository.save(channel);

        return ChannelResponseDto.success("챗팅방 생성 완료");
    }

//    //게시글 수정
//    @Transactional
//    public ResponseDto<?> updateChannel(Long channelId, ChannelRequestDto channelRequestDto, String emailId){
//
//        User user = getUser(channelId);
//
//        Channel channel = getChennel(channelId);
//
//        if(!user.getId().equals)
//
//    }
}

