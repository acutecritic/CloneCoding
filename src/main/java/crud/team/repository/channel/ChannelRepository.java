package crud.team.repository.channel;

import crud.team.entity.channel.Channel;
import crud.team.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    List<Channel> findAllByOrderByModifiedAtDesc();
    Optional<User> findByUserId(String userId);
}
