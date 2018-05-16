import java.util.Calendar;
import java.util.Date;

public class Test3 {
    static int preDay = 3;
    public static void main(String[] args) {
        //Calendar c = Calendar.getInstance();
        //Calendar c1 = (Calendar) c.clone();
        //Calendar c2 = (Calendar) c.clone();
        //setTime(c1, c2);
        //SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        //System.out.println(sdf.format(c1.getTime()));
        //System.out.println(sdf.format(c2.getTime()));

        String source = "2017-07-08 16:47:31";

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        calendar.set(Calendar.HOUR_OF_DAY, 16);
        calendar.set(Calendar.MINUTE, 47);
        calendar.set(Calendar.SECOND, 31);

        Calendar calendar1 = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2010);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 01);

        Date date = calendar.getTime();
        Date buyCarDate = calendar1.getTime();
        int addDays = (int) calNextMaintenanceDate(7500, date, 66000, buyCarDate);
        Calendar ac = calendar;
        calendar.add(Calendar.DAY_OF_MONTH, addDays);
        Date sendDate = calendar.getTime();
        System.out.println(sendDate);
    }

    // 设置七天前的0点时间和23:59:59
    public static void setTime(Calendar c1, Calendar c2) {
        // 获得二十天前的0点时间
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        c1.add(Calendar.DATE, preDay);

        // 获得二十天前的23:59:59时间
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);
        c2.set(Calendar.MILLISECOND, 0);
        c2.add(Calendar.DATE, preDay);
    }

    public static double calNextMaintenanceDate(int nextMileage, Date finisheTime, Integer actualMileage, Date buyCarDate)
    {
        double addDays = 0;
        //下过保养订单，有购车时间，行车里程
        if( null != buyCarDate)
        {
            long date1 = buyCarDate.getTime();
            long date2 = finisheTime.getTime();
            int month = (int) (((date2 - date1)/(1000*60*60*24))/30);

            if( month == 0)
            {
                addDays = 90;
            }else
            {
                double nextDay = (((double)nextMileage - actualMileage)/(actualMileage/month))*30;
                if( nextDay >=180)
                {
                    addDays = 173;
                }else
                {
                    addDays = nextDay;
                }
            }
        }else   //下过保养订单，无购车时间
        {
            addDays = 90;
        }
        return addDays;
    }
}
