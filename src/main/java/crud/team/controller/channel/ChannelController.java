package crud.team.controller.channel;


import crud.team.dto.channel.ChannelRequestDto;
import crud.team.dto.channel.ResponseDto;
import crud.team.dto.channel.UserDetailsImpl;
import crud.team.service.channel.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/channel")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;
    private final ChannelRequestDto channelRequestDto;

    //  채널 작성
    @PostMapping
    public ResponseDto<?> createChannel(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,ChannelRequestDto channelRequestDto) throws IOException{
        return channelService.createChannel(channelRequestDto,userDetailsImpl.getUser().getEmail());
    }

}
