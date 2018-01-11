package application.app.mytest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/**
 * Created by lwz on 2017/01/10.
 * ʱ�乤���� -- ʱ���ת�������ڣ�����ת����ʱ���
 * ����ʱ��ת��������
 */
public class DateUtils {

    public static void main(String[] args) {
        String string = getTimeDifference(
                "2018-04-05 23:00:00",
                "2018-04-05 23:20:00");
        System.out.println(string);
    }


    /**
     * ����ʱ���
     *
     * @param starTime      ��ʼʱ��
     * @param endTime       ����ʱ��
     * @param ==1----�죬ʱ���֡� ==2----ʱ
     * @return ����ʱ���
     */
    public static String getTimeDifference(String starTime, String endTime) {
//        starTime = "2018-04-05 23:00:00";
//        endTime = "2018-04-06 23:04:00";
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar calBegin = Calendar.getInstance(); //��ȡ����ʵ��
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(stringTodate(starTime, "yyyy")); //�ַ�������ָ����ʽת��Ϊ����
        calEnd.setTime(stringTodate(endTime, "yyyy"));
        int year = calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);

        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);
            long diff = parse1.getTime() - parse.getTime();
            long day = diff / (24 * 60 * 60 * 1000);
            long hour = (diff / (60 * 60 * 1000) - day * 24);
            long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            System.out.println("day==" + day);
            System.out.println("hour==" + hour);
            System.out.println("min==" + min);
            System.out.println("s==" + s);

            if (year == 0 && day == 0 && hour == 0 && min < 30) {
                timeString = "�ո�";
            } else if (year == 0 && day == 0 && hour == 0 && min >= 30) {
                timeString = min + "����ǰ";
            } else if (year == 0 && day == 0 && hour > 0) {
                timeString = hour + "Сʱǰ";
            } else {
                timeString = starTime.substring(0, starTime.length() - 9);
            }
//            else if (day > 0 && year <= 1 && day < 365) {
////                timeString = day + "��֮ǰ";
//                timeString = starTime.substring(5, starTime.length() - 12) + "��" + starTime.substring(8, starTime.length() - 9) + "��";//2017-09-01 10:14:32
//            } else if (year >= 1 && day >= 365) {
//                timeString = (day / 365) + "��ǰ";
//            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * ֻ��ע��  ��������ʱ���������
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int daysOfTwo(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return day2 - day1;
    }


    //�ַ�������ָ����ʽת��Ϊ����
    public static Date stringTodate(String dateStr, String formatStr) {
        // ���ʱ��Ϊ����Ĭ�ϵ�ǰʱ��
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        if (dateStr != null && !dateStr.equals("")) {
            String time = "";
            try {
                Date dateTwo = format.parse(dateStr);
                time = format.format(dateTwo);
                date = format.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            String timeTwo = format.format(new Date());
            try {
                date = format.parse(timeTwo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }


    public static String getTodayDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
                Locale.getDefault());
        return format.format(new Date());
    }

    /**
     * ���˷���������Ҫת����ʱ���������磨"2014��06��14��16ʱ09��00��"������ʱ���
     *
     * @param time
     * @return
     */
    public String data(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String getTodayDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
                Locale.getDefault());
        return format.format(new Date());
    }

    /**
     * ��ȡ��ǰʱ��
     *
     * @return
     */
    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return sdf.format(new java.util.Date());
    }

    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }

    /**
     * ���˷���������Ҫת����ʱ���������磨"2014-06-14-16-09-00"������ʱ���
     *
     * @param time
     * @return
     */
    public static String dataOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss",
                Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    public static String getTimestamp(String time, String type) {
        SimpleDateFormat sdr = new SimpleDateFormat(type, Locale.CHINA);
        Date date;
        String times = null;
        try {
            date = sdr.parse(time);
            long l = date.getTime();
            String stf = String.valueOf(l);
            times = stf.substring(0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return times;
    }

    /**
     * ���ô˷���������Ҫת����ʱ����������磨1402733340�������"2014��06��14��16ʱ09��00��"��
     *
     * @param time
     * @return
     */
    public static String times(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * ���ô˷���������Ҫת����ʱ����������磨1402733340�������"2014-06-14  16:09:00"��
     *
     * @param time
     * @return
     */
    public static String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * ���ô˷���������Ҫת����ʱ����������磨1402733340�������"2014��06��14��16:09"��
     *
     * @param time
     * @return
     */
    public static String timet(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��  HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * @param
     * @return
     */
    public static String timeslash(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy/MM/dd,HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * @param
     * @return
     */
    public static String timeslashData(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy/MM/dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
//      int i = Integer.parseInt(time);
        String times = sdr.format(new Date(lcc * 1000L));
        return times;

    }

    /**
     * @param
     * @return
     */
    public static String timeMinute(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    public static String tim(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyyMMdd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    public static String time(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;
    }

    // ���ô˷���������Ҫת����ʱ������磨1402733340�������"2014��06��14��16ʱ09��00��"��
    public static String times(long timeStamp) {
        SimpleDateFormat sdr = new SimpleDateFormat("MM��dd��  #  HH:mm");
        return sdr.format(new Date(timeStamp)).replaceAll("#",
                getWeek(timeStamp));

    }

    // ���ô˷���������Ҫת����ʱ������磨1402733340�������"2014��06��14��16ʱ09��00��"��
    public static String getTimes(long timeStamp) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdr.format(new Date(timeStamp)).replaceAll("#",
                getWeek(timeStamp));

    }

    private static String getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // ��ȡָ������ת�������ڼ�
        if (mydate == 1) {
            week = "����";
        } else if (mydate == 2) {
            week = "��һ";
        } else if (mydate == 3) {
            week = "�ܶ�";
        } else if (mydate == 4) {
            week = "����";
        } else if (mydate == 5) {
            week = "����";
        } else if (mydate == 6) {
            week = "����";
        } else if (mydate == 7) {
            week = "����";
        }
        return week;
    }

    // ���÷ָ����ʱ��ֳ�ʱ������

    /**
     * ���ô˷���������Ҫת����ʱ����������磨1402733340�������"2014-06-14-16-09-00"��
     *
     * @param time
     * @return
     */
    public String timesOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    public static String timesTwo(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * ���÷ָ����ʱ��ֳ�ʱ������
     *
     * @param time
     * @return
     */
    public static String[] timestamp(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        String[] fenge = times.split("[������ʱ����]");
        return fenge;
    }

    /**
     * ���ݴ��ݵ����͸�ʽ��ʱ��
     *
     * @param str
     * @param type ���磺yy-MM-dd
     * @return
     */
    public static String getDateTimeByMillisecond(String str, String type) {

        Date date = new Date(Long.valueOf(str));

        SimpleDateFormat format = new SimpleDateFormat(type);

        String time = format.format(date);

        return time;
    }

    /**
     * �ָ����ʱ��ֳ�ʱ������
     *
     * @param time
     * @return
     */
    public String[] division(String time) {

        String[] fenge = time.split("[������ʱ����]");

        return fenge;

    }

    /**
     * ����ʱ���������
     *
     * @param time
     * @return
     */
    public static String changeweek(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        Date date = null;
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(times);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // ��ȡָ������ת�������ڼ�
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "������";
        } else if (mydate == 2) {
            week = "����һ";
        } else if (mydate == 3) {
            week = "���ڶ�";
        } else if (mydate == 4) {
            week = "������";
        } else if (mydate == 5) {
            week = "������";
        } else if (mydate == 6) {
            week = "������";
        } else if (mydate == 7) {
            week = "������";
        }
        return week;

    }

    /**
     * ��ȡ���ں����ڡ����磺��������������������������:����������һ
     *
     * @param time
     * @param type
     * @return
     */
    public static String getDateAndWeek(String time, String type) {
        return getDateTimeByMillisecond(time + "000", type) + "  "
                + changeweekOne(time);
    }

    /**
     * ����ʱ���������
     *
     * @param time
     * @return
     */
    public static String changeweekOne(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        Date date = null;
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(times);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // ��ȡָ������ת�������ڼ�
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "������";
        } else if (mydate == 2) {
            week = "����һ";
        } else if (mydate == 3) {
            week = "���ڶ�";
        } else if (mydate == 4) {
            week = "������";
        } else if (mydate == 5) {
            week = "������";
        } else if (mydate == 6) {
            week = "������";
        } else if (mydate == 7) {
            week = "������";
        }
        return week;

    }

    /**
     * ��ȡ��ǰʱ��
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new java.util.Date());
    }

    /**
     * ���������磨2014��06��14��16ʱ09��00�룩���أ���������
     *
     * @param time
     * @return
     */
    public String week(String time) {
        Date date = null;
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(time);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // ��ȡָ������ת�������ڼ�
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "������";
        } else if (mydate == 2) {
            week = "����һ";
        } else if (mydate == 3) {
            week = "���ڶ�";
        } else if (mydate == 4) {
            week = "������";
        } else if (mydate == 5) {
            week = "������";
        } else if (mydate == 6) {
            week = "������";
        } else if (mydate == 7) {
            week = "������";
        }
        return week;
    }

    /**
     * ���������磨2014-06-14-16-09-00�����أ���������
     *
     * @param time
     * @return
     */
    public String weekOne(String time) {
        Date date = null;
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        int mydate = 0;
        String week = null;
        try {
            date = sdr.parse(time);
            Calendar cd = Calendar.getInstance();
            cd.setTime(date);
            mydate = cd.get(Calendar.DAY_OF_WEEK);
            // ��ȡָ������ת�������ڼ�
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mydate == 1) {
            week = "������";
        } else if (mydate == 2) {
            week = "����һ";
        } else if (mydate == 3) {
            week = "���ڶ�";
        } else if (mydate == 4) {
            week = "������";
        } else if (mydate == 5) {
            week = "������";
        } else if (mydate == 6) {
            week = "������";
        } else if (mydate == 7) {
            week = "������";
        }
        return week;
    }

    /**
     * UTCʱ�� ---> ����ʱ��
     *
     * @param utcTime UTCʱ��
     * @return
     */
    public static String utc2Local(String utcTime) {
        SimpleDateFormat utcFormater = new SimpleDateFormat("yyyy'-'MM'-'dd'T'kk':'mm':'ss'Z'");//UTCʱ���ʽ
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//����ʱ���ʽ
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    /**
     * �뵱ǰʱ��Ƚ�����
     *
     * @param time ��Ҫ�Ƚϵ�ʱ��
     * @return �����ʱ�������ʱ�����򷵻�true
     */
    public static boolean compareNowTime(String time) {
        boolean isDayu = false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date parse = dateFormat.parse(time);
            Date parse1 = dateFormat.parse(getTodayDateTime());
            long long_parse = parse.getTime();
            long long_parse1 = parse1.getTime();
            long diff = long_parse1 - long_parse;
            if (diff <= 0) {
                isDayu = true;
            } else {
                isDayu = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isDayu;
    }
}
