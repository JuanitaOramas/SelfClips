package eci.selfClips.repository;

import eci.selfClips.models.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


//conexion base de datos <tipo de dato maneja el doc, tipo de dato llave primaria>
@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {
}
