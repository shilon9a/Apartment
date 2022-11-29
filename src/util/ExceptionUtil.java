package util;
import Exception.*;

import java.math.BigDecimal;

public class ExceptionUtil {

    public static void compareRoomNum(int min,int max){
        if(min>max){
            throw new CompareException("剩余房间数应少于总房间数");
        }
    }

    public static void compareMaxAndMinPrice(double min,double max){
        if(min>max){
            throw new CompareException("最低价格应低于最高价格");
        }
    }

    public static void comparePriceLen(BigDecimal num)throws LengthException{
        String date=num.toString();
        String[] temp=date.split("\\.");
        date=temp[0];
        if(date.length()>=10){
            throw new LengthException("价格应低于10位数");
        }

    }
}
