package common;

import lombok.Data;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseRepository<ID, ENTITY extends BaseEntity<ID>> implements Repository<ID, ENTITY>{
protected abstract String getFilePath();
@Override
public void add(ENTITY entity){
    List<ENTITY> entities = readFile();
    entities.add(entity);
    writeFile(entities);
}

    @Override
    public ENTITY findById(ID id) {
        for (ENTITY entity : readFile()) {
            if (entity.getId().equals(id)) {
                return entity;
            }

        }
        return null;
    }

    @Override
    public void deleteById(ID id) {
   readFile().removeIf(entity -> entity.getId().equals(id));
    }

    @Override
    public List<ENTITY> getAll() {
        return readFile();
    }

    @Override
    public ENTITY save(ENTITY entity) {
       entity.setUpdated(LocalDateTime.now());
       deleteById(entity.getId());
        add(entity);
         return entity;
    }
    private List<ENTITY> readFile() throws RuntimeException {
    try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(getFilePath()))) {
        return (List<ENTITY>) inputStream.readObject();
    } catch (IOException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
  return new ArrayList<>();
    }
    public void writeFile(List<ENTITY> entities){
         try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getFilePath()))) {
             outputStream.writeObject(entities);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
