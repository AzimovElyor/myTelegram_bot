package branch;

import lombok.AllArgsConstructor;

import java.time.LocalTime;
@AllArgsConstructor
public enum WorkingHours {
    MONDAY(LocalTime.of(8,0),LocalTime.of(0,0)),
    TUESDAY(LocalTime.of(8,0),LocalTime.of(0,0)),
    WEDNESDAY(LocalTime.of(8,0),LocalTime.of(0,0)),
    THURSDAY(LocalTime.of(8,0),LocalTime.of(0,0)),
    FRIDAY(LocalTime.of(8,0),LocalTime.of(0,0)),
    SATURDAY(LocalTime.of(8,0),LocalTime.of(14,0)),
    SUNDAY(LocalTime.of(8,0),LocalTime.of(14,0));
private final LocalTime from;
private final LocalTime to;
}
