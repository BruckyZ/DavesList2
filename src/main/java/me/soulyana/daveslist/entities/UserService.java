package me.soulyana.daveslist.entities;

import me.soulyana.daveslist.repositories.AdminRepository;
import me.soulyana.daveslist.repositories.RoomRepository;
import me.soulyana.daveslist.security.SSUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class UserService
{
	@Autowired
	private SSUserDetailsService userDetailsService;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	public UserService(AdminRepository adminRepository)
	{
		this.roomRepository=roomRepository;

	}

	public Room findByEmail(String email)
	{
		return roomRepository.findByEmail(email);
	}
	public Long countByEmail(String email)
	{
		return roomRepository.countByEmail(email);
	}
	public Room findByUsername(String username)
	{
		return roomRepository.findByUsername(username);
	}

	public void saveUser(Room room)
	{
		room.setRoles(Arrays.asList(adminRepository.findByRole("USER")));

		roomRepository.save(room);
	}


	public void saveUser(Room room)
	{
		room.setRoles(Arrays.asList(adminRepository.findByRole("ADMIN")));

		roomRepository.save(room);
	}



}
