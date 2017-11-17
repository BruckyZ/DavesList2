package me.soulyana.daveslist.repositories;


import me.soulyana.daveslist.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Role,Long>
{

	Role findByRole(String role);
}
