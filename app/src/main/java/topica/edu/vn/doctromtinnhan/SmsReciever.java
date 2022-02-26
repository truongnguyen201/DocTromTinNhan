package topica.edu.vn.doctromtinnhan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object []arrPdus= (Object[]) bundle.get("pdus");//tin nhan duoc ma hoa,co nhieu tin nhan nhan den nen dung mang
        for(int i=0;i<arrPdus.length;i++)
        {
            SmsMessage smsMessage=SmsMessage.createFromPdu((byte[]) arrPdus[i]); //chuyen hoa ve string
            String noidung=smsMessage.getMessageBody();
            String phone=smsMessage.getOriginatingAddress();
            long time=smsMessage.getTimestampMillis();//time


            Date date=new Date(time);
            DateFormat format =new SimpleDateFormat("HH:mm:ss:SSS");
            String dateformat=format.format(date);


            Toast.makeText(context,"So phone"+phone+"noi dung"
                    +noidung+"Nhận lúc"+dateformat,Toast.LENGTH_LONG).show();
        }
    }
}
