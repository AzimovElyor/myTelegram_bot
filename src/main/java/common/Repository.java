package common;

import javax.ws.rs.core.Link;
import java.util.List;

public interface Repository<ID, ENTITY extends BaseEntity<ID>> {
    void add( ENTITY entity );
    ENTITY findById(ID id);
void deleteById(ID id);
List<ENTITY> getAll();
ENTITY save(ENTITY entity);

}
