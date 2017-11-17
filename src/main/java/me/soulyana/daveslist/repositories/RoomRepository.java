package me.soulyana.daveslist.repositories;

import me.soulyana.daveslist.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
	Room findByUsername(String username);
	Room findByEmail(String username);
	Long countByEmail(String email);
	Long countByUsername(String email);

}

