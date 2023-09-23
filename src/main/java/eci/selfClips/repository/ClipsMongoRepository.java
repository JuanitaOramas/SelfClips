package eci.selfClips.repository;

import eci.selfClips.models.clips.Clip;
import eci.selfClips.models.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//conexion base de datos <tipo de dato maneja el doc, tipo de dato llave primaria>
@Repository
public interface ClipsMongoRepository extends MongoRepository<Clip, String> {


}
