package me.soulyana.daveslist.repositories;


import me.soulyana.daveslist.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Long>
{
}
