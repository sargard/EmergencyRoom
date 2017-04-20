/**
 *This class returns the time and date.
 * 
 * @author sarahgardiner
 * @date 2/9/17
 */
public class TimeDate {
    
    //format
    //String timeStamp = new SimpleDateFormat("yyyyMMdd_HH:mm").format(Calendar.getInstance().getTime());
    
    
    /**
     * This method gets the date.
     * @param timestamp
     * @return the date.
     */
    public String getDate(String timestamp){
        String delims = "[_]";
        String[] orig;
        orig = timestamp.split(delims);
        return orig [0];
    }
    
    /**
     * This method gets the time.
     * @param timestamp
     * @return the time.
     */
    public String getTime(String timestamp){
        String delims = "[_]";
        String[] orig;
        orig = timestamp.split(delims);
        return orig[1];
        
    }
    
}
