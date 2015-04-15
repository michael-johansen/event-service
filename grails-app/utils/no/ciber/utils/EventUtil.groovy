package no.ciber.utils
/**
 * Created by bjerke.
 */
class EventUtil {
    static List<Long> getIdsFromEventsParameter(String events) {
        def ids = new ArrayList<Long>()
        if (events != null && !events.equals("")) {
            def idStrings = events.split(",")
            for (String idString : idStrings) {
                ids.add(Long.parseLong(idString))
            }
        }
        return ids
    }
}
