package me.soulyana.daveslist.security;

import me.soulyana.daveslist.entities.Role;
import me.soulyana.daveslist.entities.Room;
import me.soulyana.daveslist.repositories.RoomRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
	private RoomRepository roomRepository;

	public SSUserDetailsService(RoomRepository roomRepository){
		this.roomRepository=roomRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
			Room room = roomRepository.findByUsername(username);
			if(room==null)
			{
				return null;

			}

			return new org.springframework.security.core.userdetails.User(room.getUsername(),room.getPassword(),getAuthorities(room));

		}catch (Exception e)
		{
			throw new UsernameNotFoundException("User not found");
		}

	}

	private Set<GrantedAuthority> getAuthorities(Room room) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role eachRole:room.getRoles())
		{
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(eachRole.getRole());
			authorities.add(grantedAuthority);


		}
		return authorities;
	}
}
