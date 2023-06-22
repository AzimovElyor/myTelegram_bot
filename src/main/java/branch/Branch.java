package branch;

import common.BaseEntity;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;

import java.util.UUID;

public class Branch extends BaseEntity<UUID> {
    private SendLocation location;
     private WorkingHours workingHours;
}
