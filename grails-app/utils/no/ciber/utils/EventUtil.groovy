package no.ciber.utils
/**
 * Created by bjerke.
 */
class EventUtil {
    static List<Long> getIdsFromUsersParameter(String users) {
        def ids = new ArrayList<Long>()
        if (users != null && !users.equals("")) {
            def idStrings = users.split(",")
            for (String idString : idStrings) {
                ids.add(Long.parseLong(idString))
            }
        }
        return ids
    }
}
